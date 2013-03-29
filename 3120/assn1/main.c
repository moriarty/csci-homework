/**
* Assignemnt 1 CSCI 3120
* Alex Moriarty
*/

//#include "myshell.h"

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <ctype.h>
#include <errno.h>
#include <fcntl.h>

/*
Global Variables
*/

short INTERRUPTED;
static char *theArgv[256];
static char *theEnvp[256];
static char *thePaths[64];
static char *searchPath[64];

/*
Interupt handler for Ctrl+C
*/
void signalCtrlC(int signal){
	extern short INTERRUPTED;
	INTERRUPTED = 1;
	printf("\nctrl+c pressed\n");
	printf("The signal was caught, however due to my variable scoping I can not display the history.\n");
	printf("To view the history enter the command '!!'");
	fflush(stdout);
	if(theArgv[0]==NULL){
		theArgv[0]=(char *)malloc(sizeof(char)*5);
	} else {
		bzero(theArgv[0], strlen(theArgv[0]));
	}

}
/*
Parse the line inputed by user
*/
void parseInput(char *theInput){
	char *c = theInput;
	int index = 0;
	char myArgv[256];
	bzero( myArgv, 256);
	while(*c != '\0'){
		if(*c == ' '){
			if(theArgv[index] == NULL){ theArgv[index] = (char *)malloc(sizeof(char)*strlen(myArgv)+1); }
			else{ bzero(theArgv[index], strlen(theArgv[index])); }

			strncpy(theArgv[index], myArgv, strlen(myArgv));
			strncat(theArgv[index], "\0", 1);
			bzero( myArgv, 256 );
			index++;
		} else {
			strncat( myArgv, c, 1);
		}
		c++;
	}
	theArgv[index] = (char *)malloc(sizeof(char)*strlen(myArgv)+1);
	strncpy(theArgv[index], myArgv, strlen(myArgv));
	strncat(theArgv[index], "\0", 1);
}
/*
Empty all the Args
*/
void clearTheArgv(){
	int i=0;
	for(;theArgv[i]!=NULL;i++){
		bzero(theArgv[i], strlen(theArgv[i]));
		theArgv[i]=NULL;
		free(theArgv[i]);
	}
}
/*
Copy the Environment Variables
*/
void copyEnvp(char **envp){
	int i=0;
	for(;envp[i]!=NULL;i++){
		theEnvp[i]=(char *)malloc(sizeof(char)*(strlen(envp[i])+1));
		memcpy(theEnvp[i],envp[i],strlen(envp[i]));
	}
}
/*
Get the Path Evironment Variable
*/
void getPath(char **theEnvp, char *thePath){
	char *myPath=getenv("PATH");
	strncpy(thePath, myPath, strlen(myPath));
}
/*
Parse the Path env variable to create an array of search paths
*/
void setSearchPath(char *path_str){
	int i=0;
	char *c = path_str;
	char mySearchPath[128];

	bzero(mySearchPath, 128);
	while(*c != '\0') {
		if(*c == ':') {
			strncat(mySearchPath, "/", 1);
			searchPath[i] = (char *) malloc(sizeof(char) * (strlen(mySearchPath) + 1));
			strncat(searchPath[i], mySearchPath, strlen(mySearchPath));
			strncat(searchPath[i], "\0", 1);
			i++;
			bzero(mySearchPath, 128);
		} else {
			strncat(mySearchPath, c, 1);
		}
		c++;
	}
}

/*
Find the command in an array of search paths
*/
int findPath(char *theCommand){
	char myCommand[256];
	int i, fileCheck;
	bzero(myCommand, 256);
	for(i = 0; searchPath[i]!=NULL;i++){
		strcpy(myCommand, searchPath[i]);
		strncat(myCommand, theCommand, strlen(theCommand));
		if((fileCheck=open(myCommand,O_RDONLY))>0){
			close(fileCheck);
			strncpy(theCommand, myCommand, strlen(myCommand));
			return 0;
		}
		bzero(myCommand, 256);
	}
	return 1;
}
/*
Execute the command
*/
void executeCommand(char *theCommand){
	int i;
	if(fork()==0){
		i = execve(theCommand, theArgv, theEnvp);
		if(i<0){
			printf("%s: Command not found! \n", theCommand);
			exit(1);
		}
	} else { wait(NULL); }
}

