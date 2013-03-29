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
