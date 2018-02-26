package datastructure;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/palindrome-index
 */
public class PalindromeIndex {

	 public static void main(String[] args) {

			Scanner scn = new Scanner(System.in);
			int numberOfTestCases = scn.nextInt();
			String inputString[] = new String[numberOfTestCases];
			int outputArr[] = new int[numberOfTestCases];
			for (int i = 0; i < inputString.length; i++) {
				inputString[i] = scn.next();
				String chckStr = inputString[i];
				int index = 0;
				String temp = "";
				while (!checkPalindrome(chckStr)) {
					if (index <= inputString[i].length() - 1) {
						chckStr = temp + inputString[i].substring(index + 1);
						temp = temp + inputString[i].charAt(index);
						index = index + 1;
					} else {
						index = -1;
						break;
					}

				}

				outputArr[i] = index - 1;
			}
			
			for(int l:outputArr)
			{
				System.out.println(l);
			}
		}

		static boolean checkPalindrome(String s) {
			int n = s.length();
			for (int i = 0; i < (n / 2); ++i) {
				if (s.charAt(i) != s.charAt(n - i - 1)) {
					return false;
				}
			}

			return true;
		}

}
