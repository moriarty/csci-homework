
public class Node
{
	private String from;
	private String to;
	private Node next;
	
	public Node(String f, String t, Node n)
	{
		from = f;
		to = t;
		next = n;
	}
	public String getFrom()
	{
		return from;
	}
	public String getTo()
	{
		return to;
	}
	public String getName(){
		return (from+""+to);
	}
	public Node getNext()
	{
		return next;
	}
	public void setNext(Node n)
	{
		next = n;
	}
	public void setFrom(String s)
	{
		from = s;
	}
	public void setTo(String s)
	{
		to = s;
	}
	public String toString()
	{
		return (from+"->"+to);
	}
}
