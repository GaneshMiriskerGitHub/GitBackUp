package package4_Searching_and_Sorting;

public class P4_Adjacent_Diff_K {  // Find the fisrt occuring element which has difference of left and right is <= k
	
	public static int search(int[] arr, int n, int x, int k) {
		
		if(arr[0] == x) {
			if(Math.abs(arr[0]-arr[1]) <= k) {
				return 0;
			}
		}
		
		if(arr[n-1] == x) {
			if(Math.abs(arr[n-1]-arr[n-2]) <= k) {
				return n-1;
			}
		}
		
		int prev = arr[0];
		for(int i=0;i<n-1;i++) {
			if(arr[i] == x) {
				int prev_diff = Math.abs(arr[i]-prev);
				int next_diff = Math.abs(arr[i]-arr[i+1]);
				if(prev_diff <= k && next_diff <= k) {
					return i;
				}
				break;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		int arr[] = { 2, 4, 5, 7, 7, 6 };
        int x = 6;
        int k = 2;
        int n = arr.length;
         
        System.out.println("Element " + x +
                        " is present at index "
                        + search(arr, n, x, k));

	}

}
