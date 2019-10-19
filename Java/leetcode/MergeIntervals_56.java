package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
	
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new IntervalComparator());
		List<int[]> out = new ArrayList<>();
		for (int[] interval: intervals) {
			if (out.isEmpty())
				out.add(interval);
			else {
				int[] last = out.get(out.size() - 1);
				if (last[1] >= interval[0]) {
					if (last[1] < interval[1]) {
						last[1] = interval[1];
						out.set(out.size()-1, last);
					}
				}
				else {
					out.add(interval);
				}
			}
		}
		int[][] res = new int[out.size()][2];
		return out.toArray(res);
    }
	
	public class IntervalComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[0] > o2[0])? 1 : (o1[0] < o2[0])? -1: 0;
		}
		
	}
	
	public static void main(String[] args) {
		MergeIntervals_56 o = new MergeIntervals_56();
		int[][] intervals = {{1,4},{2,3}};
		int[][] out = o.merge(intervals);
		for (int[] i: out) {
			System.out.println(i[0] + " " + i[1]);
		}
	}

}
