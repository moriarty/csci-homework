public class List {
	private Node head;
	
	public List () {
		head = null;
	}
	
	public String toString () {
		Node ref = head;
		String result = "";
		while (ref != null) {
			result = result + "-->" + ref.getName();
			ref = ref.getNext();
		}
		
		return result;
	}
	
	// Return the size of the list
	public int size () {
		int count = 0;
		Node position = head;
		while (position != null) {
			count++;
			position = position.getNext();
		}
		return count;
	}
	
	// Add a node to the front of the list
	public void addToFront (String s) {
		head = new Node(s, head);
	}
	
	public boolean isEmpty () {
		if (head == null) 
			return true;
		else
			return false;
	}
	
	public void addToEnd (String s) {
		Node n = new Node(s, null);
		Node ref = head;
		if (head == null) 
			head = n;
		else {
			while (ref.getNext() != null)
				ref = ref.getNext();
			ref.setNext(n);
		}
	}
	
	public void removeHeadNode () {
		if (head != null)
			head = head.getNext();
	}
	
	public void removeLastNode () {	
		if (head == null)
			return;
		else if (head.getNext() == null)
			head = null;
		else {
			Node ref = head;
			while (ref.getNext().getNext() != null)
				ref = ref.getNext();
				
			ref.setNext(null);
		}
	}
	
	// Removes first occurence of String s
	public void removeNode (String s) {
		if (head == null)
			return;
		else if (head.getNext() == null) {
			if (head.getName().equals(s))
				head = null;
		}
		else if (head.getName().equals(s)) {
			head = head.getNext();
		}
		else {
			Node prev, current;
			current = head.getNext();
			prev = head;
			while (!current.getName().equals(s) && current.getNext() != null) {
				prev = current;
				current = current.getNext();
			}
			if (current.getName().equals(s))
				prev.setNext(current.getNext());
			
		}
	}
	
	// Removes node at a given index
	public void removeNode (int index) {
		// Nothing to remove
		if (head == null)
			return;
		
		// Remove the head
		else if (index == 0) {
			this.removeHeadNode();
		}
				
		// Remove farther along in the list
		else {
			// Index is out of bounds
			if (index > (this.size() - 1))
				System.out.println("Index out of range.");
			// Index is in bounds
			else {
				int i = 0;
				Node prev, current;
				current = head.getNext();
				prev = head;
				
				// Go through the list, bringing a trailing pointer along
				while (i < (index - 1)) {
					prev = current;
					current = current.getNext();
					i++;
				}
				
				// Remove the node at specified index by changing pointer of
				// node coming before it to point at the node that comes after
				prev.setNext(current.getNext());
			} 
		}
	}
	
	// Returns the index of the first occurence of s
	// Returns -1 is s is not in the list
	public int contains (String s) {
		Node ref = head;
		boolean found = false;
		int index = -1;
		while (ref != null && !found) {
			index++;
			if (ref.getName().equals(s)) 
				found = true;
			ref = ref.getNext();
		}
		if (!found)
			return -1;
		else
			return index;
	}
	
	// _Prints_ each of the indices that contain specified String s
	public void listAll (String s) {
		Node ref = head;
		int index = 0;
		
		while (ref != null) {
			if (ref.getName().equals(s))
				System.out.print(index + " ");
			ref = ref.getNext();
			index++;
		}
		System.out.println();
	}
	
	// Returns the beginning pointer of the list
	public Node getList () {
		return head;
	}
	
	// Adds items from another list that are not contained in this list to the
	// end of this list
	public void addAll (List otherList) {
		Node ref = otherList.getList(); //ref points to the head of the otherList
		
		// While not at the end of otherList
		while (ref != null) {
			// If this list does NOT contain data from ref
			if (this.contains(ref.getName()) == -1)
				// Add data to end of this list 
				this.addToEnd(ref.getName());	
					
			// Keep going
			ref = ref.getNext();
		}
	}
	
	// Adds a node with String s at the specified index
	public void add (int index, String s) {
		if (index == 0) 
			addToFront(s);
		else {
			Node ref = head;
			int i = 0;
			while (ref != null && i+1 != index) {
				ref = ref.getNext();
				i++;
			}
			if (ref == null)
				System.out.println("Can't add. Index out of boyunds.");
			else {
				Node n = new Node(s, ref.getNext());
				ref.setNext(n);
			}
		}
	}
	
	// Returns the String at a specified index
	public String get (int index) {
		Node ref = head;
		int i = 0;
		while (ref != null && i != index) {
			ref = ref.getNext();
			i++;
		}
		if (ref == null)
			return "Index out of bounds";
		else 
			return ref.getName();
	}
}
