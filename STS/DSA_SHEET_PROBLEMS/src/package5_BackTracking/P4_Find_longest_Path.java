package package5_BackTracking;

public class P4_Find_longest_Path {  // o/p should be 24 but it gives me 23 as answer fix it later

	static class Pair {
		boolean found;
		int val;

		public Pair(boolean found, int val) {
			this.found = found;
			this.val = val;
		}
	

	public static void findLongestPath(int[][] mat, int i, int j, int n, int m) { // https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
		int R = mat.length;
		int C = mat[0].length;
		boolean[][] visited = new boolean[R][C];
		Pair p = findLongestPathUtil(mat, i, j, n, m, R, C, visited);
		
		if(p.found) {
			System.out.println(p.val);
		}else {
			System.out.println("Invalid Path");
		}
	}

	public static Pair findLongestPathUtil(int[][] mat, int i, int j, int n, int m, int R, int C, boolean[][] visited) {

		if (i == n && j == m) {
			return new Pair(true, 0);
		}

		// not valid then return false;
		if (i < 0 || i >= R || j < 0 || j >= C || visited[i][j] == true || mat[i][j] == 0) {
			return new Pair(false, Integer.MAX_VALUE);
		}

		visited[i][j] = true;

		int res = Integer.MIN_VALUE;

		// left approach
		Pair p1 = findLongestPathUtil(mat, i, j - 1, n, m, R, C, visited);

		if (p1.found == true) {
			res = Math.max(p1.val, res);
		}

		// right approach
		Pair p2 = findLongestPathUtil(mat, i, j + 1, n, m, R, C, visited);

		if (p2.found == true) {
			res = Math.max(p2.val, res);
		}

		// up approach
		Pair p3 = findLongestPathUtil(mat, i-1, j, n, m, R, C, visited);

		if (p3.found == true) {
			res = Math.max(p3.val, res);
		}

		// down approach
		Pair p4 = findLongestPathUtil(mat, i+1, j, n, m, R, C, visited);

		if (p4.found == true) {
			res = Math.max(p4.val, res);
		}
		
		// backtrack
		visited[i][j] = false;
		
		
		if(res == Integer.MIN_VALUE) {
			return new Pair(false, Integer.MAX_VALUE);
		}else {
			return new Pair(true, res+1);
		}

	}

	public static void main(String[] args) {

		// input matrix with hurdles shown with number 0
		int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		// find longest path with source (0, 0) and
		// destination (2,9)
		findLongestPath(mat, 0, 0, 2, 9);

	}

}
