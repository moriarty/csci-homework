/**
*  File: a4.1.c (smog.c)
*
*  Programmer:	Alex Moriarty	Date: Oct 4 2009
*  Course: ENGM2081		Instructor: Fenton/Phillips
*/

#include <stdio.h>

int main(void){
	float ozone, nitrogen, carbon;
	FILE *fout = fopen("a4.1.out","a");
	
	printf("Enter the ozone level: ");
	scanf("%f", &ozone);
	fprintf(fout,"\nozone level: %.1f\n", ozone);
	printf("Enter the nitrogen dioxide level: ");
	scanf("%f", &nitrogen);
	fprintf(fout,"nitrogen dioxide level: %.1f\n", nitrogen);
	printf("Enter the carbon monoxide level: ");
	scanf("%f", &carbon);
	fprintf(fout,"carbon monoxide level: %.1f\n", carbon);

	if (carbon > 275 || nitrogen > 275 || ozone > 275)
		fprintf(fout,"second-stage smog alert\n");
	else if (carbon > 200 || nitrogen > 200 || ozone > 200)
		fprintf(fout,"first-stage smog alert\n");
	else if (carbon > 100 || nitrogen > 100 || ozone > 100)
		fprintf(fout,"unhealthy\n");
	else
		fprintf(fout,"air ok\n");

	fclose(fout);	
	
	return 0;
}


