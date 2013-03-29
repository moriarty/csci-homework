/**
 * 
 * @author jacob
 * Ledger
 * Stores a ledger of sales and returns some data about them
 * 
 */
import java.util.ArrayList;
public class Ledger {
	//Initialize local variables
	private ArrayList<Double> sale;
	private int salesMade;
	
	//Setup the array list and start the sales made counter
	public Ledger(){
		this.sale = new ArrayList<Double>();
		salesMade = 0;
	}
	
	//Adds a sale to the ledger
	public void addSale(double v){
		if(v > 0){
			this.sale.add(v);
			this.salesMade++;
		}
	}
	
	//Returns the sales counter
	public int getNumberOfSales(){
		return this.salesMade;
	}
	
	//Calculates the total sales
	public double getTotalSales(){
		double total = 0;
		
		for(int i = 0; i < this.sale.size(); i++){
			total += this.sale.get(i);
		}
		
		return total;
	}
	
	//Gets the average amount per sale
	public double getAverageSale(){
		return this.getTotalSales()/this.getNumberOfSales();
	}
	
	//Returns the number of sales above value 'v'
	public int getCountAbove(double v){
		int count = 0;
		
		for(int i = 0; i < this.sale.size(); i++){
			if(this.sale.get(i) > v)
				count++;
		}
		
		return count;
	}
}
