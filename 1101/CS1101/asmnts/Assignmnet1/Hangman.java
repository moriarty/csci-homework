/**
 * @(#)Hangman.java
 *
 *
 * @author 
 * @version 1.00 2009/1/25
 */

import java.util.Random;
import java.util.Scanner;

public class Hangman {
	
	
	private char[] secretWord;
	private char[] guessedWord;
	private int numGuess;
	public int numWrong;
	private Random generator = new Random();
	private String[] wordBank = {"clothing","listening","combines","coherent","goldburg","computer","science","abcdefghijklmnopqstuvwxyz"};

    public Hangman() {
    	secretWord = wordBank[generator.nextInt(wordBank.length)].toCharArray();
    	//System.out.println(secretWord);
	   	guessedWord = new char[secretWord.length];
    	for (int i = 0; i < secretWord.length; i++){
    		guessedWord[i] = '?';
   		}
    	numGuess = 0;
    	numWrong = 0;	
    }
    public Hangman(String[] words){
    	secretWord = words[generator.nextInt(words.length)].toCharArray();
    	for (int i = 0; i < secretWord.length; i++){
    		guessedWord[i] = '?';
    	}
    	numGuess = 0;
    	numWrong = 0;
    }
	//makeGuess(c) guesses that character c is in the word.
	public void makeGuess(char c){
		boolean theGuess = false;
		for (int i = 0; i < secretWord.length ; i++){
			if (c == secretWord[i]){
				guessedWord[i] = secretWord[i];
				theGuess = true;
			}
		}	
		if (theGuess == false){
			numWrong += 1;
		}	
		numGuess +=1;			
	}
	//getDisguisedWord returns a String containing correctly guessed letters in the correct positions and unknown letters replaced with ?.
	public String getDisguisedWord(){
		String disguisedWord;
		disguisedWord = new String(guessedWord);
		return disguisedWord;
	}	
	//getSecretWord returns the secret word.
	public String getSecretWord(){
		String word;
		word = new String(secretWord);
		return word;
	}
	//getGuessCount returns the number of guesses made.
	public int getGuessCount(){
		return numGuess;
	}
	//isFound returns true if the hidden word has been discovered.
	public boolean isFound(){
		for (int i = 0; i<secretWord.length; i++){
			if (secretWord[i] != guessedWord[i])
				return false;
		}
		return true;		
	}
}