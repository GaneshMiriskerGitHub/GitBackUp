package package2_strings;

import java.util.HashMap;
import java.util.Map;

public class PP15_Smallest_window_substring {

	public static String leetcode(String s, String t) {
		if (t == "") {
			return "";
		}

		Map<Character, Integer> countT = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {
			char t_char = t.charAt(i);
			countT.put(t_char, countT.getOrDefault(t_char, 0) + 1);
		}

		int l = 0;
		int r = 0;
		int have = 0;
		int need = countT.size();
		int[] res = { -1, -1 };
		int min_len = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			r = i;
			char ch = s.charAt(r);
			window.put(ch, window.getOrDefault(ch, 0) + 1);

			if (countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))) {
				have++;
			}

			while (have == need) {
				if (r - l + 1 < min_len) {
					min_len = r - l + 1;
					res[0] = l;
					res[1] = r;
				}
				char lc = s.charAt(l);
				window.put(lc, window.getOrDefault(lc, 0) - 1);
				if (countT.containsKey(lc) && window.get(lc) < countT.get(lc)) {
					have--;
				}
				l++;
			}
			
		}
		int left = res[0];
		int right = res[1];

		if (min_len != Integer.MAX_VALUE) {
			return s.substring(left, right + 1);
		} else {
			return "";
		}
	}

	public static String smallestWindow(String s, String p)
    {
        String ans = "";
        
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> countP = new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            countP.put(ch, countP.getOrDefault(ch, 0)+1);
        }
        
        int have = 0;
        int need = countP.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            r = i;
            char ch = s.charAt(r);
            
            window.put(ch, window.getOrDefault(ch, 0)+1);
            
            if(countP.containsKey(ch)){
                if(window.get(ch).equals(countP.get(ch))){
                    have++;
                }
            }
            
            while(have == need){
                if(r-l+1 < resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char l_char = s.charAt(l);
                window.put(l_char, window.getOrDefault(l_char, 0)-1);
                if(countP.containsKey(l_char) && window.get(l_char) < countP.get(l_char)){
                    have--;
                }
                l++;
            }
            
        }
        
        if(resLen != Integer.MAX_VALUE){
            return s.substring(res[0], res[1]+1);
        }else{
            return "-1";
        }
    }

	public static void main(String[] args) {

		String s = "timetopractice";
		String t = "toc";

		System.out.println(leetcode(s, t));
		System.out.println(smallestWindow(s, t));

	}
}
