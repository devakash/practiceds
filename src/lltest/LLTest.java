package lltest;

public class LLTest {

	public static void main(String[] args) {
		LinkList l = new LinkList();
		l.insert(6, 60);
		l.insert(5, 50);
		l.insert(4, 40);
		l.insert(3, 30);
		l.insert(2, 20);
		l.insert(1, 10);
		l.reverseFromK(l.first, 3);
	}

}
