package packagee19_Dynamic_Programming;

import java.util.Arrays;

public class A1_Tribonacci {
	
	
	// Recursion
	public static int tribonacciRec(int n) {
		if(n==0 || n==1) return 0;
		if(n==2) return 1;
		
		return tribonacciRec(n-1)+tribonacciRec(n-2)+tribonacciRec(n-3);
	}
	
	// Memoization
	public static int tribonacciMemo(int n, int[] memo) {
		if(n==0 || n==1) return 0;
		if(n==2) return 1;
		
		if(memo[n] != -1) return memo[n];
		
		memo[n] = tribonacciMemo(n-1, memo)+tribonacciMemo(n-2, memo)+tribonacciMemo(n-3, memo);
		return memo[n];
	}
	
	// Tabulation
	public static int tribonacciTab(int n) {
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=0;
		dp[2]=1;
		for(int i=3;i<dp.length;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		
		int n = 5;
		
		System.out.println(tribonacciRec(n));
		
		int[] memo = new int[n+1]; 
		Arrays.fill(memo, -1);
//		memo[0]=0;
//		memo[1]=0;
//		memo[2]=1;
		System.out.println(tribonacciMemo(n, memo));
		
		
		System.out.println(tribonacciTab(n));

	}
 
}
