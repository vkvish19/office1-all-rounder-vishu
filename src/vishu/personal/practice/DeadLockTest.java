package vishu.personal.practice;

public class DeadLockTest {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	public static void main(String[] args) {
		DeadLockThreadDemo1 dl1 = new DeadLockThreadDemo1();
		DeadLockThreadDemo2 dl2 = new DeadLockThreadDemo2();
		dl1.start();
		dl2.start();
	}

	private static class DeadLockThreadDemo1 extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1:: Holding lock1...");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ex){
					
				}
				System.out.println("Thread 1:: Waiting for lock2...");
				
				synchronized (lock2) {
					System.out.println("Thread 1:: Holding lock1 & lock2...");
				}
			}
		}
	}

	private static class DeadLockThreadDemo2 extends Thread {
		@Override
		public void run() {
			//if you change the lock1 & lock2 positions here then the deadlock can be prevented.
			synchronized (lock2) {
				System.out.println("Thread 2:: Holding lock2...");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ex){
					
				}
				System.out.println("Thread 2:: Waiting for lock1...");
				synchronized (lock1) {
					System.out.println("Thread 2:: Holding lock1 & lock2...");
				}
			}
		}
	}

}

