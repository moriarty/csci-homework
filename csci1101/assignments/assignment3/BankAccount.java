/**
 * @(#)test.java
 *
 *
 * @author 
 * @version 1.00 2009/3/3
 */


public class BankAccount {
	private double balance = 0;
	private double rate = 0.005;
	private double charge = 22.50;  
	private int deposits = 0;
	private int withdraws = 0;
    //empty constructor
    public BankAccount() {
    }
    //Constructor (which accepts arguments for the balance and annual interest rate)
    public BankAccount(double balance, double rate){
    	if (balance > 0){
    		setBalance(balance);
    	}
    	setRate(rate);
    }
    // set methods
    public void setBalance(double balance){
    	this.balance = balance;
    }
    public void setRate(double rate){
    	this.rate = rate;
    }
    public void setCharge(double charge){
    	this.charge = charge;
    }
    private void setDeposits(int deposits){
		this.deposits = deposits;  
    }
    private void setWithdraws(int withdraws){
    	this.withdraws = withdraws;
    }
    //getMethods
    public double getBalance(){
    	return balance;
    }
	public double getRate(){
		return rate;
	}
	public double getCharge(){
		return charge;
	}
	public int getDeposits(){
		return deposits;
	}
	public int getWithdraws(){
		return withdraws;
	}			
	//deposit
	public void deposit(double amount){
		if (amount > 0)	{
			setBalance(balance+amount);
			deposits ++;		
		}
	} 
	//withdraw
	public void withdraw(double amount){
		if (balance-amount>0 && amount >= 0){
			setBalance((getBalance()-amount));
			withdraws ++;
		}		
	}
	//calcInterest (updates the balance by calculating the monthly interest earned by the account, and adding this interest to the balance. The formula for the monthly interest is balance*annual interest rate/12).
	public void calcInterest(){
		double intrest = balance*rate/12;
		deposit(intrest);
	}
	//monthlyProcess (should subtract the monthly service charges, call the calcInterest method, and then set the variables that hold the number of withdrawals, number of deposits, and monthly service charges to zero).
	public void monthlyProcess(){
		if (balance - charge >=0){
			withdraw(charge);
			setWithdraws(withdraws - 1);
		}		
		// note, this bank is nice, if you do not have enough for the service charge, the fee is waved. 
		/** //otherwise uncomment this. calcIntrest will not deposit with a negative balance. 
		if (balance - charge < 0){
			setBalance(balance-charge); 
		**/ 
		calcInterest();
		setDeposits(0);
		setWithdraws(0);
		// i dont think banks only charge the monthly fee once, the base charge stays and you pay it every month, so you can uncomment it if you wish.
		//setCharge(0); 
	}
    public String toString(){
    	String str = "\t\tBankAccount\n\tBalance:\t"+balance+"\n\tRate:\t\t"+rate+"\n\tFees:\t\t"+charge+"\n\tDeposits:\t"+deposits+"\n\twithdraws:\t"+withdraws;
    	return str;
    }
}