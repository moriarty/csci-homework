
public class Node1
{
	private String name;
	private Node1 next;
	
	public Node1(String s, Node1 n)
	{
		name = s;
		next = n;
	}
	public String getName()
	{
		return name;
	}
	public Node1 getNext()
	{
		return next;
	}
	public void setNext(Node1 n)
	{
		next = n;
	}
	public void setName(String s)
	{
		name = s;
	}
	public String toString()
	{
		return (name);
	}
}