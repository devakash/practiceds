package doublelltest;

public class LinkList {

	public Node firstNode;
	public Node lastNode;

	public LinkList() {
		firstNode = null;
		lastNode = null;
	}

	void insert(int data) {
		Node n = new Node(data);
		if (firstNode == null) {
			firstNode = lastNode = n;
			firstNode.nextNode = null;
			firstNode.prevNode = null;

		} else {
			lastNode = firstNode;
			n.nextNode = firstNode;
			n.prevNode = null;
			firstNode.prevNode = n;
			firstNode = n;

		}

	}

	public void printFromBack() {
		
		Node lastNode=this.lastNode;
		if(lastNode!=null)
		{
			while(lastNode!=null)
			{
				System.out.print(lastNode+" ");
				
				lastNode=lastNode.prevNode;
			}
			System.out.println();
		}
		
		/*Node temp = firstNode;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.nextNode;
		}*/

	}

	public void deleteLast() {
		Node temp = lastNode.prevNode;
		lastNode = temp;
		lastNode.nextNode = null;

	}

	public void deleteFirst() {
		Node temp = firstNode.nextNode;
		firstNode = temp;
		lastNode.prevNode = null;

	}

}
