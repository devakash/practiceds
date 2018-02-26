package linkedinplacement;

import java.util.Scanner;

public class CaesarCipherEncryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int k = in.nextInt();

		String ouString = "";

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch >= 65 && ch <= 90) {

				int num = k % 26;
				int diff = num;
				num = ch + num;

				if (num > 90) {
					int l = diff - (90 - s.charAt(i));
					int h = (64 + l);
					ch = (char) h;
				} else {

					ch = (char) num;
				}

				ouString = ouString + String.valueOf(ch);

			} else if (ch >= 97 && ch <= 122) {

				int num = k % 26;
				int diff = num;
				num = ch + num;

				if (num > 122) {
					int l = diff - (122 - s.charAt(i));
					int h = (96 + l);
					ch = (char) h;
				} else {
					ch = (char) num;
				}

				ouString = ouString + Character.toString(ch);

			} else {

				ouString = ouString + Character.toString(ch);

			}
		}

		System.out.println(ouString);
	}

}
