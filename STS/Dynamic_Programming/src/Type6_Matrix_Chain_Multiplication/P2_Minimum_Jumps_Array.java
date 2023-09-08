package Type6_Matrix_Chain_Multiplication;

import java.util.Arrays;

public class P2_Minimum_Jumps_Array { // this is not a variation of MCM, this is a variation of kind of 0-1 knapsack

	public static int minJumps(int[] arr) {
		
		int n = arr.length;
		
		int[] dp = new int[n]; Arrays.fill(dp, -1);
		dp[n-1] = 0;
		
		for(int i=n-2;i>=0;i--) {
			int steps = arr[i]; int ans = Integer.MAX_VALUE;
			for(int j=i+1;j<=i+steps && j<n ;j++) {
				if(dp[j] != -1) {
					ans = Math.min(ans, 1+dp[j]);
				}
			}
			if(ans != Integer.MAX_VALUE) {
				dp[i] = ans;
			}
		}
		
		return dp[0];
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 1, 1, 4};
		
		System.out.println(minJumps(arr));

	}

}
