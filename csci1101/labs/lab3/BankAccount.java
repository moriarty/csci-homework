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