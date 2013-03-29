#/**
#Alex Moriarty, B00317947
#Login: moriarty
#CSci 2132, Assignment 4
#**/

decode: a4.o makeTree.o traverseTree.o decodeMessage.o
	gcc -o decode a4.o makeTree.o traverseTree.o decodeMessage.o

a4.o: a4.c struct.h makeTree.h traverseTree.h decodeMessage.h
	gcc -c a4.c

makeTree.o: makeTree.c struct.h makeTree.h
	gcc -c makeTree.c 

traverseTree.o: traverseTree.c struct.h traverseTree.h
	gcc -c traverseTree.c

decodeMessage.o: decodeMessage.c struct.h
	gcc -c decodeMessage.c

clean: 
	rm -rf *.o decode 

