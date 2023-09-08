package packagee12_Greedy;

import java.util.Arrays;

public class P3_Minimum_Absolute_different_sum {
	
	public static void minAbsDiffSum(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int abs_diff = 0;
		for(int i=0;i<A.length;i++) {
			abs_diff += Math.abs(A[i] - B[i]);  // sum of all the absolute difference
		}
		
		System.out.println(abs_diff);
	}

	public static void main(String[] args) {
		
		int[] A = {1,2,3};
		int[] B = {2,1,3};
		
		minAbsDiffSum(A, B);

	}

}
