package Type3_Unbounded_Knapsack;

public class P2_Rod_cutting {
	
	public static int maxValue(int[] length, int[] prices, int rodLength) {
		
		int[][] dp = new int[length.length+1][rodLength+1];
		
		dp[0][0] = 0;
		for(int i=0;i<dp.length;i++) dp[i][0] = 0;
		for(int i=0;i<dp.length;i++) dp[0][i] = 0;
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(j>=length[i-1]) {
					int include = prices[i-1] + dp[i][j-length[i-1]];
					int exclude = dp[i-1][j];
					dp[i][j] = Math.max(include, exclude);
				}else {
					int exclude = dp[i-1][j];
					dp[i][j] = exclude;
				}
			}
		}
		
		return dp[length.length][rodLength];
	}

	public static void main(String[] args) {
		
		int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		
		int rodLength = 8;
		
		System.out.println(maxValue(length, prices, rodLength));

	}

}
