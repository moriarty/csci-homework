/**
*/
public class Node
{
	private String first;
	private String second;
	private Node next;
	/**
	*/
	public Node(String from, String to, Node n)
	{
		first = from;
		second = to;
		next = n;
	}
	/**
	*/
	public String getFirst()
	{
		return first;
	}
	/**
	*/
	public Node getNext()
	{
		return next;
	}
	/**
	*/
	public String getSecond()
	{
		return second;
	}
	/**
	*/
	public void setSecond(String to)
	{
		second = to;
	}
	/**
	*/
	public void setNext(Node n)
	{
		next = n;
	}
	/**
	*/
	public void setFirst(String from)
	{
		first = from;
	}
	/**
	*/
	public String toString()
	{
		return (first+" --> "+second);
	}
}
