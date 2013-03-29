/* File fuel.c
   Converts km/100 L to km/L and miles/gallon
         
   Programmer:                       Date:
   Course: ENGM 2081                 Instructors: Fenton/Phillips
*/

#include <stdio.h>
#define CONVERTTOMPG  282.48

int main(void)
{
   float lp100km, kmpl, mpg;
   
   /* you fill in here */
   printf("Enter the number of litres per 100km: ");
   scanf("%f", &lp100km);
   kmpl = 100 / lp100km;
   mpg = CONVERTTOMPG / lp100km;
   printf("km/L = 100/%.1f = %.2f", lp100km, kmpl);
   printf("\nmi/g = %.2f/%.1f = %.2f\n", CONVERTTOMPG, lp100km, mpg);      
   //system("pause");

   return 0;
}

