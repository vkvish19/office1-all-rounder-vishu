package vishu.personal.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerUsingBlockingQueue {
	public static void main(String [] args) throws Exception{
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingDeque<>();
		
		Producer produce = new Producer(sharedQueue);
		Consumer consume = new Consumer(sharedQueue);
		
		produce.start();
		consume.start();
	}
}

class Producer extends Thread{
	private BlockingQueue<Integer> queue;
	
	public Producer(BlockingQueue<Integer> queue){
		super("PRODUCER ");
		this.queue = queue;
	}
	
	public void run(){
		
		for(int i=0; i<10; i++){
			try{
				System.out.println(getName() +"produced #" +i);
				queue.put(i);
				Thread.sleep(1000);
			}
			catch(InterruptedException iex){
				iex.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread{
	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue){
		super("CONSUMER ");
		this.queue = queue;
	}
	
	public void run(){
		while(true){
			try{
				int value = queue.take();
				System.out.println(getName() +"consumed #" +value);
				Thread.sleep(1000);
			}
			catch(InterruptedException iex){
				iex.printStackTrace();
			}
		}
	}
}