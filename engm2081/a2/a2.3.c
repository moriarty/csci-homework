/** File approx.c (a2.3.c)
*  Uses 5 terms of the power series expansion of exp(x) to 
*  approximate the function
*
*  Programmer: Alex Moriarty         Date:
*  Course: ENGM 2081                 Instructors: Fenton/Phillips
*/

#include <stdio.h>
#include <math.h>

int main()
{

  float x, actual, approx1, approx2, err1, err2;

  /* you fill in here */
  printf("Please insert a value for x: ");
  scanf("%f", &x);
  actual = exp(-x);
  /*method 1*/
  approx1 = 1 - x + pow(x,2)/factorial(2) - pow(x,3)/factorial(3) + pow(x,4)/factorial(4) ;
  /*method 2*/
  approx2 = 1 / (1 + x + pow(x,2)/factorial(2) + pow(x,3)/factorial(3) + pow(x,4)/factorial(4));
  /* % error */
  err1 = (fabs((approx1-actual)/actual)*100) ;
  err2 = (fabs((approx2-actual)/actual)*100) ;

  printf("\nThe actual value of e^-1 is: %f\n", actual);
  printf("\nMethod 1 gives us a value of: %f\n", approx1);
  printf("This method has a percent error of: %f %\n", err1);
  printf("\nMethod 2 gives us a value of: %f\n", approx2);
  printf("This method has a percent error of: %f %\n\n", err2);

  return 0;
}

int factorial(int n){
  if ( n <= 1 )
    return 1;
  else
    return n * factorial( n - 1);
}

