/**
 *	CS 1101 Lab 6
 *	LineShape.java
 *	Alex Moriarty
 *	2009/2/17
 **/


public class LineShape extends ShapeBasics{
/*
•	A no args constructor
•	A method to set the given offset
•	A method drawVertical that draws a vertical line of a given length starting at the offset
•	A method drawHorizontal that draws a horizontal line of a given length starting at the offset
*/
    public LineShape() {
    }
    public void drawVertical(int length){
    	for (int i=0; i<length; i++){
    		skipSpaces(getOffset());
    		draw();
    		skipLines(1);
    	}
    }
    public void drawHorizontal(int length){
    	skipSpaces(getOffset());
    	for (int i=0; i<length; i++){
			System.out.print("*");
    	}
    }
    public void drawLine(int n){
    	for (int i=0; i<n; i++)
    		System.out.print("*");
    }
    
    
}