package chall;

public class RecurFibo {

	public static void main(String[] args) {
		System.out.println(fibonacci(6));
	}

	public static int fibonacci(int number) {
		if (number == 1||number==2) {
			return 1;
		}
		int k= fibonacci(number - 1) + fibonacci(number - 2);
		return k;

	}
}

