/**
 * @(#)Sales.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */


public class Sales {
	private double cost;			//Cost per item
	private double numberSold =0;	//Number sold
	private double total =0;		//Total amount in sales
	private double totalDiscount =0;//Total discount
	private double bulkQuantity; 	//Bulk quantity
	private double bulkDiscount; 	//Bulk discount percentage per item
	
    public Sales() {
    }
    public Sales(double cost, double bulkQuantity, double bulkDiscount){
    	setCost(cost);
    	setBulkQuantity(bulkQuantity);
    	setBulkDiscount(bulkDiscount);
    }
    public void setCost(double cost){
    	if ( cost >= 0 )
    		this.cost = cost;
    	else
    		System.out.println("sorry the cost must be greater than zero.");	
    }
    public void setBulkQuantity(double bulkQuantity){
    	if (bulkQuantity > 1)
    		this.bulkQuantity = bulkQuantity;
    	else
    		System.out.println("Sorry the Bulk Quantity must be greater than one.");	
    }
    public void setBulkDiscount(double bulkDiscount){
    	if (bulkDiscount < 1 && bulkDiscount >= 0)
    		this.bulkDiscount = bulkDiscount;
    	else
    		System.out.println("Bulk Discount must be percent between 0 and 1 but less than 1");
    }	
    public void registerSale(double num){
    	if( num >= bulkQuantity)
    		totalDiscount = num*cost - num*(cost*(1-bulkDiscount));
    	else 
    		totalDiscount = 0;	
    	total += num*cost - totalDiscount;
    	numberSold += num;    	 	
    }
    public void displaySales(){
    	System.out.println("the number sold is: "+numberSold);
    	System.out.println("the total sales is: "+total);
    	System.out.println("the total discount is: "+totalDiscount);    	
    }
    public String toString(){
    	String result="cost ="+cost+"\nnumber sold ="+numberSold+"\ntotal ="+total+"\ntotal discount ="+total+"\nbulkQuantity"+bulkQuantity+"\nbulkDiscount ="+bulkDiscount;
    	return result;
    }
    
    
}