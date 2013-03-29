/**
Alex Moriarty, B00317947
Login: moriarty
CSci 2132, Assignment 4
**/

#include <stdio.h>
#include <stdlib.h>
#include "struct.h"
#include "traverseTree.h"

/*
traverseTree, takes the binary tree, and the lenght of bits to where it is 
in the tree at that time. For the initial call, it is zero, when it gets to a 
character it has the lenght from the beginning. because it doesn't return a value
each time the function calls itself, the lenght is not continualy added, it goes back
to what it was.
*/

void traverseTree (struct node *tree, int lenght) 
{

/*
lenght should only be zero for the first call, so it prints the top of the chart on a new line.
*/   
	if (lenght == 0) 
	{
        	fprintf(stderr, "\ncharacter  bits\n");
        	fprintf(stderr, "---------------\n");
	}
/*
if the character is not a '~', it must be an leaf node. print the character and its the lenght to it.
also accounts for \n and \t characters.
otherwise add one to leght and go down each branch of thr tree.
*/
	if (tree->character != '~') 
	{
        	if (tree->character == '\t') 
		{
		fprintf(stderr, "  \\t        %d\n", lenght);
        	} else if (tree->character == '\n') 
		{
            	fprintf(stderr, "  \\n        %d  \n", lenght);
        	} else 
		{
            		fprintf(stderr, "  %c         %d  \n", tree->character, lenght);
        	}
    	} else 
	{
        	lenght++;
        	traverseTree(tree->left, lenght);
        	traverseTree(tree->right, lenght);
    	}

}
