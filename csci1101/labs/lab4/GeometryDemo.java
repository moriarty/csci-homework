/**
 * @(#)GeometryDemo.java
 *
 *
 * @author 
 * @version 1.00 2009/2/4
 */
import java.util.Scanner;
public class GeometryDemo {

    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Geometry Calculator\n");
      	while( choice >= 0 && choice <= 3){
      		System.out.println("Enter 1 for circle, 2 for sphere, 3 for cylinder:");
      		choice = input.nextInt();
      		if (choice = 1){
      			System.out.println("\nCircle selected.");
      			
      		}
      		if (choice = 2){
      			System.out.println("\nSphere selected.");
      		}
      		if (choice = 3){
      			System.out.println("\nCyclinder selected.");
      		}
      	}
        
    }
}
