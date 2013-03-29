/**
Alex Moriarty, B00317947
Login: moriarty
CSci 2132, Assignment 4
**/

#include <stdio.h>
#include "struct.h"
#include "makeTree.h"

/*
this function is called by makeTree, it makes a new node.
*/

struct node *make_node() {
        struct node *new_node = malloc(sizeof(struct node));

        if (new_node == NULL) {
                fprintf(stderr, "Error: malloc failed in make_node in makeTree ");
                exit(EXIT_FAILURE);
        }

	new_node->left = NULL;
	new_node->right = NULL;
	
        return new_node;
}

/*
this is make tree.. it finaly works.
it takes no arguments. and returns a binary tree with the characters it.
*/

struct node *makeTree () {
        
	char character = getchar();

        struct node *tree = make_node();

/*
if the character is a '~' then it must create a branch in the tree by recalling itself.
and if the the character is anything else, that node's character is set to that character.
*/
	
	if (character == '~'){
		tree-> character = '~';
		tree-> left = makeTree();
		tree-> right = makeTree();
	}else {
		tree->character = character;
	}

        return tree;
}
