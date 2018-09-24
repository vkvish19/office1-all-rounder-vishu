package vishu.personal.multithreading;

import java.io.File;
import java.util.TimerTask;

public abstract class FileModifyMonitor extends TimerTask {
	private static int count = 1;
	
	public static int getCount() {
		return count;
	}
	private long timeStamp;
	private File file;
	
	public FileModifyMonitor(File file) {
		this.file = file;
		this.timeStamp = file.lastModified();
	}
	@Override
	public void run() {
		System.out.println(this.getClass().getSimpleName() +" running for:- " +count++ +" time...");
		long currentTimeStamp = file.lastModified();
		if(this.timeStamp != currentTimeStamp){
			System.out.println("FileTIMESTAMP:- " +this.timeStamp +" :: currentTIMESTAMP:- " +currentTimeStamp);
			this.timeStamp = currentTimeStamp;
			onChange(file);
		}
	}
	
	protected abstract void onChange( File file );
	
}
