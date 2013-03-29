/**
 * StockDemo1.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */

public class StockDemo1 
{
    public static void main(String[] args) 
    {
    	Stock linux, apple, microsoft;
    	linux = new Stock("tux", 9000.01);
    	apple = new Stock("mac", 8999.99);
    	microsoft = new Stock("msn", 1.01);
    	
    	System.out.println("apple's symbol is :"+apple.getSymbol()+"\n");
    	System.out.println("linux stock price is :"+linux.getSharePrice()+"\tWHAT? its over ninethousand!\nyeah right.\n");
    	if (microsoft.compare(linux)== -1){
    		System.out.println("microsoft is less than linux \nhell yeah..\n");
    	}
    	System.out.println(apple.toString()+"\n"+linux.toString()+"\n"+microsoft.toString());
    	
    }
}
/*
--------------------Configuration: <Default>--------------------
apple's symbol is :mac

linux stock price is :9000.01   WHAT? its over ninethousand!
yeah right.

microsoft is less than linux 
hell yeah..

symbol =mac sharePrice =8999.99
symbol =tux sharePrice =9000.01
symbol =msn sharePrice =1.01

Process completed.
*/