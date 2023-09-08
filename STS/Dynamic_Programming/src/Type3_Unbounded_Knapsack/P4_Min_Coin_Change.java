package Type3_Unbounded_Knapsack;

public class P4_Min_Coin_Change {
	
	public static int minCoinChange(int[] coins, int V) {
		
		int[][] dp = new int[coins.length+1][V+1];
		
		int maxPossibleValue = V+1;
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = 0;
		for(int i=0;i<dp[0].length;i++)
			dp[0][i] = maxPossibleValue;
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(j >= coins[i-1]) {
					int include = 1+dp[i][j-coins[i-1]];
					int exclude = dp[i-1][j];
					dp[i][j] = Math.min(include, exclude);
				}else {
					int exclude = dp[i-1][j];
					dp[i][j] = exclude;
				}
			}
		}
		
		if(dp[coins.length][V] > V) {
			return -1;
		}else {
			return dp[coins.length][V];
		}
		
	}

	public static void main(String[] args) {
		
		int[] coins = {1,2,5};
		
		int V = 11;
		
		System.out.println(minCoinChange(coins, V));

	}

}
