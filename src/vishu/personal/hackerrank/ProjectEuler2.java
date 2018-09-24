package vishu.personal.hackerrank;

import java.util.*;

public class ProjectEuler2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long x = 0;
            long y = 1;
            long sum = 0;
            long evenSum = 0;
            while(sum < n){
            	if(x+y > n){
            		break;
            	}
                sum = x + y;
                x = y;
                if(sum%2 == 0){
                    evenSum += sum;
                }
                y = sum;
            }
            System.out.println(evenSum);
        }
        
        
        
        in.close();
    }
}