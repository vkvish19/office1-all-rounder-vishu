package vishu.personal.practice;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class RetrieveIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(final DatagramSocket socket = new DatagramSocket()){
			  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			  String ip = socket.getLocalAddress().getHostAddress();
			  
			  System.out.println("IP:= " +ip);
			}
		catch(Exception e){
			System.out.println("inside exception block");
			e.printStackTrace();
		}
	}

}
