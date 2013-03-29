#include<stdio.h>
#include<stdlib.h>

int main(void){
	
	float num, sum = 0;
	FILE *fin = fopen("a5.1.in","r");
	int count = 0;

	while(fscanf(fin,"%f", &num) != EOF ){
		sum += num*num*num;
		count++;
	}
	
	printf("\n%d floats were read\nthe sum of cubes is %.3f\n",count,sum);

}
