package packagee13_Greedy;

import java.util.Arrays;

public class A3_Lexographically_Smallest_String_of_Length_N_and_Sum_K { // did not unserstand this code

	public static void lexo_small(int n, int k) 
	    char arr[] = new char[n];
	    Arrays.fill(arr, 'a');
	    for (int i = n - 1; i >= 0; i--) {
	        k -= i;
	        if (k >= 0) {
	            if (k >= 26) {
	                arr[i] = 'z';
	                k -= 26;
	            } else {
	                arr[i] = (char)(k + 97 - 1);
	                k -= arr[i] - 'a' + 1;
	            }
	        } else {
	            break;
	        }
	        k += i;
	    }
	    System.out.println(Arrays.toString(arr));
	}


	public static void main(String[] args) {

		int[] alphabetValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25, 26 };

		// Input
		int N = 5;
		int K = 42;
		
		lexo_small(N, K);

	}

}
