/**
 * Alex Moriarty
 * Q 1: Geometry Class
 * Lab 4 cs1101  
 * 2009/2/4
 */

import java.util.Scanner;
//import java.Math;

public class Geometry {
	private static final double PI = 3.14;
	
    public Geometry() {
    }
    public static double areaCircle(){
    //		area of a Circle = PI*radius^2.
    	double radius, area;
    	radius = getRadius();
    	area = PI*radius*radius;
    	return area;	
    } 
    public static double volumeSphere(){
    //		Volume of a sphere = (4/3)*PI*radius^3.
    	double radius, volume;
    	radius = getRadius();
    	volume = (4/3)*PI*radius*radius*radius;
    	return volume;        	
    }
    public static double areaSurfaceSphere(){
    //		Surface area of a sphere = 4*PI*radius^2
    	double radius, area;
    	radius = getRadius();
    	area = 4*PI*radius*radius;
    	return area;    
    }
    public static double volumeCylinder(){
    //		Surface area of a sphere = 4*PI*radius^2
    	double radius, area;
    	radius = getRadius();
    	area = 4*PI*Math.pow(radius, 2);
    	return area; 
    }
    public static double areaSurfaceCylinder(){
    //		Surface area of a cylinder = 2*PI*radius2 + 2*PI*radius*height
    	double radius, height, area;
    	radius = getRadius();
    	height = getHeight(); 
    	area = 2*PI*radius*radius + 2*PI*radius*height;
    	return area;	   	
    }
    private static double getRadius(){
    	System.out.println("Please enter the radius: ");
    	Scanner input = new Scanner(System.in);
    	return input.nextDouble();  
    }
    private static double getHeight(){
    	System.out.println("Please enter the height: ");
    	Scanner input = new Scanner(System.in);
    	return input.nextDouble();    	
    }
        
}