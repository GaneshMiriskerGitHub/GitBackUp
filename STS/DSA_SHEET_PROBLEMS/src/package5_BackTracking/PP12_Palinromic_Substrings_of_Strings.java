package package5_BackTracking;

public class PP12_Palinromic_Substrings_of_Strings { // https://www.youtube.com/watch?v=wvaYrOp94k0

	public static boolean isPalingdrome(String str) {
		int s=0;
		int e = str.length()-1;
		
		while(s<=e) {
			if(str.charAt(s) != str.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}
		
		return true;
	}
	
	public static void solutions(String str, String ansSoFar) {
		
		if(str.length() == 0) {
			System.out.println(ansSoFar);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			String prefix = str.substring(0,i+1);
			String rest_of_string = str.substring(i+1);
			if(isPalingdrome(prefix)) {
				solutions(rest_of_string, ansSoFar+'('+prefix+')');
			}
		}
		
	}

	public static void main(String[] args) {
		
		String str = "bcc";
		
		solutions(str, "");

	}

}
