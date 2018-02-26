package athenahealth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TopTweet {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int numTestCase = scn.nextInt();
		int numTestOut = scn.nextInt();
		String input[] = new String[numTestCase];
		scn.close();

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextLine();

		}
		sc.close();
		TreeMap<String, Integer> hm = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < input.length; i++) {
			String word[] = input[i].split(" ");
			for (int j = 0; j < word.length; j++) {
				if (word[j].charAt(0) == '#') {
					if (hm.containsKey(word[j])) {
						int val = hm.get(word[j]);
						hm.put(word[j], val + 1);
					} else {
						hm.put(word[j], 1);
					}
				}
			}
		}

		Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				return v2.compareTo(v1);
			}
		};

		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list, valueComparator);

		LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedByValue.put(entry.getKey(), entry.getValue());
		}

		Set<String> s = sortedByValue.keySet();
		Iterator<String> i = s.iterator();
		for (int k = 0; k < numTestOut; k++) {
			System.out.println(i.next());
		}

	}

}
