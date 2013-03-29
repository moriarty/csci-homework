/**
 * @(#)SalesDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */

public class SalesDemo1 {

    public static void main(String[] args) {
       	Sales item1, item2, item3;
		item1 = new Sales();
		item2 = new Sales(24.99, 25, .25);
		item3 = new Sales(49.99, 15, .30);
		item1.setCost(9.99);
		item1.setBulkQuantity(35);
		item1.setBulkDiscount(.20);
		
		item2.registerSale(25);
		
		item2.displaySales();

		System.out.println(item1.toString()+"\n**************************");
		System.out.println(item2.toString()+"\n**************************");
		System.out.println(item3.toString()+"\n**************************");
    }
}
