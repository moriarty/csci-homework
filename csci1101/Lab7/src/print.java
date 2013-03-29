/**
 * 
 * @author jacob
 * Ledger
 * Stores a ledger of sales and returns some data about them
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Ledger {
	//Initialize local variables
	private ArrayList<Double> sale;
	private int salesMade;
	
	//Setup the array list and start the sales made counter
	public Ledger(){
		this.sale = new ArrayList<Double>();
		salesMade = 0;
	}
	
	//Adds a sale to the ledger
	public void addSale(double v){
		if(v > 0){
			this.sale.add(v);
			this.salesMade++;
		}
	}
	
	//Returns the sales counter
	public int getNumberOfSales(){
		return this.salesMade;
	}
	
	//Calculates the total sales
	public double getTotalSales(){
		double total = 0;
		
		for(int i = 0; i < this.sale.size(); i++){
			total += this.sale.get(i);
		}
		
		return total;
	}
	
	//Gets the average amount per sale
	public double getAverageSale(){
		return this.getTotalSales()/this.getNumberOfSales();
	}
	
	//Returns the number of sales above value 'v'
	public int getCountAbove(double v){
		int count = 0;
		
		for(int i = 0; i < this.sale.size(); i++){
			if(this.sale.get(i) > v)
				count++;
		}
		
		return count;
	}
}
import java.util.Scanner;
public class test1 {
	public static void main(String args[]){
		//Create a new ledger and keyboard input reader
		Ledger myLedger = new Ledger();
		Scanner keyboard = new Scanner(System.in);
		double curSale = -1;
		
		//Ask user to enter some sales
		System.out.println("Enter the values of the sales, end with -1: ");
		curSale = keyboard.nextDouble();
		
		//Loop through the sales until -1 is found
		while(curSale != -1){
			myLedger.addSale(curSale);
			curSale = keyboard.nextDouble();
		}
		
		//Display some data about the Ledger
		System.out.println(
			"Number of sales: "+myLedger.getNumberOfSales()+
			"\nTotal sales: "+myLedger.getTotalSales()+
			"\nAverage sales: " +myLedger.getAverageSale()+
			"\nNumber of sales above $100.00: "+myLedger.getCountAbove(100)
		);
		
	}
}

/**
 * Sample Output:
Enter the values of the sales, end with -1: 
90 30 40 80 34.5 105.7 -1
Number of sales: 6
Total sales: 380.2
Average sales: 63.36666666666667
Number of sales above $100.00: 1
--
Enter the values of the sales, end with -1: 
-1
Number of sales: 0
Total sales: 0.0
Average sales: NaN
Number of sales above $100.00: 0
--
Enter the values of the sales, end with -1: 
150 200 -2 500.50 1050.99 -1
Number of sales: 4
Total sales: 1901.49
Average sales: 475.3725
Number of sales above $100.00: 4
*/

import java.util.ArrayList;
import java.util.Scanner;
public class test2 {
	public static ArrayList<Integer> remove(ArrayList<Integer> list, int v){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) != v)
				temp.add(list.get(i));
		}
		
		return temp;
	}
	
	public static void main(String args[]){
		//Initialize objects / variables
		int curVal = 0;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		System.out.println("Please enter a list of integers: ");
		curVal = keyboard.nextInt();
		
		while(curVal > 0){
			myList.add(curVal);
			curVal = keyboard.nextInt();
		}
		
		keyboard.nextLine();
		System.out.print("Number to remove from list: ");
		ArrayList<Integer> newList = remove(myList, keyboard.nextInt());
		
		System.out.println("New list:\n"+newList);
	}
}

/**
 * Sample Output:
Please enter a list of integers: 
2 4 7 10 100 5 5 4 3 5 8 -1
Number to remove from list: 5
New list:
[2, 4, 7, 10, 100, 4, 3, 8]
--
Please enter a list of integers: 
10 10 10 10 -1
Number to remove from list: 10
New list:
[]
--
Please enter a list of integers: 
100 78 -1 20
Number to remove from list: 78
New list:
[100]
*/
import java.util.ArrayList;
import java.util.Scanner;
public class test3 {
	public static void main(String args[]){
		 //Declare two arraylists and a user input source
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<String> l2 = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);
		String curString;
		
		//Ask user to input strings & add them to the first list
		System.out.println("Enter words on one line, end with -1");
		curString = keyboard.next();
		while(!curString.equalsIgnoreCase("-1")){
			l1.add(curString);
			curString = keyboard.next();
		}
		
