package package8_BackTracking;

public class P2_Finding_Subsets {
	
	public static void printAllSubsets(String str, String ans, int i) { //  O(2^n) because for given string of length n, no.of possible subsets that can be formed are 2^n  
		
		if(i == str.length()) {
			System.out.println(ans);
			return;
		}
		
		printAllSubsets(str, ans+str.charAt(i), i+1);
		
		printAllSubsets(str, ans, i+1);
	}

	public static void main(String[] args) {
		
		String str = "abc";
		
		String ans = "";
		
		printAllSubsets(str, ans, 0);

	}

}
