/**
 * Viruscount.c
 * Assignment 2, CSCI 3136
 * Alex Moriarty, B00317947
 *
 */

#include <stdio.h>

int main (int argc, const char * argv[]) {

	int ch, count, place;
	char sign[10] =  "aabaabrac";
	place = 0;
	count = 0;

	while ( ( ch = getchar() ) != EOF ) {
		if ( sign[place] == ch) {
			place ++;
			if (place == 9) {
				place = 0;
				count ++;
			}
		} else {
			place = 0;
		}

	}
	printf( "%d\n" , count ) ;
    return 0;
}
