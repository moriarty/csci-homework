/**
 * @(#)DateDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/28
 */

public class DateDemo1 
{
    public static void main(String[] args) 
    {
    	Date today, birthday, munroday;
    	today = new Date();
    	birthday = new Date();
    	munroday = new Date();
    	
    	today.readInput();
    	birthday.readInput();
		munroday.setDate(2,6,2009);
		
		today.printDate();
		munroday.printDate();
		birthday.printDate();		
		
		System.out.println("\n"+today.toString()+"\n"+munroday.toString()+"\n"+birthday.toString());
    }
}
/*
--------------------Configuration: <Default>--------------------
please enter date in "mm dd yyyy" format
2 29 2004
Invalid date, try again
please enter date in "mm dd yyyy" format
2 29 2009
please enter date in "mm dd yyyy" format
12 31 2009

February,29 2009
    is not Christmas day
    is the last day of February

February,6 2009
    is not Christmas day

December,31 2009
    is not Christmas day
    is the last day of December
    is the last day of the year2009
month :2    day :29 year :2009
month :2    day :6  year :2009
month :12   day :31 year :2009

Process completed.
*/
