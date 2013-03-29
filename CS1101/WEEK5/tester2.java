/**
 * @(#)tester2.java
 *
 *
 * @author 
 * @version 1.00 2009/2/13
 */

public class tester2 {
        
    
    public static void main(String[] args) {
       Point p1, p2;
       p1 = new Point (1,1);
       p2 = new Point (2,2);
       
       System.out.println(p1.isLeftOf(p2)+"\n\n"+p2.isHigher(p1)); 
    }
}
