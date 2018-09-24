package vishu.personal.practice;

public class WorkerThread implements Runnable{
	private String command;
	
	WorkerThread(String s){
		this.command = s;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +" Start. Command= " +command);
		processCommand();
		System.out.println(Thread.currentThread().getName() +" End.");
	}
	
	private void processCommand(){
		try{
			Thread.sleep(5000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return this.command;
	}
}
