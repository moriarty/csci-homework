/**
Write a main program,  moments.c, which uses the functions  readpoints and  moments to compute the moments of inertia for data read from the file  moments.in.

Each line of the file moments.in consists of three floats giving $x$, $y$ and $m$ for each of the point masses.

The main program opens the input file moments.in and passes the file pointer to the function readpoints which reads the data into three arrays each of size no more than 100 floats. The arrays are passed back to the main, along with the number of masses involved, $n$. The function readpoints should close the input file when it has finished reading the points.

The main program then calls the function moments which uses the arrays and the number of masses involved to compute and return the three required moments according to the above equations.

The main program writes the values of the moments to the output file, moments.out in the form:

Ix = 529.68
Iy = 240.11
Io = 769.78
*/

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define N 100

int readpoints(FILE *fin, float x[], float y[], float m[]);
void moments(float x[], float y[], float m[],float *ptr_xmoment, float *ptr_ymoment, float *ptr_polarmoment, int n);
float xmoment(float y[], float m[], int n);
float ymoment(float x[], float m[], int n);
float polarmoment(float x[], float y[], float m[], int n);

int main(void){
	int n;
	float x[N], y[N], m[N];
	float xmoment, ymoment, polarmoment;
	FILE *fin = fopen("moments.in","r");
	FILE *fout = fopen("moments.out","w");
	
	n = readpoints(fin, x, y, m);
	moments(x, y, m, &xmoment, &ymoment, &polarmoment, n);
	
	fprintf(fout,"\nIx = %.2f\nIy = %.2f\nIo = %.2f\n",xmoment, ymoment, polarmoment);
	
	fclose(fout);
	return 0;
}
int readpoints(FILE *fin, float x[], float y[], float m[]){
	int n = 0;
	while(fscanf(fin,"%f%f%f",&x[n],&y[n],&m[n])!=EOF){
		n++;
	}
	close(fin);
	return n;
}
void moments(float x[], float y[], float m[],float *ptr_xmoment, float *ptr_ymoment, float *ptr_polarmoment, int n){
	*ptr_xmoment = xmoment( y, m, n);
	*ptr_ymoment = ymoment( x, m, n);
	*ptr_polarmoment = polarmoment( x, y, m, n);
}
float xmoment(float y[], float m[], int n){
	int i;
	float xmoment = 0.;
	for( i = 0; i<n; i++){
		xmoment += y[i]*y[i]*m[i];
	}
	return xmoment;
}
float ymoment(float x[], float m[], int n){
	int i;
	float ymoment = 0;
	for( i = 0; i<n; i++){
		ymoment += (x[i])*(x[i])*(m[i]);
	}
	return ymoment;
}
float polarmoment(float x[], float y[], float m[], int n){
	int i;
	float polarmoment = 0;
	for( i = 0; i<n; i++){
		polarmoment += (x[i]*x[i] + y[i]*y[i])*m[i];
	}
	return polarmoment;
}
