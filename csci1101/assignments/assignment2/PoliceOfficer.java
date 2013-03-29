/**
 * @(#)PoliceOfficer.java
 *
 *
 * @author 
 * @version 1.00 2009/2/9
 */


public class PoliceOfficer {
//the name and badge number of the police officer issuing the ticket.
	private int badgeNumber;
	private String name;

//	examines the parking meter object and determines whether the car’s time has expired
//	Issues a parking ticket (generates a ParkingTicket object) if the car’s time has expired

    public PoliceOfficer() {
    }
    public PoliceOfficer(String name, int badgeNumber){
    	this.name = name;
    	this.badgeNumber = badgeNumber;
    }
    public void setName(String name){
    	this.name = name;
    }
    public void setBadgeNumber(int badgeNumber){
    	this.badgeNumber = badgeNumber;
    }
    public void checkMeter(ParkingMeter meter){
    	
    }
    private boolean isExpired(ParkingMeter meter){
    	if (meter.getTimeLeft() < 0){
    		return true;
    	}else 
    		return false;
    }
    private void issueTicket(ParkingMeter meter){
    	
    }
    
    
}