package Type1_Fibbonacci;

public class P4_Minimum_Jumps_to_reach_end {
	
//	public static int minJumps(int[] arr, int n) {
//		if(n==0) return -1;
//		if(n==1) return 0;
//		if(n==2) {
//			if(arr[1]>arr[0]) {
//				return 
//			}
//		}
//		
//		
//	}
	
	public static boolean isReachable(int[] arr) {
		
		int goal = arr.length-1;
		
		for(int i=arr.length-2;i>=0;i--) {
			if( arr[i]+i >= goal) {
				goal = i;
			}
		}
		
		return goal == 0;
	}
	
	public static int minPathCount(int[] arr) {
		int l=0;
		int r=0;
		int res = 0;
		int farthest=0;
		
		while(r<arr.length-1) {
			for(int i=l;i<=r;i++) farthest = Math.max(farthest, arr[i]+i);
			l = r+1;
			r = farthest;
			res++;
		}
		return res;
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 1, 1, 4};
		
		System.out.println(isReachable(arr));
		System.out.println(minPathCount(arr));
	}

}
