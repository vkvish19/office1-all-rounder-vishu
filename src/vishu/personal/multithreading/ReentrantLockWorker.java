package vishu.personal.multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWorker implements Runnable{
	String name;
	ReentrantLock re;
	
	public ReentrantLockWorker(String name, ReentrantLock re) {
		this.name = name;
		this.re = re;
	}
	
	@Override
	public void run(){
		boolean done = false;
		while(!done){
			//getting outer lock
			boolean ans = re.tryLock();
			//returns true if lock is Free
			
			if(ans){
				try{
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
					System.out.println("task name: " +name +" acquired Outer lock at: " 
							+sdf.format(date) +" Doing outer work");
					Thread.sleep(1500);
					
					//getting inner lock
					re.lock();
					try{
						date = new Date();
						sdf = new SimpleDateFormat("hh:mm:ss");
						System.out.println("task name: " +name +" acquired Inner lock at: " 
								+sdf.format(date) +" Doing inner work");
						System.out.println("Lock hold count: " +re.getHoldCount());
						Thread.sleep(1500);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally{
						//inner lock release
						System.out.println("task name: " +name + " releasing Inner lock");
						re.unlock();
					}
					System.out.println("Lock hold count: " +re.getHoldCount());
					System.out.println("task name: " +name +" work done...");
					
					done = true;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					//releasing outer lock
					System.out.println("task name: " +name +" releasing outer lock");
					re.unlock();
					System.out.println("Lock hold count: " +re.getHoldCount());
				}
			}
			else{
				System.out.println("task name: " +name +" waiting for the lock...");
				try{
					Thread.sleep(1000);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
