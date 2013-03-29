/**
 * Alex Moriarty
 * Lab 8 csci1101  
 * 2009/3/11
 */


public class set {

    public set() {
    }
//	that returns a third list which is the union of the two lists list1 and list2.    
    public static List union(List list1, List list2){
    	List result = new List();
    	result.addAll(list1);
    	for (Node p=list1.getList(); p!=null; p=p.next){
    		for(Node q=list2.getList(); q!=null; q=q.next){
    			if (p.getName()!=q.getName())
    				
    		}
    	}
    }
//	that returns a third list which is the intersection of the two lists list1 and list2.
	public static List intersection(List list1, List list2)

//You can assume that elements in each list occur only once (that is, they are not duplicated).

    
    
}