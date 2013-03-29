/**
*  File: a4.2.c (sumit.c)
*
*  Programmer: Alex Moriarty	Date: Oct 4 2009
*  Course: ENGM2081		Instructor: Fenton/Phillips
*/

#include<stdio.h>

int main(void){
	int n, i, sum = 0;
	FILE *fout = fopen("a4.2.out","a");
	
	printf("please enter an integer: ");
	scanf("%d", &n);	

	if (n>0){
		for( i = n; i<=n*2; i++){
			sum += i;
		}
		fprintf(fout,"\nThe sum of integers from %d to %d is %d\n", n, 2*n, sum);
	} else if (n<0){
		for( i = n*2; i<=n; i++){
			sum += i;
		}
		fprintf(fout,"\nThe sum of integers from %d to %d is %d\n", 2*n, n, sum);	
	} else
		printf("\nERROR IN INPUT\n");
	


	fclose (fout);
	return 0;
}
