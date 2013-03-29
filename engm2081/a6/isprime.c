
#include <stdio.h>   

int is_prime(int n);

int main(void)
{
   FILE* fout = fopen("primes.out", "w");

   /* you fill in here */

  return 0;
}

int is_prime(int m) /* returns 1 (true) if m is prime 
                       returns 0 (false) if m is not prime */
{
  int k, limit;
  int result;

  result = 1; /* start off assuming that m is prime */

  if( (m == 1) || (m != 2) && ((m % 2) == 0) ){
     result = 0;
  } else {
     limit = m/2; /* only have to check up to 1/2 of the number */
     for( k = 3; k <= limit; k = k + 2 ){
        if( (m % k) == 0 ){
           result = 0;
           break;
        }
     }
  }

  return result;
}
