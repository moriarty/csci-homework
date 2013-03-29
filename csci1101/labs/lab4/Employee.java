/**
 * Alex Moriarty
 * Q 5: Employee Class
 * Lab 4 cs1101  
 * 2009/2/4
 */

public class Employee {
	/*
Instance variables name, number of hours worked per week and wages.
Static variable to keep track of the number of employees, set to 0.
Static variable that specifies the hourly rate, set to 0.
Static variable that stores the total payment for all employees, set to 0.	 
	 */
	private String name;
	private double hours;
	private double wages;
	
	static int employees = 0;
	static double rate = 0;
	static double payments = 0;

    public Employee() {
    }
//Method to set the name and number of hours worked. This should also update the number of employees.
	public void setEmployee(String name, double hours){
		this.name = name;
		this.hours = hours;
		employees += 1;
	}
//Static Method to set the hourly rate.
	public static void setRate(double rate){
		rate = rate;
	}
//Method findWages that computes the weekly wages for that employee. Use the following formula: for the first 40 hours, the payment is hours * rate. For each hour above 40, it is 1.5 times the hourly rate. Note: this method should also update the total payment.
	public void findWages(){
		if (hours > 40){
			wages = (hours - 40)*1.5*rate + 40*rate;
		}else	
			wages = hours*rate;
		payments += wages;	
	}
//Static method to return the number of employees.
	public static double getEmployees(){
		return employees;
	}
//Static method to return the total payment made for all employees.
	public static double getPayments(){
		return payments;
	}
//An appropriate toString method.
  	public String toString(){
  		String result ="\nName :\t"+name+"\nHours :\t"+hours+"\nWage :\t"+wages;
  		return result;
  	} 
}