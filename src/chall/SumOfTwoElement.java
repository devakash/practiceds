package chall;

public class SumOfTwoElement {

	public static void main(String[] args) {
		int i[] = { 2, 4, 3, 9, 22, 17 };

		for (int j = 0; j < i.length; j++) {
			for (int k = j + 1; k < i.length; k++) {
				if (i[j] > i[k]) {
					int temp = i[k];
					i[k] = i[j];
					i[j] = temp;
				}
			}
		}

		int max = 0;

		for (int j = 0; j < i.length; j++) {
			for (int k = j + 1; k < i.length; k++) {
				int sum = i[j] + i[k];
				int add = checkMax(i, sum);
				if (add != 0 && add > max) {
					max = add;
				}
			}
		}

		if (max > 0) {
			System.out.println(max);
		} else {
			System.out.println(-1);
		}

	}

	public static int checkMax(int[] i, int sum) {
		for (int j = 0; j < i.length; j++) {
			if (i[j] == sum) {
				return i[j];
			}
		}
		return 0;

	}

}
