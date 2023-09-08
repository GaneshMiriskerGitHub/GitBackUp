package packagee13_Greedy;

public class A1_Maximum_Balanced_Substring {
	
	public static int balancedPartition(String str, int n) {
		
		int rCount = 0;
		int lCount = 0;
		int ans = 0;
		for(int i=0;i<n;i++) {
			if(str.charAt(i) == 'R') {
				rCount++;
			}else if(str.charAt(i) == 'L') {
				lCount++;
			}
			
			if(rCount == lCount) {
				ans++;
			}
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		String str = "LLRRRLLRRL";
		int n = str.length();
		
		System.out.println(balancedPartition(str, n));

	}

}
