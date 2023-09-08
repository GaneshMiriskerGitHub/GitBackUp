package Type4_LCS_Longest_Common_SubSequence;

public class P7_String_Conversion {

	public static int minOperations(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {

					// delete
					int deleteOp = 1 + dp[i - 1][j];
					// replace
					int replaceOp = 1 + dp[i - 1][j - 1];

					dp[i][j] = Math.min(replaceOp, deleteOp);
				}
			}
		}

		return dp[word1.length()][word2.length()];

	}

	public static void main(String[] args) {
		String str1 = "pear";
		String str2 = "sea";

		System.out.println(minOperations(str1, str2));
	}

}
