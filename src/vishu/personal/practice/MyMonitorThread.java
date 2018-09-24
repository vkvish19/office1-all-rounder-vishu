package vishu.personal.practice;

import java.util.concurrent.ThreadPoolExecutor;

public class MyMonitorThread implements Runnable{
	private ThreadPoolExecutor executor;
	private int seconds;
	private boolean run = true;
	
	public MyMonitorThread(ThreadPoolExecutor executor, int delay) {
		this.executor = executor;
		this.seconds = delay;
	}
	
	public void shutDown(){
		this.run=false;
	}
	@Override
	public void run() {
		while(run){
			System.out.println(
					String.format("[monitor] [%d/%d] ,Active: %d, Completed: %d, Task: %d, isShutDown: %s, isTerminated: %s",
							this.executor.getPoolSize(),
							this.executor.getCorePoolSize(),
							this.executor.getActiveCount(),
							this.executor.getCompletedTaskCount(),
							this.executor.getTaskCount(),
							this.executor.isShutdown(),
							this.executor.isTerminated())
					);
			try{
				Thread.sleep(seconds * 1000);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		
	}
	
}