/*
Check the syntax of command and attempt to execute it.
*/
void tryCommand(char *theCommand){
	int fileCheck;
	int found = 0;
	/* did they not specify the path? */
	if(index(theCommand, '/') == NULL){
		if(findPath(theCommand)==0){
			found = 1;
			executeCommand(theCommand);
		}
	} else {
		if((fileCheck = open( theCommand, O_RDONLY)) > 0){
			close(fileCheck);
			found = 1;
			executeCommand(theCommand);
		}
	}
	if(found != 1){ printf("%s: Command not found\n", theCommand); }
}
/*
Is numeric? function used for error catching in History.
*/
int isNumeric(const char *s){
	if (s==NULL||*s=='\0'){
		return 0;
	}
	char *p;
	strtod( s, &p);
	return *p == '\0';
}
/*
My Shell
*/

int main(int argc, char *argv[], char *envp[]){

	//Check usage
	/* yet to implement*/
	//Print help
	/* yet to implement*/

	/* Set the Variables*/
	char c;
	char *theInput = (char *)malloc(sizeof(char)*256);
	char *thePath = (char *)malloc(sizeof(char)*256);
	char *theCommand = (char *)malloc(sizeof(char)*256);

	extern short INTERRUPTED;
	INTERRUPTED = 0;

	/* what should happen when Ctrl+C is pressed */
	signal(SIGINT, signalCtrlC);

	/* get the environment variables and set up a array of search paths*/
	copyEnvp(envp);
	getPath(theEnvp,thePath);
	setSearchPath(thePath);

	/* some more variables needed to keep track of History */
	int i = 0, t = 0;
	char *history[10];

	if(fork()==0){
		execve("/usr/bin/clear",argv, theEnvp);
		exit(1);
	} else {
		wait(NULL);
	}

	printf("Welcome to Alex's Shell\nUsing the PATH: %s\n",thePath);
	printf("-----------------------\n");
	printf("COMMAND --> ");
	fflush(stdout);

	while(c != EOF){
		c = getchar();
		if(c == '\n'){
			/* User has ended line, begin processing command */
			/* If the command was just a return */
			if(theInput[0] == '\0'){ printf("COMMAND --> ");
			} else{
				i = t%10;
				/* parse the input into theArgv global variable */
				parseInput(theInput);
				/* now that theArgv has been populated, get the command and try to execute it */
				strncpy(theCommand, theArgv[0], strlen(theArgv[0]));
				/* Save the input into the history array */
				char *tmp;
				tmp  = strchr(theCommand,'!');
				if(theCommand != tmp){
					history[i]=(char *)malloc(sizeof(char)*strlen(theInput)+1);
					strncpy(history[i],theInput, strlen(theInput));

					/* parse the input into theArgv global variable */
					parseInput(theInput);
					/* now that theArgv has been populated, get the command and try to execute it */
					strncpy(theCommand, theArgv[0], strlen(theArgv[0]));
					if(strcmp(theCommand, "exit")==0) return 0;
					if(strcmp(theCommand, "history")==0) goto HISTORY;
				} else {
					/**/
					//parseInput(theInput);
					//strncpy(theCommand, theArgv[0], strlen(theArgv[0]));
					//printf("A history command would be executed here\n");
					if(strcmp(theCommand, "!!")==0 &&  t != 0){
						HISTORY:
						INTERRUPTED = 0;
						int foo;
						if(t<10){ foo=0;}else{foo=t-10;}
						for(;foo<t;foo++){
							i=foo%10;
							printf("%d\t\%s\n",foo+1,history[i]);
						}
						bzero(theCommand,256);
						strncat(theCommand, "SKIP_FLAG", 9);
						//printf("HERE\n");
					}else{
						int foo=0;
						for(;foo<strlen(theCommand);foo++){
							*(theCommand+foo) = *(theCommand+foo+1);
						}
						if(isNumeric(theCommand)!=0){
							//printf("you wish to run the %sth command?",theCommand);
							foo = atoi(theCommand);
							if(foo<=t && foo > t-10){
								parseInput(history[(foo-1)%10]);
								bzero(theCommand, 256);
								strncpy(theCommand, theArgv[0], strlen(theArgv[0]));
							} else {
								printf("%sth Command not in history\n",theCommand);
								bzero(theCommand,256);
								strncat(theCommand, "SKIP_FLAG", 9);
							}
						}
					}
					//break;
				}
				if(strcmp(theCommand, "SKIP_FLAG")!=0){
					strncat(theCommand, "\0", 1);
					tryCommand(theCommand);
				}
				/* Clean up some garbage to prepare for next command*/
				clearTheArgv();
				bzero(theCommand, 256);
				t++;
				printf("COMMAND --> ");
			}
			bzero(theInput, 256);
		}else{
			/* User is typing input, concatenate into one string*/
			strncat(theInput, &c, 1);
		}
	}

	return 0;
}
