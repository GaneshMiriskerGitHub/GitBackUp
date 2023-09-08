package package8_BackTracking;

public class P7_Grid_ways_simple_math_trick {
	
	/*
	 * 
	 *    (n-1+m+1)!  /   (n-1)!(m-1)!
	 * 
	 * 
	 */
	
	public static int gridWays(int i, int j, int n, int m) {
		
		return factorial(n-1+m-1) / (factorial(n-1)*factorial(m-1));
		
	}
	
	public static int factorial(int n) {
		int prod = 1;
		for(int i=1;i<=n;i++) {
			prod*=i;
		}
		
		return prod;
	}
	

	public static void main(String[] args) {
		
		int n = 3;
		int m = 3;
		
		System.out.println(gridWays(0,0,n,m));

	}

}
