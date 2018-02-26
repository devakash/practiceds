package linkedinplacement;

import java.util.Scanner;

public class BitwiseAND {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int numTCase = Integer.parseInt(scn.nextLine());
		int result[] = new int[numTCase];

		for (int i = 0; i < numTCase; i++) {
			String input = scn.nextLine();
			int num = Integer.parseInt(input.split(" ")[0]);
			int k = Integer.parseInt(input.split(" ")[1]);

			int max = 0;

			for (int j = 1; j <= num; j++) {
				for (int g = j + 1; g <= num; g++) {
					int l = j & g;
					if (l > max && l < k) {
						max = l;
					}
				}

			}
			result[i]=max;
		}
		
		for(int k:result)
		{
			System.out.println(k);
		}
		scn.close();

	}

}
