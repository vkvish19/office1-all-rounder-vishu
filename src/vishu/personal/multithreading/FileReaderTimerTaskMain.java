package vishu.personal.multithreading;

import java.util.Timer;


public class FileReaderTimerTaskMain {

	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.schedule(new FileReaderTimerTask(), 0, 30000);
		
		
	}

}
