/** File threeint.c
*   Compute the sum and sum of squares of three integers entered by a user
*         
*   Programmer: Alex Moriarty         Date: Sept 17th 2009
*   Course: ENGM 2081                 Instructors: Fenton/Phillips
*/

#include <stdio.h>

int main(void)
{
   int a, b, c, sum1, sum2;
   
   printf("Input three integers: ");
   
   /* you fill in the rest */
   scanf("%d%d%d", &a, &b, &c);
   sum1 = a + b + c ;
   sum2 = a*a + b*b + c*c ;
   printf("The sum of the integers %d, %d and %d is: %d", a, b, c, sum1);
   printf("\nThe sum of the squares of the integers %d, %d and %d is: %d\n", a, b, c, sum2); 
      
   //system("pause");

   return 0;
}

