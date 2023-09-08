package package3_2D_Array;

import java.util.ArrayList;
import java.util.List;

public class P3_Spiral_Matrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;

        while(startrow <= endrow && startcol <= endcol){

            for(int i=startcol;i<=endcol;i++){
                list.add(matrix[startrow][i]);
            }

            for(int i=startrow+1;i<=endrow;i++){
                list.add(matrix[i][endcol]);
            }

            for(int i=endcol-1;i>=startcol;i--){
                if(startrow == endrow){
                    break;
                }
                list.add(matrix[endrow][i]);
            }

            for(int i=endrow-1;i>=startrow+1;i--){
                if(startcol == endcol){
                    break;
                }
                list.add(matrix[i][startcol]);
            }

            startrow++;
            startcol++;
            endrow--;
            endcol--;

        }

        return list;

    }

	public static void main(String[] args) {
		
		

	}

}
