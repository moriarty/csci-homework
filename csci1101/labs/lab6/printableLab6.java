/*****************************************************************
 Question One (Shape, Circle, CircleDemo)
 *****************************************************************/
 /**
 *	CS 1101 Lab 6
 *	Shape.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class Shape {
	static final double PI = 3.14159265;
	private double area;
    public Shape() {    }
    public void setArea(double area){
    	this.area = area;    }
    public double getArea(){
    	return area;    }
    public String toString(){
    	return "Area is :"+getArea();
}}
*****************************************************************
/**
 *	CS 1101 Lab 6
 *	Circle.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class Circle extends Shape{
	private double radius;
    public Circle() {    }
    public Circle(double radius){
    	setRadius(radius);    }
    public void setRadius(double radius){
    	this.radius = radius;    }
    private double calcArea(){
    	return PI*radius*radius;    }
    public double getRadius(){
    	return radius;    }
    public String toString(){
    	return "Circle:\tRadius: "+getRadius()+"\tArea: "+getArea();
}}
*****************************************************************
/* CircleDemo.java
 * 2009/2/18
 */
public class CircleDemo {
    public static void main(String[] args) {
    	Circle c1, c2, c3;
    	c1 = new Circle(1.0);
    	c2 = new Circle();
    	c2.setRadius(2);
    	c3 = new Circle(3.0);
    	System.out.println("c1 :\n"+c1+"\nc2 :\n"+c2+"\nc3 :\n"+c3);
}}
/*
--------------------Configuration: <Default>--------------------
c1 :
Circle: Radius: 1.0 Area: 0.0
c2 :
Circle: Radius: 2.0 Area: 0.0
c3 :
Circle: Radius: 3.0 Area: 0.0

Process completed.
*/*****
/*****************************************************************
 Question Two (Person, Student, StudentDemo)
 *****************************************************************/
/**
 *	CS 1101 Lab 6
 *	Person.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class Person {
/**	- name: String	**/
	private String name;
    public Person() {    }
    public Person(String name){
    	setName(name);    }
/**	setName(String newName): void	**/
     public void setName(String newName){
     	name = newName;     }
/**	getName(): String	**/     
     public String getName(){
     	return name;     }
/**	toString(): String	**/     
     public String toString(){
     	return name;     }
/**	hasSameName(Person anotherPerson)): boolean	**/
     public boolean hasSameName(Person otherPerson){
     	if (name == otherPerson.getName()){
     		return true;
     	}else
     		return false; 
}}
*****************************************************************
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
    public Student() {    }
    public Student(String name, int num){
    	reset(name, num);    }
/**	reset(String newName, int newNumber): void	**/
    public void reset(String newName, int newNumber){
    	setName(newName);
    	setStudentNumber(newNumber);    }
/**	getStudentNumber(): int	**/
    public int getStudentNumber(){
    	return studentNumber;    }
/**	setStudentNumber(int n): void	**/
    public void setStudentNumber(int n){
    	studentNumber = n;    }
/**	toString(): String	**/
    public String toString(){
    	return getName()+":\t"+studentNumber;    }
