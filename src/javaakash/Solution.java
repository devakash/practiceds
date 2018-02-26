package javaakash;

import java.util.Scanner;

public class Solution {

	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int i=scn.nextInt();
		String a[][]=new String[i][3];
		for(int j=0;j<a.length;j++)
		{
			for(int k=0;k<3;k++)
			{
				a[j][k]=scn.next();
			}
		}
		System.out.print("");
		
	}
}
