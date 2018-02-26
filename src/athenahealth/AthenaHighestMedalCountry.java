package athenahealth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class AthenaHighestMedalCountry {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int i = scn.nextInt();
		String a[][] = new String[i][3];
		for (int j = 0; j < a.length; j++) {
			for (int k = 0; k < 3; k++) {
				a[j][k] = scn.next();
			}
		}
		scn.close();
		HashMap<String, Integer[]> hm = new HashMap<>();
		for (int j = 0; j < a.length; j++) {
			for (int k = 0; k < 3; k++) {
				if (hm.containsKey(a[j][k])) {
					Integer val[] = hm.get(a[j][k]);
					if (k == 0) {
						val[0] = val[0] + 1;
					} else if (k == 1) {
						val[1] = val[1] + 1;
					} else {
						val[2] = val[2] + 1;
					}
					hm.put(a[j][k], val);

				} else {

					Integer val[] = new Integer[3];
					if (k == 0) {
						val[0] = 1;
						val[1] = 0;
						val[2] = 0;
					} else if (k == 1) {
						val[0] = 0;
						val[1] = 1;
						val[2] = 0;
					} else {
						val[0] = 0;
						val[1] = 0;
						val[2] = 1;
					}
					hm.put(a[j][k], val);
				}
			}
		}

		Comparator<Entry<String, Integer[]>> valueComparator = new Comparator<Entry<String, Integer[]>>() {
			@Override
			public int compare(Entry<String, Integer[]> e1, Entry<String, Integer[]> e2) {
				Integer[] v1 = e1.getValue();
				Integer[] v2 = e2.getValue();
				if (v1[0] > v2[0]) {
					return -1;
				} else if (v1[0] < v2[0]) {
					return 1;
				} else if (v1[0] == v2[0] && v1[1] > v2[1]) {
					return -1;
				} else if (v1[0] == v2[0] && v1[1] < v2[1]) {
					return 1;
				} else if (v1[0] == v2[0] && v1[1] == v2[1] && v1[2] > v2[2]) {
					return -1;
				} else if (v1[0] == v2[0] && v1[1] == v2[1] && v1[2] < v2[2]) {
					return 1;
				} else {
					return e1.getKey().compareTo(e2.getKey());
				}

			}
		};

		List<Entry<String, Integer[]>> list = new ArrayList<Entry<String, Integer[]>>(hm.entrySet());
		Collections.sort(list, valueComparator);

		LinkedHashMap<String, Integer[]> sortedByValue = new LinkedHashMap<String, Integer[]>();
		for (Entry<String, Integer[]> entry : list) {
			sortedByValue.put(entry.getKey(), entry.getValue());
		}

		Set<Map.Entry<String, Integer[]>> s = sortedByValue.entrySet();
		for (Map.Entry<String, Integer[]> m : s) {
			String country = m.getKey();
			Integer[] arr = m.getValue();
			String res = country + " ";
			for (int k : arr) {
				res = res + k + " ";
			}
			System.out.println(res.trim());
		}
	}
}
