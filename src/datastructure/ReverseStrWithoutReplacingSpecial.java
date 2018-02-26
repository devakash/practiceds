package datastructure;

public class ReverseStrWithoutReplacingSpecial {

	public static void main(String[] args) {
		String input = "((akb)(l)";
		int counter=0;
		char[] charArray = input.toCharArray();
		int openp='(';
		int closep=')';
		char[] temp = new char[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			int k=c;
			if (k != openp && k != closep) {
				temp[counter] = c;
				counter=counter+1;
			}
		}

		String ans="";
		counter=counter-1;
		for (int i = 0; i < input.length(); i++) {
			char c=input.charAt(i);
			int k=c;
			if(k==openp || k==closep)
			{
				ans=ans+c;
			}
			else
			{
				ans=ans+temp[counter];
				counter=counter-1;
			}
		}
		System.out.println(ans);
	}

}
