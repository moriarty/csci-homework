public class AddAllDemo {
	public static void main (String[] args) {
		List a = new List();
		List b = new List();
		
		a.addToEnd("a");
		a.addToEnd("b");
		a.addToEnd("c");
		a.addToEnd("d");
		
		b.addToEnd("e");
		b.addToEnd("f");
		b.addToEnd("a");
		b.addToEnd("c");
		
		System.out.println("List A: " + a);
		System.out.println("List B: " + b);
		
		a.addAll(b);
		
		System.out.println("List B added to List A: " + a);
	}
}