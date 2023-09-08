package package8_BackTracking;

import java.util.Arrays;

public class P1_BackTrack_on_Array {
	
	public static void backTrackOnArray(int[] arr, int i) {
		
		if(i == arr.length) {
			return;
		}
		
		arr[i] = i+1;
		backTrackOnArray(arr, i+1);
		arr[i] -= 2;
	}

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		backTrackOnArray(arr, 0);
		
		System.out.println(Arrays.toString(arr));

	}

}
