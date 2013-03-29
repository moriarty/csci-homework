/**
 * Lab 7 #2
 * Exe2.java
 * Alex Moriarty 
 * 2009/3/4
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Exe2 {

    public Exe2() {
    }
    public static ArrayList<Integer> remove(ArrayList<Integer> list, int v){
    	ArrayList<Integer> newList = new ArrayList<Integer>();
    	for (int i = 0; i < list.size(); i++){
    		if (list.get(i)!=v){
    			newList.add(list.get(i));
    		}
    	}
    	return newList;
    }
    	public static void main(String args[]){
		int curr = 0;
		Scanner input= new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		System.out.println("Please enter integers, end with -1: ");
		curr = input.nextInt();
		
		while(curr > 0){
			list.add(curr);
			curr = input.nextInt();
		}		
		input.nextLine();
		System.out.print("Number to be removed: ");
		ArrayList<Integer> newList = remove(list, input.nextInt());
		
		System.out.println("New list:\n"+newList);
	}
}
/*
--------------------Configuration: <Default>--------------------
Please enter integers, end with -1: 
5 6 6 4 3 2 5 3 1
-1
Number to be removed: 3
New list:
[5, 6, 6, 4, 2, 5, 1]

Process completed.
--------------------Configuration: <Default>--------------------
Please enter integers, end with -1: 
7 7 7 6 3 3 2 33 7 3 7 6 7 4 7
1
-1
Number to be removed: 7
New list:
[6, 3, 3, 2, 33, 3, 6, 4, 1]

Process completed.
*/