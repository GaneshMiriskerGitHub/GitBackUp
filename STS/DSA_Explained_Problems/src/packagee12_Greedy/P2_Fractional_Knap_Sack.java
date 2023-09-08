package packagee12_Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class P2_Fractional_Knap_Sack {
	
	public static long maxValue(int[] value, int[] weight, int W ) { // put everything in double to get correct accurate answer
		
		int[][] knapsack = new int[value.length][4];
		for(int i=0;i<value.length;i++) {
			knapsack[i][0] = i;
			knapsack[i][1] = value[i];
			knapsack[i][2] = weight[i];
			knapsack[i][3] = value[i]/weight[i];
		}
		
		Arrays.sort(knapsack, Comparator.comparingDouble( o -> o[3]));
		
		long maxValue = 0;
		for(int i=value.length-1;i>=0;i--) {
			if(W >= knapsack[i][2]) {
				W = W - knapsack[i][2];
				maxValue = maxValue + knapsack[i][1];
			}else {
				if(W > 0) {
					maxValue += W*knapsack[i][3];
					W = 0;
					break;
				}
			}
		}
		
		return maxValue;
		
	}

	public static void main(String[] args) {
		
		int[] value = {60, 100, 120};
		int[] weight = {10, 20, 30};
		
		int W = 50;
		
		System.out.println(maxValue(value, weight, W));
	}

}
