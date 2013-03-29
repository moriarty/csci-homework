/**
Assignment 10 Question 1:
Write a program which declares a string and sets it to contain the phrase ``Egyptian delegates allegedly forego eggs''. The string is first written 
to an output file and is then passed to a function called  convert which converts each occurrence of ``eg'' to ``EG''. The main then writes the 
converted string to the output file. You program should consist of both the main and the function  convert. 
*/
/**
	File: a10.1.c ()
	Programmer: Alex Moriarty	Date: Dec 2/09
	Course: Engm 2081		Prof: Dr. Fenton
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdio.h>

void convert( char **str );

int main(void){
	char s1[] = "Egyptian delegates allegedly forego eggs";
	FILE *fout = fopen("a10.1.out","w");
	
	printf("\n%s\n", s1);

	convert(&s1);

	fprintf(fout,"\n%s\n", s1);

	fclose(fout);
}
void convert( char *str[] ){
	int i = 0;
	int j = 1;
	printf("\n_HERE_\n%s\n_HERE_\n", str[j]);
	/*
	while( *str[j] != '\0' ){
		if (*str[i] == 'e' || *str[i] == 'E' ){
			if (*str[j] == 'g' || *str[j] == 'G' ){
				*str[i] = 'E';
                        	*str[j] = 'G';
			}
		}
		i++;
		j++;		
	}
	*/	
}
