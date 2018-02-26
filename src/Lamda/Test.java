package Lamda;

public class Test {
	
	
	public static void main(String[] args) {
		int i[]={1};
		System.out.println(getSingleQuotedCommaSeperatedString(i));
	}
	
	public static String getSingleQuotedCommaSeperatedString(int[] str) {
		String returnString = "";
		if (str != null) {
			for (int k = 0; k < str.length; k++) {
				String temp = String.valueOf(str[k]);
				temp = "'" + temp + "'";
				returnString = returnString + "," + temp;
			}

			if (returnString.length() > 0) {
				returnString = returnString.substring(1, returnString.length());

			}
			return returnString;
		} else {
			return null;
		}
	}
}
