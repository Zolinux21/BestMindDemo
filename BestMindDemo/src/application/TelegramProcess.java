package application;

public class TelegramProcess {
	public static String run(String Telegram) {
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
