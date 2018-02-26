package linkedinplacement;

import java.util.Scanner;

public class DivisiblePairsSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String ip1 = scn.nextLine();

		int i = Integer.parseInt(ip1.split(" ")[0]);
		int k = Integer.parseInt(ip1.split(" ")[1]);

		int arr[] = new int[i];
		for (int num = 0; num < i; num++) {
			arr[num] = scn.nextInt();
		}

		int count = getCount(arr, k);
		System.out.println(count);
		
		scn.close();

	}

	public static int getCount(int[] input, int k) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if ((input[i] + input[j]) % k == 0) {
					count = count + 1;
				}
			}
		}

		return count;
	}

}
