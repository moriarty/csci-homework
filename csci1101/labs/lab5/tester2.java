/**
 * @(#)tester2.java
 *
 *
 * @author 
 * @version 1.00 2009/2/13
 */

public class tester2 {
        
    
    public static void main(String[] args) {
       Point p1, p2, p3, p4, p5, p6;
       p1 = new Point (0,0);
       p2 = new Point (0,5);
       p3 = new Point (5,0);
       p4 = new Point (1,1);
       p6 = new Point (1,2);
       p5 = new Point (2,1);
       Triangle2D tri1, tri2;
       tri1 = new Triangle2D(p1,p2,p3);
       tri2 = new Triangle2D(p4,p5,p6);
       
       System.out.println(p1.isLeftOf(p2)+"\n\n"+p2.isHigher(p1)); 
       
       System.out.println(tri2.contains(p1));
       
       
       	
    }
}
