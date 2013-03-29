/* ParkingMeter.java
 * Alex Moriarty
 * Assignment 2, part 1 
 * 2009/2/9 	*/


public class ParkingMeter {
//the amount of fine, which is $25 for the first hour or part of an hour that the car is illegally parked, 
//plus $10 for every additional hour or part of an hour that the car is illegally parked.
    private ParkedCar car;
    private double timeLeft;
    private double timePurchased;
    private double time;
    private String location;
    private double timeExpires;	    
	

    public ParkingMeter() {
    }
    public ParkingMeter(String location, double time){
    	setLocation(location);
	setTime(time);
    }
    public void setLocation(String location){
    	this.location = location;
    }
    public void setTime(double time){
    	this.time = time;
    }
    public void parkCar(ParkedCar car, double timePurchased){
    	this.car = car;
    	this.timePurchased = timePurchased;
    }
    public double getTimeLeft(){
	timeLeft = (time - timePurchased);
	return timeLeft;    
    }
    
    
}
