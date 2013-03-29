/**
 *Waypoint.java
 *Alex Moriarty
 *2009/3/4
 */

//COMMENTING NEEDED? no.
//Commented... yes. 
//Bonus points?
public class Waypoint {
	private int X;	//X coord
	private int Y;	//Y coord
	private int T;	//Time in seconds

    public Waypoint() {
    }
    public Waypoint(int X, int Y, int T){
    	setX(X);
    	setY(Y);
    	setT(T);
    }
    //set methods, followed by get methods
    public void setX(int X){
    	this.X = X;
    }
    public void setY(int Y){
    	this.Y = Y;
    }
    public void setT(int T){
    	if (T>=0)
    		this.T = T;
    	else
    		this.T = T*-1;
    }
    public int getX(){
    	return X;
    }
    public int getY(){
    	return Y;
    }
    public int getT(){
    	return T;
    }
    public String toString(){
    	String str = "\nX:\t"+X+"\nY:\t"+Y+"\nT:\t"+T;
    	return str;
    }     
}