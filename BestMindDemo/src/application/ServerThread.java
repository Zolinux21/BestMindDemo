package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
 
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
 
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
 
 
            String Telegram;
            String Response;
            
 
            do {
            	Telegram = reader.readLine();
            	System.out.println("Telegram read");
            	if(!Telegram.equals(null)) {
            		System.out.println("Start Response");
            		Response = TelegramProcess.run(Telegram);
            		writer.println(Response);
            	}

                
            } while (Telegram.equals(null));
 
            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
            try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    

    private String TelegramProcesss(String Telegram) {
    	String response = "";
    	String[] data = Telegram.split("&");
    	String[] ReadValues = data[0].split("#");
    	String[] WriteValues = data[1].split("#");
        
    	//Write
    	for(int i = 0; i < WriteValues.length; i++) {
    		String[] Split = WriteValues[i].split("=");
    		String Var = Split[0];
    		String Value = Split[1];
    		switch(Var) {
    		case "helpImage":
    			GlobalVars.helpImage = Integer.parseInt(Value);
    			break;
    		case "helpText":
    			GlobalVars.helpText = Value;
    			break;
    		}
    	}
    	//Read
    	for(int i = 0; i < ReadValues.length; i++) {
    		switch(ReadValues[i]) {
    		case "gameTime":
    			response = response + Integer.toString(GlobalVars.gameTime) + "#";
    			break;
    		case "status":
    			response = response + Integer.toString(GlobalVars.status) + "#";
    			break;
    		}
    	}
        
        return response;
    }
    
    
}