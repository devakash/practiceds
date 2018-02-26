package datastructure;

import java.util.Scanner;

/*
 * This program checks number of common characters in set of strings. 
 * @Example: 
 * i/p: 
 * 	a. abc
 * 	b. cda
 * 	c. eda
 * 
 * answer: 1 since a is the only common character.
 */
public class Gemstones {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int ii = scn.nextInt();
		String s[] = new String[ii];
		for (int i = 0; i < s.length; i++) {
			s[i] = scn.next();
		}
		char cc[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };

		int count = 0;

		for (int i = 0; i < cc.length; i++) {
			boolean flag = false;
			inner: for (int j = 0; j < s.length; j++) {
				if (s[j].contains("" + cc[i])) {
					flag = true;
				} else {
					flag = false;
					break inner;
				}
			}
			if (flag) {
				count = count + 1;
			}
		}
		System.out.println(count);

	}

}
