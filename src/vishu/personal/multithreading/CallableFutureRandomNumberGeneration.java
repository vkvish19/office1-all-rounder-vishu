package vishu.personal.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableFutureRandomNumberGeneration {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception{
		Random r = new Random();
		FutureTask[] ft = new FutureTask[6];
		for(int i=0; i<6; i++){
			Callable c = new MyCallableFutureRandomNumberGeneration(r.nextInt(6));
			ft[i] = new FutureTask(c);
			Thread t = new Thread(ft[i]);
			t.start();
		}
		
		for(int i=0; i<6; i++){
			System.out.println("ft["+i+"] output= " +ft[i].get() +", isDone():- " +ft[i].isDone() +", isCancelled():- "+ft[i].isCancelled());
		}
	}

}

@SuppressWarnings("rawtypes")
class MyCallableFutureRandomNumberGeneration implements Callable {
	private int num;
	
	@Override
	public Object call() throws Exception{
		Thread.sleep(1000);
		return (Thread.currentThread().getName() +" :: num= " +this.num);
	}
	
	public MyCallableFutureRandomNumberGeneration(int num){
		this.num = num;
	}
}