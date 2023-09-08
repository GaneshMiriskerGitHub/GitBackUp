package packagee19_dynamic_programming;

import java.util.Arrays;

public class P1_Fibonacci {
	
	// 0 1 1 2 3
	
	// recursion
	public static int fibo(int n) {
		if(n<=1) {
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}
	
	// memoization
	public static int fiboMemoization(int n, int[] dp) {
		if(n<=1) {
			return n;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		
		dp[n] = fiboMemoization(n-1, dp)+fiboMemoization(n-2, dp);
		
		return dp[n];
	}
	
	// Tabulation
	public static int fiboTabulation(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<dp.length;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		
		int n = 5;
		
		// Recursion
		System.out.println(fibo(n));
		
		// Memoization
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(fiboMemoization(n, dp));
		
		// Tabulation
		System.out.println(fiboTabulation(n));
		
		

	}

}
