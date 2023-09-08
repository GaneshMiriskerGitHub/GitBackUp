package Type1_Fibbonacci;

public class P2_Climbing_Stairs { 
	
	/*
	 * Find no of ways a person can reach the nth stair, while he can take only 1 or 2 steps at at time.
	 */
	
	// recursion
	public static int ways(int n) { // calculate noOfWays for nth stair
		if(n == 1 || n == 2 || n== 0) {
			return n;
		}
		
		return ways(n-1)+ways(n-2);
	}
	
	// memoization
	public static int ways2(int n, int[] arr) {
		if(n == 1 || n == 2 || n== 0) {
			return n;
		}
		if(arr[n] != 0) {
			return arr[n];
		}
		
		arr[n] = ways2(n-1, arr)+ways2(n-2, arr);
		return arr[n];
	}
	
	// tabulation
	public static int ways3(int n) {
		int[] arr = new int[n+1];
		
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=n;i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		
		return arr[n];
	}

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(ways(n));
		System.out.println(ways2(n, new int[n+1]));
		System.out.println(ways3(n));

	}

}
