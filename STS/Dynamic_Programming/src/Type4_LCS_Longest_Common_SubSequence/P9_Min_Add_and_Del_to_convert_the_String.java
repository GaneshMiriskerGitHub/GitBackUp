package Type4_LCS_Longest_Common_SubSequence;

/*
 * we know how to calculate min operations for string convertions, 
 * now the output is to be :- print the min del operations and add operations
 */
public class P9_Min_Add_and_Del_to_convert_the_String {  // explanation :- https://www.youtube.com/watch?v=yMnH0jrir0Q 
	
	public static int lcs(String str1, String str2) {
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					int include = 1+dp[i-1][j-1];
					dp[i][j] = include;
				}else {
					int choice1 = dp[i-1][j];
					int choice2 = dp[i][j-1];
					dp[i][j] = Math.max(choice1, choice2);
				}
			}
		}
		
		return dp[str1.length()][str2.length()];
		
	}
	
	public static void main(String[] args) {
		
		String str1 = "abcd";
		String str2 = "anc";
		
		int lcsLength = lcs(str1, str2);
		
		System.out.println("min delete operations = "+(str1.length()-lcsLength));
		System.out.println("min add operations = "+ (str2.length()-lcsLength));
	}

}
