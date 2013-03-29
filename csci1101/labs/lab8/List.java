/**
 * Alex Moriarty
 * Lab 8 csci1101  
 * 2009/3/11
 */


public class List {
	private Node head;
//	Constructor to create an empty list
    public List() {
    	head = null;
    }
//	toString
	public String toString(){
		Node curr = head;
		String str = "";
		while (curr != null) {
			str = str + "-->" + curr.getName();
			curr = curr.getNext();
		}
		return str;
	}
//	addToFront
	public void addToFront(String str){
		head = new Node(str, head);
	}
//	size
	public int size(){
		int num = 0;
		Node curr = head;
		while (curr != null){
			num++;
			curr = curr.getNext();
		}
		return num;
	}
//	isEmpty
	public boolean isEmpty(){
		if (head == null)
			return true;
		else 
			return false;		
	}
//	addToEnd
	public void addToEnd(String str){
		Node curr = head;
		if (head == null)
			head.setNext(new Node(str, null));
		else{
			while (curr.getNext() != null){
				curr = curr.getNext();				
			}
			curr.setNext(new Node(str, null));
		}			
	}
//	removeHeadNode
	public void removeHeadNode(){
		if(head != null)
			head = head.getNext();
	}
//	removeLastNode
	public void removeLastNode(){
		Node curr = head;
		if (head == null)
			return;
		else if (head.getNext() == null)
			head = null;
		else{
			while (curr.getNext().getNext() != null){
				curr = curr.getNext();				
			}
			curr.setNext(null);
		}
	}
//	removeNode (String s)
	public void removeNode(String str){
		if (this.contains(str)!= -1){
			//int index = this.contains(str);
			for(Node curr=this.head, prev=null; curr!=null; prev=curr, curr = curr.getNext()){
				if(curr.getName().equals(str)){
					prev = curr;
					curr = curr.getNext();
				}
			}
		}
	}
//	removeNode (int index)
	public void removeNode(int index){
		if (head == null)
			return;
		else if (index == 0) {
			this.removeHeadNode();
		}
		else {
			if (index > (this.size() - 1))
				System.out.println("Index out of range.");
			else {
				int i = 0;
				Node prev, curr;
				curr = head.getNext();
				prev = head;
				while (i < (index - 1)) {
					prev = curr;
					curr = curr.getNext();
					i++;
				}
				prev.setNext(curr.getNext());
			} 
		}		
	}
	
//	contains(String s)
	public int contains(String str){
    	int index = 0;
    	boolean has = false;
    	for(Node curr = this.head; curr!=null; curr = curr.getNext()){
    		if (curr.getName().equals(str)){
    			has = true;
    			break;
    		}	
    		index++;
    	}
    	if (!has)
    		return -1;
    	else
    		return index;
    }
//	listAll    
	public void listAll (String s) {
		Node curr = head;
		int index = 0;
		
		while (curr != null) {
			if (curr.getName().equals(s))
				System.out.print(index + " ");
			curr = curr.getNext();
			index++;
		}
		System.out.println();
	}    

//	add(int index, String s)
	public void add(int index, String s){
		//Node n = new Node(s,null)
		int i = 0;
		for(Node curr=this.head, prev =null;1<2; prev=curr, curr=curr.getNext()){
			if (i == index){
				if (curr == null){
					System.out.println("index out of bounds");
					return;
				}
				else{
					Node n = new Node(s, curr);
					prev=n;
					return;
				}					
			}
			i++;
		}
		
	}
//	addAll(List otherList)
	public void addAll (List otherList) {
		Node ref = otherList.getList(); 		
		while (ref != null) {
			if (this.contains(ref.getName()) == -1)
				this.addToEnd(ref.getName());	
			ref = ref.getNext();
		}
	}	
//	get(int index)
	public String get(int index){
		String str = "";
		return str;
	}
	
// Returns the beginning pointer of the list
	public Node getList () {
		return head;
	}
	    
}