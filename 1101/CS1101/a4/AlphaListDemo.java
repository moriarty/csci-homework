public class AlphaListDemo {
	public static void main(String args[]){
		AlphaList list = new AlphaList();
		list.insert("a");
		list.insert("b");
		list.insert("d");
		list.insert("z");
		list.insert("h");
		list.insert("l");
		list.insert("abc");
		
		System.out.println(list);
	}
}