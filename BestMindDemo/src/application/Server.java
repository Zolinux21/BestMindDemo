package application;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends Thread{
	
	
	static void Start(int Port, String IP) {
		Thread ServerThread = new Thread(new Runnable() {
            public void run() {
            	
       	     try (ServerSocket serverSocket = new ServerSocket(Port, 30, InetAddress.getByName(IP))) {

       	         System.out.println("Server is listening on || IP: "+ IP + " || port: " + Port);

       	         while (true) {
       	             Socket socket = serverSocket.accept();
       	             System.out.println("New client connected");

       	             new ServerThread(socket).start();
       	         }

       	     } catch (IOException ex) {
       	         System.out.println("Server exception: " + ex.getMessage());
       	         ex.printStackTrace();
       	     }
            }		
			});
		ServerThread.setDaemon(true);
		ServerThread.start();
		 
	}
	 
}
