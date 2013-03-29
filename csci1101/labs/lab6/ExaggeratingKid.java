/**
 *	CS 1101 Lab 6
 *	ExaggeratingKid.java
 *	Alex Moriarty
 *	2009/2/17
 **/

public class ExaggeratingKid extends SchoolKid{

    public ExaggeratingKid() {
    }
    public ExaggeratingKid(String name, String teacher, int age){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(("HI I'm "+getName()+". I am "+getAge()+"! "));
    	exaggerate();
    }
    public ExaggeratingKid(String name, String teacher, int age, String greeting){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(greeting);
    	exaggerate();
    }
    public void exaggerate(){
    	changeAge();
    	changeGreeting();
    }
    private void changeAge(){
    	setAge((getAge()+2));
    }
    private void changeGreeting(){
    	setGreeting((getGreeting()+" I am the Best!"));
    }
    
}