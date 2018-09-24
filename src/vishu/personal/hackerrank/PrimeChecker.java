package vishu.personal.hackerrank;

import java.io.*;
import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
import java.lang.reflect.*;
import static java.lang.System.in;

class Prime {
    public void checkPrime(int... n1){
        boolean flag = false;
        List<Integer> primes = new ArrayList<>();
        for(int a=0; a<n1.length; a++){
            if(n1[a] > 1){
            	if(n1[a] == 2){
                	primes.add(2);
                }
            	else{
	                for(int i=2; i*i<=n1[a]; i++){
	                    
	                    if(n1[a]%i == 0){
	                        flag = true;
	                        break;
	                    }
	                    else{
	                        flag = false;
	                        continue;
	                    }
	                }
	                if(!flag){
	                	primes.add(n1[a]);
	                }
            	}
                
            }
        }
        for(int x=0; x<primes.size(); x++){
        		System.out.print(primes.get(x) + " ");
        }
        System.out.println();
    }
}

public class PrimeChecker {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}