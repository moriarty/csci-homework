/* SomeClassDemo.java
 *
 * Alex Moriarty
 * 2009/2/10
 */


public class SomeClassDemo
{
	public static void main(String[] args)
	{
		List a = new List();
		System.out.println(a + "(Empty list)");
		System.out.print("c occurs at: ");
		a.listAll("c");
		System.out.println("Now add some nodes to the list: ");
		
		a.addToFront("a");
		a.addToEnd("b");
		a.addToEnd("c");
		a.addToEnd("c");
		
		System.out.println(a);
		System.out.print("c occurs at: ");
		a.listAll("c");
		
		a.addToFront("c");
		System.out.println(a);
		System.out.print("c occurs at: ");
		a.listAll("c");
		
	}
}
/*
 */
 
