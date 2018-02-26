package datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCountInString {

	public static void main(String[] args) {
		LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<Character, Integer>();
		String s = "abbaccdbac";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (lhm.containsKey(c)) {
				lhm.put(c, lhm.get(c) + 1);
			} else {
				lhm.put(c, 1);
			}
		}
		String result = "";
		for (Map.Entry<Character, Integer> l : lhm.entrySet()) {
			result = result + l.getKey() + "" + l.getValue();
		}
		System.out.println(result);
	}

}
