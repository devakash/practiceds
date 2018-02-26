package linkedinplacement;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class DictionariesandMaps {

	public static void main(String[] argh) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			lhm.put(name, phone);
		}
		while (in.hasNext()) {
			String s = in.next();
			if (lhm.containsKey(s)) {

				int number = lhm.get(s);
				System.out.println(s + "=" + number);

			} else {
				System.out.println("Not found");
			}
		}
		in.close();
	}

}
