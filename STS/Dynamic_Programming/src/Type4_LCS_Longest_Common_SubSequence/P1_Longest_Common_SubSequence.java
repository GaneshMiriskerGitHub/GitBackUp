package Type4_LCS_Longest_Common_SubSequence;

import java.util.Arrays;

public class P1_Longest_Common_SubSequence {

	// Recursion
	public static int maxSubSequence(String str1, String str2, int n, int m) {
		
		if(n==0 || m==0) {
			return 0;
		}

		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			int ans = 1 + maxSubSequence(str1, str2, n-1, m-1);
			return ans;
		}else {
			int choice1 = maxSubSequence(str1, str2, n-1, m);
			int choice2 = maxSubSequence(str1, str2, n, m-1);
			return Math.max(choice1, choice2);
		}
		
	}

	public static int maxSubSequenceMemo(String str1, String str2, int n, int m, int[][] dp) {
		
		if(n==0 || m==0) {
			dp[n][m] = 0;
			return dp[n][m];
		}

		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			int ans = 1 + maxSubSequence(str1, str2, n-1, m-1);
			return ans;
		}else {
			int choice1 = maxSubSequence(str1, str2, n-1, m);
			int choice2 = maxSubSequence(str1, str2, n, m-1);
			return Math.max(choice1, choice2);
		}
		
	}
	
	// Tabulation
	public static int maxSubSequenceTabulation(String str1, String str2) {
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					int choice1 = dp[i-1][j];
					int choice2 = dp[i][j-1];
					dp[i][j] = Math.max(choice1, choice2);
				}
			}
		}
		
		return dp[str1.length()][str2.length()];
		
		
	}
	

	public static void main(String[] args) {

		String str1 = "abcde"; int n = str1.length();
		String str2 = "ace";   int m = str2.length();

		// Recursion
		int result = maxSubSequence(str1, str2, n, m);
		System.out.println(result);
		
		// Memoization
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
		
		int resultMemo = maxSubSequenceMemo(str1, str2, n, m, dp);
		System.out.println(resultMemo);
		
		// Tabulation
		System.out.println(maxSubSequenceTabulation(str1, str2));

	}

}
