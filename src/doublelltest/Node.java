package doublelltest;

public class Node {

	public Node nextNode;
	public Node prevNode;
	public int data;

	public Node(int data) {
		this.data = data;
	}
	
	public String toString()
	{
		return "{"+data+"}";
	}

}
