/**
Write a main program,  minmax.c, which uses two functions  readdat and  minmax to find the maximum and minimum of a set of floats stored in the file  minmax.in.

You may assume that no more than 100 numbers will ever be stored in the input file.

The main program opens the input file and passes the file pointer to the function readdat. The function readdat then reads the numbers stored in the input file into an array, x, and passes the array and the number of elements in the array, n, back to the main. The function readdat should close the input file when it has finished reading the numbers.

The main program then calls the function minmax which computes the minimum and maximum values found in the array and passes these back to main.

The main program then prints the maximum and minimum to the file minmaxdriver.out, in the form:

The maximum value in the array is 44.099998

The minimum value in the array is 5.300000
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define N 100

int readdat(FILE *fin, float x[]);
void minmax(float x[], float *ptr_min, float *ptr_max, int n);

int main(void){
	int n;
	float x[N], min, max;
	FILE *fin = fopen("minmax.in","r");
	FILE *fout = fopen("minmaxdriver.out","w");
	
	n = readdat(fin, x);
	minmax(x, &min, &max, n);
	
	fprintf(fout,"\nThe maximum value in the array is %f\n", max);
	fprintf(fout,"\nThe minimum value in the array is %f\n", min);
	
	fclose(fin);
	fclose(fout);
	return 0;
}
int readdat(FILE *fin, float x[]){
	int n = 0;
	while(fscanf(fin,"%f",&x[n])!=EOF){
		n++;
	}
	return n;
}
void minmax(float x[], float *ptr_min, float *ptr_max, int n){
	float curr;
	int i;
	curr = x[0];
	*ptr_min = curr;
	*ptr_max = curr;
	for( i = 0; i<n; i++){
		curr = x[i];
		if( curr < *ptr_min) *ptr_min = curr;
		if( curr > *ptr_max) *ptr_max = curr;
	}
}
