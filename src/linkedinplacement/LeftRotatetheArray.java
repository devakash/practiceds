package linkedinplacement;

import java.util.Scanner;

public class LeftRotatetheArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int arraySize = scn.nextInt();
		int numRotation = scn.nextInt();

		int input[] = new int[arraySize];
		for (int j = 0; j < arraySize; j++) {
			input[j] = scn.nextInt();
		}

		if (numRotation % arraySize == 0) {
			for (int j : input) {
				System.out.print(j + " ");
			}
		} else {
			if (numRotation > arraySize) {
				numRotation = numRotation % arraySize;
			}
			for (int k = 0; k < numRotation; k++) {
				int buffer = input[0];
				for (int h = 0; h < input.length-1; h++) {

					input[h] = input[h + 1];
				}
				input[input.length-1] = buffer;
			}

		}
		
		for(int ans:input)
		{
			System.out.print(ans+" ");
		}

	}

}
