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
