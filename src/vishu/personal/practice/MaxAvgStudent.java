package vishu.personal.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MaxAvgStudent {

	public static void main(String[] args) {
		String [][] input = {
								{"sam", "90"},
								{"singh", "80"},
								{"sam", "50"},
								{"singh", "70"},
								{"sam", "40"},
							};
		
		Map<String, Integer> sum = new HashMap<String, Integer>();
		Map<String, Integer> count = new HashMap<String, Integer>();
		
		int length = input.length;
		
		for(int i=0; i<length; i++) {
			if(sum.containsKey(input[i][0])){
				sum.put(input[i][0], sum.get(input[i][0]) + Integer.parseInt(input[i][1]) );
				count.put(input[i][0], count.get(input[i][0]) + 1);
			}
			else{
				sum.put(input[i][0], Integer.parseInt(input[i][1]) );
				count.put(input[i][0], 1);
			}
		}
		
		double maxAvg = Integer.MIN_VALUE;
		String avgName = "";
//		List<String> avgNames = new ArrayList<>(); 
		// get the average
		for (String name: sum.keySet()){
			double temp = (sum.get(name) / count.get(name));
			if( temp > maxAvg) {
				maxAvg  = temp;
				avgName = name;
			}
		}
		
		System.out.println("Max Avg ::\nName: " +avgName +", MaxAvg Value: " +maxAvg);

	}

}
