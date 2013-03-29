/**
*  File: a3.1.c (category.c)
*  
*  Programmer: Alex Moriarty	Date: October 2, 2009
*  Course: ENGM 2081		Instructor: Fenton/Phillips
*/

#include <stdio.h>
#include <stdlib.h>

int main(void){
	FILE *fout = fopen("a3.1.out","a");
	float price;
	
	printf("Enter the price of the item: ");
	scanf("%f", &price);
	
	printf("\n\tYou entered %.2f\n", price);	

	if (price > 0 && price < 1){
		fprintf(fout, "price = %.2f,\tcategory = A\n", &price);
	} else if (price >=1 && price < 5){
		fprintf(fout, "price = %.2f,\tcategory = B\n", &price);
	} else if (price >=5 && price <10){
		fprintf(fout, "price = %.2f,\tcategory = C\n", &price);
	} else if (price >=10 && price < 20){
		fprintf(fout, "price = %.2f,\tcategory = D\n", &price);
	} else if (price >=20){
		fprintf(fout, "price = %.2f,\tcategory = E\n", &price);
	} else
	printf("invalid price");
	return 0;	
}
