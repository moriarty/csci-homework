/** File: coins.c
*   Compute the value of coins entered by the user
*         
*   Programmer: Alex Moriarty         Date: Sept 17 2009
*   Course: ENGM 2081                 Instructors: Fenton/Phillips
*/

#include <stdio.h>

int main(void)
{
   int h;  /* number of half dollars */
   int q;  /* number of quarters     */
   int d;  /* number of dimes        */
   int n;  /* number of nickels      */
   int p;  /* number of pennies      */
      
   /* you fill in the rest */
   int total, value;
   printf("How many half dollars do you have? "); 
   scanf("%d", &h);  
   printf("How many quarters do you have? "); 
   scanf("%d", &q);   
   printf("How many dimes do you have? ");   
   scanf("%d", &d);
   printf("How many nickels do you have? "); 
   scanf("%d", &n);
   printf("How many pennies do you have? "); 
   scanf("%d", &p);
   total = h+q+d+n+p;
   value = 50*h+25*q+10*d+5*n+p;
   printf("\nYou entered:\t%d half dollars\n\t\t%d quarters\n\t\t%d quarters\n\t\t%d dimes\n\t\t%d pennies\n", h, q, d, n, p);
   printf("The value of your %d coins is equivalent to %d pennies\n", total, value);
   return 0;
}

