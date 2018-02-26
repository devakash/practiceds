package datastructure;

import java.util.Scanner;
/*
 * This programs check weather a string becomes Palindrome if we interchange its character position.
 * Logic: A palindrome string has zero or at most one character with odd number of occurrence. 
 */

public class GameOfThrones_Palindrome {

	public static void main(String[] args) {

		        Scanner myScan = new Scanner(System.in);
		        String in = myScan.nextLine();
		        
		        String ans;
		        
		        if(in.length()==1)
		            ans = "YES";
		        int[] letters = new int[26];
		        for(int i=0;i<in.length();i++){
		        	int k=in.charAt(i)-'a';
		            letters[k]=letters[k]+1;
		        }
		        int odd = 0;
		        for(int l:letters){
		            if(l%2!=0)
		                odd++;
		        }
		        ans = (odd>1)?"NO":"YES";
		        System.out.println(ans);
		        myScan.close();
		    }

}
