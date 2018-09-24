package vishu.personal.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableFutureFactorialCalculator {
	
	public static void main(String... args){
		ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> list = new ArrayList<>();
		Random r = new Random();
		for(int i=0; i<4; i++){
			Integer in = r.nextInt(10);
			Callable<Integer> c = new FactorialCalculator(in);
			Future<Integer> fu = ex.submit(c);
			list.add(fu);
		}
		
		for(Future<Integer> f: list){
			try{
				System.out.println("Future result is :- " +f.get() +"; and isDone() :- " +f.isDone());
			}
			catch(InterruptedException | ExecutionException e){
				e.printStackTrace();
			}
		}
		ex.shutdown();
	}
}

class FactorialCalculator implements Callable<Integer> {
	private int number;
	
	public FactorialCalculator(int number){
		this.number = number;
	}
	
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if(number == 0 || number == 1){
			return 1;
		}
		
		for(int i=2; i<=number; i++){
			result *= i;
			Thread.sleep(200);
		}
		
		System.out.println("Factorial of number '" +number +"' is:- " +result);
		
		return result;
	}
}
