package Type1_Fibbonacci;

public class Tester {
	
	// Recursion
	public static int maxRob(int[] arr, int i) {
		if(i == 0) return 0;
		if(i == 1) {
			return arr[0];
		}
		if(i == 2) {
			return Math.max(arr[0], arr[1]);
		}
		
		return Math.max(arr[i]+maxRob(arr, i-2), maxRob(arr, i-1));
	}
	
	// tabulation
	public static int maxRob(int[] arr) {
		
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2;i<arr.length;i++) {
			dp[i] = Math.max(arr[i]+dp[i-2], dp[i-1]);
		}
		
		return dp[dp.length-1];
	}

	public static void main(String[] args) {
		
		int arr[] = { 6, 7, 1, 3, 8, 2, 4 };
		
		System.out.println(maxRob(arr, arr.length-1));
		System.out.println(maxRob(arr));
	}

}
