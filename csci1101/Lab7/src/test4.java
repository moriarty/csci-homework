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