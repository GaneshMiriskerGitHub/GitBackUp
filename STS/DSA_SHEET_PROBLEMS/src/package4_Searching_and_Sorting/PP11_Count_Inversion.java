package package4_Searching_and_Sorting;

public class PP11_Count_Inversion {
	
	// brute force :- O(n*n) : https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
	public static void countInversions(int[] arr) {
		
		int count = 0;
		
		for(int i = 0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
	// Optimisation using merge sort knowledge
	public 

	public static void main(String[] args) {
		
		int[] arr = {8, 4, 2, 1};
		
		countInversions(arr);

	}

}
