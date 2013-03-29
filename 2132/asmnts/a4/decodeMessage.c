
/**
Alex Moriarty, B00317947
Login: moriarty
CSci 2132, Assignment 4
**/

#include <stdio.h>
#include "struct.h"
#include "decodeMessage.h"

/*
This function is called by decode message to convert the characters '1', 
'0' and to an int of value 1, 0, or 666 which is just flag for when the 
char is not one of those, making it the end of the input It takes no 
arguments, it gets the char itself, and returns it as an integer.  
*/
int charToBin() {

    int Bin;
	
    char Character = getchar();
        // for 0
        if (Character == 48)
		{
                Bin = 0;
        }// for 1
		else if (Character == 49)
        {
			Bin = 1;
        }else
            Bin = 666;

        return Bin;
}

/*
This is the decodeMessage function it takes the binary tree previously 
created as an argument. 
The function creates a new root for the tree, so that it can find the beginning. 
then, in an infinite loop, it   
*/
void decodeMessage(struct node *tree) 
{
	
	struct node *root = malloc(sizeof(struct node));
	
	if (root == NULL) 
	{
        	fprintf(stderr, "Error: malloc failed in decodeMessage");
        	exit(EXIT_FAILURE);
   	}
	
/*
creates all other variables needed.
*/
	int bits = 0;
    	int chars = 0;
	int bit;
	double ratio;
/*
makes root point to the tree.
*/    
	root = tree;
/*
the is an unwanted newline character in the input that is discarded. 
*/
	getchar();
/*
reads the first char from the second line of input. and converts it to a int, (binary-ish).
*/
	bit = charToBin();

/*
start the loop.
*/
	for (;;)
	{
/*
if the char read was 0, it means go to the next left node.
*/		
		if (bit == 0)
		{
			tree = tree->left;
		}
/*
if the char read was 1, it means go to the next right node.
*/ 
		else if (bit == 1)
		{
			tree = tree->right;
		} 
/*
if the character read was not 0 or 1, calculate and print the variables, 
and return the function ending the infinite loop.		
*/
		else if (bit == 666)
		{
			ratio = ((double)bits / ((double)chars*8))*100;
			fprintf(stderr, "Number of bits       = %d\n", bits);
			fprintf(stderr, "Number of characters = %d\n",chars);
			fprintf(stderr, "Compression ratio    = %.1f%%\n", ratio);
            		return;
		}
/*
every time it checks the current node to see if there it contains a character if it does, 
its adds one to the character count and returns back to the root of the tree.
*/		
		if (tree->character != '~')
		{
			printf("%c", tree->character);
			chars++;
			tree = root;
		}
/*
adds on to the bit counter and gets the next bit.
*/
		bits++;
		bit = charToBin();
	}
	
}
