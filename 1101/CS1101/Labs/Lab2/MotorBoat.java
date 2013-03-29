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
	private double efficiency = 0.00015; //	The efficiency of the boat’s motor (L/100km)?
	private double distance = 0; 	//	The distance traveled (km)

//	Constructor that sets everything to some default values.
    public MotorBoat() {
    }
//	Constructor that sets the capacity, fuel in the tank, max speed and efficiency
	public MotorBoat(double maxFuel, double fuel, double maxSpeed, double efficiency){
		this.maxFuel = abs(maxFuel);
		this.fuel = fuel;
		this.maxSpeed = abs(maxSpeed);
		this.efficiency = efficiency*0.0001;
	}

//	Set the current speed of the boat
	public void setSpeed(double speed){
		if (abs(speed)>maxSpeed){
			this.speed = maxSpeed;
		}else
			this.speed = abs(speed);
	}
//	Change the speed of the boat (the method should accept the change which is a positive or negative number and change the current speed. If the change is greater than max speed, it should set the current speed to max speed).
	public void changeSpeed(double change){
		speed += change;
		speed = abs(speed);
	}
//	Operate the boat for an amount of time at the current speed (set the distance traveled and reduce the amount of fuel in the tank by the appropriate amount).
	public void boatFor(double time){
		time = abs(time);
		if (fuelUsed(time)==0){
			return;
		}else
			fuel = fuel - fuelUsed(time);
			distance += speed*time;	
	}
//	Calculate (e * s2 * t) and return the amount of fuel used. if fuel used is more than fuel, bitch.
	private double fuelUsed(double time){
		double fuelUsed = efficiency*speed*speed*time;
		if (fuelUsed>=fuel){
			System.out.println("That would run your tank dry, wreck your motor, and leave you stranded");
			fuelUsed = 0;
			return fuelUsed;
		}else
			return fuelUsed;		
	}	
//	absolut value function to convert a velocity to speed, incase user decreases speed until negative	
	private double abs(double velocity){
		if (velocity<0)
			return (-1*velocity);
		else
			return velocity;	
	}
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
//	standard toString method printing all variables
	public String toString(){
		String result = "***\nmaxFuel="+maxFuel+"\tfuel="+fuel+"\nmaxSpeed="+maxSpeed+"\tspeed="+speed+"\nefficiency="+efficiency+"\ndistance="+distance;
		return result;
	}
    
    
}