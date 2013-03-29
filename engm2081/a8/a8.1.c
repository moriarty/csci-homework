/**



*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define N 100

void norms(float x[], float *ptr_norm1, float *ptr_norm2, int n);
float norm1(float x[], int n);
float norm2(float x[], int n);

int main(void){
	float x[N], norm1, norm2;
	int n = 0;
	FILE *fin = fopen("length.in","r");
	FILE *fout = fopen("length.out","w");
	
	/**	this loop just finds length of array, while setting it from file*/
	while(fscanf(fin,"%f",&x[n])!=EOF){
		n++;
	}
	
	norms(x, &norm1, &norm2, n);
	
	fprintf(fout,"\nThe 1-norm of the array is %f\n", norm1);
	fprintf(fout,"\nThe 2-norm of the array is %f\n", norm2);
	
	fclose(fin);
	fclose(fout);
	return 0;
}
void norms(float x[], float *ptr_norm1, float *ptr_norm2, int n){
	*ptr_norm1 = norm1(x, n);
	*ptr_norm2 = norm2(x, n);
}
float norm1(float x[], int n){
	float norm1 = 0;
	int i;
	for (i=0; i<n; i++){
		norm1 += abs( x[i] );
	}
	return norm1;
}
float norm2(float x[], int n){
	float norm2 = 0;
	int i;
	for (i=0; i<n; i++){
		norm2 += x[i]*x[i];
	}
	norm2 = sqrt(norm2);
	return norm2;
}
