/**
 * BankAccountDemo2.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
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