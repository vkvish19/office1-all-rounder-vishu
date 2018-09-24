package vishu.personal.practice;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		 System.out.print("ENTER value for N: ");
		 int n = sc.nextInt();
		 sc.close();
		 
		 System.out.println("FIBONACCI SERIES TILL " +n +" in ITERATIVE way:");
		 fibonacciIterative(n);
		 
		 System.out.println("\nFIBONACCI Nth Value Iterative Way: " +fibonacciNthIterative(n));
		 System.out.println("FIBONACCI Nth Value Recursive Way: " +fibonacciNthRecursive(n));
	}
	
	public static void fibonacciIterative(int n){
		long f0 = 0;
		long f1 = 1;
		if(n == 0){
			print(n);
		}
		else if(n == 1){
			print(0);
			print(1);
		}
		else{
			print(0);
			print(1);
			long tmp = 3;
			while (tmp <= n){
				long r = f0 + f1;
				f0 = f1;
				f1 = r;
				print(r);
				tmp++;
			}
		}
	}
	
	public static long fibonacciNthIterative(int n){
		long f0 = 0;
		long f1 = 1;
		if(n == 1){
			return f0;
		}
		else if(n == 2){
			return f1;
		}
		else{
			int tmp = 3;
			long r=1;
			while (tmp <= n){
				r = f0 + f1;
				f0 = f1;
				f1 = r;
//				print(r);
				tmp++;
			}
			return r;
		}
	}
	
	public static long fibonacciNthRecursive(int n){
		if(n == 1){
			return 0;
		}
		if(n == 2){
			return 1;
		}
		else{
			return fibonacciNthRecursive(n-1) + fibonacciNthRecursive(n-2);
		}
	}
	
	public static void print(long i){
		System.out.print(i +" ");
	}

}
