package leetcode.sortingSearching;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency_451 {
	
	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}
		List<Map.Entry<Character, Integer>> sorted = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
		
		Collections.sort(sorted, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				if (o1.getValue() > o2.getValue()) return -1;
				if (o1.getValue() < o2.getValue()) return 1;
				return 0;
			}
		});
		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<Character, Integer>> it = sorted.iterator();
		while (it.hasNext()) {
			Map.Entry<Character,Integer> e = it.next();
			for (int i = 0; i < e.getValue(); i++) {
				sb.append(e.getKey());
			}
		}
		
		return sb.toString();
    }

	public static void main(String[] args) {
		SortCharactersByFrequency_451 o = new SortCharactersByFrequency_451();
		String s = "tree";
		System.out.println(o.frequencySort(s));
	}

}
