/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */

public class Wallet
{
	private double totalValue;
//	private String[][] coins;		//was to contain [Coin Name][how Many are in wallet] for smaller array
//	private int tracker = 0;		//track the last place in array, for adding new coins
	private String[] coins = new String[100]; 
/*		*/
	public Wallet(){
	}
	public void addCoin(Coin coin){
		totalValue += coin.getValue();
		putCoin(coin);
	}
	public void removeCoin(Coin coin){
		if (hasCoin(coin)){
			totalValue -= coin.getValue();
			takeCoin(coin);
		} else
			System.out.println("Error: no coins of type: "+coin.getName()+" in this wallet");	
	}
	public double getTotalValue(){
		return totalValue;
	}
	private boolean hasCoin(Coin coin){
		for (int i = 0; i < 100; i++){
			if(coins[i] == coin.getName()){
				return true;
			}
		}
		return false;
	}
	private void putCoin(Coin coin){
		for (int i = 0; i < 100; i++){
			if(coins[i] == null){
				coins[i] = coin.getName();
				return;
			}
		}
		return;
	}
	private void takeCoin(Coin coin){
		for (int i = 0; i < 100; i++){
			if(coins[i] == coin.getName()){
				coins[i] = null;
				return; 
			}
		}
		return;
	}
	public String toString(){
		String contents = "Contents Of Wallet :\n";
		for (int i = 0; i < 100; i++){
			contents+="\t"+i+":  "+coins[i]+"\n";
		}
		return contents;
	}
/* //Maybe todo later. (better use of array)
	private boolean containsCoin(Coin coin){
		for (int i=0; i<20; i++){
			if (coins[i][0] == coin.getName() && Integer(coins[i][1]) > 0){
				return true;
			}else 
				return false;	}}
	private boolean hasCoin(Coin coin){
		for (int i=0; i<20; i++){
			if (coins[i][0] == coin.getName()){
				return true;
			}else 
				return false;	}}
	private void updateCoins(Coin coin){
		if (hasCoin(coin) == true){
			for (int i=0; i<20; i++){
				if (coins[i][0] == coin.getName()){
					coins[i][1] = ""+(Integer(coins[i][1])+1);
	}}}}*/
}
