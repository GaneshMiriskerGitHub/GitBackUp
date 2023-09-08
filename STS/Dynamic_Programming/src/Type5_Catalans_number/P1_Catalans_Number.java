package Type5_Catalans_number;

import java.util.Arrays;

public class P1_Catalans_Number {

	// Recursion
	public static int catalans(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += catalans(i) * catalans(n - (i + 1));
		}

		return ans;
	}

	// Memoization
	public static int catalansMemo(int n, int[] memo) {

		if (memo[n] != -1) {
			return memo[n];
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += catalansMemo(i, memo) * catalansMemo(n - i - 1, memo);
		}

		memo[n] = ans;

		return memo[n];

	}

	// Tabulation
	public static int catalansTab(int n) {
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				dp[i] += dp[j]*dp[i-j-1];
			}
		}
		
		return dp[n];
				
		
		
	}

	public static void main(String[] args) {

		int n = 5;

		System.out.println(catalans(n));

		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		memo[0] = 1;
		memo[1] = 1;
		System.out.println(catalansMemo(n, memo));
		
		System.out.println(catalansTab(n));

	}

}
