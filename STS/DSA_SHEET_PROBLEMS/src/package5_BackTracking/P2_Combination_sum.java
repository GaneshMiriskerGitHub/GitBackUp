package package5_BackTracking;

import java.util.ArrayList;

public class P2_Combination_sum {  // https://www.youtube.com/watch?v=OyZFFqQtu98
	                                // also refer the gfg solution also pasted in the DSA sheet

	public static void findCombinations(int[] arr, int target) {
		
		ArrayList<ArrayList<Integer>>  ans = new  ArrayList<>();
		
		findCombinationsUtil(arr, target, 0, ans, new  ArrayList<>());
		for(ArrayList<Integer> ele : ans) {
			System.out.println(ele);
		}

	}

	public static void findCombinationsUtil(int[] arr, int target, int i, ArrayList<ArrayList<Integer>>  ans, ArrayList<Integer> eachList) {
		
		if(i == arr.length) {
			if(target == 0) {
				ans.add(new ArrayList<>(eachList)); // add new list each time
				return;
			}else {
				return;
			}
		}
		

		// picking same value
		if(target>=arr[i]) {
			eachList.add(arr[i]);
			findCombinationsUtil(arr, target-arr[i], i, ans, eachList);
			eachList.remove(eachList.size()-1);
		}
		
		// not picking up
		findCombinationsUtil(arr, target, i+1, ans, eachList);
		
	}

	public static void main(String[] args) {

		int[] arr = { 2, 4, 6, 8 };
		int target = 8;

		findCombinations(arr, target);

	}

}
