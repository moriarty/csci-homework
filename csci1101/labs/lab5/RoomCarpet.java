/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */

public class RoomCarpet
{	
	private RoomDimension size;
	private double carpetCost;
/*	Empty RoomCarpet Constructor	*/
//	public RoomCarpet(){
//	}
/*	RoomCarpet Constructor	*/
	public RoomCarpet(RoomDimension size, double carpetCost){
		setSize(size);
		setCarpetCost(carpetCost);
	}
/*	Sets room size	*/
	public void setSize(RoomDimension size){
		this.size = size;
	}
/*	Sets Carpet Cost	*/
	public void setCarpetCost(double carpetCost){
		this.carpetCost = carpetCost;
	}
/*	Returns Calculated Total cost	*/
	public double getTotalCost(){
		return (size.getArea() * carpetCost);
	}
/*	Returns all variables and Total Cost in a String	*/
	public String toString(){
		String result = "\nDimensions :\n"+size+"\tCarpet Cost: "+carpetCost+"\nTotal carpet cost: :"+getTotalCost()+"$";
		return result;
	}	
}
