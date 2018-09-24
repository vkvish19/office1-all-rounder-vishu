package vishu.personal.hackerrank;

import java.util.*;

public class ProjectEuler6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long eachSquare = 0;
            for(int j=1; j<=n; j++){
            	eachSquare += (j*j);
            }
            long whole = ((n*(n+1))/2);
            long wholeSquare = whole * whole;
            System.out.println(Math.abs(wholeSquare-eachSquare));
        }
        
        
        in.close();
    }
}