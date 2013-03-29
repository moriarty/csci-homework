/**
 * @(#)HangmanDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/25
 */
import java.util.Scanner;

public class HangmanDemo1 {
        
public static void main(String[] argsj) {
		Hangman game;
		game = new Hangman();
		System.out.println("let the game begin, don't make too many wrong guesses. \nGood Luck!");		
		while ((game.isFound() == false) && game.numWrong < 6){
			System.out.println(game.getDisguisedWord());
			Scanner input = new Scanner(System.in);
			char guess = input.next().charAt(0);
			game.makeGuess(guess);
			System.out.println();
		}
		if (game.isFound() == true){
			System.out.println("GoodWork, you guessed it:\t"+game.getSecretWord());
		}else
			System.out.println("Sorry, "+game.numWrong+" is just too many wrong guesses... maybe next time.");
		System.out.println("the word was: "+game.getSecretWord());
		System.out.println("it took you: " +game.getGuessCount());
		System.out.println("your score was: "+(game.getGuessCount()-game.numWrong)+"/"+game.getGuessCount());				
	}

}
