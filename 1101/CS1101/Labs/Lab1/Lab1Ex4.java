/**
CSCI 1101 – Winter 2009
Laboratory Report 1
Name: Alex Moriarty
Student ID: B00317947
Date of Laboratory:	Jan 14 2009		
Time of Laboratory: 5:35
Signature:
*/

import java.util.Scanner;
	    
public class Lab1Ex4 {
	public static void main(String[] args) {
		for (int num = 2; num<10; num++){
    	
    	if (isPrime(num)) 	
   			System.out.println("the number:"+num+" is Prime");
		}	
	}
	public static boolean isPrime(int num){
    	for (int i = 2; i <= num/2; i++){
    		if (num%i == 0){
    			return false;
    		}
    	}
    	return true;		    
	}
}
/********		_SAMPLE OUTPUT_
--------------------Configuration: <Default>--------------------
the number:2 is Prime
the number:3 is Prime
the number:5 is Prime
the number:7 is Prime

Process completed.
***********************/