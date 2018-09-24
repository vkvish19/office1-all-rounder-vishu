package vishu.personal.multithreading;

public class AlphaNumericSequentialPrinter {
	static AlphaNumericSequentialPrinter ansp = new AlphaNumericSequentialPrinter();
	Object obj = new Object();
	
	public static void main(String[] args) throws Exception{
		PrintCharacter pc = ansp.new PrintCharacter();
		PrintNumber pn = ansp.new PrintNumber();
		Thread t1 = new Thread(pc);
		Thread t2 = new Thread(pn);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("\nFINISHED PRINTING ALL");
	}
	
	class PrintCharacter implements Runnable {
		public void run(){
			for(char i='a'; i<='z'; i++){
				ansp.printChar(i);
			}
		}
	}
	
	class PrintNumber implements Runnable {
		public void run(){
			for(int i=1; i<=26; i++){
				ansp.printNum(i);
			}
		}
	}
	
	private boolean isChar = true;
		
	public void printChar(char p){
		try{
			while(true){
				Thread.sleep(1000L);
				synchronized(obj){
					if(isChar){
						System.out.print(p +", ");
						isChar = false;
						obj.notifyAll();
						return;
					}
					else{
						obj.wait();
					}
				}
			}
		}
		catch(InterruptedException iex){
			iex.printStackTrace();
		}
	}
	
	public void printNum(int p){
		try{
			while(true){
				Thread.sleep(1000L);
				synchronized(obj){
					if(!isChar){
						System.out.print(p +", ");
						isChar = true;
						obj.notifyAll();
						return;
					}
					else{
						obj.wait();
					}
				}
			}
		}
		catch(InterruptedException iex){
			iex.printStackTrace();
		}
	}
}
