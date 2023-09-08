package package8_BackTracking;

public class A2_Keypad_Combinations {
	
	static final char[][] L = {{},
								{},
								{'a','b','c'},
								{'d','e','f',},
								{'g', 'h', 'i'},
								{'j','k','l'},
								{'m','n','o'},
								{'p','q','r','s'},
								{'t','u','v'},
								{'w','x','y','z'}};
	
	public static void printLetterCombinations(String numStr) {
		int len = numStr.length();  // length of each output should be
		
		if(len == 0) {
			System.out.println(" ");
			return;
		}
		
		bfs(numStr, len, new StringBuilder(), 0);
	}
	
	public static void bfs(String numStr, int len, StringBuilder sb, int pos) {
		
		if(pos == len) {
			System.out.println(sb.toString());
			return;
		}else {
			char[] letters = L[Character.getNumericValue(numStr.charAt(pos))];
			for(int i=0;i<letters.length;i++) {
				bfs(numStr, len, new StringBuilder(sb).append(letters[i]), pos+1);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printLetterCombinations("23");

	}

}
