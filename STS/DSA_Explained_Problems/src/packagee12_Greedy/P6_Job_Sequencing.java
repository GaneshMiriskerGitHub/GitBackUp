package packagee12_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utility_package.HelperClass;

public class P6_Job_Sequencing {
	
	static class Jobs  {
		int deadLine;
		int profit;
		
		public Jobs(int deadLine, int profit) {
			this.deadLine = deadLine;
			this.profit = profit;
		}
	}
	
	public static void maxProfitColletionsSortByTakingAClassToSort(int[][] jobsInfo) {
		
		List<Jobs> list = new ArrayList<>();
		for(int i=0;i<jobsInfo.length;i++) {
			list.add(new Jobs(jobsInfo[i][0], jobsInfo[i][1]));
		}
		
		Collections.sort(list, (a, b) -> b.profit-a.profit);
		
		int maxProfit = 0;
		int time = 0;
		for(int i=0;i<jobsInfo.length;i++) {
			if(list.get(i).deadLine > time) {
				maxProfit+=list.get(i).profit;
				time++;
			}
		}
		
		System.out.println("maximum profit is : "+maxProfit);
		
	}

	public static void maxProfitArraySortMethod(int[][] jobsInfo) {
		Arrays.sort(jobsInfo, Comparator.comparingDouble(o -> o[1]));

		HelperClass.printArray(jobsInfo);

		int maxProfit = 0;
		int time = 0;
		for (int i = jobsInfo.length - 1; i >= 0; i--) {
			if (jobsInfo[i][0] > time) {
				System.out.print("A" + i);
				System.out.print(" ");
				maxProfit += jobsInfo[i][1];
				time++;
			}
		}
		System.out.println();
		System.out.println("maximum profit is : "+maxProfit);
	}

	public static void main(String[] args) {

		int[][] jobsInfo = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
		
		maxProfitArraySortMethod(jobsInfo);
		
		maxProfitColletionsSortByTakingAClassToSort(jobsInfo);

	}

}
