package leetcode;

public class BusiestTimeInTheMall {
	  
	static int findBusiestPeriod(int[][] data) {
	    int cur = 0;
	    int curTime = 0;
	    int maxCount = Integer.MIN_VALUE;
	    int maxTime = 0;
	    
	    for(int i = 0; i < data.length; i++) {
			if (data[i][0] != curTime) {
			  if (cur > maxCount) {
			    maxCount = cur;
			    maxTime = curTime;
			  }
			  curTime = data[i][0];
			} 
			cur = data[i][2] == 1 ? cur + data[i][1] : cur - data[i][1];
	    }
	    if (cur > maxCount) return curTime;
	    return maxTime;
	  }
	
	  public static void main(String[] args) {
	    int[][] data = {{1487799425, 14, 1}, 
	                    {1487799425, 4,  0},
	                    {1487799425, 2,  0},
	                    {1487800378, 10, 1},
	                    {1487801478, 18, 0},
	                    {1487801478, 18, 1},
	                    {1487901013, 1,  0},
	                    {1487901211, 7,  1},
	                    {1487901211, 7,  0}};
	    System.out.println(findBusiestPeriod(data));
	  }
}
