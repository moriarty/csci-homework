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
	
    public Counter() {
    }
    public Counter(int count){
    	if (count>=0){
    		this.count = count;
    		resetValue = count;
    	}else
    		System.out.println(error);	
    }
    public Counter(int count, int change){
    	if (count>=0){
    		this.count = count;
    		resetValue = count;
    		this.change = change;
    	}else
    		System.out.println(error);
    		this.change = change;	
    }
    public void toZero(){
    	count = 0;
    }
    public void reset(){
    	count = resetValue;
    }
    public void up(){
    	count+=change;
    }
    public void down(){
    	if (count-change >=0)
    		count=count - change;
    	else
    		System.out.println(error);	
    }
    public int accessor(){
    	return count;
    }
    public void print(){
       	System.out.println(count);
    }
    public String toString(){
    	String result ="***\ncount ="+count+"\nresetValue ="+resetValue+"\nchange ="+change+"\n***";
    	return result;
    }
}