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