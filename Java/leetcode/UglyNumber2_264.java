package leetcode;

public class UglyNumber2_264 {
	
	public int nthUglyNumber(int n) {
		int[] mem = new int[n];
		mem[0] = 1;
		
		int i2 = 0; 
		int i3 = 0;
		int i5 = 0;
		
		for (int i = 1; i < n; i++) {
			mem[i] = Math.min(mem[i2] * 2, Math.min(mem[i3] * 3, mem[i5] * 5));
			
			if (mem[i] == mem[i2] * 2) i2++;
			if (mem[i] == mem[i3] * 3) i3++;
			if (mem[i] == mem[i5] * 5) i5++;
		}
		
		return mem[n-1];
    }

	public static void main(String[] args) {
		UglyNumber2_264 o = new UglyNumber2_264();
		int n = 10;
		System.out.println(o.nthUglyNumber(n));
	}

}
