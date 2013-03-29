/**
*  File: a3.2.c (earthquake.c)
*
*  Programmer: Alex Moriarty	Date: Oct 2, 2009
*  Course: ENGM 2081		Intructor: Fenton/Phillips
*/

#include<stdio.h>
#include<stdlib.h>


int main(void){
	
	FILE *fout = fopen("a3.2.out","a");
	float magnitude;
	
	printf("Please enter the Richter scale value: ");
	scanf("%f", &magnitude);	
	printf("\tYou entered: %.1f\n", magnitude);

	if( magnitude < 5.0){
		fprintf(fout,"For Richter Scale number %.1f there is little or no damage\n", magnitude);
	} else if(magnitude <5.5){
		fprintf(fout,"For Richter Scale number %.1f there is some damage\n", magnitude);
	} else if(magnitude <6.5){
		fprintf(fout,"For Richter Scale number %.1f there is serious damage\n", magnitude);
	} else if(magnitude <7.5){
		fprintf(fout,"For Richter Scale number %.1f there is a disaster\n", magnitude);
	} else if(magnitude >= 7.5){
		fprintf(fout,"For Richter Scale number %.1f there is a catastrophe\n", magnitude);
	} else
	printf("invalid input\n");

	fclose(fout);
	return 0;
}
