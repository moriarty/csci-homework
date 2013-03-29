/**
 * @(#)Triangle2D.java
 *
 *
 * @author 
 * @version 1.00 2009/2/13
 */


public class Triangle2D {
	private Point high;
	private Point low;
	private Point mid;
	
//	private Point left;
//	private Point right;
//	private Point centre;
	
    public Triangle2D(Point p1, Point p2, Point p3) {
    	high = findHighest(p1, p2, p3);
    	low = findLowest(p1, p2, p3);
    	mid = findMid(p1, p2, p3);
    	
    //	left = findLeftMost(p1,p2,p3);
    //	right = findRightMost(p1,p2,p3);
    //	centre = findCentre(p1,p2,p3);
    }
    private Point findHighest(Point p1, Point p2, Point p3){
    	if (p1.getY() > p2.getY() && p1.getY() > p3.getY()){
    		return p1;
    	}if (p2.getY() > p1.getY() && p2.getY()> p3.getY()){
    		return p2;
    	}else 
    		return p3;    	
    } 
    private Point findLowest(Point p1, Point p2, Point p3){
    	if (p1.getY() < p2.getY() && p1.getY() < p3.getY()){
    		return p1;
    	}if (p2.getY() < p1.getY() && p2.getY() < p3.getY()){
    		return p2;
    	}else 
    		return p3;
    }
    private Point findMid(Point p1, Point p2, Point p3){
    	if (p3.getY() < p1.getY() && p3.getY() > p2.getY()){
    		return p3;
    	}
    	if (p2.getY() < p1.getY() && p2.getY() > p3.getY()){
    		return p2;
    	}else 
    		return p1;
    }
    /*
    private Point findLeft(Point p1, Point p2, Point p3){
    	if (p1.getX() < p2.getX() && p1.getY() < p3.getX() ){
    		return p1;
    	}if (p2.getX() < p1.getX() && p2.getX() < p3.getX() ){
    		return p2;
    	}else 
    		return p3;
    }
    private Point findRight(Point p1, Point p2, Point p3){
    	
    }
    private Point findCentre(Point p1, Point p2, Point p3){
    	
    }*/
    
    private double findM(Point p1, Point p2){
    	return (p2.getY()-p1.getY())*1.0 / (p2.getX()-p1.getX()*1.0);
    }
    private double findB(Point p1, Point p2){
    	double b; 
    	b = p1.getY() - findM(p1, p2)*p1.getX();
    	return b;	
    }
    private boolean isBelow(Point aPoint, Point lower, Point higher){
    	double m, b;
    	m = findM(lower, higher);
    	b = findB(lower, higher);
    	
    	System.out.println("/n"+aPoint.getY()+":"+m+"*"++""++"")
    	
    	if (aPoint.getY() < (m*aPoint.getX())+b ){
    		return true;
    	}
    	else return false;
    }
    public boolean contains(Point aPoint){
    	if ((isBelow(aPoint,low,mid)==false)&&isBelow(aPoint,low,high)&&isBelow(aPoint,mid,high)){
    		return true;
    	}else
    		return false;
    } 
    
}