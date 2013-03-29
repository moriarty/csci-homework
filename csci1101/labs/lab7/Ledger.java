/**
 * Lab 7 #1
 * Ledger.java
 * Alex Moriarty 
 * 2009/3/4
 */
import java.util.ArrayList;
public class Ledger {
//	sale – an ArrayList of double values that are the amounts of all sales.
//	salesMade – the number of sales so far
	private ArrayList<Double> list;
    private int salesMade;
//	Ledger() – a constructor that creates an empty ArrayList and sets salesMade to zero    
    public Ledger() {
    	list = new ArrayList<Double>();
    	salesMade = 0;
    }
//	addSale(d) – adds a sale whose value is d
	public void addSale(double d){
		list.add(d);
	}
//	getNumberOfSales – returns the total number of sales made
	public int getNumberOfSales(){
		if (list.size()>1)
			return list.size();
		else 
			return 0;	
	}
//	getTotalSales – returns the total value of the sales
	public double getTotalSales(){
		int n=0;
		for(int i=0; i<list.size(); i++)
			n += list.get(i);
		return n;	
	}
//	getAverageSale() – returns the average value of all sales
	public double getAverageSale(){
		if (getNumberOfSales() != 0)
			return (getTotalSales()/(double)(getNumberOfSales()));
		else
			return 0;	
	}
//	getCountAbove(v) – returns the number of sales that exceeded v in value
    public int getCountAbove(double v){
    	int n =0;
    	for(int i=0; i<list.size(); i++){
    		if (list.get(i)>v)
    			n++;
    	}
    	return n;
    }
    public String toString(){
    	String str = "\nNumber of sales:\t"+getNumberOfSales()+"\nTotal sales:\t"+getTotalSales()+"\nAverage sale:\t"+getAverageSale();
    	return str;
    }
}