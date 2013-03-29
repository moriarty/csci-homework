/**
 * RectangleDemo2.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */

public class RectangleDemo2
{
	public static void main(String[] args)
	{
		Rectangle rect1, rect2;
		int area1, area2;
		rect1 = new Rectangle();
		rect2 = new Rectangle();
		rect1.setLength(10);
		rect1.setWidth(30);
		rect2.setLength(20);
		rect2.setWidth(25);
		area1 = rect1.findArea();
		area2 = rect2.findArea();
				
		System.out.println("Area of the first rectangle: " + area1);
		System.out.println("Area of the second rectangle: " + area2);
		
		System.out.println(rect1.toString()+"\n"+rect2.toString());
		
		System.out.println(rect1.getWidth());
		System.out.println(rect1.getLength());
		
		if(rect1.equals(rect2)){
			System.out.println("true");
		}else
			System.out.println("false");
		
		if(rect2.isLarger(rect1)){
			System.out.println("rect 2 is larger");
		}else
			System.out.println("rect 2 is not larger");	
	}
}
/*
--------------------Configuration: <Default>--------------------
Area of the first rectangle: 300
Area of the second rectangle: 500
length =10  width =30
length =20  width =25
30
10
false
rect 2 is larger

Process completed.
*/