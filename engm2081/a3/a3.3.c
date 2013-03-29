/**
*  File a3.3.c (mempic.c)
*	
*  Programmer: Alex Moriarty	Date: Oct 2, 2009
*  Course: ENGM2081 		Instructor Fenton/Phillips
*/

#include<stdlib.h>
#include<stdio.h>

int main(void){
		
	FILE *fout = fopen("a3.3.out","w");
	int x=1, y=2, tmp;
	int* p = &x;
	int* q = &y;
	
	fprintf(fout,"\nVariable\t\tValue\t\tAddress\n");
	fprintf(fout,"-------------------------------------------------\n");

	fprintf(fout,"x\t\t\t%d\t\t%u\n", x, &x);
	fprintf(fout,"y\t\t\t%d\t\t%u\n", y, &y);
	fprintf(fout,"tmp\t\t\t%d\t\t%u\n", tmp, &tmp);
	fprintf(fout,"p\t\t\t%u\t%u\n", p, &p);
	fprintf(fout,"q\t\t\t%u\t%u\n", q, &q);
	fprintf(fout,"*p\t\t\t%u\n", *p);
	fprintf(fout,"*q\t\t\t%u\n", *q);
	
	fprintf(fout,"\n-------------------------------------------------\n");

	/*Assignment Statements*/
	tmp = *p;
	*p = *q;
	*q = tmp;

	fprintf(fout,"After the assignment statements\n");
	fprintf(fout,"-------------------------------------------------\n");
	fprintf(fout,"Variable\t\tValue\t\tAddress\n");

	fprintf(fout,"x\t\t\t%d\t\t%u\n", x, &x);
        fprintf(fout,"y\t\t\t%d\t\t%u\n", y, &y);
        fprintf(fout,"tmp\t\t\t%d\t\t%u\n", tmp, &tmp);
        fprintf(fout,"p\t\t\t%u\t%u\n", p, &p);
        fprintf(fout,"q\t\t\t%u\t%u\n", q, &q);
        fprintf(fout,"*p\t\t\t%u\n", *p);
        fprintf(fout,"*q\t\t\t%u\n", *q);

	fclose(fout);
	return 0;
}
