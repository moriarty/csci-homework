/**
 *	CS 1101 Lab 6
 *	SchoolKid.java
 *	Alex Moriarty
 *	2009/2/17
 **/


public class SchoolKid {
/**	
attributes for the child’s name and age, the name of the child’s teacher, and a greeting. 
It should have appropriate accessor and mutator methods for each of the attributes
**/
	private String name, teacher, greeting;
	private int age;
		
    public SchoolKid() {
    }
    public SchoolKid(String name, String teacher, int age){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(("HI I'm "+getName()+". I am "+getAge()+"! "));
    }public SchoolKid(String name, String teacher, int age, String greeting){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(greeting);
    }
    public void setName(String name){
    	this.name = name;	
    }
    public void setTeacher(String teacher){
    	this.teacher = teacher;
    }
    public void setGreeting(String greeting){
    	this.greeting = greeting;
    }
    public void setAge(int age){
    	this.age = age;
    }
    public String getName(){
    	return name;
    }
    public String getTeacher(){
    	return teacher;
    }
    public String getGreeting(){
    	return greeting;
    }
    public int getAge(){
    	return age;
    }
    public String toString(){
    	String s;
    	s = greeting+"\nDid I tell you that, My name is: "+name+"?!";
    	s += "\nAnd that I am: "+age+" years old!\nMy teacher is "+teacher;
    	return s; 
    }
}