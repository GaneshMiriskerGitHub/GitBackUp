package package3_2D_Array;

public class P4_Rotated_Matrix {
	
	public static void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] rotated = new int[col][row];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                rotated[j][row-i-1] = matrix[i][j];
            }
        }

        //print rotated matrix
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = rotated[i][j];
            }
        }

    }

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		rotate(matrix);
	}

}
