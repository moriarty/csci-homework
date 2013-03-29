/**
 * @(#)TurnTakerDemo.java
 *
 *
 * @author 
 * @version 1.00 2009/2/4
 */


public class TurnTakerDemo
{
	public static void main(String[] args)
	{
		TurnTaker person1 = new TurnTaker("Romeo", 1);
		TurnTaker person2 = new TurnTaker("Juliet", 1);
		
		TurnTaker.getTurn();
		for(int i = 1; i<= 5; i++)
		{
			System.out.println("Turn = "+i /*+ TurnTaker.getTurn()*/);
			if (person1.isMyTurn())
				System.out.println("Love from "+ person1.getName());
			if (person2.isMyTurn())
				System.out.println("Love from " + person2.getName());
		}
	}
}
/*
 */
 