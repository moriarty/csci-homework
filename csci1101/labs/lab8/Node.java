/**
 * Alex Moriarty
 * Lab 8 csci1101  
 * 2009/3/11
 */

public class Node {
	private String name;
	private Node next;
	
	public Node () {
		name = null;
		next = null;
	}
	
	public Node (String s, Node n) {
		name = s;
		next = n;
	}
//	
	public void setName (String s) {
		name = s;
	}
//	
	public String getName () {
		return name;
	}
//	
	public void setNext (Node n) {
		next = n;
	}
//	
	public Node getNext () {
		return next;
	}
//	
	public String toString () {
		return name;
	}
}
