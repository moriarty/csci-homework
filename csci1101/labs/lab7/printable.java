***********************************************
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
***********************************************
/**
 * Lab 7 #1
 * LedgerDemo.java
 * Alex Moriarty 
 * 2009/3/4
 */
import java.util.Scanner;
public class LedgerDemo {
    public static void main(String[] args) {
       Ledger l1;
       l1 = new Ledger();
       Scanner input = new Scanner(System.in);
       double thisSale = input.nextDouble();
       do{
       	if ( thisSale == -1)
       		break;
       	else
       		l1.addSale(thisSale);
       		thisSale = input.nextDouble();	
       }while(thisSale != -1 );
       System.out.println(l1);
       System.out.println("sales above $100:\t"+l1.getCountAbove(100));
        
    }
}
/*
--------------------Configuration: <Default>--------------------
45 10 10 30 40 600 100 -1

Number of sales:    7
Total sales:    835.0
Average sale:   119.28571428571429
sales above $100:   1

Process completed.
--------------------Configuration: <Default>--------------------
10 10 10 100 1000 -1

Number of sales:    5
Total sales:    1130.0
Average sale:   226.0
sales above $100:   1

Process completed.
 */