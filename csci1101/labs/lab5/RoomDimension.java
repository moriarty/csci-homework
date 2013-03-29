/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */

public class RoomDimension
{	
	private double length;	
	private double width;

/*	Room Dimension Empty Constructor	*/
//	public RoomDimension(){
//	}
/*	Room Dimension Constructor	*/
	public RoomDimension(double length, double width){
		setLength(length);
		setWidth(width);
	}
/*	Sets Room Length	*/	
	public void setLength(double length){
		this.length = length;
	}
/*	Sets Room Width	*/	
	public void setWidth(double width){
		this.width = width;
	}
/*	Returns Room Length	*/	
	public double getLength(){
		return length;
	}
/*	Returns Room Width	*/	
	public double getWidth(){
		return width;
	}
/*	Returns Calculated Area		*/	
	public double getArea(){
		return (length*width);
	}
/*	Returns All variables and Area in String	*/	
	public String toString(){
		String result = "length :\t"+length+"\twidth :\t"+width+"\tArea :\t"+getArea();
		return result;
	}
}
