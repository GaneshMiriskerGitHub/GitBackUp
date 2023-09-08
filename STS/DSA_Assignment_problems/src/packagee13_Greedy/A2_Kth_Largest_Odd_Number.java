package packagee13_Greedy;

public class A2_Kth_Largest_Odd_Number {

	public static void main(String[] args) {
		
		int L = -9;
		int R = 9;
		int K=8;  // find kth largest odd number
		
		int nth = 1;
		for(int i=R;i>=L;i--) {
			if(i % 2 != 0) {
				if(nth == K) {
					System.out.println(i);
					break;
				}
				nth++;
			}
		}
	}

}
