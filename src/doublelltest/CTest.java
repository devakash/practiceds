package doublelltest;

public class CTest {
	
	public static void main(String[] args) {
		LinkList l=new LinkList();
		l.insert(10);
		l.insert(20);
		l.printFromBack();
		l.deleteLast();
		l.printFromBack();
		l.deleteFirst();
		l.printFromBack();
	}

}
