package datastructure;

import java.util.Scanner;
/*
 * We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. 
 * In other words, both strings must contain the same exact letters in the same exact frequency.
 * 
 * this program to make two string anagrams by deleting the unnecessary or not required characters from a string.
 * 
 * Logic: for each String create an integer array of length 26 (a-z) containing occurrence of characters in a String.
 * make both arrays equals. Number of modification done is the answer.
 */
public class MakingAnagrams {
	
	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		String a1=scn.next();
		String a2=scn.next();
		
		int[] letters1 = new int[26];
        for(int i=0;i<a1.length();i++){
        	int k=a1.charAt(i)-'a';
            letters1[k]=letters1[k]+1;
        }
        
        int[] letters2 = new int[26];
        for(int i=0;i<a2.length();i++){
        	int k=a2.charAt(i)-'a';
            letters2[k]=letters2[k]+1;
        }
        int count=0;
        for(int i=0;i<letters1.length;i++)
        {
        	if(letters1[i]<letters2[i])
        	{
        		count+=letters2[i]-letters1[i];
        	}
        	else
        		if(letters1[i]>letters2[i])
        	{
        			count+=letters1[i]-letters2[i];
        	}
        }
        System.out.println(count);
	}
		
	

}
