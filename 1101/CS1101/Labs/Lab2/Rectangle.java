/**
 * @(#)Rectangle.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */
//	Makes a rectange and can calculate its area!
public class Rectangle
{
	private int length;
	private int width;
	
	public Rectangle()
	{
	}
	public void setLength(int l)
	{
		length = l;
	}
	public void setWidth(int w)
	{
		width = w;
	}
	public int findArea()
	{
		return length*width;
	}
}
