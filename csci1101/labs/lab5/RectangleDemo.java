/**
 * Alex Moriarty
 * Lab 5 cs1101  
 * 2009/2/11
 */

public class RectangleDemo {
	public static void main(String[] args) {
    	//make points
    	Point p1, p2, p3, p4, p5, p6;
    	p1 = new Point(1,1);
    	p2 = new Point(5,5);
    	p3 = new Point(2,2);
    	p4 = new Point(3,3);
    	p5 = new Point(3,4);
    	p6 = new Point(6,7);
    	//make rectangles
    	Rectangle2D r1, r2, r3;
    	r1 = new Rectangle2D(p1, p2);
    	r2 = new Rectangle2D(p3, p4);
    	r3 = new Rectangle2D(p5, p6);
    	
    	if (r1.contains(p4))
    		System.out.println(" point p1: "+p1+" is inside r1 ");
    	if (r1.contains(p6)== false)
    		System.out.println(" point p6: "+p6+" is outside r1");	
    	if (r1.contains(r2))
    		System.out.println("\n Rectangle r2 is inside r1");
    	if (r1.contains(r3)==false)
    		System.out.println("\n Rectangle r3 is not inside r1");
    	if (r1.overlap(r3))
    		System.out.println("\n Rectangle r3 overlaps r1");
    	if (r1.overlap(r2) == false)
    		System.out.println("\n Rectangle r2 does not overlaps r1");     		    	
    }
}
/*
--------------------Configuration: <Default>--------------------
 point p1: Point = (1,1) is inside r1 
 point p6: Point = (6,7) is outside r1

 Rectangle r2 is inside r1

 Rectangle r3 is not inside r1

 Rectangle r3 overlaps r1

 Rectangle r2 does not overlaps r1

Process completed.
*/
