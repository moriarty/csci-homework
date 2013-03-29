/**
 * @(#)DateDemo1.java
 * 2009/1/28
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
01
28
2009
please enter date in "mm dd yyyy" format
03
07
1990
The date is January the 28 of 2009
The date is February the 6 of 2009
The date is March the 7 of 1990

month :1    day :28 year :2009
month :2    day :6  year :2009
month :3    day :7  year :1990

Process completed.
--------------------Configuration: <Default>--------------------
please enter date in "mm dd yyyy" format
13 10 2009
Invalid date
please enter date in "mm dd yyyy" format
2 30 2009
Invalid date
The date is void the 0 of 0
The date is February the 6 of 2009
The date is void the 0 of 0

month :0    day :0  year :0
month :2    day :6  year :2009
month :0    day :0  year :0

Process completed.
*/
