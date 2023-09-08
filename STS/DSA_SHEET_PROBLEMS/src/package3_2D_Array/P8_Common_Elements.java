package package3_2D_Array;

import java.util.HashSet;
import java.util.Set;

public class P8_Common_Elements {

	public static void findCommon(int[][] mat) {

		Set<Integer> commonElements = new HashSet<>();

		for (int i = 0; i < mat[0].length; i++) {
			commonElements.add(mat[0][i]);
		}

		for (int i = 1; i < mat.length; i++) {
			Set<Integer> rowElements = new HashSet<>();
			for (int j = 0; j < mat[i].length; j++) {
				if (commonElements.contains(mat[i][j])) {
					rowElements.add(mat[i][j]);
				}
			}

			commonElements = rowElements;
		}

		System.out.println(commonElements);

	}

	public static void main(String[] args) {

		int mat[][] = { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 } };

		findCommon(mat);

	}

}
