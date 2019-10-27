package leetcode;

public class SumOfTwoIntegers_371 {
	
	public int getSum(int a, int b) {
		while (b != 0) {
			if (b < 0) {a--; b++;}
			else {a++;b--;}
		}
		return a;
    }

	public static void main(String[] args) {
		SumOfTwoIntegers_371 o = new SumOfTwoIntegers_371();
		System.out.println(o.getSum(1, 0));
	}

}
