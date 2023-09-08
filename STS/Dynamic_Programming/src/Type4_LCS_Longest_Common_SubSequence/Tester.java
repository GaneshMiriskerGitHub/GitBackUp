package Type4_LCS_Longest_Common_SubSequence;

import java.util.Arrays;

public class Tester {

	// Memoization
	public static int maxSubSequenceMemo(String str1, String str2, int n, int m, int[][] dp) {

		if (n == 0 || m == 0) {
			return 0;
		}

		if (dp[n][m] != -1) {
			return dp[n][m];
		}

		if (str1.charAt(n) == str2.charAt(m)) {
			return dp[n][m] = 1 + maxSubSequenceMemo(str1, str2, n - 1, m - 1, dp);
		} else {
			int choice1 = maxSubSequenceMemo(str1, str2, n - 1, m, dp);
			int choice2 = maxSubSequenceMemo(str1, str2, n, m - 1, dp);
			return dp[n][m] = Math.max(choice1, choice2);
		}

	}

	public static void main(String[] args) {

		String str1 = "abcde"; int n = str1.length();
		String str2 = "ace";   int m = str2.length();
		
		
		// memoization
		// Memoization approach
	    int[][] dp = new int[n + 1][m + 1];
	    for (int[] row : dp) {
	        Arrays.fill(row, -1);
	    }
	    int memoResult = maxSubSequenceMemo(str1, str2, n - 1, m - 1, dp); // Start with (n-1, m-1) instead of (0, 0)
	    System.out.println("Memoization LCS Length: " + memoResult);

	    // Print the entire memoization table to verify the values
	    for (int i = 0; i <= n; i++) {
	        System.out.println(Arrays.toString(dp[i]));
	    }

	}

}
