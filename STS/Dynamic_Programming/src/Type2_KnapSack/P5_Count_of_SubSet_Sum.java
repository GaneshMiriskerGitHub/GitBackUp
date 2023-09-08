package Type2_KnapSack;

import java.util.Arrays;

public class P5_Count_of_SubSet_Sum {

	public static int count;

	public static int countOfSubSetSum(int[] arr, int target) {

//		return helper(arr, target, arr.length - 1);
		int[][] memo = new int[arr.length][target];
		Arrays.fill(memo, -1);
		return helperMemo(arr, target, target, memo);
	}

	public static int helper(int[] arr, int target, int i) {

		if (target == 0) {
			return 1;
		}

		if (i < 0) {
			return 0;
		}

		int include = helper(arr, target - arr[i], i - 1);

		int exclude = helper(arr, target, i - 1);

		return include + exclude;
	}

	public static int helperMemo(int[] arr, int target, int i, int[] memo) {

		if (target == 0)
			return 1;

		if (i == 0)
			if (target - arr[0] != 0)
				return 0;
			else
				return 1;

		if (memo[i] != -1) {
			return memo[i];
		}

		int include = helperMemo(arr, target - arr[i], i - 1, memo);

		int exclude = helperMemo(arr, target, i - 1, memo);

		memo[i] = include + exclude;

		return memo[i];
	}

	public static int helperTabulation(int[] arr, int target) {
		int[][] dp = new int[arr.length+1][target+1];
		dp[0][0] = 0;
		
		for()
	}
	
	
	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 1 };

		int target = 1;

		System.out.println(countOfSubSetSum(arr, target));

	}

}
