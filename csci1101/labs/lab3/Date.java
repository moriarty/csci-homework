/**
 * Date.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */

import java.util.Scanner;

public class Date 
{
	private int day;
	private int month;
	private int year;
	private boolean correct;
	
    public Date() {
    	
    }
    // reads input from users, repeating if date is invalid
    public void readInput(){
		do {
    	Scanner input = new Scanner(System.in);
    	System.out.println("please enter date in \"mm dd yyyy\" format");
    	int month = input.nextInt();
    	int day = input.nextInt();
    	int year = input.nextInt();
    	if (dateOK(month, day, year)){
    		correct = true;
    		setDate(month, day, year);
    	}else{
    		correct = false;
    		System.out.println("Invalid date, try again");
    	}
		} while (correct == false);
    }
    // sets the date
    public void setDate(int month, int day, int year){
    	if (dateOK()){
	    	this.month=month;
	    	this.day=day;
	    	this.year=year;
    	} else
    		System.out.println("invalid Date");

    }
    // standard to string
    public String toString(){
    	String result = "month :"+month+"\tday :"+day+"\tyear :"+year;
    	return result;
    }
    // checks if date valid, checking months that have 30 days, february and if its a leap year
    private boolean dateOK(int month, int day, int year){
    	if (year > 1 && year <10000){
    		if (monthString(month)=="void"){
    			return false;
    		}else {
    			switch (month){
    				case 4:  
	    			case 6:
    				case 9:
    				case 11:
    					if (day > 30) 
	    					return false;
    				case 2:
    					if (day > 29) 
    						return false;
    					if (day == 29 && (year%4 == 0 && year%100 != 0))
    						return false;	
    			}			
    		}
    		return true;
    	}else 
       		return false;
    }
    // checks if its the 25th of december
    public boolean isChristmas(){
    	//boolean isChristmas;
    	if ( day == 25 && month == 12){
    		return true;
    	} else
    		return false;
    }
    // checks if its the 30th of a month that has 30 days, the 29 of february ( 28 if its a leap year )
    public boolean isEndOfMonth(){
    	//boolean endOfMonth;
 		switch (month){
			case 4:  
			case 6:
			case 9:
			case 11:
				if (day == 30) 
					return true;
				break;
			case 2:
				if (day == 29) 
					return true;
				if (day == 29 && (year%4 == 0 && year%100 != 0))
					return true;			
		}
		if (day == 31){
			return true;
		}else 
    		return false;	
    }
    //checks if its december 31
    public boolean isEndOfYear(){
    	//boolean endOfYear;
    	if ( month == 12 && day == 31){
    		return true;
    	}else 
    		return false;
    }
    //prints the date
    public void printDate(){
    	System.out.println("\n"+monthString(month)+","+day+" "+year);
    	if (isChristmas()){
    		System.out.println("\tis Christmas day");    		
    	}else{
    		System.out.println("\tis not Christmas day");
    	}
    	if (isEndOfMonth()){
    		System.out.println("\tis the last day of "+monthString(month));
    		if (isEndOfYear()){
    			System.out.print("\tis the last day of the year "+year);
    		}
    	}    		
    }
    //increases the date
    public void increaseDate(){
    	if (isEndOfYear()){
    		year += 1;
    		month = 1;
    		day = 1;
    	} else if(isEndOfMonth()){
    		month += 1;
    		day = 1;
    	} else
    		day +=1;
    } 
    // returns the month as a string
    private String monthString(int month){
    	String strMonth = "void";
    	switch (month){
    		case(1):
    		strMonth = "January";
    		break;
    		case(2):
    		strMonth = "February";
    		break;
    		case(3):
    		strMonth = "March";
    		break;
    		case(4):
    		strMonth = "April";
    		break;
    		case(5):
    		strMonth = "May";
    		break;
    		case(6):
    		strMonth = "June";
    		break;
    		case(7):
    		strMonth = "July";
    		break;
    		case(8):
    		strMonth = "August";
    		break;
    		case(9):
    		strMonth = "September";
    		break;
    		case(10):
    		strMonth = "October";
    		break;
    		case(11):
    		strMonth = "November";
    		break; 
    	   	case(12):
    		strMonth = "December";
    		break; 		
   		}
   		return strMonth;
    } 
    
}