package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class MonkLoveFood {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numInput = sc.nextInt();
		Scanner scn = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < numInput; i++) {
			String inputString = scn.nextLine();

			String inp[] = inputString.split(" ");
			int k = Integer.parseInt(inp[0]);
			if (k == 1) {
				if (s.size() > 0) {
					System.out.println(s.pop());
				} else {
					System.out.println("No Food");
				}
			} else if (Integer.parseInt(inp[0]) == 2) {
				s.push(Integer.parseInt(inp[1]));
			}
		}
		
	}

}
