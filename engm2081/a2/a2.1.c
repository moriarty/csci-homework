/** File roundoff.c (a2.1.c)
*  Shows the problems with roundoffs
*
*  Programmer: Alex Moriarty         Date:
*  Course: ENGM 2081                 Instructors: Fenton/Phillips
*/

#include <stdio.h>


int main(void)
{
  float a, b, c;

  /* you fill in here */
  printf("Please enter two numbers, whom differ by more than 7 significant digits: ");
  scanf("%f%f",&a, &b);
  c = a + b;

  printf("The sum of %f and %f is %f\n", a, b, c);   

  //system("pause");

  return 0;
}

