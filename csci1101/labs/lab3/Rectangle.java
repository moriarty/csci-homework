/**
 * Rectangle.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */


public class Rectangle {

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
	public String toString(){
		String result = "length ="+length+"\twidth ="+width;
		return result;
	}
	public int getLength(){
		return length;
	}
	public int getWidth(){
		return width;
	}
	// checks if this rectange is the same as another
	public boolean equals(Rectangle rect2){
		if(length == rect2.getLength() && width == rect2.getWidth()){
			return true;
		}
		return false;
	} 
	// checks if this rectange is larger than another
	public boolean isLarger(Rectangle rect2){
		if (this.findArea() > rect2.findArea()){
			return true;
		}
		return false;
	}
}