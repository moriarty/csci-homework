/**
*  File: a4.4.c (approxpi.c)
* 
*  Programmer: Alex Moriarty	Date: Oct 5 2009
*  Course: Engm2081		Instructor: Fenton/Phillips
*/

#include<stdio.h>
#include<math.h>

#define PI 4.0*atan(1.0)

int main(void){
	float pi, s = 0, i, err;
	int n;
	FILE *fout = fopen("a4.4.out","a");	

	/*pi = 12.*(1-.25+1/9-1/16.);
	
	pi = sqrt(pi);
	*/
	printf("Enter a value for n: ");
	scanf("%d", &n);

	for(i = 1; i<=n; i++){
		if ((int)i%2 == 0){
			s = s - 1./(i*i); 
		}else
			s = s + 1./(i*i);	
	}
	
	pi = 12*s;
	pi = sqrt(pi);
	err = (fabs((PI-pi)/PI)*100);

	fprintf(fout,"\nActual value of PI is: %f\n", PI);
	fprintf(fout,"After %d terms pi is approximately: %f\n", n, pi);	
	fprintf(fout,"The relative error is: %f\n", err);
	fclose(fout);
	return 0;
}
