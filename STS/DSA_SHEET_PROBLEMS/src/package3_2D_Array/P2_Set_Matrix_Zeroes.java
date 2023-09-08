package package3_2D_Array;

import java.util.Arrays;

public class P2_Set_Matrix_Zeroes {
	
	public static void setMatrixZeroes(int[][] matrix) {
		
		
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j] == 0) {
					
				}
			}
		}
		
	}

	public static void main(String[] args) {
		
		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		
		setMatrixZeroes(matrix);
		
		for(int i=0;i<matrix.length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

}
