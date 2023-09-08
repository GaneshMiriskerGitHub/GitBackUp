package Type4_LCS_Longest_Common_SubSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P3_Longest_Increasing_Subsequence {
	
	public static int Lic(int[] arr) {
		
		Set<Integer> set = new HashSet<Integer>();
		for(int ele: arr) set.add(ele);
		int[] arr2 = new int[set.size()];
		int k=0;
		for(int ele : set) { 
			arr2[k] = ele; 
			k++;
		}
		
		
		int[][] dp = new int[arr.length+1][arr2.length+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(arr[i-1] == arr2[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					int choice1 = dp[i-1][j];
					int choice2 = dp[i][j-1];
					dp[i][j] = Math.max(choice1, choice2);
				}
			}
		}
		
		return dp[arr.length][arr2.length];	
	}

	public static void main(String[] args) {
		
		int[] arr = {50, 3, 10, 7, 40, 80};
		
		
		
		System.out.println(Lic(arr));

	}

}
