package datastructure;

public class PrintSecondLowestWithoutSorting {

	public static void main(String[] args) {
		int i[] = { 11, 20, 13, 4, 5, 6, 7, 8, 9, 10 };

		int firstLowest = i[0];
		int secondLowest = i[0];
		for (int j = 0; j < i.length - 1; j++) {
			if (i[j] < firstLowest) {
				secondLowest = firstLowest;
				firstLowest = i[j];

			}

			if (i[j] > firstLowest && i[j] < secondLowest) {
				secondLowest = i[j];

			}

		}
		System.out.println("FIRST  LOWEST " + firstLowest);
		System.out.println("SECOND LOWEST " + secondLowest);

	}

}
