#include <stdio.h>
#include <math.h>

float cross_sectional_area(int base, int height);
float moment_of_inertia(int base, int height);
float section_modulus(int base, int height);

int main(void){

	int b, h;
	float crossArea, inertia, modulus;	
	FILE *fout = fopen("a5.4.out","w");

	fprintf(fout,"Lumber Size     Cross sectional     Moment of       Section\n                    Area            Inertia         Modulus\n------------------------------------------------------------\n");

	for(b=2;b<=10;b+=2){
		for(h=2;h<=12;h+=2){
			crossArea = cross_sectional_area(b,h);
			inertia = moment_of_inertia(b,h);
			modulus = section_modulus(b,h);

			fprintf(fout, "%2d x %2d %16.2f %16.2f %16.2f\n", b, h,  crossArea, inertia, modulus);
		}	
	}
}

float cross_sectional_area(int base, int height){
	return base*height*1.0;
}

float moment_of_inertia(int base, int height){
	return (base*pow(height,3))/12.0 ;
}

float section_modulus(int base, int height){
	return (base*pow(height,2))/6.0 ;
}
