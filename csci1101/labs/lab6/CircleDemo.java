/* CircleDemo.java
 * 2009/2/18
 */

public class CircleDemo {
    public static void main(String[] args) {
    	Circle c1, c2, c3;
    	c1 = new Circle(1.0);
    	c2 = new Circle();
    	c2.setRadius(2);
    	c3 = new Circle(3.0);
    	System.out.println("c1 :\n"+c1+"\nc2 :\n"+c2+"\nc3 :\n"+c3);
    }
}
/*
--------------------Configuration: <Default>--------------------
c1 :
Circle: Radius: 1.0 Area: 0.0
c2 :
Circle: Radius: 2.0 Area: 0.0
c3 :
Circle: Radius: 3.0 Area: 0.0

Process completed.
*/
