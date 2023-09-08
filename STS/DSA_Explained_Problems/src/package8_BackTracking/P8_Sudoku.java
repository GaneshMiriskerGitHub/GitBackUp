package package8_BackTracking;

/*
 * 
 * Revised solution :-
 * package package8_BackTracking;

public class P8_Sudoku {
	
	public static void print(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static boolean solveSudoku(int[][] grid, int row, int col) {
		
		if(row == 9 ) {
			return true;
		}
		
		int nextRow = row;
		int nextCol = col+1;
		
		if(col+1 == 9) {
			nextRow = row+1;
			nextCol = 0;
		}
		
		if(grid[row][col] != 0) {
			return solveSudoku(grid, nextRow, nextCol);
		}
		
		for(int digit=1;digit<=9;digit++) {
			if(isSafe(grid, row, col, digit)) {  // do not use nextRow , nextCol over here , they are only for next recursive calls
				grid[row][col] = digit;
				if(solveSudoku(grid, nextRow, nextCol)) {
					return true;
				}
				grid[row][col] = 0;
			}
		}
		
		return false;
	}
	
	public static boolean isSafe(int[][] grid, int row, int col, int digit) {
		// same row 
		for(int i=0;i<=8;i++) {
			if(grid[row][i] == digit) {
				return false;
			}
		}
		
		// same col
		for(int i=0;i<=8;i++) {
			if(grid[i][col] == digit) {
				return false;
			}
		}
		
		// same grid
		int sr = (row/3)*3;
		int sc = (col/3)*3;
		
		for(int i=sr;i<sr+3;i++) {
			for(int j=sc;j<sc+3;j++) {
				if(grid[i][j] == digit) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if (solveSudoku(grid, 0, 0))
			print(grid);
		else
			System.out.println("No Solution exists");

	}

}
 */

public class P8_Sudoku {
	
	public static void print(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static boolean solveSudoku(int[][] grid, int row, int col) {
		
		if(row == 9 && col == 0) {
			return true;
		}else if(row == 9) {
			return false;
		}
		
		int nextRow = row;
		int nextCol = col;
		
		if(col == grid[row].length-1) {
			nextRow = row+1;
			nextCol = 0;
		}else {
			nextCol = col + 1;
		}
		
		if(grid[row][col] != 0) {
			return solveSudoku(grid, nextRow, nextCol);
		}else {
			for(int i=1;i<=9;i++) {
				int digit = i;
				if(isSafe(grid, row, col, digit)) {
					grid[row][col] = digit;
					if(solveSudoku(grid, nextRow, nextCol)) {
						return true;
					}else {
						grid[row][col] = 0;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isSafe(int[][] grid, int row, int col, int digit) {
		// same row 
		for(int i=0;i<9;i++) {
			if(grid[row][i] == digit) {
				return false;
			}
		}
		
		// same col
		for(int i=0;i<9;i++) {
			if(grid[i][col] == digit) {
				return false;
			}
		}
		
		// same grid
		int sr = (row/3)*3;
		int sc = (col/3)*3;
		
		for(int i=sr;i<sr+3;i++) {
			for(int j=sc;j<sc+3;j++) {
				if(grid[i][j] == digit) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if (solveSudoku(grid, 0, 0))
			print(grid);
		else
			System.out.println("No Solution exists");

	}

}
