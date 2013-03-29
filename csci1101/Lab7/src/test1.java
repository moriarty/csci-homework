import java.util.Scanner;
public class test1 {
	public static void main(String args[]){
		//Create a new ledger and keyboard input reader
		Ledger myLedger = new Ledger();
		Scanner keyboard = new Scanner(System.in);
		double curSale = -1;
		
		//Ask user to enter some sales
		System.out.println("Enter the values of the sales, end with -1: ");
		curSale = keyboard.nextDouble();
		
		//Loop through the sales until -1 is found
		while(curSale != -1){
			myLedger.addSale(curSale);
			curSale = keyboard.nextDouble();
		}
		
		//Display some data about the Ledger
		System.out.println(
			"Number of sales: "+myLedger.getNumberOfSales()+
			"\nTotal sales: "+myLedger.getTotalSales()+
			"\nAverage sales: " +myLedger.getAverageSale()+
			"\nNumber of sales above $100.00: "+myLedger.getCountAbove(100)
		);
		
	}
}

/**
 * Sample Output:
Enter the values of the sales, end with -1: 
90 30 40 80 34.5 105.7 -1
Number of sales: 6
Total sales: 380.2
Average sales: 63.36666666666667
Number of sales above $100.00: 1
--
Enter the values of the sales, end with -1: 
-1
Number of sales: 0
Total sales: 0.0
Average sales: NaN
Number of sales above $100.00: 0
--
Enter the values of the sales, end with -1: 
150 200 -2 500.50 1050.99 -1
Number of sales: 4
Total sales: 1901.49
Average sales: 475.3725
Number of sales above $100.00: 4
*/