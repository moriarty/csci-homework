/**
 *GPS.java
 *Alex Moriarty 
 *2009/3/4
 */

import java.util.ArrayList;
import java.util.Scanner;
public class GPS {

    public static boolean again;
    //The GPS's guts (aka, its grossly coded insides)
    public static void main(String[] args) {
    	
    	Welcome();
    	// create the array list
    	ArrayList<Waypoint> list = new ArrayList();
    	//the while loop continues while user wants to enter more points. 
    	do{
    		//Ask user for points.
    		System.out.println("please enter the new waypoint\nX\tY\tT (all ints)");
    		Scanner input = new Scanner(System.in);
    		//take points, add them to a new waypoint w.
    		Waypoint w = new Waypoint(input.nextInt(),input.nextInt(),input.nextInt());
    		// add the new waypoint to the list
    		list.add(w);
    		askAgain();
    	}while (again == true);
    	// distance
    	double distance = 0;
    	// loop through ("the shit") and calculate distance
    	for (int i = 0; i < list.size()-1; i++){
    		//p1 being this point, p2 being next point
    		Waypoint p1, p2;
    		p1 = list.get(i);
    		p2 = list.get(i+1);
    		distance += Math.sqrt(Math.pow(p1.getY()-p2.getY(),2)+Math.pow((p1.getX())-(p2.getX()),2));
    	}
    	//give travelled distance converted to km
    	System.out.println("You travelled:\t"+distance*0.1+"km");
    	double time = (double)((list.get(list.size()-1)).getT());
    	// we dont want to divide by zero
    	if (list.size() > 1)
    		//display the speed
    		System.out.println("Your Average Speed was:"+distance/(time/360)+"km/hr");    	
    }
    // the following methods are static. and arent really needed. they just save a little time.
    // 
    private static void askAgain(){
    	System.out.println("\tAnother point?\t(Y/n)");
    	Scanner input = new Scanner(System.in);
    	char a = input.next().charAt(0);
    	again = (a == 'y' || a == 'Y');
    	
    }
    //because only one method wouldn't look good
    private static void Welcome(){
    	System.out.println("\t\t Hello, welcome to the GPS program");
    }
    
    private static void askWaypoint(){
    	System.out.println("\t Please enter a waypoint\n");
    }
}
/*
--------------------Configuration: <Default>--------------------
         Hello, welcome to the GPS program
please enter the new waypoint
X   Y   T (all ints)
1
1
0
    Another point?  (Y/n)
y
please enter the new waypoint
X   Y   T (all ints)
1
2
15
    Another point?  (Y/n)
n
You travelled:  0.1km
Your Average Speed was:24.0km/hr

Process completed.
--------------------Configuration: <Default>--------------------
         Hello, welcome to the GPS program
please enter the new waypoint
X   Y   T (all ints)
1
1
0
    Another point?  (Y/n)
y
please enter the new waypoint
X   Y   T (all ints)
1
2
3600
    Another point?  (Y/n)
n
You travelled:  0.1km
Your Average Speed was:0.1km/hr

Process completed.

--------------------Configuration: <Default>--------------------
         Hello, welcome to the GPS program
please enter the new waypoint
X   Y   T (all ints)
1
1
1
    Another point?  (Y/n)
2
You travelled:  0.0km

Process completed.

*/