**************************************************************************
/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */

public class RoomDimension
{	
	private double length;	
	private double width;

/*	Room Dimension Empty Constructor	*/
//	public RoomDimension(){
//	}
/*	Room Dimension Constructor	*/
	public RoomDimension(double length, double width){
		setLength(length);
		setWidth(width);
	}
/*	Sets Room Length	*/	
	public void setLength(double length){
		this.length = length;
	}
/*	Sets Room Width	*/	
	public void setWidth(double width){
		this.width = width;
	}
/*	Returns Room Length	*/	
	public double getLength(){
		return length;
	}
/*	Returns Room Width	*/	
	public double getWidth(){
		return width;
	}
/*	Returns Calculated Area		*/	
	public double getArea(){
		return (length*width);
	}
/*	Returns All variables and Area in String	*/	
	public String toString(){
		String result = "length :\t"+length+"\twidth :\t"+width+"\tArea :\t"+getArea();
		return result;
	}
}
**************************************************************************
/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */

public class RoomCarpet
{	
	private RoomDimension size;
	private double carpetCost;
/*	Empty RoomCarpet Constructor	*/
//	public RoomCarpet(){
//	}
/*	RoomCarpet Constructor	*/
	public RoomCarpet(RoomDimension size, double carpetCost){
		setSize(size);
		setCarpetCost(carpetCost);
	}
/*	Sets room size	*/
	public void setSize(RoomDimension size){
		this.size = size;
	}
/*	Sets Carpet Cost	*/
	public void setCarpetCost(double carpetCost){
		this.carpetCost = carpetCost;
	}
/*	Returns Calculated Total cost	*/
	public double getTotalCost(){
		return (size.getArea() * carpetCost);
	}
/*	Returns all variables and Total Cost in a String	*/
	public String toString(){
		String result = "\nDimensions :\n"+size+"\tCarpet Cost: "+carpetCost+"\nTotal carpet cost: :"+getTotalCost()+"$";
		return result;
	}	
}
**************************************************************************
/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/11
 */

public class RoomDemo {

    public static void main(String[] args) {
        //create 3 rooms of set dimensions
        RoomDimension room1, room2, room3;
        room1 = new RoomDimension(10, 10);
        room2 = new RoomDimension(20, 20);
        room3 = new RoomDimension(30, 30);
        // carpet each room with a carpet of some price
        RoomCarpet carpet1, carpet2, carpet3;
        carpet1 = new RoomCarpet(room1, 1.50);
        carpet2 = new RoomCarpet(room2, 1.75);
        carpet3 = new RoomCarpet(room3, 1.50);
        
        System.out.println("Carpet Rooms\n\nRoom 1:"+carpet1+"\n\nRoom 2: "+carpet2+"\n\nRoom 3: "+carpet3+"\n");
        
    }
}
/*
--------------------Configuration: <Default>--------------------
Carpet Rooms

Room 1:
Dimensions :
length :    10.0    width : 10.0    Area :  100.0   Carpet Cost: 1.5
Total carpet cost: :150.0$

Room 2: 
Dimensions :
length :    20.0    width : 20.0    Area :  400.0   Carpet Cost: 1.75
Total carpet cost: :700.0$

Room 3: 
Dimensions :
length :    30.0    width : 30.0    Area :  900.0   Carpet Cost: 1.5
Total carpet cost: :1350.0$


Process completed.
 */
**************************************************************************
See Attached For Q2 (UML DOC)
**************************************************************************
/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */

public class Coin
{
	private String name;	
	private double value;
/*		*/	
//	public Coin(){
//	}	
/*	Coin Constructor, sets Name and Value	*/
	public Coin(String name, Double value){
		setName(name);
		setValue(value);
	}
/*	Sets the name	*/
	public void setName(String name){
		this.name = name;
	}
/*	Sets the vaule	*/
	public void setValue(double value){
		this.value = value;
	}
/*	returns the name	*/
	public String getName(){
		return name;
	}
/*	returns the value	*/
	public double getValue(){
		return value;
	}
/*	returns variables in String format	*/
	public String toString(){
		String result = "\nCoin name: "+name+"\tValue: "+value;
		return result; 
	}
}
**************************************************************************
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
**************************************************************************
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
**************************************************************************
/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */
public class Point {
	private int x;
	private int y;

//	public Point() {
//	}
    public Point(int x, int y){
    	setX(x);
    	setY(y);
    }
/*	*/
    public void setX(int x){
    	this.x = x;
    }
/*	*/
    public void setY(int y){
    	this.y = y;
    }
/*	*/
    public int getX(){
    	return x;
    }
/*	*/
    public int getY(){
    	return y;
    }
/*	*/
    public boolean isHigher(Point p2){
    	if (p2.getY() >= y){
    		return false;
    	}else
    		return true;
    }
/*	*/
    public boolean isLeftOf(Point p2){
    	if (p2.getX() >= x)
		return false;
	else
		return true;
    }
/*	*/
	public String toString(){
		String result = "Point = ("+x+","+y+")";
		return result;
	}    
}
**************************************************************************
/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/10
 */


