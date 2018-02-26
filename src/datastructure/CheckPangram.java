package datastructure;

import java.util.Scanner;

/*
 * This class checks for the String being Pangram. A string is Pangram if it has all the character from a-z.
 */
public class CheckPangram {
	
	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		String sentence="";
		sentence=sentence+scn.nextLine();
		
		sentence=sentence.toLowerCase();
		int count=0;
		int ascii=97;
		while(ascii<=122)
		{
			akash: for(int i=0;i<sentence.length();i++)
			{
				if(sentence.charAt(i)==ascii)
				{
					count=count+1;
					break akash;
				}
			}
			ascii=ascii+1;
		}
		if(count==26)
		{
			System.out.println("pangram");
		}
		else
		{
			System.out.println("not pangram");
		}
	}

	
}
