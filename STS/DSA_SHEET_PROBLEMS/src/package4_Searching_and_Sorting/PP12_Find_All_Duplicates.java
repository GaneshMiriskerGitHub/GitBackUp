package package4_Searching_and_Sorting;

public class PP12_Find_All_Duplicates { // https://www.youtube.com/watch?v=5wdQI88O3Mc
	                                    // https://www.youtube.com/watch?v=ePNh0U-S1ck
	
    // Kirraakk codu le
	public static void printAllDuplicates(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]);
			
			if(arr[index-1] < 0) {
				System.out.println(index);
			}else {
				arr[index-1] = arr[index-1]*-1;
			}
			
		}
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 6, 3, 6, 1 };

		printAllDuplicates(arr);

	}

}
