package datastructure;

import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String inputArr[] = new String[scn.nextInt()];
		int resultArr[] = new int[inputArr.length];
		for (int r = 0; r < inputArr.length; r++) {
			inputArr[r]=scn.next();
		}
		for(int r = 0; r < inputArr.length; r++)
		{
			if (inputArr[r].length() % 2 == 0) {
				
				int len=inputArr[r].length();
				String a1=inputArr[r].substring(0,len/2);
				String a2=inputArr[r].substring(len/2,len);

				int[] letters1 = new int[26];
				for (int i = 0; i < a1.length(); i++) {
					int k = a1.charAt(i) - 'a';
					letters1[k] = letters1[k] + 1;
				}

				int[] letters2 = new int[26];
				for (int i = 0; i < a2.length(); i++) {
					int k = a2.charAt(i) - 'a';
					letters2[k] = letters2[k] + 1;
				}

				int count = 0;
				for (int i = 0; i < letters1.length; i++) {
					if (letters1[i] < letters2[i]) {
						count += letters2[i] - letters1[i];
					} else if (letters1[i] > letters2[i]) {
						count += letters1[i] - letters2[i];
					}
				}

				resultArr[r]=count/2;
			}
			else
			{
				resultArr[r]=-1;
			}
		}

	for(int k:resultArr)
	{
		System.out.println(k);
	}
	}

}
