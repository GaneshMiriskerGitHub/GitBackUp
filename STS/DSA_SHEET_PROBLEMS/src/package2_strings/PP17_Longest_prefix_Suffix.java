package package2_strings;

public class PP17_Longest_prefix_Suffix {
	
	// 1. Solved on leetcode - hard question
	// Resources :-
	// 1. youtube:- https://www.youtube.com/watch?v=V5-7GzOfADQ
	// 2. youtube:- https://www.youtube.com/watch?v=3_iycwSZvKo
	// 3. Leetcode:- submissions, below code only 

	
	public static String longesPrefixSufix(String s) {   // O(n+m)
        int n = s.length();

        int i = 1;
        int len = 0;
        int[] lps = new int[n];
        lps[0] = 0;

        while(i < n){
            if(s.charAt(len) == s.charAt(i)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return s.substring(0, lps[n-1]);
	}
	

	public static void main(String[] args) {
		
		String s = "abab";
		
		System.out.println(longesPrefixSufix(s));

	}

}
