package package4_Searching_and_Sorting;

public class PP16_Reverse_a_SubArray_Check_If_Array_Sorted_or_Not {
	
	public static void isSorted(int[] arr ) { // bokka le this is also easy i applied my sontham logic
		
		int subArrStart = -1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] > arr[i+1]) {
				subArrStart = i;
				break;
			}
		}
		
		int subArrEnd = -1;
		for(int i=subArrStart;i<arr.length;i++) {
			if(i == arr.length-1) {
				System.out.println(i);
				subArrEnd = arr.length-1;
				break;
			}
			System.out.println(i);
			if(arr[i] < arr[i+1]) {
				subArrEnd = i;
			}
			
		}
		
		
		reverseSubArray(arr, subArrStart, subArrEnd);
		
		boolean isSorted = true;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				isSorted = false;
				break;
			}
		}
		
		System.out.println(isSorted);
	}
	
	public static void reverseSubArray(int[] arr, int s, int e) {
		while(s<=e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			
			s++;
			e--;
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 5, 4, 3};
		
		isSorted(arr);

	}

}
