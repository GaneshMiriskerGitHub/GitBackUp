package package8_BackTracking;

public class A3_Knights_Tour {
	
	public static boolean solveKT() {
		int[][] sol = new int[8][8];
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				sol[i][j] = -1;
			}
		}
		
		int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
		
		sol[0][0] = 0;
		
		if(solveKTUtil(0,0,1,sol,xMoves, yMoves)) {
			printSol(sol);
			return true;
		}else {
			System.out.println("No solution exists");
			return false;
		}
	}
	
	public static boolean solveKTUtil(int x, int y, int movei,int[][] sol, int[] xMoves, int[] yMoves) {
		
		int k, next_x, next_y;
		if(movei == 8*8) {
			return true;
		}
		
		for(k=0;k<8;k++) {
			next_x = x+xMoves[k];
			next_y = y+yMoves[k];
			if(isSafe(sol, next_x, next_y)) {
				sol[next_x][next_y] = movei;
				if(solveKTUtil(next_x, next_y, movei+1, sol, xMoves, yMoves)) {
					return true;
				}else {
					sol[next_x][next_y] = -1;
				}
			}
		}
		
		return false;
	}
	
	public static boolean isSafe(int[][] sol, int r, int c) {
		return (r>=0 && r<8 && c>=0 && c<8 && sol[r][c] == -1);
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
		
		int N = 8;
		
		solveKT();

	}

}
