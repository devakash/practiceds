package datastructure;

import java.util.Scanner;

public class ConvertToPalindrom {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String inputArr[] = new String[scn.nextInt()];
		int resultArr[] = new int[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = scn.next();
			String inputString = inputArr[i];

			int iteration = 0;
			int len = inputString.length();
			int endIndex = len - 1;
			int startIndex = 0;
			while (!checkPalindrome(inputString)) {

				if (inputString.charAt(startIndex) < inputString.charAt(endIndex)) {
					char c = inputString.charAt(endIndex);
					if (c != 'a') {
						int j = inputString.charAt(endIndex);
						j = j - 1;
						StringBuffer sb = new StringBuffer(inputString);
						sb.setCharAt(endIndex, (char) j);
						inputString = sb.toString();
						iteration = iteration + 1;
					} else {
						endIndex = endIndex - 1;
					}
					System.out.println(inputString);
				} else 
				if(inputString.charAt(startIndex) > inputString.charAt(endIndex)){
					char c = inputString.charAt(startIndex);
					if (c != 'a') {
						int j = inputString.charAt(startIndex);
						j = j - 1;
						StringBuffer sb = new StringBuffer(inputString);
						sb.setCharAt(startIndex, (char) j);
						inputString = sb.toString();
						iteration = iteration + 1;
					} else {
						startIndex = startIndex + 1;
					}
					System.out.println(inputString);
				}
				else
				{
					startIndex=startIndex+1;
					endIndex=endIndex-1;
				}
					
			}
			resultArr[i]=iteration;
		}

		for(int a:resultArr)
		{
			System.out.println(a);
		}
	}

	
	
	static boolean checkPalindrome(String s) {
		int n = s.length();
		  for (int i=0;i<(n / 2);++i) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
	}
}
