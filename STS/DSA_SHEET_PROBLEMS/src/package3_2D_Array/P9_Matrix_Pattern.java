package package3_2D_Array;

import java.util.Arrays;

public class P9_Matrix_Pattern {  // i solved this by my own : em le just use the spiral matrix code and modify it, each iteration change the letter
	
	public static void createMatrix(String[][] matrix, int n, int m) {
		
		int startrow = 0;
		int startcol = 0;
		int endrow = matrix.length-1;
		int endcol = matrix[0].length-1;
		
		boolean flag = true;
		
		while(startrow <= endrow && startcol <= endcol){
			
			String letterToBeFilled = "";
			if(flag == true) {
				letterToBeFilled = "X";
			}else {
				letterToBeFilled = "O";
			}

            for(int i=startcol;i<=endcol;i++){
                matrix[startrow][i] = letterToBeFilled;
            }

            for(int i=startrow+1;i<=endrow;i++){
                 matrix[i][endcol] = letterToBeFilled;
            }

            for(int i=endcol-1;i>=startcol;i--){
                if(startrow == endrow){
                    break;
                }
                 matrix[endrow][i] = letterToBeFilled;
            }

            for(int i=endrow-1;i>=startrow+1;i--){
                if(startcol == endcol){
                    break;
                }
                 matrix[i][startcol] = letterToBeFilled;
            }
            
            flag = false;
            
            startrow++;
            startcol++;
            endrow--;
            endcol--;

        }
		
	}

	public static void main(String[] args) {
		
		int n = 4;
		int m = 5;
		
		String[][] arr = new String[m][n];
		
		createMatrix(arr, n, m);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

	}

}
