package linkedinplacement;

import java.util.Scanner;

public class BinaryNumbers1s {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();

		String binary = "";

		while (num != 1 && num != 0) {

			int k = num % 2;

			num = num / 2;
			binary = binary + k;

		}
		binary = binary + num;
		StringBuffer sb = new StringBuffer(binary);
		binary = sb.reverse().toString();
		System.out.println(binary);
		int counter = 0;
		int buffer = 0;

		for (int l = 0; l < binary.length(); l++) {
			int i=binary.charAt(l);
			System.out.println(i);
			if (i == 48) {
				if (counter >= buffer) {
					buffer = counter;
					counter=0;
				}
				else
				{
					counter=0;
				}
			} else {
				counter = counter + 1;
			}
		}
		
		System.out.println(counter>buffer?counter:buffer);
		scn.close();
	}

}
