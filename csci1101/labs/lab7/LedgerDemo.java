/**
 * Lab 7 #1
 * LedgerDemo.java
 * Alex Moriarty 
 * 2009/3/4
 */
import java.util.Scanner;
public class LedgerDemo {
	public static double SALESABOVE = 100;
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
       System.out.println("sales above $100:\t"+l1.getCountAbove(SALESABOVE));
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