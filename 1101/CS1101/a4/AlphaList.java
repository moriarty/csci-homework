/**
 *	Alex Moriarty
 *	AlphaList
 */
public class AlphaList {
	private Node1 head;
	
	/**
	*	Constructor
	*/
	public AlphaList(){
		this.head = null;
	}
	/**
	*	Puts String into linked list, where it belongs, lexicographically.
	*/
	public void insert(String str){
		if(this.head == null){
			this.head = new Node1(str, null);
		}	else {
			Node1 prevNode = this.getBefore(str);
			Node1 nextNode = null;
			if(prevNode != null){
				nextNode = prevNode.getNext();
			}
			Node1 node = new Node1(str, nextNode);
			if(prevNode != null){
				prevNode.setNext(node);
			}
		}
	}
	/**
	*	Finds the node before the one to be inserted
	*/
	private Node1 getBefore(String str){
		Node1 node = this.head;
		
		while(node != null){
			if(node.getName().compareTo(str) <= 0 && (node.getNext() == null || node.getNext().getName().compareTo(str) > 0))
				break;
			node = node.getNext();
		}
		
		return node;
	}
	/**
	*	Returns The list in a String
	*/
	public String toString(){
		Node1 node = this.head;
		String str = "";
		
		while(node != null){
			str += node.getName();
			if(node.getNext() != null)
				str += " => ";
			node = node.getNext();
		}
		
		return str;
	}
}
