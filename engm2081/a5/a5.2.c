#include<stdio.h>
#include<stdlib.h>

void print_astrix(int n, FILE *fout){
	fprintf(fout," %d: ", n);
	int z;
	for(z=0; z<n; z++){
		 fprintf(fout,"*");
	}
	fprintf(fout,"\n");	
}

/*
	NOTE: Program Expects Input from a file named a5.2.in !
*/

int main(void){

	int a=0, e=0, i=0, o=0, u=0;
	char ch;
	FILE *fout=fopen("a5.2.out","w");
	FILE *fin=fopen("a5.2.in","r");

	while( fscanf(fin,"%c",&ch) != EOF ){
		if(ch == 'A' || ch == 'a')
			a++;
		else if(ch =='E' || ch == 'e')
			e++;
		else if(ch =='I' || ch == 'i')
			i++;
		else if(ch =='O' || ch == 'o')
			o++;
		else if(ch =='U' || ch == 'u')
			u++;	
	}
	
	fprintf(fout,"a:");
	print_astrix(a, fout);
	fprintf(fout,"e:");
	print_astrix(e, fout);
	fprintf(fout,"i:");
	print_astrix(i, fout);
	fprintf(fout,"o:");
	print_astrix(o, fout);
	fprintf(fout,"u:");
	print_astrix(u, fout);

	return 1;

}	

