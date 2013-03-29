/**
 *	CS 1101 Lab 6
 *	LeftArrow.java
 *	Alex Moriarty
 *	2009/2/17
 **/


public class LeftArrow extends LineShape{

    public LeftArrow() {
    }
    private int tail, width;
    public LeftArrow(int tail, int width){
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
    	for (int i=1; i<=width;i++){
    		if(i == width/2+1 ){
    			skipSpaces(getOffset());
    			draw();
    			skipSpaces(width-1);
    			drawLine(tail);	
    		}
    		if(i == 1 || i == width){
    			skipSpaces(getOffset()+width);
    			draw();
    		}
    		if (i != width/2+1 && i!=1 && i!=width){
    			skipSpaces(getOffset());
    			skipSpaces(Math.abs(width-((i-1)*2)-1));
    			draw();
    			drawNext(i);
    			//System.out.print(i);
    		}
    		System.out.println();    		
    	}
    }
    private void drawNext(int i){
    	if ( i<=width/2 && i>0){
    		skipSpaces(Math.abs((i-1)*2));
    		draw();
    	}
    	if ( i>(width/2) && i<width){
    		skipSpaces(((width-i)*2));
    		draw();
    		//System.out.print(i);
    	}	
    }
    
    
}