/**	equals(Student anotherStuent): boolean	**/    
    public boolean equals(Student anotherStudent){
    	if(getStudentNumber()==anotherStudent.getStudentNumber()&&hasSameName(anotherStudent)==true){
    		return true;
    	}else
    		return false;
}}
*****************************************************************
/* StudentDemo.java
 * 2009/2/18
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student s1, s2, s3;
        s1 = new Student("Alex", 1234);
        s2 = new Student("Allan", 3456);
        s3 = new Student("Alex", 1234);
        System.out.println("s1 == s2 :"+s1.equals(s2)+"\ns1 == s3 :"+s1.equals(s3));
}}
/*
--------------------Configuration: <Default>--------------------
s1 == s2 :false
s1 == s3 :true

Process completed.
*/*****
/*****************************************************************
 Question Three (SchoolKid, ExaggeratingKid, KidDemo)
 *****************************************************************/
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
    public SchoolKid() {    }
    public SchoolKid(String name, String teacher, int age){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(("HI I'm "+getName()+". I am "+getAge()+"! "));    }
    public SchoolKid(String name, String teacher, int age, String greeting){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(greeting);    }
    public void setName(String name){
    	this.name = name;	    }
    public void setTeacher(String teacher){
    	this.teacher = teacher;    }
    public void setGreeting(String greeting){
    	this.greeting = greeting;    }
    public void setAge(int age){
    	this.age = age;    }
    public String getName(){
    	return name;    }
    public String getTeacher(){
    	return teacher;    }
    public String getGreeting(){
    	return greeting;    }
    public int getAge(){
    	return age;    }
    public String toString(){
    	String s;
    	s = greeting+"\nDid I tell you that, My name is: "+name+"?!";
    	s += "\nAnd that I am: "+age+" years old!\nMy teacher is "+teacher;
    	return s; 
}}
*****************************************************************
/**
 *	CS 1101 Lab 6
 *	ExaggeratingKid.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class ExaggeratingKid extends SchoolKid{

    public ExaggeratingKid() {    }
    public ExaggeratingKid(String name, String teacher, int age){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(("HI I'm "+getName()+". I am "+getAge()+"! "));
    	exaggerate();    }
    public ExaggeratingKid(String name, String teacher, int age, String greeting){
    	setName(name);
    	setTeacher(teacher);
    	setAge(age);
    	setGreeting(greeting);
    	exaggerate();    }
    public void exaggerate(){
    	changeAge();
    	changeGreeting();    }
    private void changeAge(){
    	setAge((getAge()+2));    }
    private void changeGreeting(){
    	setGreeting((getGreeting()+" I am the Best!"));
}}
*****************************************************************
/* KidDemo.java
 * 2009/2/18
 */

public class KidDemo {
    public static void main(String[] args) {
        ExaggeratingKid k1, k2, k3;
        k1 = new ExaggeratingKid("Dave","Mr. Barkhouse",5,"Hi, I Can Bike.");
        k2 = new ExaggeratingKid("Allan","Mr. Barkhouse",6);
        k3 = new ExaggeratingKid("Jacon","Mr. Teacher",5);
        System.out.println(k1+"\n\n"+k2+"\n\n"+k3);
}}
/*
--------------------Configuration: <Default>--------------------
Hi, I Can Bike. I am the Best!
Did I tell you that, My name is: Dave?!
And that I am: 7 years old!
My teacher is Mr. Barkhouse

HI I'm Allan. I am 6!  I am the Best!
Did I tell you that, My name is: Allan?!
And that I am: 8 years old!
My teacher is Mr. Barkhouse

HI I'm Jacon. I am 5!  I am the Best!
Did I tell you that, My name is: Jacon?!
And that I am: 7 years old!
My teacher is Mr. Teacher

Process completed.
*/*****
/*****************************************************************
 Question Four (Book, Dictionary, DictionaryDemo)
 *****************************************************************/
 /**
 *	CS 1101 Lab 6
 *	Book.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class Book {
/**	- numPages: int	**/
	private int numPages;
    public Book() { }
/**	Book(int n)	**/
    public Book(int n){
    	setPages(n);    }
/**	setPages(int n): void	**/ 
	public void setPages(int n){
		numPages = n;	}
/**	getPages(): int	**/	
	public int getPages(){
		return numPages;
}}
*****************************************************************
/**
 *	CS 1101 Lab 6
 *	Dictionary.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class Dictionary extends Book{
/**	- numDefinitions: int	**/	
	private int numDefinitions;
    public Dictionary() {   }
/**	Dictionary(int p, int d)	**/
	public Dictionary(int p, int d){
		setPages(p);
		setDefinitions(d);	}
/**	setDefinitions(int n): void	**/
	public void setDefinitions(int n){
		numDefinitions = n;	}
/**	getDefintions(): int	**/
	public int getDefinitions(){
		return numDefinitions;	}
/**	computeRatio(): int	**/	
    public int computeRatio(){
    	return (int)((getDefinitions()*1.0)/(getPages()*1.0));    }
/**	toString(): String	**/
    public String toString(){
    	return "this Dictionary has: "+getPages()+" Pages, and "+getDefinitions()+" Definitions!\nThats about "+computeRatio()+" Definitions per Page!";
}}
*****************************************************************
/* DictionaryDemo.java
 * 2009/2/18
 */
