/**
 * @(#)BankAccountDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */


public class BankAccountDemo1 {

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
	}
    
    
}