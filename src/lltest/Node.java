package lltest;

public class Node {

	public Node nextNode;
	public int data;
	public int index;

	public Node(int index,int data) {
		this.index=index;
		this.data = data;
	}
	
	public String toString()
	{
		//return "{"+data+" "+index+"}";
		return "{"+index+"}";
	}

}
