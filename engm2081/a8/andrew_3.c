/* File: moments.c
   Programmer: Andrew Hebb           Date: 24 November, 2009
   Course: C Programming             Instructor: Fenton/Phillips
*/
#include <stdio.h>
#define N 100
int readpoints(/*FILE* fin,*/float* x,float* y,float* m);

void moments(int n,float* ix,float* iy,float* io,float* x,float* y,float* m);

int main(void){
   /*FILE *fin=fopen("moments.in","r");*/
   FILE *fout=fopen("moments.out","w");
   int n;
   float ix=0,iy=0,io=0;
   float x[N],y[N],m[N];
   n=readpoints(/*fin,*/x,y,m);
   moments(n,&ix,&iy,&io,x,y,m);
   fprintf(fout,"Ix = %.2f\n",ix);
   fprintf(fout,"Iy = %.2f\n",iy);
   fprintf(fout,"Io = %.2f\n",io);
   return 0;
}

int readpoints(/*FILE* fin,*/float* x,float* y,float* m){
   int i;
   FILE *fin=fopen("moments.in","r");
   for(i=0;!feof(fin);i++){
      fscanf(fin,"%f",&x[i]);
      fscanf(fin,"%f",&y[i]);
      fscanf(fin,"%f",&m[i]);
   }
   fclose(fin);
   return i;
}/*
int readpoints(FILE *fin, float x[], float y[], float m[]){
	int n = 0;
	while(fscanf(fin,"%f%f%f",&x[n],&y[n],&m[n])!=EOF){
		n++;
	}
	close(fin);
	return n;
}*/
void moments(int n,float* ix,float* iy,float* io,float* x,float* y,float* m){
   int i;
   
   for(i=0;i<n;i++){
      *ix+=y[i]*y[i]*m[i];
      *iy+=x[i]*x[i]*m[i];
      *io+=(x[i]*x[i]+y[i]*y[i])*m[i];
   }
   
}
