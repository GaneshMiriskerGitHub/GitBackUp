package packagee12_Greedy;

import java.util.Arrays;
import java.util.Collections;

public class P7_Chocola_Problem {

	public static void main(String[] args) {
		
		Integer[] horizontalCuts = {4, 3, 2, 1, 1};
		Integer[] verticalCuts   = {4, 2, 1};
		
		// sorting must be done : descending order
		Arrays.sort(horizontalCuts, Collections.reverseOrder());
		Arrays.sort(verticalCuts, Collections.reverseOrder());
		
		int hp = 1;
		int vp = 1;
		int i = 0;
		int j = 0;
		int totalCost = 0;
		while(i <= horizontalCuts.length-1 && j <= verticalCuts.length-1) {
			if(horizontalCuts[i] > verticalCuts[j]) {
				totalCost+=horizontalCuts[i]*vp;
				i++;
				hp++;
			}else {
				totalCost+=verticalCuts[j]*hp;
				j++;
				vp++;
			}
		}
		
		while(i <= horizontalCuts.length-1) {
			
			totalCost+=horizontalCuts[i]*vp;
				i++;
				hp++;
			
		}
		
		while(j <= verticalCuts.length-1) {
			
			totalCost+=verticalCuts[j]*hp;
				j++;
				vp++;
			
		}
		
		System.out.println(totalCost);

	}

}
