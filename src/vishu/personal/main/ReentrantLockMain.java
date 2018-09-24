package vishu.personal.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import vishu.personal.multithreading.ReentrantLockWorker;

public class ReentrantLockMain {

	static final int MAX_THREADS = 2;
	public static void main(String[] args) {
		ReentrantLock rel = new ReentrantLock();
		ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);
		Runnable w1 = new ReentrantLockWorker("job1", rel);
		Runnable w2 = new ReentrantLockWorker("job2", rel);
		Runnable w3 = new ReentrantLockWorker("job3", rel);
		Runnable w4 = new ReentrantLockWorker("job4", rel);
		
		pool.submit(w1);
		pool.submit(w2);
		pool.submit(w3);
		pool.submit(w4);
		
		pool.shutdown();
	}

}
