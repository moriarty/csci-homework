/**
 * Lab 7 #4
 * Exe4.java
 * Alex Moriarty 
 * 2009/3/4
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Exe4 {

    public Exe4() {
    }
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> data) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i<data.size(); i++){
    		if (contains(list, data.get(i))==false){
    			list.add(data.get(i));
    		}
    	}
    	return list;
    }
    public static boolean contains(ArrayList<Integer> list, int n){
    	for (int k = 0; k < list.size(); k++){
    		if (list.get(k)==n){
    			return true;
    		}	
    	}
    	return false;
    }
    public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int curr;
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		System.out.println("Enter numbers, end with -1");
		curr = input.nextInt();
		while(curr != -1){
			l1.add(curr);
			curr = input.nextInt();
		}
		System.out.println(l1);
		System.out.println(removeDuplicates(l1));
	}    
}
/*
--------------------Configuration: <Default>--------------------
Enter numbers, end with -1
1 2 11 2 1 5 33 2 33 4 1 2 -1
[1, 2, 11, 2, 1, 5, 33, 2, 33, 4, 1, 2]
[1, 2, 11, 5, 33, 4]

Process completed.
--------------------Configuration: <Default>--------------------
Enter numbers, end with -1
1 1 1 1 1 1 1 -1 
[1, 1, 1, 1, 1, 1, 1]
[1]

Process completed.
*/