public class DictionaryDemo {
    public static void main(String[] args) {
        Dictionary d1, d2;
        d1 = new Dictionary(1000, 45000);
        d2 = new Dictionary(100, 9000);
        System.out.println("d1 :"+d1+"\n\nd2 :"+d2);
}}
/*
--------------------Configuration: <Default>--------------------
d1 :this Dictionary has: 1000 Pages, and 45000 Definitions!
Thats about 45 Definitions per Page!

d2 :this Dictionary has: 100 Pages, and 9000 Definitions!
Thats about 90 Definitions per Page!

Process completed.
*/*****
/*****************************************************************
 Question Five (ShapeBasics, LineShape, RectangleShape)
 *****************************************************************/
 /**
 *	CS 1101 Lab 6
 *	ShapeBasics.java
 *	Alex Moriarty
 *	2009/2/17
 **/

public class ShapeBasics{
		//offset indicates how far it is indented from the left
		//edge of the screen
		private int offset;		
		public ShapeBasics(){
			offset=0;	}
		public ShapeBasics(int theOffset)	{
			offset = theOffset;	}
		public void setOffset(int newOffset)	{
			offset = newOffset;	}
		public int getOffset()	{
			return offset;	}
		//static method skipLines skips the given number of lines
		//down from the current one
		public static void skipLines(int lineNumber){
			for(int count=0;count<lineNumber;count++)
				System.out.println();	}
		//static method skipSpaces that skips the given number of spaces
		public static void skipSpaces(int number){
			for(int count = 0; count<number; count++)
				System.out.print(' ');	}
		//method drawHere draws the shape beginning at the current line
		public void drawHere(){
			skipSpaces(offset);
			System.out.println('*');	}
		//my added methods
		//method to draw a point, where is. not creating a new line.
		public void draw(){
			System.out.print("*");
}}
*****************************************************************
/**
 *	CS 1101 Lab 6
 *	LineShape.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class LineShape extends ShapeBasics{
/*
•	A no args constructor
•	A method to set the given offset
•	A method drawVertical that draws a vertical line of a given length starting at the offset
•	A method drawHorizontal that draws a horizontal line of a given length starting at the offset
*/
    public LineShape() {    }
    public void drawVertical(int length){
    	for (int i=0; i<length; i++){
    		skipSpaces(getOffset());
    		draw();
    		skipLines(1);  	}    }
    public void drawHorizontal(int length){
    	skipSpaces(getOffset());
    	for (int i=0; i<length; i++){
			System.out.print("*");
}}}
*****************************************************************
/**
 *	CS 1101 Lab 6
 *	RectangleShape.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class RectangleShape extends LineShape{
/*
•	Instance variables height and width
•	Constructor that sets the offset, height and width
•	Method drawHere that draws the rectangle starting at the given offset and of dimensions width and height
•	Method drawSides that draws the two sides of the rectangle. This method is used by the drawHere method.
*/
	private int height, width;	
    public RectangleShape() {    }
    public RectangleShape(int width, int height){
    	setWidth(width);
    	setHeight(height);    }
    public void setHeight(int height){
    	this.height = height;    }
    public void setWidth(int width){
    	this.width = width;    }
    public void drawHere(){
    	drawHorizontal(width);
    	skipLines(1);
    	drawSides(height);
    	drawHorizontal(width);    }
    private void drawSides(int height){
    	for (int i=0; i<(height-2); i++){
    		skipSpaces(getOffset());
    		draw();
    		skipSpaces(width-2);
    		draw();
    		skipLines(1);
}}}
/*****************************************************************
 Bonus Question (RightArrow, LeftArrow, DrawShapes)
 *****************************************************************/
 /**
 *	CS 1101 Lab 6
 *	RightArrow.java
 *	Alex Moriarty
 *	2009/2/17
 **/


