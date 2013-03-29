#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "mymem.h"
#include <time.h>


/* The main structure for implementing memory allocation.
 * You may change this to fit your implementation.
 */

struct memoryList
{
  // doubly-linked list
  struct memoryList *last;
  struct memoryList *next;

  int size;            // How many bytes in this block?
  char alloc;          // 1 if this block is allocated,
                       // 0 if this block is free.
  void *ptr;           // location of block in memory pool.
};

strategies myStrategy = NotSet;    // Current strategy


size_t mySize;
void *myMemory = NULL;

static struct memoryList *head;
//static struct memoryList *next;



/* initmem must be called prior to mymalloc and myfree.

   initmem may be called more than once in a given exeuction;
   when this occurs, all memory you previously malloc'ed  *must* be freed,
   including any existing bookkeeping data.

   strategy must be one of the following:
		- "best" (best-fit)
		- "worst" (worst-fit)
		- "first" (first-fit)
		- "next" (next-fit)
   sz specifies the number of bytes that will be available, in total, for all mymalloc requests.
*/

void initmem(strategies strategy, size_t sz)
{
	myStrategy = strategy;

	/* all implementations will need an actual block of memory to use */
	mySize = sz;

	if (myMemory != NULL) { 
		free(myMemory); 
		/* in case this is not the first time initmem2 is called */

	/* TODO: release any other memory you were using for bookkeeping when doing a re-initialization! */
		struct memoryList *temp;
		for ( ; head!=NULL; ) {
			temp = head->next;
			free(head);
			head = temp;
		}
	}

	myMemory = malloc(sz);
	
	/* TODO: Initialize memory management structure. */
	head = malloc(sizeof(struct memoryList));
	head->size=sz;
	head->alloc=0;
	head->next=NULL;
	head->last=NULL;
	head->ptr = myMemory;
	
}

/* Allocate a block of memory with the requested size.
 *  If the requested block is not available, mymalloc returns NULL.
 *  Otherwise, it returns a pointer to the newly allocated block.
 *  Restriction: requested >= 1 
 */

void *mymalloc(size_t requested)
{
	assert((int)myStrategy > 0);
	struct memoryList *temp, *newFree;
	
	switch (myStrategy)
	  {
	  case NotSet:
			  return NULL;
	  case First:
			  for (temp = head; temp; temp = temp->next) {
				  if (temp->alloc == 0 && temp->size == requested) {
					  temp->alloc = 1;
					  return temp->ptr;
				  } else if (temp->alloc ==0 && temp->size > requested) {
					  newFree = malloc(sizeof(struct memoryList));
					  newFree->next = temp->next;
					  newFree->last = temp;
					  newFree->alloc = 0;
					  //Uses dot to get address.
					  newFree->ptr = (temp->ptr + requested);
					  newFree->size = (temp->size - requested);
					  temp->next->last = newFree;
					  
					  temp->size = requested;
					  temp->alloc = 1;
					  temp->next = newFree;
					  
					  return temp->ptr;
				  }
			  }
			  return NULL;
	  case Best:
			  //for (temp = head; temp; temp = temp->next) {
				  
			  //}
			  return NULL;
	  case Worst:
			  //for (temp = head; temp; temp = temp->next) {
				  
			  //}
			  return NULL;
	  case Next:
			  //for (temp = head; temp; temp = temp->next) {
				  
			  //}
			  return NULL;
	  }
	return NULL;
}


/* Frees a block of memory previously allocated by mymalloc. */
void myfree(void* block)
{
	struct memoryList *temp, *FOO1, *FOO2;
	for (temp=head; temp; temp = temp->next) {
		if (temp->ptr == block) {
			if (temp->last->alloc == 0 && temp->next->alloc == 0) {
				//Merge prev, curr and next into one free block
				FOO1 = temp;
				temp = temp->last;
				FOO2 = FOO1->next;
				
				FOO2->next->last = temp;
				
				temp->size += FOO1->size;
				temp->size += FOO2->size;
				
				temp->next = FOO2->next;
				
				free(FOO1);
				free(FOO2);
				
			}else if (temp->last->alloc == 0) {
				//Merge prev, curr into one free block
				FOO2 = temp;
				temp = temp->last;
				
				FOO2->next->last = temp;
				
				temp->size += FOO2->size;
				temp->next = FOO2->next;
				
				free(FOO2);
				return;
				
			}else if (temp->next->alloc == 0) {
				//Merge curr, next into one free block
				FOO2 = temp->next;
				FOO2->next->last = temp;
				
				temp->alloc = 0;
				temp->size += FOO2->size;
				temp->next = FOO2->next;
				
				free(FOO2);
				return;
			}else {
				//Delete the current block
				temp->alloc = 0;
				return;
			}

		}
	}
	return;
}

