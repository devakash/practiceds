package chall;

public class SortBinary {

	public static void main(String[] args) {

		int k[] = { 0, 1, 0, 1, 0, 1, 1, 1, 0, 1 };
		int lastIndex = k.length - 1;

		for (int i = 0; i < k.length / 2; i++)

		{
			if (k[i] == 1) {
				while (k[lastIndex] != 0 && lastIndex >= k.length / 2) {
					lastIndex = lastIndex - 1;
				}

				k[lastIndex] = 1;
				k[i] = 0;

			}

		}
		for (int j : k) {
			System.out.println(j);
		}
	}

}
