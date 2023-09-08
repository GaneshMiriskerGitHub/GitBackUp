package Type2_KnapSack;

import java.util.Arrays;

public class P2_SubSet_Sum {
	
	// Recursion
	public static boolean isSubSetPossible(int[] arr, int target, int i) {
		
		if(target == 0) {
			return true;
		}
		if(i == arr.length-1) {
			if(target != 0) {
				return false;
			}
		}
		
		boolean isPossible = false;
		// pick curr element
		if(target >= arr[i]) {
			boolean include = isSubSetPossible(arr, target-arr[i], i+1);
			boolean exclude = isSubSetPossible(arr, target, i+1);
			isPossible = include || exclude;
			return isPossible;
		}else {
		// don't pick curr element
			boolean exclude = isSubSetPossible(arr, target, i+1);
			isPossible = exclude;
			return isPossible;
		}
	} 
	
//	// memoization
//	public static int isSubSetPossibleMemo(int[] arr, int target, int i, int[] memo) {
//		
//		if(target == 0) {
//			return 1;
//		}
//		if(i == arr.length-1) {
//			if(target != 0) {
//				return 0;
//			}
//		}
//		
//		if(memo[i] != -1) {
//			return memo[i];
//		}
//		
//		int isPossible = -1;
//		// pick curr element
//		if(target >= arr[i]) {
//			int include = isSubSetPossibleMemo(arr, target-arr[i], i+1, memo);
//			int exclude = isSubSetPossibleMemo(arr, target, i+1, memo);
//			if(include || exclude) {
//				isPossible = 1;
//			}else {
//				isPossible
//			}
//		}else {
//		// don't pick curr element
//			boolean exclude = isSubSetPossible(arr, target, i+1);
//			isPossible = exclude;
//		}
//		
//		if(isPossible) {
//			memo[i] = 1;
//		}else {
//			memo[i] = 0;
//		}
//		
//		return memo[i];
//	} 
	
	// Tabulation
	public static boolean isSubSetPossibleTabulation(int[] arr, int target) {
		
		boolean[][] dp = new boolean[arr.length+1][target+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				int v = arr[i-1];
				if(j>=v) {
					dp[i][j] = dp[i-1][j-v] || dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[arr.length][target];
	}

	public static void main(String[] args) {
		
		int[] arr = {4, 2, 7, 1, 3};
		int target = 10;
		
		System.out.println(isSubSetPossible(arr, target, 0));
		int[] memo = new int[arr.length];
		Arrays.fill(memo, -1);
		//System.out.println(isSubSetPossibleMemo(arr, target, 0, memo));
		
		int[] arr2 = {2,2,1,1};
		System.out.println(isSubSetPossibleTabulation(arr2, 3));

	}

}
