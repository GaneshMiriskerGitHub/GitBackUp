package package2_strings;

// https://www.youtube.com/watch?v=6RhKLjeX568

public class PP19_String_Transformation {
	
	public static int transform(String A, String B) {
		int n = A.length();
		int m = B.length();
		
		int count = 0;
		
		if(n != m) {
			return -1;
		}
		
		int nVal = 0;
		for(int i=0;i<n;i++) {
			nVal += A.charAt(i);
		}
		int mVal = 0;
		for(int i=0;i<m;i++) {
			mVal += B.charAt(i);
		}
		
		if(nVal != mVal) {
			return -1;
		}
		
		int i = n-1;
		int j = m-1;
		while(i>=0 && j>= 0) {
			if(A.charAt(i) == B.charAt(j)) {
				i--;
				j--;
			}else {
				count++;
				i--;
			}
		}
		
		return count;
		
	}

	public static void main(String[] args) {
		
		String A = "EACBD";
        String B = "EABCD";
 
        System.out.println(
            "Minimum number of operations required is "
            + transform(A, B));

	}

}
