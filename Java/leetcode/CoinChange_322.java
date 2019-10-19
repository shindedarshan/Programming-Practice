package leetcode;

import java.util.HashMap;

public class CoinChange_322 {
	
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0) return -1;
		if (amount <= 0) return 0;
		HashMap<Integer, Integer> mem = new HashMap<>();
		int out = helper(coins, amount, mem);
		return (out == Integer.MAX_VALUE) ? -1 : out;
    }

	private int helper(int[] coins, int amount, HashMap<Integer, Integer> mem) {
		if (amount == 0) return 0;
		if (mem.containsKey(amount)) return mem.get(amount);
		
		int[] total = new int[coins.length];
		for (int i = 0; i < total.length; i++) {
			total[i] = Integer.MAX_VALUE;
			if (amount - coins[i] >= 0) {
				int c = helper(coins, amount - coins[i], mem);
				if (c == Integer.MAX_VALUE) total[i] = c;
				else total[i] = 1 + c;
			}
		}
		int min = total[0];
		for (int t: total) min = Math.min(min, t);
		mem.put(amount, min);
		return min;
	}

	public static void main(String[] args) {
		CoinChange_322 o = new CoinChange_322();
		int[] coins = {2};
		int amount = 3;
		System.out.println(o.coinChange(coins, amount));
	}

}
