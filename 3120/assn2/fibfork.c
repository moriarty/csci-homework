#include <stdio.h>   /* printf, stderr, fprintf */
#include <unistd.h>  /* _exit, fork */
#include <stdlib.h>  /* exit */
#include <errno.h>   /* errno */

int main( int argc, char *argv[])
{
	printf("I begin");
	int n = atoi(argv[1]);
	if ( argc != 2) {
		printf("\nusage: %s possitive_integer\n\n", argv[0]);
	} else if (n < 0 ){
		printf("\ninteger argument must be possitive!\n\n");
	} else {
		pid_t  pid;
		/* Output from both the child and the parent process
    	* will be written to the standard output,
    	* as they both run at the same time.
    	*/
    	printf("\ncreating fork\n%d\n",n);
		pid = fork();
		if (pid == -1){
	   		/* Error:
	   		* When fork() returns -1, an error happened
	   		* (for example, number of processes reached the 
limit).
	   		*/
	   		fprintf(stderr, "can't fork, error %d\n", 
errno);
	   		exit(EXIT_FAILURE);
	   	} 
	   	if (pid == 0) {
	   		/* Child process:
	   		* Fibonacci code.
	   		*/
	   		int fib0 = 0, fib1 = 1, i;
	   		
	   		for (i = 0; i <= n ; i++){
	   			int fibcurr = fib0;
	   			fib0 = fib1;
	   			fib1 = fibcurr + fib1;
		   		//printf("\n");
	   			printf("%d, ", fibcurr);
	   		}
   			_exit(0);
   		} else {
   			/* Parent process: */
   			//printf("\nparent\n");
   			wait(&pid);
   			exit(0);
   		}
   	}
   	
}

