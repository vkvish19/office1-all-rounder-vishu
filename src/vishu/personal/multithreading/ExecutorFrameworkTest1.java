package vishu.personal.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameworkTest1 {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		int numberOfVishuThreads = 5;
		for(int i=1; i<=numberOfVishuThreads; i++){
			VishuExecutorFrameworkTest1 v = new VishuExecutorFrameworkTest1("vishu: " +i);
			es.execute(v);
		}
		
		es.shutdown();
		while(!es.isTerminated()){
//			System.out.println("******NOT YET TERMINATED******");
		}
		System.out.println("*****************TERMINATED*****************");

	}

}

class VishuExecutorFrameworkTest1 implements Runnable {
	private String name;
	public VishuExecutorFrameworkTest1(String name) {
		this.name = name;
	}
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName() +" (start) " +name);
		try{
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() +" (start) " +name +" (WOKE UP)");
		}
		catch(InterruptedException iex){
			System.out.println("Interrupted Exception");
			System.out.println(iex.getMessage());
		}
		System.out.println(Thread.currentThread().getName() +" (end) " +name);
	}
}