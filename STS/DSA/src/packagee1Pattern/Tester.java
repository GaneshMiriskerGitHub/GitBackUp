package packagee1Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tester {

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < nums.length-2; i++) {
			
			if (i > 0 && nums[i] == nums[i - 1]) {  // very important step
                continue; // Skip duplicates
            }
			
			
			int l = i + 1;
			int r = nums.length - 1;

			while (l < r) {
				if (nums[l] + nums[r] == 0-nums[i]) {
			        List<Integer> result = new ArrayList<>();
			        result.add(nums[i]);
			        result.add(nums[l]);
			        result.add(nums[r]);
			        list.add(result);
			        while(l<r && nums[l] == nums[l+1]) {
			        	l++;
			        }
			        while(l<r && nums[r] == nums[r-1]) {
			        	r--;
			        }
			        l++;
			        r--;
			    } else if (nums[l] + nums[r] < 0-nums[i]) {
			        l++;
			    } else {
			        r--;
			    }
			}

		}
		System.out.println(list);
		
		return list;

	}

	public static void main(String[] args) {

		int[] arr = { -1,0,1,2, -1,-4 };

		threeSum(arr);
		
	}

}
