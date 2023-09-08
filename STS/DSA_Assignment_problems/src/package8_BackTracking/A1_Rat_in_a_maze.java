package package8_BackTracking;

public class A1_Rat_in_a_maze {
	
	public static boolean isSafe(int[][] arr, int row, int col) {
		
		int n = arr.length;
		if(row>=0 && row <= arr.length-1 && col>=0 && col <= arr.length-1 && arr[row][col] == 1) {
			return true;
		}
		
		return false;
	}
	
	public static boolean ratInMaze(int[][] maze, int row, int col, int[][] sol) {
		
		if(row == maze.length-1 && col == maze.length-1) {
			sol[row][col] = 1;
			return true;
		}
		
		if(isSafe(maze, row, col)) {
			sol[row][col] = 1;
			if(ratInMaze(maze, row, col+1, sol)) {
				return true;
			}
			if(ratInMaze(maze, row+1, col, sol)) {
				return true;
			}
			sol[row][col] = 0;
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void printSolution(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+ " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int n = 4;
		int m = 4;
		int maze[][] = { { 1, 0, 0, 0 },
                		 { 1, 1, 0, 1 },
                		 { 0, 1, 0, 0 },
                		 { 1, 1, 1, 1 } };
		int[][] sol = new int[n][m];

		if(ratInMaze( maze,0, 0, sol)) {
			printSolution(sol);
		}else {
			System.out.println("Invalid path");
		}

	}

}
