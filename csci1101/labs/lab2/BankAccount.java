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
	
    public BankAccount() {
    }
    public BankAccount(String name, double balance){
    	this.name = name;
    	this.balance = balance;
    }
    public void setName(String name){
    	this.name = name;
    }
	public void deposit(double amount){
		balance += amount;  
	}
	public void withdraw(double amount){
		if (balance-amount>= 0 && amount>0)
			balance -= amount;
		else
			System.out.println("NOT ENOUGH FUNDS");		
	}
	public void printBalance(){
		System.out.println(name+",\nyour balance is:\t"+balance);
	}
	public String toString(){
		String result="Name = "+name+"\nBalance = "+balance;
		return result;
	}

    
}