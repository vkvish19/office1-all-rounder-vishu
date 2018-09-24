package vishu.personal.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

	public static void main(String [] args) throws Exception {
		PrintNumber pn = new PrintNumber();
		
		Thread t1 = new Thread(pn, "t1");
		t1.start();
		Thread t2 = new Thread(pn, "t2");
		t2.start();
		
		t1.join();
		t2.join();
		
//		System.out.println("Counter:- " +pn.getCounter());
	}
}

class PrintNumber implements Runnable{
	private AtomicInteger counter = new AtomicInteger();
	
	public int getCounter() {
		return this.counter.get();
	}
	
	@Override
	public void run() {
		for(int i=1; i<101; i++){
			gotoSleep(i);
			System.out.println("Thread Counter: " +this.counter.incrementAndGet());
//			counter.incrementAndGet();
		}
	}
	
	public void gotoSleep(int i) {
		try{
			Thread.sleep(i * 50);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
