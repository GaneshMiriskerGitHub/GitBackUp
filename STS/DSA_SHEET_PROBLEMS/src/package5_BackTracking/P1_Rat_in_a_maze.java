package package5_BackTracking;

public class P1_Rat_in_a_maze {
	
	public static void solveMaze(int[][] maze) {
		
		int[][] sol = new int[4][4];
		
		if(solveMazeUtil(maze, 0, 0, sol)) {
			printSol(sol);
			return;
		}else {
			System.out.println("No Solution Possible");
			return;
		}
		
	}
	
	public static boolean solveMazeUtil(int[][] maze, int row, int col, int[][] sol) {
		
		if(row == maze.length-1 && col == maze.length-1) {
			sol[row][col] = 1;
			return true;
		}
		
		if(isSafe(maze, row, col)) {
			sol[row][col] = 1;
			if(solveMazeUtil(maze, row, col+1, sol)) {
				return true;
			}
			if(solveMazeUtil(maze, row+1, col, sol)) {
				return true;
			}
			sol[row][col] = 0;
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isSafe(int[][] maze, int row, int col) {
		if(maze[row][col] == 1 && row <4 && col < 4 ) {
			return true;
		}
		return false;
	}
	
	public static void printSol(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+ " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        
        solveMaze(maze);

	}

}