public class Rectangle2D {
	private Point topLeft;
	private Point bottomRight;
	private int length;
	private int width;	

//	public Rectangle2D() {
//	}
	public Rectangle2D(Point topLeft, Point bottomRight){
		setTopLeft(topLeft);
		setBottomRight(bottomRight);
		setDimension(topLeft, bottomRight);	
	}    
/*		*/
	public void setTopLeft(Point topLeft){
		this.topLeft = topLeft;
	} 
/*		*/
	public void setBottomRight(Point bottomRight){
		this.bottomRight = bottomRight;
	}
/*		*/
	private void setDimension(Point topLeft, Point bottomRight){
		setLength((bottomRight.getX()-topLeft.getX()));
		setWidth((bottomRight.getY()-topLeft.getY()));
	}
/*		*/
	private void setLength(int length){
		this.length = length;
	}
/*		*/
	private void setWidth(int width){
		this.width = width;
	}
/*		*/
	public Point getTopLeft(){
		return topLeft;
	}
/*		*/
	public Point getBottomRight(){
		return bottomRight;
	}
/*		*/
	public Point getBottomLeft(){
		Point bottomLeft;
		bottomLeft = new Point(topLeft.getX(), bottomRight.getY());
		return bottomLeft;
	}
/*		*/
	public Point getTopRight(){
		Point topRight;
		topRight = new Point(bottomRight.getX(), topLeft.getY());
		return topRight;
	}
/*		*/
	public boolean contains(Point p){
		if (topLeft.getX() < p.getX() && bottomRight.getX() > p.getX() && topLeft.getY() < p.getY() && bottomRight.getY() > p.getY() )
			return true;
		else
			return false;
	}
/*		*/
	public boolean contains(Rectangle2D r){
		if ( contains(r.getTopLeft()) && contains(r.getBottomRight()) )
			return true;
		else
			return false;
	}
/** **/
 	public boolean overlap(Rectangle2D r){
		if ( contains(r.getTopLeft()) && contains(r.getBottomRight())== false ){
			return true;
		} if ( contains(r.getTopLeft()) == false && contains(r.getBottomRight()) ){
			return true;
		} if ( contains(r.getTopRight()) && contains(r.getBottomLeft()) == false){
			return true;
		} if ( contains(r.getTopRight()) == false && contains(r.getBottomLeft()) ){
			return true;
		}
		else
			return false;
	}
}
**************************************************************************
/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/11
 */

public class RectangleDemo {
	public static void main(String[] args) {
    	//make points
    	Point p1, p2, p3, p4, p5, p6;
    	p1 = new Point(1,1);
    	p2 = new Point(5,5);
    	p3 = new Point(2,2);
    	p4 = new Point(3,3);
    	p5 = new Point(3,4);
    	p6 = new Point(6,7);
    	//make rectangles
    	Rectangle2D r1, r2, r3;
    	r1 = new Rectangle2D(p1, p2);
    	r2 = new Rectangle2D(p3, p4);
    	r3 = new Rectangle2D(p5, p6);
    	
    	if (r1.contains(p4))
    		System.out.println(" point p1: "+p1+" is inside r1 ");
    	if (r1.contains(p6)== false)
    		System.out.println(" point p6: "+p6+" is outside r1");	
    	if (r1.contains(r2))
    		System.out.println("\n Rectangle r2 is inside r1");
    	if (r1.contains(r3)==false)
    		System.out.println("\n Rectangle r3 is not inside r1");
    	if (r1.overlap(r3))
    		System.out.println("\n Rectangle r3 overlaps r1");
    	if (r1.overlap(r2) == false)
    		System.out.println("\n Rectangle r2 does not overlaps r1");     		    	
    }
}
/*
--------------------Configuration: <Default>--------------------
 point p1: Point = (1,1) is inside r1 
 point p6: Point = (6,7) is outside r1

 Rectangle r2 is inside r1

 Rectangle r3 is not inside r1

 Rectangle r3 overlaps r1

 Rectangle r2 does not overlaps r1

Process completed.
*/
**************************************************************************
