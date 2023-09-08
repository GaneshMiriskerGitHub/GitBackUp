package packagee19_dynamic_programming;

public class P5_Target_Sum_Subset {
	
	// Recursion
	private static boolean targetSumExists(int[] nums, int target, int i) {
		if(target == 0) {
			return true;
		}
		if(i == -1) {
			return false;
		}
		
		if(nums[i] <= target) {
			boolean inc = targetSumExists(nums, target-nums[i], i-1);
			boolean exc = targetSumExists(nums, target, i-1);
			return inc || exc;
		}else {
			boolean exc = targetSumExists(nums, target, i-1);
			return exc;
		}
	}
	
	// Memoization
	public static boolean targetSumMemoization(int[] nums, int target, int i, boolean[][] dp) {
		if(target == 0) {
			return true;
		}
		if(i == -1) {
			return false;
		}
		
		if(nums[i] <= target) {
			boolean inc = targetSumExists(nums, target-nums[i], i-1);
			boolean exc = targetSumExists(nums, target, i-1);
			return inc || exc;
		}else {
			boolean exc = targetSumExists(nums, target, i-1);
			return exc;
		}
	}
	
	// Tabulation
	public static boolean targetSumTabulation(int[] nums, int target) {
		boolean[][] dp = new boolean[nums.length+1][target+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<target+1;j++) {
				if(nums[i-1] <= j && dp[i-1][j-nums[i-1]] == true) {
					dp[i][j] = true;
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[nums.length][target];
	}

	public static void main(String[] args) {
		
		int[] nums = {4,2,7,1,3};
		int target = 10;
		
		// Recursion
		System.out.println(targetSumExists(nums, target, nums.length-1));
		
		// Memoization
		boolean[][] dp = new boolean[nums.length+1][target+1];
		System.out.println(targetSumMemoization(nums, target, nums.length-1, dp));
		
		// Tabulation
		System.out.println(targetSumTabulation(nums, target));
		

	}

}
