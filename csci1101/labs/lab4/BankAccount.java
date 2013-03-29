/**
 * Alex Moriarty
 * Q 2: BankAccount Class
 * Lab 4 cs1101  
 * 2009/2/4
 */


public class BankAccount {
	
	private String name;
	private double balance;
	static double rate =0 ;
	static int accounts =0 ;
	
//A constructor which sets the name and balance, and increments number of accounts.
    public BankAccount(String name, double balance) {
    	this.name = name;
    	this.balance = balance;
    	accounts ++;
    }
//	A static method to set the interest rate
    public static void setRate(double rate){
    	rate = rate;
    }
//	A static method to get the interest rate
    public static double getRate(){
    	return rate;
    }
//	A static method to get the number of accounts
	public static int getAccounts(){
    	return accounts;
    }
//	A non-static method to deposit an amount
   	public void deposit(double amount){
        if (amount > 0){
        	balance += amount;
        }	
    }
//	A non-static method to withdraw an amount
	public void withdraw(double amount){
    	if (amount > 0 && amount <= balance){
    		balance -= amount;
    	}
    }
//	A non-static method to add interest
	public void addIntrest(){
    	balance += balance*rate*0.01;
    }
//	A non-static method to get the balance.
	public double getBalance(){
    	return balance;
    }
//	A non-static toString method
	public String toString(){
    	String result ="\nName :\t"+name+"\nBalance :\t"+balance+"\nRate :\t"+rate+"\nAccounts :\t"+accounts;
    	return result;
    }
}