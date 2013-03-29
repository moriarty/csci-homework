/**
 * @(#)test.java
 *
 *
 * @author 
 * @version 1.00 2009/3/3
 */


public class SavingsAccount extends BankAccount{
	private boolean valid;
    public SavingsAccount(double balance, double rate){
    	if (balance > 0){
    		setBalance(balance);
    	}
    	setRate(rate);
    	setValid();
    }
    private void setValid(){
    	valid = validate();
    }
    public boolean getValid(){
    	return valid;
    } 
    private boolean validate(){
    	if (getBalance() >= 25){
    		return true;
    	}else
    		return true;
    }
    //withdraw: This method should call the superclass version after ensuring that the account is active.
    public void withdraw(double amount){
    	if (valid){
    		super.withdraw(amount);
    	}
    	setValid();
    }
	//deposit: This method should call the superclass version. It should also check/change the account status.
	public void deposit(double amount){
		super.deposit(amount);
		setValid();
	}
	//monthlyProcess: Before the superclass method is called, this method checks the number of withdrawals. If it is more than 4, a service charge of $1 for each withdrawal above 4 is added to the superclass field that holds the monthly service charges.
	public void monthlyProcess(){
		int wdsOver = 0;
		if (getWithdraws()>4){
			wdsOver = getWithdraws()-4;
		}
		setCharge(getCharge()+wdsOver*1.0);
		super.monthlyProcess();
		setCharge(getCharge()-wdsOver*1.0);
	}
	//toString to be fixed
    
}