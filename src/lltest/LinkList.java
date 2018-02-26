package lltest;

import java.util.HashSet;

public class LinkList {

	public Node first;

	public LinkList() {
		first = null;
	}

	public void insert(int index, int data) {
		Node n = new Node(index, data);
		n.nextNode = first;
		first = n;
	}

	public Node delete() {
		Node n = first;
		if (first != null) {
			first = n.nextNode;

		}
		return n;
	}

	public void insertInMid(int index, int data) {
		Node t = first;
		Node n = new Node(index, data);

		while (first.index != index) {
			first = first.nextNode;
		}

		Node temp = first.nextNode;
		first.nextNode = n;
		first.nextNode.nextNode = temp;
		first = t;

	}

	public void print() {
		Node t = first;
		while (t != null) {
			System.out.print(t);
			t = t.nextNode;
		}
	}

	public void delFromMid(int index) {
		Node t = first;

		while (first.index != index) {
			first = first.nextNode;
		}

		Node temp = first.nextNode.nextNode;
		first.nextNode = null;
		first.nextNode = temp;
		first = t;

	}

	void Reverse() {
		Node temp = first;
		LinkList l = new LinkList();
		l.insert(0, first.data);
		int i = 1;
		while (temp.nextNode != null) {
			Node n = temp.nextNode;
			l.insert(i, n.data);
			++i;
			temp = temp.nextNode;
		}
		l.print();

	}

	void removeDuplicate() {
		Node current = first;
		Node next_next = null;
		while (current.nextNode != null) {
			if (current.data == current.nextNode.data) {
				next_next = current.nextNode.nextNode;
				current.nextNode = null;
				current.nextNode = next_next;
			} else {
				current = current.nextNode;
			}
		}
	}

	boolean checkCyclic() {

		Node current = first;
		Node prev = null;
		while (current != null) {
			if (current.nextNode != null) {
				if (prev == current.nextNode) {
					return true;
				}
				prev = current;
				current = current.nextNode;

			} else {
				return false;
			}
		}

		return false;
	}

	public void delTheMiddleElement() {
		Node slowptr = first;
		Node fastptr = first;
		Node prev = first;
		while (fastptr != null && fastptr.nextNode != null) {
			fastptr = fastptr.nextNode.nextNode;
			prev = slowptr;
			slowptr = slowptr.nextNode;

		}
		// deleting the middle
		prev.nextNode = slowptr.nextNode;

	}

	int comp(Node a, Node b) {
		while (a != null && b != null) {

			if (a.data != b.data) {
				return 0;
			}
			a = a.nextNode;
			b = b.nextNode;

		}
		return (a == null && b == null) ? 1 : 0;

	}

	void reverse2() {
		Node current = first;
		Node next = null;
		Node prev = null;
		while (current != null) {
			next = current.nextNode;
			current.nextNode = prev;
			prev = current;
			current = next;
		}

		first = prev;
	}

	Node mergeList(Node a, Node b) {

		if (a == null)
			return b;
		if (b == null)
			return a;
		Node toR;
		if (a.data < b.data) {
			toR = a;
		} else {
			toR = b;
			b = a;
			a = toR;
		}
		while (a.nextNode != null) {
			if (a.nextNode.data > b.data) {
				Node temp = a.nextNode;
				a.nextNode = b;
				b = temp;
			}
			a = a.nextNode;
		}
		a.nextNode = b;
		return toR;
	}

	int findDetectionPoint(Node a, Node b) {
		HashSet<Node> n = new HashSet<>();
		while (a != null) {
			n.add(a);
			a = a.nextNode;
		}
		while (b != null) {
			if (n.contains(b)) {
				return b.data;
			}
			b = b.nextNode;
		}
		return 0;
	}

	void reverseFromK(Node a, int k) {
		Node temp = a;
		int i = 1;
		while (i < k) {
			a = a.nextNode;
			++i;
		}
		Node toReverse = a.nextNode;
		Node reversed = reverse(toReverse);
		a.nextNode = reversed;
		while(temp!=null)
		{
			System.out.print(temp);
			temp=temp.nextNode;
		}
	}

	private Node reverse(Node toReverse) {
		Node current = toReverse;
		Node prev = null;
		Node next = null;
		while (current != null) {
			next=current.nextNode;
			current.nextNode=prev;
			prev=current;
			current=next;
		}
		current=prev;
		return current;

	}
	
	public  void findNthFromLast(Node head)
	{
		
	}

}
