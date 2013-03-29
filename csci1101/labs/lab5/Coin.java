/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */

public class Coin
{
	private String name;	
	private double value;
/*		*/	
//	public Coin(){
//	}	
/*	Coin Constructor, sets Name and Value	*/
	public Coin(String name, Double value){
		setName(name);
		setValue(value);
	}
/*	Sets the name	*/
	public void setName(String name){
		this.name = name;
	}
/*	Sets the vaule	*/
	public void setValue(double value){
		this.value = value;
	}
/*	returns the name	*/
	public String getName(){
		return name;
	}
/*	returns the value	*/
	public double getValue(){
		return value;
	}
/*	returns variables in String format	*/
	public String toString(){
		String result = "\nCoin name: "+name+"\tValue: "+value;
		return result; 
	}
}
