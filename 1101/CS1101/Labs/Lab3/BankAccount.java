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
	public double getBalance(){
		return balance;
	}
	public void printBalance(){
		System.out.println(name+",\n\tyour balance is:\t"+balance);
	}
	public void setBalance(double newBalance){
		balance = newBalance;
	}
	public void transferTo(BankAccount otherAccount, double amount){
		if (amount <= balance){
			this.withdraw(amount);
			otherAccount.deposit(amount);
		}
		else
			System.out.println("NOT ENOUGH FUNDS");
	}
	public void transferFrom(BankAccount otherAccount, double amount){
		if (otherAccount.getBalance() >= amount){
			otherAccount.withdraw(amount);
			this.deposit(amount);
		}
		else
			System.out.println("NOT ENOUGH FUNDS");
	}
	public String toString(){
		String result="Name = "+name+"\n\tBalance = "+balance;
		return result;
	}    
}