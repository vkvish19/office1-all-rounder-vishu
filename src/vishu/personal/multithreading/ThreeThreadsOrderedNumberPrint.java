package vishu.personal.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadsOrderedNumberPrint {
	private AtomicInteger sharedNumber = new AtomicInteger(0);
	private Object obj = new Object();
	
	public static void main(String [] args) throws Exception {
		ThreeThreadsOrderedNumberPrint t = new ThreeThreadsOrderedNumberPrint();
		
		PrintNumber pn1 = t.new PrintNumber(0);
		PrintNumber pn2 = t.new PrintNumber(1);
		PrintNumber pn3 = t.new PrintNumber(2);
		
		Thread t1 = new Thread(pn1);
		Thread t2 = new Thread(pn2);
		Thread t3 = new Thread(pn3);
		
		t1.setName("THREAD-1");
		t1.setName("THREAD-2");
		t1.setName("THREAD-3");
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		System.out.println("ALL THREADS COMPLETED");
	}
	
	private class PrintNumber implements Runnable {
		private final int index;
		public PrintNumber(int i){
			super();
			this.index = i;
		}
		@Override
		public void run(){
			while(sharedNumber.get() < 100) {
				synchronized(obj) {
					if(sharedNumber.get() % 3 == this.index){
						if(sharedNumber.get() < 100){
							System.out.println(Thread.currentThread() +" " +sharedNumber.incrementAndGet());
						}
					}
				}
			}
		}
	}
}
