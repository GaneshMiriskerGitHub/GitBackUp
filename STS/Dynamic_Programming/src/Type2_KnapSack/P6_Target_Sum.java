package Type2_KnapSack;

public class P6_Target_Sum {
	
	// Recursion
	public static boolean targetSumRec(int[] arr, int target, int i) {
		
		if(target == 0) {
			return true;
		}
		if(i<0) {
			return false;
		}
		
		boolean isPossible;
		if(target>=arr[i]) {
			boolean include = targetSumRec(arr, target-arr[i], i-1);
			boolean exclude = targetSumRec(arr, target, i-1);
			isPossible = include || exclude;
		}else {
			boolean exclude = targetSumRec(arr, target, i-1); 
			isPossible = exclude;
		}
		
		return isPossible;
		
		
	}

	public static void main(String[] args) {
	
		int[] arr = {4, 2};
		
		int target = 10;
		
		System.out.println(targetSumRec(arr, target, arr.length-1));

	}

}
