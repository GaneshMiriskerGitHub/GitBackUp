package packagee12_Greedy;

public class P5_Indian_Coins {
	
	public static void noOfCoins(int[] coins, int V) {
		
		int coinsCount = 0;
		int capacity = V;
		for(int i=coins.length-1;i>=0;i--) {
			if(coins[i] <= capacity) {
				capacity = capacity - coins[i];
				coinsCount++;
				System.out.println(coins[i]);
			}
		}
		
		System.out.println("no of coins "+ coinsCount);
	}

	public static void main(String[] args) {
		
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
		
		int V = 121;
		
		noOfCoins(coins, V);
		

	}

}
