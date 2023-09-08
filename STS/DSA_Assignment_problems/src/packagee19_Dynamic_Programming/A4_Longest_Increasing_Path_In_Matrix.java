package packagee19_Dynamic_Programming;

import java.util.Arrays;

public class A4_Longest_Increasing_Path_In_Matrix {
	// leetcode link :-
	// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
	// explanation link :- https://www.youtube.com/watch?v=wCc_nd-GiEc
	// java code :- refer mine, but you can also find the java code in neetcode.io

	public static int longestIncreasingPath(int[][] matrix) {

		// Step 1 : initialize the dp array
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row][col];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		// Step 2 : directly go look at the dfs function and then come here to read
		// explanation of this below for loop
		// Step 4 : now do dfs for every single cell in whole matrix
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dp[i][j] == -1) { // if still not calculated then calculate it
					dfs(row, col, matrix, i, j, -1, dp);
				}
			}
		}

		// Step 5 : now that we have our dp[][] cache full ready will all longestPaths
		// stored at every cell,
		// find the cell which has max value and then return the same
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}

		return max;

	}

	// Step 3: logic to perform dfs at each cell,
	public static int dfs(int row, int col, int[][] matrix, int r, int c, int preVal, int[][] dp) {

		// checking the index out of bound and invalid scenarios
		if (r < 0 || c < 0 || r >= row || c >= col || matrix[r][c] <= preVal) {
			return 0;
		}

		// if result is already calculated
		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		// now only valid scenarios are left , so first calculate for all directions
		int down = dfs(row, col, matrix, r + 1, c, matrix[r][c], dp);
		int right = dfs(row, col, matrix, r, c + 1, matrix[r][c], dp);
		int up = dfs(row, col, matrix, r - 1, c, matrix[r][c], dp);
		int left = dfs(row, col, matrix, r, c - 1, matrix[r][c], dp);

		// store the comparative max of one
		int res = 1 + Math.max(Math.max(left, right), Math.max(up, down));

		dp[r][c] = res; // cache it in dp[][]

		return dp[r][c];
	}

	public static void main(String[] args) {

		int mat[][] = { { 1, 2, 3, 4 }, { 2, 2, 3, 4 }, { 3, 2, 3, 4 }, { 4, 5, 6, 7 }, };

		int n = 4, m = 4;
		System.out.println(longestIncreasingPath(mat));

	}

}
