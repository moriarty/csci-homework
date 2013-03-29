/**
*  File: a4.3.c (decay.c)
*  
*  Programmer: Alex Moriarty	Date: Oct 5 2009
*  Course: ENGM 2081 		Instructor: Fenton/Phillips
*/

#include<stdio.h>
#include<math.h>

int main(void){
	FILE *fout = fopen("a4.3.out","a");	
	float H = 28, y, intial_amount, amount;
	int i;
	
	printf("\nPlease enter intial amount: ");
	scanf("%f", &intial_amount);
	printf("\nPlease enter number of years: ");
	scanf("%f", &y);

	fprintf(fout,"\n--------------\nyear\tamount remaining\n");

	for( i = 1; i<=y; i++){
		amount = (intial_amount)*(pow(2,(-i/H)));
		
		fprintf(fout,"  %d\t%.2f\n", i, amount);
	}
	
	fclose(fout);
	return 0;
}
