/**
 *	CS 1101 Lab 6
 *	RightArrow.java
 *	Alex Moriarty
 *	2009/2/17
 **/


public class RightArrow extends LineShape{
/*
The size of the arrow is determined by two numbers,
 one for the length of the “tail” and one for the width of the arrowhead. 
 (the width is the length of the vertical base). 
 The arrow shown here has a length of 21 and a width of 7. 
 The width of the arrowhead cannot be an even number,
 so your constructors and mutator methods should check to make sure that it is always odd.
 You can assume that the width of the base of the arrowhead is at least 3. Write a test program for each class
*/
	private int tail, width;
    public RightArrow() {
    }
    public RightArrow(int tail, int width){
    	setTail(tail);
    	setWidth(width);    	
    }
    public void setTail(int tail){
    	this.tail = tail;
    }
    public void setWidth(int width){
    	if (isOdd(width))
    		this.width = width;
    	else
    		this.width = 7;	
    }
    private boolean isOdd(int n){
    	if (n%2!=0 && n>=3){
    		return true;
    	}else
    		return false;
    }
    public void drawHere(){
    	for (int i=0; i<width;i++){
    		if(i == width/2 ){
    			drawHorizontal(tail);
    			drawNext(i);	
    		}
    		if(i == 0 || i == width-1){
    			skipSpaces(getOffset()+tail-1);
    			draw();
    		}
    		if (i != width/2 && i!=0 && i!=width-1){
    			skipSpaces(getOffset()+tail-1);
    			draw();
    			drawNext(i);
    			//System.out.print(i);
    		}
    		System.out.println();    		
    	}
    }
    private void drawNext(int i){
    	if ( i<=width/2 && i>0){
    		skipSpaces(i*2);
    		draw();
    	}
    	if ( i>(width/2) && i<width){
    		skipSpaces((width-i-1)*2);
    		draw();
    		//System.out.print("*");
    	}	
    }    
}