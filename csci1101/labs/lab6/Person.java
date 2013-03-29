/**
 *	CS 1101 Lab 6
 *	Person.java
 *	Alex Moriarty
 *	2009/2/17
 **/

public class Person {
/**	- name: String	**/
	private String name;
    public Person() {
    }
    public Person(String name){
    	setName(name);
    }
/**	setName(String newName): void	**/
     public void setName(String newName){
     	name = newName;
     }
/**	getName(): String	**/     
     public String getName(){
     	return name;
     }
/**	toString(): String	**/     
     public String toString(){
     	return name;
     }
/**	hasSameName(Person anotherPerson)): boolean	**/
     public boolean hasSameName(Person otherPerson){
     	if (name == otherPerson.getName()){
     		return true;
     	}else
     		return false;     	
     }    
}