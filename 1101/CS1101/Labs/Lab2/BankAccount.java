/**
 * @(#)BankAccount.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */


public class BankAccount 
{
	private String name;
	private double balance;
//	constructor	...incase you want to set them the long way 
    public BankAccount() {
    }
//	constructor2    
    public BankAccount(String name, double balance){
    	this.name = name;
    	this.balance = balance;
    }
//	sets the Name on the account    
    public void setName(String name){
    	this.name = name;
    }
// 	sets the deposit amount. dont try and deposit negative money.. its your loss    
	public void deposit(double amount){
		balance += amount;  
	}
//	some luck person might just try and withdraw negative money.. surprise!.. my kinda bank.	
	public void withdraw(double amount){
		if (balance-amount>= 0 && amount>0)
			balance -= amount;
		else
			System.out.println("NOT ENOUGH FUNDS");		
	}
//	prints name and balance	
	public void printBalance(){
		System.out.println(name+",\nyour balance is:\t"+balance);
	}
	public String toString(){
		String result="Name = "+name+"\nBalance = "+balance;
		return result;
	}
}