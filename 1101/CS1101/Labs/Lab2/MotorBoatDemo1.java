/**
 * @(#)MotorBoatDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/23
 */

public class MotorBoatDemo1 {
    public static void main(String[] args) {
    	MotorBoat boat1, boat2;
    	boat1 = new MotorBoat();
    	boat2 = new MotorBoat(100, 80, 95, 70);
    	
    	System.out.println(boat1.toString());
    	System.out.println(boat2.toString());
    	
    	boat2.setSpeed(-100);
    	
    	boat1.addFuel(150);
    	boat2.boatFor(1);
    	
    	System.out.println(boat2.toString());
    	System.out.println(boat1.toString());
    	    
    }
}
