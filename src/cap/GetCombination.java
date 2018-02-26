package cap;

import java.util.Scanner;

public class GetCombination {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		int total = scn.nextInt();

		int out[] = new int[total];

		for (int i = 0; i < total; i++) {
			int n = scn.nextInt();
			int full = pow(2, n);
			int pow = pow(2, n - 1);
			n = n - 3;
			pow = pow - n;

			out[i] = full - pow;

		}

		for (int k : out) {
			System.out.println(k);
		}

	}

	static int pow(int base, int power) {
		if (power == 0)
			return 1;
		return base * pow(base, --power);
	}

}
