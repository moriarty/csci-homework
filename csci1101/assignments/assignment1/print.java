/**
 * Rectangle.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */


public class Rectangle {

	private int length;
	private int width;
	
	public Rectangle()
	{
	}
	public void setLength(int l)
	{
		length = l;
	}
	public void setWidth(int w)
	{
		width = w;
	}
	public int findArea()
	{
		return length*width;
	}
	public String toString(){
		String result = "length ="+length+"\twidth ="+width;
		return result;
	}
	public int getLength(){
		return length;
	}
	public int getWidth(){
		return width;
	}
	// checks if this rectange is the same as another
	public boolean equals(Rectangle rect2){
		if(length == rect2.getLength() && width == rect2.getWidth()){
			return true;
		}
		return false;
	} 
	// checks if this rectange is larger than another
	public boolean isLarger(Rectangle rect2){
		if (this.findArea() > rect2.findArea()){
			return true;
		}
		return false;
	}
}
/**
 * RectangleDemo2.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */

public class RectangleDemo2
{
	public static void main(String[] args)
	{
		Rectangle rect1, rect2;
		int area1, area2;
		rect1 = new Rectangle();
		rect2 = new Rectangle();
		rect1.setLength(10);
		rect1.setWidth(30);
		rect2.setLength(20);
		rect2.setWidth(25);
		area1 = rect1.findArea();
		area2 = rect2.findArea();
				
		System.out.println("Area of the first rectangle: " + area1);
		System.out.println("Area of the second rectangle: " + area2);
		
		System.out.println(rect1.toString()+"\n"+rect2.toString());
		
		System.out.println(rect1.getWidth());
		System.out.println(rect1.getLength());
		
		if(rect1.equals(rect2)){
			System.out.println("true");
		}else
			System.out.println("false");
		
		if(rect2.isLarger(rect1)){
			System.out.println("rect 2 is larger");
		}else
			System.out.println("rect 2 is not larger");	
	}
}
/*
--------------------Configuration: <Default>--------------------
Area of the first rectangle: 300
Area of the second rectangle: 500
length =10  width =30
length =20  width =25
30
10
false
rect 2 is larger

Process completed.
*/
/**
 * BankAccount.java
 * 2009/1/21
 */


public class BankAccount 
{
	private String name;
	private double balance;
	
    public BankAccount() {
    }
    // constructs an account
    public BankAccount(String name, double balance){
    	this.name = name;
    	this.balance = balance;
    }
    // sets the name
    public void setName(String name){
    	this.name = name;
    }
    // deposits funds
	public void deposit(double amount){
		balance += amount;  
	}
	// withdraw funds
	public void withdraw(double amount){
		if (balance-amount>= 0 && amount>0)
			balance -= amount;
		else
			System.out.println("NOT ENOUGH FUNDS");		
	}
	// returns balance
	public double getBalance(){
		return balance;
	}
	// prints the balance
	public void printBalance(){
		System.out.println(name+",\n\tyour balance is:\t"+balance);
	}
	// sets the balance
	public void setBalance(double newBalance){
		balance = newBalance;
	}
	// transfers money to given account
	public void transferTo(BankAccount otherAccount, double amount){
		if (amount <= balance){
			this.withdraw(amount);
			otherAccount.deposit(amount);
		}
		else
			System.out.println("NOT ENOUGH FUNDS");
	}
	// transfers money from given acount to this account
	public void transferFrom(BankAccount otherAccount, double amount){
		if (otherAccount.getBalance() >= amount){
			otherAccount.withdraw(amount);
			this.deposit(amount);
		}
		else
			System.out.println("NOT ENOUGH FUNDS");
	}
	// standard to string method
	public String toString(){
		String result="Name = "+name+"\n\tBalance = "+balance;
		return result;
	}    
}
/**
 * BankAccountDemo2.java
 * 2009/1/21
 */


public class BankAccountDemo2 {

	public static void main(String[] args)
	{
		BankAccount account1, account2;
		account1 = new BankAccount();
		account2 = new BankAccount("Jack", 100.00);
		account1.setName("Jill");
		account1.deposit(200.00);
		account2.withdraw(-500);
		account2.printBalance();
		
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		
		account1.transferTo(account2, 50.0);
		account2.transferFrom(account1, 30.0);
				
		System.out.println(account1.toString());
		System.out.println(account2.toString());
	}    
}
/*
--------------------Configuration: <Default>--------------------
NOT ENOUGH FUNDS
Jack,
    your balance is:    100.0
Name = Jill
    Balance = 200.0
Name = Jack
    Balance = 100.0
Name = Jill
    Balance = 120.0
Name = Jack
    Balance = 180.0

Process completed.
*/
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
/**
 * Date.java
 * Lab 3
 * CSCI 1101
 * Alex Moriarty B00317947
 * 2009/1/28
 */
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
/**
 * DateDemo1.java
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
		birthday.increaseDate();
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
--------------------Configuration: <Default>--------------------
please enter date in "mm dd yyyy" format
02 29 2004
Invalid date, try again
please enter date in "mm dd yyyy" format
12 25 2008
please enter date in "mm dd yyyy" format
12 31 2008

December,25 2008
    is Christmas day

February,6 2009
    is not Christmas day

December,31 2008
    is not Christmas day
    is the last day of December
    is the last day of the year 2008
January,1 2009
    is not Christmas day

month :12   day :25 year :2008
month :2    day :6  year :2009
month :1    day :1  year :2009

Process completed.
*/
