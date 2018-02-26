package linkedinplacement;

import java.util.Scanner;

public class NestedLogic {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String input[] = new String[2];
		for (int i = 0; i < 2; i++) {
			input[i] = scn.nextLine();
		}

		int actualreturnDay = Integer.parseInt(input[0].split(" ")[0]);
		int actualreturnMonth = Integer.parseInt(input[0].split(" ")[1]);
		int actualreturnYear = Integer.parseInt(input[0].split(" ")[2]);

		int expectedreturnDay = Integer.parseInt(input[1].split(" ")[0]);
		int expectedreturnMonth = Integer.parseInt(input[1].split(" ")[1]);
		int expectedreturnYear = Integer.parseInt(input[1].split(" ")[2]);

		if (expectedreturnMonth <= actualreturnMonth && expectedreturnYear <= actualreturnYear
				&& actualreturnDay <= expectedreturnDay) {
			System.out.println(0);
		} else if (expectedreturnMonth == actualreturnMonth && expectedreturnYear == actualreturnYear
				&& actualreturnDay >= expectedreturnDay) {
			System.out.println((actualreturnDay - expectedreturnDay) * 15);

		} else if (actualreturnMonth > expectedreturnMonth && expectedreturnYear == actualreturnYear) {
			System.out.println((actualreturnMonth - expectedreturnMonth) * 500);
		}
		else
			if(expectedreturnYear < actualreturnYear)
			{
				System.out.println(10000);
			}
			else
			{
				System.out.println(0);
			}
		scn.close();

	}

}
