/**
 * Alex Moriarty 
 * VirusList 
 */
 
import java.util.ArrayList;
public class VirusList {
	private Node head;
	public VirusList(){	
	}
	/**
	*	Spreads the virus from one person to another
	*/
	public void spread(String from, String to){
		Node spread = new Node(from, to, this.head);
		this.head = spread;
	}	
	/**
	*	returns true if they've spread virus
	*/
	private boolean hasSpread(String name){
		Node curr = this.head;
		while(curr != null){
			if(curr.getFrom().equalsIgnoreCase(name))
				return true;
			curr = curr.getNext();
		}
		return false;
	}	
	/**
	*	Checks to see if the arraylist contains the specified string
	*/
	private boolean listContains(ArrayList<String> list, String name){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).equalsIgnoreCase(name))
				return true;
		}
		return false;
	}	
	/**
	*	Returns people who have not spread the virus
	*/
	public ArrayList<String> getNotSpread(){
		Node curr = this.head;
		ArrayList<String> notSpread = new ArrayList<String>();
		
		while(curr != null){
			String currName = curr.getTo();
			if(!this.listContains(notSpread, currName) && !this.hasSpread(currName))
				notSpread.add(currName);
			curr = curr.getNext();
		}
		
		return notSpread;
	}
	/**
	*	Returns an array list of people who got sick from
	*	the a person in a chain of 'n' links or fewer
	*/
	public ArrayList<String> sickFrom(String N, int n){
		ArrayList<String> sick = new ArrayList<String>();
		ArrayList<Node> strand = this.getStrand(N);
		
		if(n > 0){
			for(int i = 0; i < strand.size(); i++){
				sick.add(strand.get(i).getTo());
				ArrayList<String> temp = this.sickFrom(strand.get(i).getTo(), n - 1);
				for(int j = 0; j < temp.size(); j++){
					sick.add(temp.get(j));
				}
			}
		}		
		return sick;
	}
	/**
	*	returns the strand of the virus that 'n' started
	*/
	private ArrayList<Node> getStrand(String n){
		Node curr = this.head;
		ArrayList<Node> nodes = new ArrayList<Node>();
		while(curr != null){
			if(curr.getFrom().equalsIgnoreCase(n))
				nodes.add(curr);
			curr = curr.getNext();
		}
		return nodes;
	}
}