import java.util.ArrayList;
import java.util.Scanner;
public class bonus {
	public static void main(String args[]){
		//Create instance objects & vars
		Scanner keyboard = new Scanner(System.in);
		Paragraph doc = new Paragraph();
		String paragraph = "";
		String[] sentences;
		int searchSentence = 0, searchWord = 0;
		
		//Get the user to input an entire paragraph
		System.out.println("Input a paragraph:");
		paragraph = keyboard.nextLine();
		//Split the paragraph into sentences
		sentences = paragraph.split("\\.");
		
		//Loop through the sentences and add their words to an arraylist
		for(int i = 0; i < sentences.length; i++){
			ArrayList<String> curSentence = new ArrayList<String>();
			String[] words = sentences[i].split(" ");
			for(int n = 0; n < words.length; n++){
				curSentence.add(words[n]);
			}
			//Add the sentence arraylist to the paragraph
			doc.addSentence(curSentence);
		}
		
		//Ask user what they would like to search
		System.out.print("What sentence number would you like to search? ");
		searchSentence = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Which word number would you like to display? ");
		searchWord = keyboard.nextInt();
		//Print the word that they specified, if valid
		System.out.println(doc.find(searchSentence-1, searchWord-1));
	}
}
/**
 * Sample Output: 
Input a paragraph:
Note that it can be tricky to scan an ArrayList and simultaneously remove items from it. This is due to the fact that when you remove or add an item, the list adjusts itself and hence the index used for scanning will not be pointing to the same location.
What sentence number would you like to search? 1
Which word number would you like to display? 3
it
--
Input a paragraph:
Note that it can be tricky to scan an ArrayList and simultaneously remove items from it. This is due to the fact that when you remove or add an item, the list adjusts itself and hence the index used for scanning will not be pointing to the same location.
What sentence number would you like to search? 20
Which word number would you like to display? 4
Invalid sentence number.
--
Input a paragraph:
Note that it can be tricky to scan an ArrayList and simultaneously remove items from it. This is due to the fact that when you remove or add an item, the list adjusts itself and hence the index used for scanning will not be pointing to the same location.
What sentence number would you like to search? 2
Which word number would you like to display? 30
pointing
--
Input a paragraph:
Note that it can be tricky to scan an ArrayList and simultaneously remove items from it. This is due to the fact that when you remove or add an item, the list adjusts itself and hence the index used for scanning will not be pointing to the same location.
What sentence number would you like to search? 2
Which word number would you like to display? 100
Invalid word number
*/