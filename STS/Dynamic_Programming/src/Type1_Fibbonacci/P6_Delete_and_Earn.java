package Type1_Fibbonacci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P6_Delete_and_Earn {
	
	public static int maxEarnedAfterDeleting(int[] arr) {
		
		// Step 1: Create a sorted array (ARR) with distinct elements from 'arr'
        int[] ARR = Arrays.stream(arr).distinct().sorted().toArray();

        // Step 2: Create a frequency map for the elements in 'arr'
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Create the 'count' array based on frequencies from 'arr'
        int[] count = new int[ARR.length];
        for (int i = 0; i < ARR.length; i++) {
            count[i] = frequencyMap.getOrDefault(ARR[i], 0);
        }
		
		int[] dp = new int[ARR.length];
		if(ARR.length == 0) return 0;
		if(ARR.length == 1) {
			int currEarn = ARR[0]*count[0];
			dp[0] = currEarn;
			return dp[0];
		}else {
			int currEarn = ARR[0]*count[0];
			dp[0] = currEarn;
		}
		if(arr.length == 2) {
			if(ARR[0]+1 != ARR[1]) {
				dp[1] = (ARR[1]*count[1])+dp[0];
			}else {
				dp[1] = Math.max((ARR[0]*count[0]), (ARR[1]*count[1]));
			}
			return dp[1];
		}else {
			if(arr[0]+1 != arr[1]) {
				dp[1] = (ARR[1]*count[1])+dp[0];
			}else {
				dp[1] = Math.max((ARR[0]*count[0]), (ARR[1]*count[1]));
			}
		}
		
		for(int i=2;i<ARR.length;i++) {
			int currEarn = ARR[i]*count[i];
			if(ARR[i] == ARR[i-1]+1) {
				dp[i] = Math.max(currEarn+dp[i-2], dp[i-1]);
			}else {
				dp[i] = currEarn+dp[i-1];
			}
		}
//		System.out.println(Arrays.toString(dp));
		return dp[dp.length-1];
		
	}

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 3, 5, 6, 6};
//		maxEarnedAfterDeleting(arr);
		System.out.println(maxEarnedAfterDeleting(arr));

	}

}