public class RightArrow extends LineShape{
/*
The size of the arrow is determined by two numbers,
 one for the length of the “tail” and one for the width of the arrowhead. 
 (the width is the length of the vertical base). 
 The arrow shown here has a length of 21 and a width of 7. 
 The width of the arrowhead cannot be an even number,
 so your constructors and mutator methods should check to make sure that it is always odd.
 You can assume that the width of the base of the arrowhead is at least 3. Write a test program for each class
*/
	private int tail, width;
    public RightArrow() {    }
    public RightArrow(int tail, int width){
    	setTail(tail);
    	setWidth(width);      }
    public void setTail(int tail){
    	this.tail = tail;    }
    public void setWidth(int width){
    	if (isOdd(width))
    		this.width = width;
    	else
    		this.width = 7;	    }
    private boolean isOdd(int n){
    	if (n%2!=0 && n>=3){
    		return true;
    	}else
    		return false;    }
    public void drawHere(){
    	for (int i=0; i<width;i++){
    		if(i == width/2 ){
    			drawHorizontal(tail);
    			drawNext(i);    		}
    		if(i == 0 || i == width-1){
    			skipSpaces(getOffset()+tail-1);
    			draw();    		}
    		if (i != width/2 && i!=0 && i!=width-1){
    			skipSpaces(getOffset()+tail-1);
    			draw();
    			drawNext(i);    		}
    		System.out.println();  	}    }
    private void drawNext(int i){
    	if ( i<=width/2 && i>0){
    		skipSpaces(i*2);
    		draw();    	}
    	if ( i>(width/2) && i<width){
    		skipSpaces((width-i-1)*2);
    		draw();
}}}
*****************************************************************
/**
 *	CS 1101 Lab 6
 *	LeftArrow.java
 *	Alex Moriarty
 *	2009/2/17
 **/
public class LeftArrow extends LineShape{
    public LeftArrow() {    }
    private int tail, width;
    public LeftArrow(int tail, int width){
    	setTail(tail);
    	setWidth(width);    }
    public void setTail(int tail){
    	this.tail = tail;    }
    public void setWidth(int width){
    	if (isOdd(width))
    		this.width = width;
    	else
    		this.width = 7;    }
    private boolean isOdd(int n){
    	if (n%2!=0 && n>=3){
    		return true;
    	}else
    		return false;    }
    public void drawHere(){
    	for (int i=1; i<=width;i++){
    		if(i == width/2+1 ){
    			skipSpaces(getOffset());
    			draw();
    			skipSpaces(width-1);
    			drawLine(tail);	    		}
    		if(i == 1 || i == width){
    			skipSpaces(getOffset()+width);
    			draw();    		}
    		if (i != width/2+1 && i!=1 && i!=width){
    			skipSpaces(getOffset());
    			skipSpaces(Math.abs(width-((i-1)*2)-1));
    			draw();
    			drawNext(i);
    			//System.out.print(i);    		}
    		System.out.println();   }    }
    private void drawNext(int i){
    	if ( i<=width/2 && i>0){
    		skipSpaces(Math.abs((i-1)*2));
    		draw();    	}
    	if ( i>(width/2) && i<width){
    		skipSpaces(((width-i)*2));
    		draw();	
}}
*****************************************************************
/* tester.java
 * 2009/2/17
 */

public class tester {
    public static void main(String[] args) {
    	LineShape line1 = new LineShape();
        line1.setOffset(10);
        line1.drawVertical(10);
        ShapeBasics.skipLines(3);
        line1.drawHorizontal(10);
        ShapeBasics.skipLines(3);
        RectangleShape rect1 = new RectangleShape(10,10);
        rect1.setOffset(20);
        rect1.drawHere();	
        ShapeBasics.skipLines(3);
        RightArrow ra1, ra2;
        ra1 = new RightArrow(11,9);
        ra2 = new RightArrow(30,25);
        ra1.drawHere();
        ShapeBasics.skipLines(3);
        ra2.drawHere();
        ShapeBasics.skipLines(3);
        LeftArrow la1, la2;
        la1 = new LeftArrow(11,9);
        la1.drawHere();
        la2 = new LeftArrow(20,11);
        la2.setOffset(10);
        la2.drawHere();
    }
}
/*
--------------------Configuration: <Default>--------------------
          *
          *
          *
          *
          *
          *
          *
          *
          *
          *



          **********


                    **********
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    *        *
                    **********


          *
          *  *
          *    *
          *      *
***********        *
          *      *
          *    *
          *  *
          *



                             *
                             *  *
                             *    *
                             *      *
                             *        *
                             *          *
                             *            *
                             *              *
                             *                *
                             *                  *
                             *                    *
                             *                      *
******************************                        *
                             *                      *
                             *                    *
                             *                  *
                             *                *
                             *              *
                             *            *
                             *          *
                             *        *
                             *      *
                             *    *
                             *  *
                             *



         *
      *  *
    *    *
  *      *
*        ***********
  *      *
    *    *
      *  *
         *
                     *
                  *  *
                *    *
              *      *
            *        *
          *          ********************
            *        *
              *      *
                *    *
                  *  *
                     *

Process completed.
*/
*****************************************************************