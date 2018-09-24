package vishu.personal.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class Practice{
	Object obj = new Object();
	AtomicInteger ai = new AtomicInteger(1);
	
	public static void main(String[] args) {
		Practice p = new Practice();
		Thread t1 = new Thread(p.new Printer(0, 3));
		Thread t2 = new Thread(p.new Printer(1, 3));
		Thread t3 = new Thread(p.new Printer(2, 3));
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	private class Printer implements Runnable{
		int threadNum;
		int numberOfThreads;
		
		Printer(int threadNum, int numberOfThreads){
			this.threadNum = threadNum;
			this.numberOfThreads = numberOfThreads;
		}
		
		@Override
		public void run(){
			print();
		}
		
		public void print(){
			try{
				while(true){
					Thread.sleep(1000L);
					synchronized(obj){
						if( ai.get()%this.numberOfThreads != this.threadNum){
							obj.wait();
						}
						else{
							System.out.println("Thread-" +this.threadNum +" ----> " +ai.getAndIncrement());
							obj.notifyAll();
						}
					}
				}
			}
			catch(InterruptedException iex){
				iex.printStackTrace();
			}
		}
	}
}