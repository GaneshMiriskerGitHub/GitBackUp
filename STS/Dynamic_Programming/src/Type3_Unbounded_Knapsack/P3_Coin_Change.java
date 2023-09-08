package Type3_Unbounded_Knapsack;

public class P3_Coin_Change {

	public static int noOfWays(int[] coins, int sum) {

		int[][] dp = new int[coins.length + 1][sum + 1];

		for (int i = 0; i < dp.length; i++)
			dp[i][0] = 1;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (j >= coins[i-1]) {
					int include = dp[i][j - coins[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = include + exclude;
				}else {
					int exclude = dp[i - 1][j];
					dp[i][j] = exclude;
				}
			}
		}
		
		return dp[coins.length][sum];

	}

	public static void main(String[] args) {

		int[] coins = { 1, 2, 3 };
		int sum = 4;

		System.out.println(noOfWays(coins, sum));

	}

}
