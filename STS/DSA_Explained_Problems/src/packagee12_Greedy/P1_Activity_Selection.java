package packagee12_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import utility_package.HelperClass;

public class P1_Activity_Selection {
	
	public static void maxActivities(int[] start, int[] end) {
		int[][] activites = new int[start.length][3];
		for(int i=0;i<start.length;i++) {
			activites[i][0] = i;
			activites[i][1] = start[i];
			activites[i][2] = end[i];
		}
		
		Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));
		
		List<String> list = new LinkedList<>();
		
		list.add("A"+activites[0][0]);
		int LastEnd = activites[0][2];
		int counter = 1;
		for(int i=1;i<end.length;i++) {
			if(activites[i][1] >= LastEnd) {
				list.add("A"+activites[i][0]);
				LastEnd = activites[i][2];
				counter++;
			}
		}
		
		System.out.println("maximum activities :- " +counter);
		System.out.println(list);
	}

	public static void main(String[] args) {
		

		
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] end = {2, 4, 6, 7, 9, 9};
		
		maxActivities(start, end);

	}

}
