/**
 * @(#)Counter.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */


public class Counter {
	
	private int count = 0;
	private int resetValue = 0;
	private int change = 1;
	private String error ="Error negative count; count ="+count;
//	default constructor starting at zero counting by 1	
    public Counter() {
    }
//	constructor2, starting at whatever possitive value, or zero    
    public Counter(int count){
    	if (count>=0){
    		this.count = count;
    		resetValue = count;
    	}else
    		System.out.println(error);	
    }
//	constructor3, starting at some value, and changing by some value    
    public Counter(int count, int change){
    	if (count>=0){
    		this.count = count;
    		resetValue = count;
    		this.change = change;
    	}else
    		System.out.println(error);
    		this.change = change;	
    }
//	incase you want to set the value to zero    
    public void toZero(){
    	count = 0;
    }
// incase you want to set the value to your original value    
    public void reset(){
    	count = resetValue;
    }
//	add to the cound    
    public void up(){
    	count+=change;
    }
//	take away from the count    
    public void down(){
    	if (count-change >=0)
    		count=count - change;
    	else
    		System.out.println(error);	
    }
//	returns the count as int    
    public int accessor(){
    	return count;
    }
//	prints the count     
    public void print(){
       	System.out.println(count);
    }
//	returns string contaning all variables    
    public String toString(){
    	String result ="***\ncount ="+count+"\nresetValue ="+resetValue+"\nchange ="+change+"\n***";
    	return result;
    }
}