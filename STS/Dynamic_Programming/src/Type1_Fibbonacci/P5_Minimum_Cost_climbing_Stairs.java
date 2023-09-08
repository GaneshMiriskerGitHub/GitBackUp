package Type1_Fibbonacci;

public class P5_Minimum_Cost_climbing_Stairs {
	
	public static int minCost(int[] arr) {
		
		return Math.min(minCostHelper(arr, 0), minCostHelper(arr, 1));
		
	}
	
	public static int minCostHelper(int[] arr, int i) {
		if(i >= arr.length) {
			return 0;
		}
		if(i == arr.length-1) {
			return arr[i];
		}
		if(i == arr.length-2) {
			return Math.min(arr[i], arr[i]+arr[i+1]);
		}
		
		
		
		return Math.min(arr[i]+minCostHelper(arr, i+1), arr[i]+minCostHelper(arr, i+2));
	}
	
	
	
	// memoization
	

	public static void main(String[] args) {
		
		int[] arr = {10, 15, 20};
		
		System.out.println(minCost(arr));
		

	}

}
