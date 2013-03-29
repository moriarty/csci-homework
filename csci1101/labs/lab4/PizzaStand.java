/**
 * Alex Moriarty
 * Q 4: PizzaStand Class
 * Lab 4 cs1101  
 * 2009/2/4
 */

public class PizzaStand {
	static double cost;
	static int totalSold;
	private int id;
	private int sold;
//A constructor that sets the ID number to some value and the number of pizzas sold by that stand to 0.	
    public PizzaStand(int id) {
    	this.id = id;
    	sold = 0;
    }
//  A method named justSold that increments the number of pizzas sold by that stand by 1.  
    public void justSold(){
    	sold += 1;
    	totalSold += 1;
    }
//	Another method to return the number of pizzas sold by that stand.
	public double getSoldStand(){
		return sold;
	}    
//	A static method to set the cost per pizza.
    static void setCost(double cost){
    	cost = cost;
    }
//	A static method that returns the total number of pizzas sold by all stands.
    static double getSold(){
    	return totalSold;
    }
//	A static method to return the total sales.
	static double getSales(){
    	return (totalSold * cost);
    }
}