package vishu.personal.multithreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TimerTask;

public class FileReaderTimerTask extends TimerTask{
	private static int count = 1;
	
	public static int getCount() {
		return count;
	}

	@Override
	public void run() {
		try{
			File file = new File("C:\\Users\\vishwanath_k03\\workspace\\AllRounderVishu\\textfiles\\TimerTaskTestFile.txt");
			Scanner sc = new Scanner(file);
			System.out.println("Executing " +this.getClass().getName() +" for:- " +count++ +" time.");
			if(!sc.hasNextLine()){
				System.out.println("THE FILE IS EMPTY!!!");
			}
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
}
