/**
 * Lab 7 #3
 * Exe3.java
 * Alex Moriarty 
 * 2009/3/4
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Exe3 {

    public Exe3() {
    }
    //GGROSS, 3 nested for loops.. 
    public static ArrayList<String> getCommonStrings(ArrayList<String> list1, ArrayList<String> list2){
    	ArrayList<String> list = new ArrayList<String>();
    	for (int i = 0; i < list1.size(); i++){
    		if (contains(list2, list1.get(i))==true && contains(list, list1.get(i))==false){
    			list.add(list1.get(i));
    		} 
    	}
    	return list; 
    }
    public static boolean contains(ArrayList<String> list, String str){
    	for (int k = 0; k < list.size(); k++){
    		if (list.get(k).equalsIgnoreCase(str)){
    			return true;
    		}	
    	}
    	return false;
    }
    	public static void main(String args[]){
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<String> l2 = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String curr;
		System.out.println("Enter words on one line, end with -1");
		curr = input.next();
		while(!curr.equalsIgnoreCase("-1")){
			l1.add(curr);
			curr = input.next();
		}
		System.out.println("Enter words, end with -1");
		curr = input.next();
		while(!curr.equalsIgnoreCase("-1")){
			l2.add(curr);
			curr = input.next();
		}
		System.out.println(getCommonStrings(l1, l2));
	}
}
/*
--------------------Configuration: <Default>--------------------
Enter words on one line, end with -1
the dog ate a cat that stank -1
Enter words, end with -1
that stank is coming from the dog -1
[the, dog, that, stank]

Process completed.
*/