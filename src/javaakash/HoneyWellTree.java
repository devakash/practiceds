package javaakash;

import java.util.ArrayList;

public class HoneyWellTree {

	public static void main(String[] args) {

		int i[] = { 3,2,1,5};

		if (i.length > 1) {

			ArrayList<Integer> al = new ArrayList<>();
			for (int k : i) {
				al.add(k);
			}

			boolean b = false;
			int loop = 0;

			while (!b) {

				loop = loop + 1;
				int count = 0;
				for (int k = 0; k < al.size() - 1; k++) {
					if (al.get(k + 1) > al.get(k)) {

						al.remove(k + 1);
						count = count + 1;
						b = true;
					}
				}

				if (b && count > 0) {
					b = false;
				} else {
					b = true;
					loop = loop - 1;
				}

			}
			System.out.println(loop);
		} else {
			System.out.println(0);
		}
	}

}
