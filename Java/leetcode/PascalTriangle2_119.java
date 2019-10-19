package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle2_119 {
	
	public List<Integer> getRow(int n) {
		LinkedList<Integer> oriList = new LinkedList<>();
        oriList.add(0);
        oriList.add(1);
        oriList.add(0);
        
        if (n == 0) {
            oriList.removeFirst();
            oriList.removeLast();
            return oriList;
        }
        
        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(0);
            for (int j = 0; j < oriList.size() - 1; j++) {
                temp.add(oriList.get(j) + oriList.get(j + 1));
            }
            temp.add(0);
            oriList = temp;
        }
        
        oriList.removeFirst();
        oriList.removeLast();
        return oriList;
	}

	public static void main(String[] args) {
		PascalTriangle2_119 o = new PascalTriangle2_119();
		o.getRow(8);

	}

}
