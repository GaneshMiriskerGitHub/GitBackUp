package package2_strings;

import java.util.HashMap;
import java.util.Map;

public class PPP20_Minimum_window_Substring {

	public static String smallestWindow(String s, String t) {
		Map<Character, Integer> countT = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			countT.put(ch, countT.getOrDefault(ch, 0) + 1);
		}

		Map<Character, Integer> window = new HashMap<>();

		int have = 0;
		int need = countT.size();
		int l = 0;
		int r = 0;
		int min_len = Integer.MAX_VALUE;
		int[] res = {-1, -1};
		for (int i = 0; i < s.length(); i++) {
			r = i;
			char ch = s.charAt(r);
			window.put(ch, window.getOrDefault(ch, 0) + 1);
			
			if(countT.containsKey(ch)&& countT.get(ch).equals(window.get(ch))) {
				have++;
			}
			
			while(have == need) {
				if(r-l+1 < min_len) {
					min_len = r-l+1;
					res[0] = l;
					res[1] = r;
				}
				char lc = s.charAt(l);
				window.put(lc, window.get(lc)-1);
				if(countT.containsKey(lc) && window.get(lc) < countT.get(lc)) {
					have--;
				}
				l++;
			}
		}
		
		if(min_len == Integer.MAX_VALUE) {
			return "";
		}else {
			return s.substring(res[0], res[1]+1);
		}
	}

	public static void main(String[] args) {

		String s = "timetopractice";
		String t = "toc";

		//System.out.println(leetcode(s, t));
		System.out.println(smallestWindow(s, t));

	}

}
