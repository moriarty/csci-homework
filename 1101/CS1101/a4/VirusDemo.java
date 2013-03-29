
public class VirusDemo {

	/**
	 *	Assignment 4 "virus spread" Demo
	 */
	public static void main(String[] args) {
		VirusList cold = new VirusList();
		cold.spread("Joe","Bill");
		cold.spread("Vic","Bill");
		cold.spread("Joe","Vic");
		cold.spread("Bill","Jane");
		cold.spread("Joe","James");
		cold.spread("Vic","Jake");
		cold.spread("James","Rob");
		cold.spread("Jane","Greg");
		System.out.println(cold);
				
		System.out.println(cold.getNotSpread());
		System.out.println(cold.sickFrom("joe", 3));
		System.out.println(cold.sickFrom("Vic", 1));
		
	}

}