/****** Memory status/property functions ******
 * Implement these functions.
 * Note that when we refer to "memory" here, we mean the 
 * memory pool this module manages via initmem/mymalloc/myfree. 
 */

/* Get the number of contiguous areas of free space in memory. */
int mem_holes()
{
	int num = 0;
	struct memoryList *temp;
	for (temp = head; temp == NULL; temp=temp->next) {
		if (temp->alloc == 0 ) {
			num ++;
		}
	}
	return num;
}

/* Get the number of bytes allocated */
int mem_allocated()
{
	return 0;
}

/* Number of non-allocated bytes */
int mem_free()
{
	int num = 0;
	struct memoryList *temp;
	for (temp = head; temp == NULL; temp=temp->next) {
		if (temp->alloc == 0 ) {
			num += temp->size;
		}
	}
	return num;
}

/* Number of bytes in the largest contiguous area of unallocated memory */
int mem_largest_free()
{
	int num = 0;
	struct memoryList *temp;
	for (temp = head; temp == NULL; temp=temp->next) {
		if (temp->size > num ) {
			num = temp->size;
		}
	}
	return num;	
}

/* Number of free blocks smaller than "size" bytes. */
int mem_small_free(int size)
{
	int num = 0;
	struct memoryList *temp;
	for (temp = head; temp == NULL; temp=temp->next) {
		if (temp->size < size ) {
			num++;
		}
	}
	return num;
}       

char mem_is_alloc(void *ptr)
{
	struct memoryList *temp;
	for (temp=head; temp == NULL; temp=temp->next) {
		if (temp->ptr == ptr && temp->alloc == 1) {
			return 1;
		}
	}
	return 0;
}

/* 
 * Feel free to use these functions, but do not modify them.  
 * The test code uses them, but you may ind them useful.
 */


//Returns a pointer to the memory pool.
void *mem_pool()
{
	return myMemory;
}

// Returns the total number of bytes in the memory pool. */
int mem_total()
{
	return mySize;
}


// Get string name for a strategy. 
char *strategy_name(strategies strategy)
{
	switch (strategy)
	{
		case Best:
			return "best";
		case Worst:
			return "worst";
		case First:
			return "first";
		case Next:
			return "next";
		default:
			return "unknown";
	}
}

// Get strategy from name.
strategies strategyFromString(char * strategy)
{
	if (!strcmp(strategy,"best"))
	{
		return Best;
	}
	else if (!strcmp(strategy,"worst"))
	{
		return Worst;
	}
	else if (!strcmp(strategy,"first"))
	{
		return First;
	}
	else if (!strcmp(strategy,"next"))
	{
		return Next;
	}
	else
	{
		return 0;
	}
}


/* 
 * These functions are for you to modify however you see fit.  These will not
 * be used in tests, but you may find them useful for debugging.
 */

/* Use this function to print out the current contents of memory. */
void print_memory()
{
	return;
}

/* Use this function to track memory allocation performance.  
 * This function does not depend on your implementation, 
 * but on the functions you wrote above.
 */ 
void print_memory_status()
{
	printf("%d out of %d bytes allocated.\n",mem_allocated(),mem_total());
	printf("%d bytes are free in %d holes; maximum allocatable block is %d bytes.\n",mem_free(),mem_holes(),mem_largest_free());
	printf("Average hole size is %f.\n\n",((float)mem_free())/mem_holes());
}

/* Use this function to see what happens when your malloc and free
 * implementations are called.  Run "mem -try <args>" to call this function.
 * We have given you a simple example to start.
 */
void try_mymem(int argc, char **argv) {
        strategies strat;
	void *a, *b, *c, *d, *e;
	if(argc > 1)
	  strat = strategyFromString(argv[1]);
	else
	  strat = First;
	
	
	/* A simple example.  
	   Each algorithm should produce a different layout. */
	
	initmem(strat,500);
	
	a = mymalloc(100);
	b = mymalloc(100);
	c = mymalloc(100);
	myfree(b);
	d = mymalloc(50);
	myfree(a);
	e = mymalloc(25);
	
	print_memory();
	print_memory_status();
	
}
