package Lamda;

public class Main {

	public static void main(String[] a) {
		
		i ii = (int j) -> System.out.println(" HELLO " + j);
		ii.a(10);

	}

	@FunctionalInterface
	interface i {
		public void a(int k);
	}
}