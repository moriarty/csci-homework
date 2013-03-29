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

public class Lab1Ex2 {

    public static void main(String[] args) {
		int num;
    	
    	Scanner input = new Scanner(System.in);
    	System.out.println("Please enter an possitive Integer: ");
    	num = input.nextInt();
    	
    	if (isPerfect(num)){  	
   			System.out.println("the number:"+num+" is Perfect");
   		}else
   			System.out.println("the number:"+num+" is not Perfect"); 
    }
    public static boolean isPerfect(int num){
    	int sum = 0;
    	if (num < 0){
    		System.out.println("The Number is not Perfect, because its negative");
    	} else 
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
/*******		_SAMPLE OUTPUT_
 --------------------Configuration: <Default>--------------------
Please enter an possitive Integer: 
6
the number :6 is perfect.

Process completed.
--------------------Configuration: <Default>--------------------
Please enter an possitive Integer: 
28
the number :28 is perfect.

Process completed
--------------------Configuration: <Default>--------------------
Please enter an possitive Integer: 
3
the number :3 is not perfect

Process completed.

****************/