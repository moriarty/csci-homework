/**
CSCI 3120 Assignment 2 question	2
Alex Moriarty
csid moriarty
Date Due Friday	June 17
**/

#include <stdio.h>   
#include <unistd.h>  
#include <stdlib.h>  
#include <errno.h>   
#include <sys/types.h>
#include <sys/ipc.h> 
#include <sys/shm.h> 
#include <string.h>


#define MAX_SEQUENCE 10

typedef struct {
	long fib_sequence[MAX_SEQUENCE];
	int sequence_size;
} shared_data;

int main( int argc, char *argv[])
{
	//printf("I begin");
	
	if ( argc != 2) {
		printf("\nusage: %s possitive_integer\n\n", argv[0]);
		exit(0);
	} else if (atoi(argv[1]) < 0 ){
		printf("\nusage: %s possitive_integer", argv[0]);
		printf("\ninteger argument must be possitive!\n\n");
	} else if (atoi(argv[1]) > MAX_SEQUENCE ){
		printf("\nusage: %s possitive_integer", argv[0]);
		printf("\ninteger must be below %d!\n\n", MAX_SEQUENCE);
	} else {
		int status;
		int i;
		void* shared_memory = NULL;
		shared_data *dataptr;
		int shmid;
		int mykey = getuid();
		
		shmid = shmget((key_t)mykey, sizeof(shared_data), 0666 | IPC_CREAT);

		if (shmid == -1) {
			perror("shmget: shmget failed"); 
			exit(EXIT_FAILURE); 
		} 
		
		shared_memory = shmat(shmid, NULL, 0);	
		if (shared_memory == (void *)-1) {
			fprintf(stderr, "shmat failed\n");
			exit(EXIT_FAILURE);
        }
        dataptr = (shared_data *) shared_memory;
        
		dataptr->sequence_size = atoi(argv[1]); 
		pid_t  pid;
		pid = fork();

		if (pid == -1){
	   		/* Error: When fork() returns -1, */
	   		fprintf(stderr, "can't fork, error %d\n", errno);
	   		exit(EXIT_FAILURE);
	   	} 
	   	if (pid == 0) {
	   		/* Child process: */
	   		// Fibonacci code.
	   		long fib0 = 0;
	   		long fib1 = 1;
	   		
	   		for (i = 0; i < dataptr->sequence_size ; i++){
	   			long fibcurr = fib0;
	   			fib0 = fib1;
	   			fib1 = fibcurr + fib1;
	   			dataptr->fib_sequence[i] = fibcurr;
	   		}
	   		
   			_exit(0);
   		} else {
   			/* Parent process: */
   			
   			if ((pid = wait(&status)) == -1){
   				printf("ERROR: Parent should be waiting.");
   				exit(EXIT_FAILURE);
   			}
   			//
   			int j;
			for(j = 0; j < dataptr->sequence_size; j++){
   				printf("%ld ", dataptr->fib_sequence[j]);
   			}
   		}
   		
  		printf("\n");
		
		if (shmdt(shared_memory) == -1) {
        	fprintf(stderr, "shmdt failed\n");
        	exit(EXIT_FAILURE);
    	}

    	if (shmctl(shmid, IPC_RMID, 0) == -1) {
    	    fprintf(stderr, "shmctl(IPC_RMID) failed\n");
    	    exit(EXIT_FAILURE);
    	}
		exit(EXIT_SUCCESS);
   	}   	
}
