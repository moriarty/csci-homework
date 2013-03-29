/**
 *	CS 1101 Lab 6
 *	Shape.java
 *	Alex Moriarty
 *	2009/2/17
 **/


public class Shape {
	static final double PI = 3.14159265;
	private double area;

    public Shape() {
    }
    public void setArea(double area){
    	this.area = area;
    }
    public double getArea(){
    	return area;
    }
    public String toString(){
    	return "Area is :"+getArea();
    }
    
    
}