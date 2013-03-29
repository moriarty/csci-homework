/**
Alex Moriarty, B00317947
Login: moriarty
CSci 2132, Assignment 4
**/

#include <stdio.h>
#include "struct.h"
#include "makeTree.h"
#include "traverseTree.h"
#include "decodeMessage.h"


int main() {
	
	struct node *tree = makeTree();
    	traverseTree(tree, 0);
   	decodeMessage(tree);
    	return 0;
}
