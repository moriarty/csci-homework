/**
 * Stock.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */


public class Stock {	
	private String symbol;
	private double sharePrice;
	// constructor, takes and sets, symbol and sharePrice
    public Stock(String symbol, double sharePrice) {
    	this.symbol = symbol;
    	this.sharePrice = sharePrice;
    }
    // returns the stocks Symbol
    public String getSymbol(){
    	return symbol;
    }
    // return the share price
    public double getSharePrice(){
    	return sharePrice;
    }
    // returns all variables in string formate
    public String toString(){
    	String result = "symbol ="+symbol+"\tsharePrice ="+sharePrice;
    	return result;
    }
    // compares to stocks, returning -1 , 0 or +1 (less-then, equal, greater-then)
    public int compare(Stock otherStock){
    	if (sharePrice == otherStock.getSharePrice()){
    		return 0;
    	}else if(sharePrice < otherStock.getSharePrice()){
    		return -1;
    	} else
    		return +1;
    }    
}