		//Ask user to input strings & add them to the second list
		System.out.println("Enter words on one line, end with -1");
		curString = keyboard.next();
		while(!curString.equalsIgnoreCase("-1")){
			l2.add(curString);
			curString = keyboard.next();
		}
		
		//Display the common strings
		System.out.println(getCommonStrings(l1, l2));
	}
	
	//Return an array list with all of the common strings contained within
	public static ArrayList<String> getCommonStrings(ArrayList<String> list1, ArrayList<String> list2){
		ArrayList<String> common = new ArrayList<String>();
		
		//Loop through both lists to find common strings
		for(int i = 0; i < list1.size(); i++){
			String curString = list1.get(i);
			boolean alreadyAdded = false;
			for(int k = 0; k < common.size(); k++){
				alreadyAdded = common.get(k).equalsIgnoreCase(curString);
			}
			if(alreadyAdded)
				continue;
			for(int n = 0; n < list2.size(); n++){
				//If a common string is found, add it to the arraylist, and then continue the list 1 loop
				if(curString.equals(list2.get(n))){
					common.add(curString);
					break;
				}
			}
		}
		
		return common;
	}
}

/**
 * Sample Output:
Enter words on one line, end with -1
google microsoft george bush ttt -1
Enter words on one line, end with -1
omg ggkthx ttt lol yes google -1
[google, ttt]
--
Enter words on one line, end with -1
no no no yes omg ... lol abc jacob -1
Enter words on one line, end with -1
do not touch no -1
[no]
--
Enter words on one line, end with -1
sdkj skjdaf fsdkjg ksdfjag -1
Enter words on one line, end with -1
lsdjg sdkjg sljangjg sdjnfjs jjj -1
[]
*/
/*
 * This is both Exercise 4 and the first bonus question concatenated into one. 
 */
import java.util.ArrayList;
import java.util.Scanner;
public class test4 {
	public static void main(String args[]){
		//Create keyboard scanner && array list
		Scanner keyboard = new Scanner(System.in);
		int curInt;
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		
		//Get new array list from user input
		System.out.println("Enter numbers on one line, end with -1");
		curInt = keyboard.nextInt();
		while(curInt != -1){
			l1.add(curInt);
			curInt = keyboard.nextInt();
		}
		
		//Print orig. list, remove duplicates, and print new list
		System.out.println(l1);
		removeDuplicates(l1);
		System.out.println(l1);
	}
	
	//Removes duplicates from an arraylist - uses by reference to manipulate
	public static void removeDuplicates(ArrayList<Integer> data){
		//Get the arraylist size
		int size = data.size();
		
		//Start counter i
		for(int i = 0; i < size; i++){
			//Recalibrate size
			size = data.size();
			//Start counter n, which will always be at least one ahead of counter i
			for(int n = i+1; n < size; n++){
				//Recalibrate size - May not be needed, but added just in case
				size = data.size();
				//If it finds a duplicate of the current entry, the entry is removed, counter i is reduced by one to compensate and the n counter loop is broken
				if(data.get(i) == data.get(n)){
					data.remove(n);
					i--;
					break;
				}
			}
		}
	}
}
/**
 * Sample Output:
Enter numbers on one line, end with -1
10 10 20 30 40 40 30 20 10 -1
[10, 10, 20, 30, 40, 40, 30, 20, 10]
[10, 20, 30, 40]
--
Enter numbers on one line, end with -1
10 10 10 10 20 30 40 40 50 50 40 30 20 -1
[10, 10, 10, 10, 20, 30, 40, 40, 50, 50, 40, 30, 20]
[10, 20, 30, 40, 50]
--
Enter numbers on one line, end with -1
50 40 30 20 10 10 10 20 30 40 50 -1
[50, 40, 30, 20, 10, 10, 10, 20, 30, 40, 50]
[50, 40, 30, 20, 10]
*/
import java.util.ArrayList;
public class Paragraph {
	//Store an ArrayList of sentence array lists
	ArrayList<ArrayList<String>> sentences;
	
	//Initialize the sentence list
	public Paragraph(){
		sentences = new ArrayList<ArrayList<String>>();
	}

	//Adds a setence to the list
	public void addSentence(ArrayList<String> sentence){
		sentences.add(sentence);
	}
	
	//Find a word in a sentence
	public String find(int sentence, int word){
		//Tries to find the specified sentence number. Returns error if it doesn't exist
		try{
			ArrayList<String> curSentence = sentences.get(sentence);
			//Tries to return the specified word. Returns error if it doesn't exist
			try {
				return curSentence.get(word);
			} catch(Exception e){
				System.out.println("Invalid word number.");
			}
		} catch(Exception e){
			System.out.println("Invalid sentence number.");
		}
		return "";
	}
}
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