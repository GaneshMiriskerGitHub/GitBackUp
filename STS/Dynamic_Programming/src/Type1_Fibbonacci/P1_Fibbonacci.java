package Type1_Fibbonacci;

public class P1_Fibbonacci {
	
	// normal loop
	public static int nthFibbonacci1(int n) {
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 1;
		}
		int a = 0;
		int b = 1;
		int c = a+b;
		for(int i=2;i<=n;i++) {
			c = a+b;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	// Recursion
	public static int nthFibbonacci2(int n) {
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		
		return nthFibbonacci2(n-1)+nthFibbonacci2(n-2);
		
	}
	
	// memoization
	public static int nthFibbonaacci3(int n, int[] arr) {
		if(n == 0 || n ==1) {
			return n;
		}
		
		if(arr[n] != 0) {
			return arr[n];
		}
		
		arr[n] = nthFibbonaacci3(n-1, arr)+nthFibbonaacci3(n-2, arr);
		
		return arr[n];
	}
	
	// tabulation
	public static int nthFibbonacci4(int n) {
		int[] arr = new int[n+1];
		
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		
		return arr[n];
	}

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(nthFibbonacci1(n)); // 0, 1, 1, 2, 3, 5
		System.out.println(nthFibbonacci2(n));
		System.out.println(nthFibbonaacci3(n, new int[n+1]));
		System.out.println(nthFibbonacci4(n));

	}

}
