public class Set {
	// Returns a list that is the union of list1 and list2
	// Note: Assume that neither list has duplicated elements
	public static List union (List list1, List list2) {
		Node ref1 = list1.getList();
		Node ref2 = list2.getList();
		List list3 = new List();
		
		// Add all the items from list1 to the union list
		while (ref1 != null) {
			list3.addToEnd(ref1.getName());
			ref1 = ref1.getNext();
		}
		
		// Add remaining non-duplicate items from list 2
		while (ref2 != null) {
			// If this item hasn't already been added to the union list
			if (list3.contains(ref2.getName()) == -1)
				list3.addToEnd(ref2.getName());
			ref2 = ref2.getNext();
		}
		
		return list3;
	}	
		
	// Interseciton returns a list that has the common items from list1 and list2
	public static List intersection (List list1, List list2) {
		Node ref1 = list1.getList();
		List list3 = new List();
		
		while (ref1 != null) {
			// If the other list has it, then add it to the common list
			if (list2.contains(ref1.getName()) != -1) {
				list3.addToEnd(ref1.getName());
			}
			
			ref1 = ref1.getNext();
		}
		
		return list3;
	}	
}