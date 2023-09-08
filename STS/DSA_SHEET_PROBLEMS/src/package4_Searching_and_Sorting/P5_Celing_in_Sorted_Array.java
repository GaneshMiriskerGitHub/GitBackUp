package package4_Searching_and_Sorting;

public class P5_Celing_in_Sorted_Array { // Same binary search :-
//	                                          return start for ceiling
//	                                          return end for floor
	
	public static int ceilingSearch(int[] arr, int s, int e, int target) {
		
		while(s<e) {
			int m = s+(e-s)/2;
			
			if(arr[m] == target) {
				return m;
			}
			if(target < arr[m]) {
				e = m-1;
			}else {
				s= m+1;
			}
		}
		
		return s;
		
		
	}
	


	public static void main(String[] args) {
		
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
	       int n = arr.length;
	       int x = 3;
	       int index = ceilingSearch(arr, 0, n-1, x);
	       if(index == -1)
	         System.out.println("Ceiling of "+x+" doesn't exist in array");
	       else
	         System.out.println("ceiling of "+x+" is "+arr[index]);

	}

}
