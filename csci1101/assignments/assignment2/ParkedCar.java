/**
 * @(#)ParkedCar.java
 *
 *
 * @author 
 * @version 1.00 2009/2/9
 */


public class ParkedCar {
//the make, model, color and license number of the illegally parked car.
	private String make, model, colour, plateNumber;
    
    public ParkedCar() {
    }
    public ParkedCar(String make, String model, String colour, String plateNumber){
    	setMake(make);
    	setModel(model);
    	setColour(colour);
    	setPlateNumber(plateNumber);
    }
    public void setMake(String make){
    	this.make = make;	
    }
    public void setModel(String model){
    	this.model = model;
    }
    public void setColour(String colour){
    	this.colour = colour;
    }
    public void setPlateNumber(String plateNumber){
    	this.plateNumber = plateNumber;
    }
    public String getMake(){
    	return make;
    }
    public String getModel(){
    	return model;
    }
    public String getColour(){
    	return colour;
    }
    public String getPlateNumber(){
    	return plateNumber;
    }
}