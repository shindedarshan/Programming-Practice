package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertInterval_57 {
	public static void main(String[] args) {
		InsertInterval_57 o = new InsertInterval_57();
		int[][] intervals = {{2,5},{6,7},{8,9}};			
		int[] newInterval = {0,1};
		int[][] newIntervals = o.insert(intervals, newInterval);
		
		for(int[] i: newIntervals) {
			System.out.println(i[0] + " " + i[1]);
		}
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			return new int[][] {newInterval};
		}
		
		if (!overlap(intervals, newInterval)) {
			return addInterval(intervals, newInterval);
		}
		else {
			ArrayList<int[]> itvs = new ArrayList<>();
			for (int[] i: intervals) itvs.add(i);
			itvs.add(newInterval);
			Collections.sort(itvs, new IntervalComparator());
			return mergeIntervals(itvs);
		}
	}
	
	private int[][] mergeIntervals(ArrayList<int[]> itvs) {
		ArrayList<int[]> out = new ArrayList<>();
		
		for (int[] i : itvs) {
			if (out.isEmpty()) out.add(i);
			else {
				int[] top = out.get(out.size() - 1);
				if (isOverlap(top, i)) {
					int start = Math.min(top[0], i[0]);
					int end = Math.max(top[1], i[1]);
					out.set(out.size() - 1, new int[] {start, end});
				}
				else out.add(i);
			}
		}
		int[][] res = new int[out.size()][2];
		return out.toArray(res);
	}

	private boolean isOverlap(int[] top, int[] i) {
		if (top[0] <= i[0] && i[0] <= top[1]) return true;
		if (top[0] <= i[1] && i[1] <= top[1]) return true;
		if (i[0] <= top[0] && top[0] <= i[1]) return true;
		if (i[0] <= top[1] && top[1] <= i[1]) return true;
		return false;
	}

	public class IntervalComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[0] > o2[0])? 1: (o1[0] < o2[0])? -1: 0;
		}
	}
	
	private boolean overlap(int[][] intervals, int[] top) {
		for (int[] i: intervals) {
			if ((top[0] <= i[0] && i[0] <= top[1]) || (top[0] <= i[1] && i[1] <= top[1]) || (i[0] <= top[0] && top[0] <= i[1]) || (i[0] <= top[1] && top[1] <= i[1])) 
				return true;
		}
		return false;
	}
	
	private int[][] addInterval(int[][] intervals, int[] newInterval) {
		int[][] out = new int[intervals.length + 1][2];
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < intervals.length; i++) {
			if (!flag && intervals[i][0] > newInterval[1] && intervals[i][0] > newInterval[0]) {
				out[j] = newInterval;
				out[j + 1] = intervals[i];
				flag = true;
				j += 2;
			}
			else {out[j] = intervals[i];j++;}
		}
		if (!flag) out[j] = newInterval;
		return out;
	}
}
