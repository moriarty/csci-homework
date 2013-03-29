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

public class Lab1Ex3 {

    public static void main(String[] args) {
		for (int num = 2; num<10000; num++){
    	
    	if (isPerfect(num)) 	
   			System.out.println("the number:"+num+" is Perfect");
		}			
    }
    public static boolean isPerfect(int num){
    	int sum = 0;
    	for (int  i = 1; i <= num/2; i++){
    		if (num%i == 0){
    			sum += i;
    		}
    	}
    	
    	if (num == sum){
    		return true;
    	}else
    		return false;
    } 
}
/******     _SAMPLE OUTPUT_
--------------------Configuration: <Default>--------------------
the number:6 is Perfect
the number:28 is Perfect
the number:496 is Perfect
the number:8128 is Perfect

Process completed.
***************/