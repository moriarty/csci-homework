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
	    
public class Lab1Ex7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	System.out.println("Please enter a integer of four digits: ");
    	int number = input.nextInt(); 
    		
    	System.out.println("the reverse of :"+number+" is :"+digitReverse(number));	
    	}
    public static int digitReverse(int number){
    	String str = "" + number;
    	if (str.length()==4){
    		String rts = "";
    		char[] digits = str.toCharArray();
    		for (int i = str.length() -1; i >= 0; i--){
    			rts += ""+digits[i];
    		}
    		int rebmun = Integer.parseInt(rts);
    		return rebmun;
    	}
    	System.out.println("with four digits next time.");
    	return 0;
  }
}
/********			_SAMPLE OUTPUT_
--------------------Configuration: <Default>--------------------
Please enter a integer of four digits: 
5638
the reverse of :5638 is :8365

Process completed.
--------------------Configuration: <Default>--------------------
Please enter a integer of four digits: 
79856
with four digits next time.
the reverse of :79856 is :0

Process completed.
--------------------Configuration: <Default>--------------------
Please enter a integer of four digits: 
1234
the reverse of :1234 is :4321

Process completed.
*********/