public class RemoveNodeDemo {
	public static void main (String[] args) {
		List x = new List();
		x.removeNode(0);
		x.addToEnd("a");
		x.addToEnd("b");
		x.addToEnd("c");
		System.out.println(x);
		x.removeNode(1);
		System.out.println(x);
		x.addToEnd("d");
		x.addToEnd("e");
		x.addToEnd("f");
		System.out.println(x);
		x.removeNode(11);
		x.removeNode(4);
		System.out.println(x);
		x.removeNode(0);
		System.out.println(x);
		x.addToEnd("x");
		x.addToEnd("y");
		x.addToEnd("z");
		System.out.println(x);
		x.removeNode(2);
		System.out.println(x);
	}
}