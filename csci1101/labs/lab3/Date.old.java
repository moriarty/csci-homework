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
	
    public Date() {
    }
    public void readInput(){
    	Scanner input = new Scanner(System.in);
    	System.out.println("please enter date in \"mm dd yyyy\" format");
    	int month = input.nextInt();
    	int day = input.nextInt();
    	int year = input.nextInt();
    	if (dateOK(month, day, year)){
    		setDate(month, day, year);
    	}else
    		System.out.println("Invalid date");
    	
    }
    public void setDate(int month, int day, int year){
    	this.month=month;
    	this.day=day;
    	this.year=year;
    }
    public String toString(){
    	String result = "month :"+month+"\tday :"+day+"\tyear :"+year;
    	return result;
    }
    private boolean dateOK(int month, int day, int year){
    	//boolean result = false;
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
    			}			
    		}
    		return true;
    	}else 
       		return false;
    }
    public void printDate(){
    	System.out.println("The date is "+monthString(month)+" the "+day+" of "+year);
    }
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