/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/11
 */

public class WalletDemo {
        
   
    public static void main(String[] args) {
    	Wallet myWallet;
    	Coin loonie, toonie, quarter, nickle, dime, penny; 
    	loonie = new Coin("loonie", 1.00);
    	toonie = new Coin("toonie", 2.00);
    	quarter = new Coin("quarter", 0.25);
    	nickle = new Coin("nickle", 0.05);
    	dime = new Coin("dime", 0.10);
    	penny = new Coin("penny", 0.01);
    	myWallet = new Wallet();
    	
    	for (int i=0; i < 5; i++){
	    	myWallet.addCoin(loonie);
			myWallet.addCoin(dime);
			myWallet.addCoin(penny);	
    	}
    	System.out.println(myWallet);
    	for (int i=0; i<4; i++){
    		myWallet.removeCoin(penny);
    	}

    	for (int i=0; i < 20; i++){
    		myWallet.addCoin(toonie);
    	}
    	myWallet.removeCoin(nickle);
    	System.out.println(myWallet);
    	System.out.println(myWallet.getTotalValue());
    }
}
/*
--------------------Configuration: <Default>--------------------
Contents Of Wallet :
    0:  loonie
    1:  dime
    2:  penny
    3:  loonie
    4:  dime
    5:  penny
    6:  loonie
    7:  dime
    8:  penny
    9:  loonie
    10:  dime
    11:  penny
    12:  loonie
    13:  dime
    14:  penny
    15:  null
    16:  null
...
    95:  null
    96:  null
    97:  null
    98:  null
    99:  null

Error: no coins of type: nickle in this wallet
Contents Of Wallet :
    0:  loonie
    1:  dime
    2:  toonie
    3:  loonie
    4:  dime
    5:  toonie
    6:  loonie
    7:  dime
    8:  toonie
    9:  loonie
    10:  dime
    11:  toonie
    12:  loonie
    13:  dime
    14:  penny
    15:  toonie
    16:  toonie
    17:  toonie
    18:  toonie
    19:  toonie
    20:  toonie
    21:  toonie
    22:  toonie
    23:  toonie
    24:  toonie
    25:  toonie
    26:  toonie
    27:  toonie
    28:  toonie
    29:  toonie
    30:  toonie
    31:  null
    32:  null
... 
    98:  null
    99:  null

45.51

Process completed.
*/