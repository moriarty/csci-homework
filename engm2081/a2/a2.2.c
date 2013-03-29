/** File roundoffdouble.c (a2.2.c)
*  Shows the problems with roundoffs
*
*  Programmer: Alex Moriarty         Date:
*  Course: ENGM 2081                 Instructors: Fenton/Phillips
*/

#include <stdio.h>


int main(void)
{
  double a, b, c;

  /* you fill in here */
  printf("Please enter two numbers, whom differ by more than 7 significant digits: ");
  scanf("%lf%lf",&a, &b);
  c = a + b;

  printf("The sum of %lf and %lf is %lf\n", a, b, c);   

  //system("pause");

  return 0;
}

