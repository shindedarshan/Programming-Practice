package leetcode;

import java.util.Arrays;

public class CoinChange_322_optimized {
	
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0) return -1;
		if (amount == 0) return 0;
		
		int[] out = new int[amount + 1];
		Arrays.fill(out, Integer.MAX_VALUE);
		out[0] = 0;
		for (int c: coins) if(c <= amount) out[c] = 1;
		
		for(int i = 1; i <= amount; i++) {
			int temp = arrayMin(coins, i, out);
			out[i] = (temp == Integer.MAX_VALUE) ? temp: Math.min(out[i], temp);
		}
		return (out[amount] == Integer.MAX_VALUE)? -1:out[amount] ;
	}
	
	private int arrayMin(int[] coins, int amount, int[] out) {
		int[] mem = new int[coins.length];
		Arrays.fill(mem, Integer.MAX_VALUE);
		for (int i = 0; i < coins.length; i++) {
			if (amount - coins[i] < 0) continue;
			else mem[i] = (out[amount-coins[i]] == Integer.MAX_VALUE) ? out[amount-coins[i]]: out[amount-coins[i]] + 1;
		}
		int min = mem[0];
		for (int m: mem) if (m < min) min = m;
		return min;
	}

	public static void main(String[] args) {
		CoinChange_322_optimized o = new CoinChange_322_optimized();
		int[] coins = {2};
		int amount = 1;
		System.out.println(o.coinChange(coins, amount));
	}

}
