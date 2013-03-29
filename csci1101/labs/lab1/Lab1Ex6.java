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
	    
public class Lab1Ex6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	System.out.println("Please enter a String of letters: ");
    	String word = input.nextLine();    
    	
    	System.out.println(word+" has "+countVowels(word)+" vowel(s)");
    }
    public static int countVowels(String word){
		char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
		int counter = 0;
		char[] letters = word.toCharArray();
		for(int i = 0; i<word.length(); i++){
			for(int j=0; j<9; j++)
				if(letters[i] == vowels[j])
					counter += 1;
		}
		return counter;
	}
}
/******        _SAMPLE OUTPUT_
--------------------Configuration: <Default>--------------------
Please enter a String of letters: 
hello_world
hello_world has 3 vowel(s)

Process completed.
--------------------Configuration: <Default>--------------------
Please enter a String of letters: 
computer
computer has 3 vowel(s)

Process completed.
--------------------Configuration: <Default>--------------------
Please enter a String of letters: 
qwerty
qwerty has 1 vowel(s)

Process completed.
**********/
