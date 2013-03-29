public class ListDemo {
	public static void main(String[] args) {
		List l = new List();
		System.out.println("Empty: " + l.isEmpty());
		l.addToFront("a");
		System.out.println("size: " + l.size());
		l.addToEnd("b");
		System.out.println(l);
		l.removeHeadNode();
		System.out.println(l);
		l.removeLastNode();
		System.out.println(l);
		l.addToFront("a");
		l.addToEnd("b");
		l.addToEnd("c");
		System.out.println(l);
		l.removeNode("b");
		System.out.println(l);
		System.out.println("Contains b: " + l.contains("b"));
		l.add(1, "z");
		System.out.println(l);
		System.out.println("Node at index 1: " + l.get(1));
	}
}