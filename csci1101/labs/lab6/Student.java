/**
 *	CS 1101 Lab 6
 *	Student.java
 *	Alex Moriarty
 *	2009/2/17
 **/

public class Student extends Person{
/**	- studentNumber: int	**/
	private int studentNumber;
/**	Student()	**/    
    public Student() {
    }
    public Student(String name, int num){
    	reset(name, num);
    }
/**	reset(String newName, int newNumber): void	**/
    public void reset(String newName, int newNumber){
    	setName(newName);
    	setStudentNumber(newNumber);
    }
/**	getStudentNumber(): int	**/
    public int getStudentNumber(){
    	return studentNumber;
    }
/**	setStudentNumber(int n): void	**/
    public void setStudentNumber(int n){
    	studentNumber = n;
    }
/**	toString(): String	**/
    public String toString(){
    	return getName()+":\t"+studentNumber;
    }
/**	equals(Student anotherStuent): boolean	**/    
    public boolean equals(Student anotherStudent){
    	if(getStudentNumber()==anotherStudent.getStudentNumber()&&hasSameName(anotherStudent)==true){
    		return true;
    	}else
    		return false;
    }	
}