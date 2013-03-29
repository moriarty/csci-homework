#include <stdio.h>   /* printf, stderr, fprintf */
#include <unistd.h>  /* _exit, fork */
#include <stdlib.h>  /* exit */
#include <errno.h>   /* errno */

int main( int argc, char *argv[])
{
	//printf("I begin");
	
	if ( argc != 2) {
		printf("\nusage: %s possitive_integer\n\n", argv[0]);
		exit(0);
	} else if (atoi(argv[1]) < 0 ){
		printf("\nusage: %s possitive_integer", argv[0]);
		printf("\ninteger argument must be possitive!\n\n");
	} else {
		int number = atoi(argv[1]);
		int status;
		pid_t  pid;
		/* Output from both the child and the parent process
    	* will be written to the standard output,
    	* as they both run at the same time.
    	*/
    	//printf("\ncreating fork\n%d\n",n);
		pid = fork();
		if (pid == -1){
	   		/* Error: When fork() returns -1, */
	   		fprintf(stderr, "can't fork, error %d\n", errno);
	   		exit(EXIT_FAILURE);
	   	} 
	   	if (pid == 0) {
	   		/* Child process: */
	   		// Fibonacci code.
	   		long fibseq[number];
	   		long fib0 = 0;
	   		long fib1 = 1;
	   		int i;
	   		for (i = 0; i <= number ; i++){
	   			long fibcurr = fib0;
	   			fib0 = fib1;
	   			fib1 = fibcurr + fib1;
	   			fibseq[i] = fibcurr;
	   		}
	   		for(i = 0; i <= number; i++){
	   			printf("%ld ", fibseq[i]);
	   		}
	   		printf("\n");
   			_exit(0);
   		} else {
   			/* Parent process: */
   			//printf("\nparent\n");
   			//w0ait(pid);
   			if ((pid = wait(&status)) == -1){
   				printf("ERROR: Parent should be waiting.");
   			}
   			//printf("i waited\n");
   			exit(0);
   		}
   	}
   	
   	
}
