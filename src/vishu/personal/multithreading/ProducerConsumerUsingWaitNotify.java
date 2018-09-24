package vishu.personal.multithreading;

import java.util.LinkedList;

public class ProducerConsumerUsingWaitNotify {
	
	public static void main(String [] args) throws InterruptedException{
		final PC pc = new PC();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					pc.produce();
				}
				catch(InterruptedException iex){
					iex.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					pc.consume();
				}
				catch(InterruptedException iex){
					iex.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	public static class PC {
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 4;
		
		public void produce() throws InterruptedException{
			int value = 0;
			while(true){
				synchronized (this) {
					while(list.size() == capacity){
						wait();
					}
					System.out.print("PRODUCER produced #" +value);
					list.add(value++);
					System.out.println(" List Size= " +list.size());
					notify();
					Thread.sleep(1200);
				}
			}
		}
		
		public void consume() throws InterruptedException{
			while(true){
				synchronized (this) {
					while(list.size() == 0){
						wait();
					}
					
					int val = list.removeFirst();
					System.out.println("CONSUMER consumed #" +val +" List Size= " +list.size());
					notify();
					
					Thread.sleep(1800);
				}
			}
		}
	}
}
