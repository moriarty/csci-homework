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
