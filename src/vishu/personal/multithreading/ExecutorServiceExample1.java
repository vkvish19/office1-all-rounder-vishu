package vishu.personal.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample1 {
	public static void main(String... args){
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		for(int i=0; i<10; i++){
			Runnable r = new WorkerThread("" +i);
			es.execute(r);
		}
		es.shutdown();
		while(!es.isTerminated()){
			// this is to wait till all threads are executed
		}
		System.out.println("Finished all Threads...");
	}
}

class WorkerThread implements Runnable{
	private String command;
	
	public WorkerThread(String s){
		this.command = s;
	}
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName() +" Started. Thread Num= " +this.command);
		processCommand();
		System.out.println(Thread.currentThread().getName() +" Finished.");
	}
	
	private void processCommand(){
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException iex){
			System.out.println(Thread.currentThread().getName() +" incurred InterruptedException...");
		}
	}
	
	@Override
	public String toString(){
		return this.command;
	}
}