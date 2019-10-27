package leetcode.sortingSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords_692 {
	
	public List<String> topKFrequent(String[] words, int k) {
		List<String> out = new ArrayList<>();
		
		if (words == null || words.length == 0) return out;
		
		HashMap<String, Integer> map = new HashMap<>();
		for (String w: words) 
			map.put(w, map.getOrDefault(w, 0) + 1);
		PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> 
			map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
		
		for (String w: map.keySet()) {
			heap.add(w);
			if (heap.size() > k) heap.poll();
		}
		while(!heap.isEmpty()) {
			out.add(heap.poll());
		}
		Collections.reverse(out);
		return out;
    }

	public static void main(String[] args) {
		TopKFrequentWords_692 o = new TopKFrequentWords_692();
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		List<String> res = o.topKFrequent(words, k);
		for (String w: res) System.out.print(w + " ");
	}

}
