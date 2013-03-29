/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */


public class RectangleDemo1
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
	}
}
