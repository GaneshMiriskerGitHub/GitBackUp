package package4_Searching_and_Sorting;

import java.util.Arrays;

public class PP10_Merge_Two_Sorted_Arrays { // https://www.youtube.com/watch?v=n7uwj04E0I4

	public static void main(String[] args) {
		
		int ar1[] = {1 ,3, 5, 7};
		int ar2[] = {0, 2, 6, 8, 9};
		
		int i=ar1.length-1;
		int j=0;
		
		while(i>=0 && j<ar2.length) {
			if(ar1[i] > ar2[j]) {
				int temp = ar1[i];
				ar1[i] = ar2[j];
				ar2[j] = temp;
				i--;
				j++;
			}else {
				break;
			}
		}
		
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));

	}

}
