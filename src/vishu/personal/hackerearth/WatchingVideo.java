package vishu.personal.hackerearth;

import java.util.*;

public class WatchingVideo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int [] dpps = new int[N];
		int c = 0;
		long totalKb = 0;
		long canWatch = 0;
		int count = 0;
		for(int i=0; i<N; i++) {
			dpps[i] = sc.nextInt();
			totalKb += dpps[i];
			canWatch = totalKb/d;
			if(canWatch != 0){
				count++;
				canWatch = 0;
				totalKb = 0;
			}
			else{
				c++;
			}
		}
		System.out.println(count+1);
		sc.close();

	}

}
