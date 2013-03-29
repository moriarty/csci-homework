/**
 * @(#)tester.java
 *
 *
 * @author 
 * @version 1.00 2009/2/17
 */

public class tester {
        
    /**
     * Creates a new instance of <code>tester</code>.
     */
    public tester() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	LineShape line1 = new LineShape();
        line1.setOffset(10);
        line1.drawVertical(10);
        ShapeBasics.skipLines(3);
        line1.drawHorizontal(10);
        ShapeBasics.skipLines(3);
        RectangleShape rect1 = new RectangleShape(10,10);
        rect1.setOffset(20);
        rect1.drawHere();	
        ShapeBasics.skipLines(3);
        RightArrow ra1, ra2;
        ra1 = new RightArrow(11,9);
        ra2 = new RightArrow(30,25);
        ra1.drawHere();
        ShapeBasics.skipLines(3);
        ra2.drawHere();
        ShapeBasics.skipLines(3);
        LeftArrow la1, la2;
        la1 = new LeftArrow(11,9);
        la1.drawHere();
        la2 = new LeftArrow(20,11);
        la2.setOffset(10);
        la2.drawHere();
        
        
	}
}
/*
--------------------Configuration: <Default>--------------------
          *
          *
          *
          *
          *
          *
          *
          *
          *
          *



          **********


                    **********
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    **********


          *
          *  *
          *    *
          *      *
***********        *
          *      *
          *    *
          *  *
          *



                             *
                             *  *
                             *    *
                             *      *
                             *        *
                             *          *
                             *            *
                             *              *
                             *                *
                             *                  *
                             *                    *
                             *                      *
******************************                        *
                             *                      *
                             *                    *
                             *                  *
                             *                *
                             *              *
                             *            *
                             *          *
                             *        *
                             *      *
                             *    *
                             *  *
                             *



         *
      *  *
    *    *
  *      *
*        ***********
  *      *
    *    *
      *  *
         *
                     *
                  *  *
                *    *
              *      *
            *        *
          *          ********************
            *        *
              *      *
                *    *
                  *  *
                     *

Process completed.
*/
