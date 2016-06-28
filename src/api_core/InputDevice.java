package api_core;

public class InputDevice {
	
	boolean dbStatus = false;
	
	public InputDevice(){
	
	}
	
	
	public String getDbConnectionStatus(){
		if(dbStatus){
			return "connected successfully to database" ; 
		}else{
			return "error connection to database";
		}
	}

}
