package package8_BackTracking;

public class P3_Finding_Permutations {
	
	public static void findAllPermutations(String str, String ans) {
		
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			String newStr = str.substring(0,i)+str.substring(i+1);
			findAllPermutations(newStr, ans+ch);
		}
	}

	public static void main(String[] args) {
		
		String str = "abc";
		
		String ans = "";
		
		findAllPermutations(str, ans);

	}

}
