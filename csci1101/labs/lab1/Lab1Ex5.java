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
	    
public class Lab1Ex5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	System.out.println("Please enter a String of letters: ");
    	String word = input.nextLine();
		
		if (isReverse(word)){
			System.out.println(word+" is a Palendron");
		}else
			System.out.println(word+" is not a Palendron");
	}
	public static boolean isReverse(String word)
	{
		char[] letters = word.toCharArray();
		for (int i = 0; i < word.length(); i++)
		{
			if(letters[i] != letters[word.length()-1-i])
				return false;
		}
		return true;
	}
}
/******         _SAMPLE OUTPUT_
--------------------Configuration: <Default>--------------------
Please enter a String of letters: 
racecar
racecar is a Palendron

Process completed.
--------------------Configuration: <Default>--------------------
Please enter a String of letters: 
dad
dad is a Palendron

Process completed.
--------------------Configuration: <Default>--------------------
Please enter a String of letters: 
dog
dog is not a Palendron

Process completed.
********/