package package5_BackTracking;

import java.util.HashSet;
import java.util.Stack;

public class PP10_Remove_Invalid_Paranthesis { // https://www.youtube.com/watch?v=Cbbf5qe5stw

	public static int getMin(String str) {
		
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch == '(') {
				st.push(ch);
			} else if(ch == ')') {
				if(st.size() == 0) {
					st.push(ch);
				}else if(st.peek() == ')') {
					st.push(ch);
				}else if(st.peek() == '(') {
					st.pop();
				}
			}
			
		}

		return st.size();
	}

	public static void solutions(String str, int mra, HashSet<String> ans) {

		if (mra == 0) {
			int mrnow = getMin(str);
			if (mrnow == 0) {
				if (!ans.contains(str)) {
					System.out.println(str);
					ans.add(str);
				}
			}
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			solutions(left + right, mra - 1, ans);
		}
	}

	public static void main(String[] args) {

		String str = "(()()";

		int mra = getMin(str);
		HashSet<String> set = new HashSet<>();
		solutions(str, mra, set);

	}

}
