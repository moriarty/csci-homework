/**
 * @(#)ParkingTicket.java
 *
 *
 * @author 
 * @version 1.00 2009/2/9
 */


public class ParkingTicket {
//the amount of fine, which is $25 for the first hour or part of an hour that the car is illegally parked, 
//plus $10 for every additional hour or part of an hour that the car is illegally parked.
//has the officer’s name and badge number
	private ParkedCar car;
	private ParkingMeter meter;
	private PoliceOfficer policeOfficer;

    public ParkingTicket() {
    }
    public ParkingTicket(ParkedCar car, ParkingMeter meter, PoliceOfficer policeOfficer){
    	setCar(car);
    	setMeter(Meter);
    	setPoliceOfficer(policeOfficer);
    }
    public void setCar(ParkedCar car){
    	this.car = car;
    }
    public void setMeter(ParkingMeter meter){
    	this.meter = meter;
    }
    public void setPoliceOfficer(PolicerOfficer policeOfficer){
    	this.policeOfficer = policeOfficer;
    }
    private double calcFine(ParkingMeter meter){
    	
    }
    public String toString(){
    	
    }    
}