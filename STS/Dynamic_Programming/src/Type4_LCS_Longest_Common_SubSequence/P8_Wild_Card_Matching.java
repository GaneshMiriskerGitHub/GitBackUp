package Type4_LCS_Longest_Common_SubSequence;

public class P8_Wild_Card_Matching {

	public static boolean isMatching(String str, String pattern) {
		boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];

		dp[0][0] = true;

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = false;
		}

		for (int j = 1; j < dp[0].length; j++) {
			if (pattern.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		
		return dp[str.length()][pattern.length()];

	}

	public static void main(String[] args) {

		String str = "aa";
		String pattern = "*";
		
		System.out.println(isMatching(str, pattern));

	}

}
