package Type2_KnapSack;

public class P3_Equal_SubSet_Sum_Partition {

	// Tabulation
	public static boolean isSubSetPossibleTabulation(int[] arr, int target) {

		boolean[][] dp = new boolean[arr.length + 1][target + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				int v = arr[i - 1];
				if (j >= v) {
					dp[i][j] = dp[i - 1][j - v] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[arr.length][target];
	}

	public static void main(String[] args) {

		int[] arr2 = { 2, 2, 1, 1 };
		System.out.println(isSubSetPossibleTabulation(arr2, 3));

	}

}
