/**
 *	CS 1101 Lab 6
 *	RectangleShape.java
 *	Alex Moriarty
 *	2009/2/17
 **/

public class RectangleShape extends LineShape{
/*
•	Instance variables height and width
•	Constructor that sets the offset, height and width
•	Method drawHere that draws the rectangle starting at the given offset and of dimensions width and height
•	Method drawSides that draws the two sides of the rectangle. This method is used by the drawHere method.
*/
	private int height, width;	
	
    public RectangleShape() {
    }
    public RectangleShape(int width, int height){
    	setWidth(width);
    	setHeight(height);
    }
    public void setHeight(int height){
    	this.height = height;
    }
    public void setWidth(int width){
    	this.width = width;
    }
    public void drawHere(){
    	drawHorizontal(width);
    	skipLines(1);
    	drawSides(height);
    	drawHorizontal(width);
    }
    private void drawSides(int height){
    	for (int i=0; i<(height-2); i++){
    		skipSpaces(getOffset());
    		draw();
    		skipSpaces(width-2);
    		draw();
    		skipLines(1);
    	}
    }
    
    
}