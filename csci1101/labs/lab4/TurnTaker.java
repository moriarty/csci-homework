/**
 * Alex Moriarty
 * Lab 4 cs1101  
 * 2009/2/4
 */

public class TurnTaker
{
	private static int turn = 0;
	
	private int myTurn;
	private String name;
	
	public TurnTaker(String n, int t)
	{
		name = n;
		myTurn = t;
	}
	
	public String getName()
	{
		return name;
	}
	public static int getTurn()
	{
		turn++;
		return turn;
	}
	public boolean isMyTurn()
	{
		if (turn==myTurn)
			return true;
		else
			return false;
	}
}
