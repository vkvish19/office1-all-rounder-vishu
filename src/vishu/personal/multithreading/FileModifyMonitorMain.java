package vishu.personal.multithreading;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class FileModifyMonitorMain {
	public static void main(String...args) throws Exception{
		TimerTask task = new FileModifyMonitor( new File("C:\\Users\\vishwanath_k03\\workspace\\AllRounderVishu\\textfiles\\TimerTaskTestFile.txt") ) {
		      protected void onChange( File file ) {
		          // here we code the action on a change
		          System.out.println( "File "+ file.getName() +" have change !" );
		          try{
			          Scanner sc = new Scanner(file);
			          if(!sc.hasNextLine()){
							System.out.println("THE FILE IS EMPTY!!!");
						}
						while(sc.hasNextLine()){
							System.out.println(sc.nextLine());
						}
						sc.close();
		          }
		          catch(Exception ex){
		        	  System.out.println(ex.getMessage());
		          }
		        }
		      };

		      Timer timer = new Timer();
		      // repeat the check every second
		      timer.schedule( task , new Date(), 1000 );
		
	}
}
