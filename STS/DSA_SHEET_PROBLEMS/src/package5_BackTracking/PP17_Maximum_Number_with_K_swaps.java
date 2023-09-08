package package5_BackTracking;

/*
 * Q) find the maximum number that can be formed with k times of swapping
 * For example :- 254  , and k = 1
 * answers :- with only k no of swaps, we can swap 5 and 2 so final maximum number that can
 * be formed is 524
 */

/*
 * ChatGPT solution :- 
 * public class MaximumNumberWithKSwaps {
    public static String findMaximumNumber(String number, int k) {
        // Base case: if no swaps remaining or number is already maximum
        if (k == 0 || number.length() <= 1) {
            return number;
        }

        char[] digits = number.toCharArray();
        int n = digits.length;

        // Find the maximum digit in the remaining unsorted part of the number
        char maxDigit = digits[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (digits[i] > maxDigit) {
                maxDigit = digits[i];
                maxIndex = i;
            }
        }

        // If the maximum digit is not at the current position, swap it with the current digit
        if (maxDigit != digits[0]) {
            char temp = digits[0];
            digits[0] = maxDigit;
            digits[maxIndex] = temp;
            k--;  // Reduce the number of remaining swaps
        }

        // Recursively find the maximum number in the remaining subarray with reduced swaps
        String remainingNumber = new String(digits, 1, n - 1);
        String maxRemaining = findMaximumNumber(remainingNumber, k);

        // Combine the swapped digit with the remaining maximum number
        return digits[0] + maxRemaining;
    }

    public static void main(String[] args) {
        String number = "53274";
        int k = 2;

        String maxNumber = findMaximumNumber(number, k);
        System.out.println("Maximum number with at most " + k + " swaps: " + maxNumber);
    }
}

 */

public class PP17_Maximum_Number_with_K_swaps { // idoka moggalo questionu adi malli solve kuda cheyyala ?
	                                            // answer :- just send the maximum number to first position
	                                            // source chatGPT , solution above

	public static String findMaximumNumber(String number, int k) {
		if( k == 0 || number.length() <= 0 ) {
			return number;
		}
		
		char[] arr = number.toCharArray();
		
		char maxDigit = arr[0];
		int maxIndex = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i] > maxDigit) {
				maxDigit = arr[i];
				maxIndex = i;
			}
		}
		
		if(arr[0]!= maxDigit) {
			char temp = arr[0];
			arr[0] = maxDigit;
			arr[maxIndex] = temp;
		}
		
		String remainingDigits = new String(arr,1,arr.length-1);
		String maxRemaining = findMaximumNumber(remainingDigits, k-1);
		return arr[0]+maxRemaining;
	}
	
	public static void main(String[] args) {
		
		int M = 1234;
		int k = 2;
		
		System.out.println(findMaximumNumber(String.valueOf(M), k));

	}

}
