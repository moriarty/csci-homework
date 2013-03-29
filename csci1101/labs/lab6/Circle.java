/**
 *	CS 1101 Lab 6
 *	Circle.java
 *	Alex Moriarty
 *	2009/2/17
 **/


public class Circle extends Shape{
	private double radius;
    public Circle() {
    }
    public Circle(double radius){
    	setRadius(radius);
    }
    public void setRadius(double radius){
    	this.radius = radius;
    }
    private double calcArea(){
    	return PI*radius*radius;
    }
    public double getRadius(){
    	return radius;
    }
    public String toString(){
    	return "Circle:\tRadius: "+getRadius()+"\tArea: "+getArea();
    }
    
    
}