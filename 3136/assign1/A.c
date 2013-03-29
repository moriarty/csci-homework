/**
 *	CSCI 3136		Assignment 1, question 3
 *	Programmer: Alex Moriarty			Student ID: B00317947
 *	CSID: moriarty					
 *	Date: January 23 2011
 */

#include <stdio.h>

/* Check if Character is a Digit */
int is_digit(const char c){
	if (c >= '0' && c <= '9') {
		return 1;
	}
	return 0;
}
/* Check if Character is Letter */
int is_letter(const char c){
	if (c >= 'a' && c <= 'z') {
		return 1;
	}
	if (c >= 'A' && c <= 'Z') {
		return 1;
	}
	return 0;
}


int main () {
    /**/
	int numChars, numLines, numTokens, numIdents, numNums;
	int c, cCurr, cPrev;
	int flagI = 0, flagN =0;
	/**/
	numChars = 0;
	numLines = 0;
	numIdents = 0;
	numNums = 0;
	cCurr = EOF;
	cPrev = EOF;
	
	/* Read first Character from stdin */
	c = getchar();
	/* Catch first line is newline*/
	if (c == '\n') {
		printf("\nAn Error May Have Occured, Check input\n");
		goto HELL;
	}
	/* Start loop process, read next character when done. */
	do
	{
		/* Checks if file is empty*/
		if (c == EOF) {
			goto HELL;
		}
		cCurr = c;
		/* Checks for End of Input Condition */
		if (cCurr == '\n' && cPrev == '\n') 
		{
			goto HELL;
		}
		/* Increments the Character Counter*/
		numChars++;
		/* Increments the Line Counter*/
		if (cCurr == '\n') 
		{
			numLines++;
		}
		/* Checks if current Character is part of a Identifier*/
		if (flagI) 
		{
			if (is_letter(cCurr)) {
				goto SKIP; // No counters need incrementing
			} else if (is_digit(cCurr)) {
				goto SKIP; // No counters need incrementing
			} else if (cCurr == '_') {
				goto SKIP; // No counters need incrementing
			}
			flagI = 0;
		}
		/* Checks if current Character is part of a Number*/
		if (flagN) 
		{
			if (is_digit(cCurr)) {
				goto SKIP; // No counters need incrementing
			} 
			flagN = 0;
		}
		/* Checks if current Character is start of a Identifier*/
		if (is_letter(cCurr) || c == '_')
		{
			numIdents++;
			flagI = 1;
		}
		/* Checks if current Character is start of a Number */
		if (is_digit(cCurr)) 
		{
			numNums++;
			flagN = 1;
		}
	/* Where you end up if only the numChar must be incremented*/
	SKIP:
		cPrev = cCurr;
	}while ((c = getchar())!= EOF);
/* Where you end up in exception cases. */	
HELL:
	
	/* Number of Tokens can be calculated as defined */
	numTokens = numNums + numIdents;
	
	/*Print output to stdout*/
	printf("\n Characters: %d",numChars);
	printf("\n      Lines: %d",numLines);
	printf("\n     Tokens: %d",numTokens);
	printf("\nIdentifiers: %d",numIdents);
	printf("\n    Numbers: %d\n",numNums);
	
    return 0;
}
/***************************************
 PROOF IT WORKED WITH SAMPLE INPUT
 [Session started at 2011-01-24 03:48:05 -0400.]
 GNU gdb 6.3.50-20050815 (Apple version gdb-1472) (Wed Jul 21 10:53:12 UTC 2010)
 [......]
 Loading program into debugger…
 sharedlibrary apply-load-rules all
 Program loaded.
 run
 [Switching to process 39256]
 Running…
 This is a sample input. _identifier12, and a number 10ident12.
 _12_13 14_25.
 
 
 Characters: 77
 Lines: 2
 Tokens: 14
 Identifiers: 12
 Numbers: 2
 Debugger stopped.
 Program exited with status value:0.
***************************************/
