/**
 * @(#)MotorBoat.java
 *
 *
 * @author 
 * @version 1.00 2009/1/21
 */


public class MotorBoat {
	private double maxFuel = 50; 	//	The capacity of the fuel tank (L)
	private double fuel = 30; 		//	The amount of fuel in the tank (L)
	private double maxSpeed = 85; 	//	The maximum speed of the boat (km/hr)
	private double speed = 0; 		//	The current speed of the boat (km/hr)
	private double efficiency = 15; //	The efficiency of the boat’s motor (L/100km)?
	private double distance = 0; 	//	The distance traveled (km)

    public MotorBoat() {
    }
//	Constructor that sets the capacity, fuel in the tank, max speed and efficiency

//	Set the current speed of the boat

//	Change the speed of the boat (the method should accept the change which is a positive or negative number and change the current speed. If the change is greater than max speed, it should set the current speed to max speed).

//	Operate the boat for an amount of time at the current speed (this method should set the distance traveled and reduce the amount of fuel in the tank by the appropriate amount).

//	Refuel the boat with some amount of fuel (if the total amount of fuel is greater than the capacity, set it to the capacity).
	public void addFuel(double fuel){
		if (this.fuel+fuel >= maxFuel && fuel > 0){
			this.fuel = maxFuel;
		}else if(fuel < 0){
			System.out.println("error: Why add negative fuel?");
		}else
			this.fuel += fuel;
	}
//	Return the amount of fuel in the tank
	public double fuel(){
		return fuel;
	}
//	Return the distance traveled so far
	public double distance(){
		return distance;
	}

    
    
}