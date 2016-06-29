package api_core;
import java.sql.Statement;

import api_support.DBConnection;


public class InputDevice {
	
	DBConnection dbconn ;
	public String dbStatus;
	boolean dbConnected = false;
	Statement stmt = null;

	public InputDevice(String plocalhost, String pport, String pdbname, String pusername, String ppasword){
	
//		dbconn = new DBConnection(plocalhost, pport, pdbname, pusername, ppasword);
		dbconn = new DBConnection("localhost", "1522", "ORCL", "alex", "alexpass");
		stmt = dbconn.connectToDB();
		
		dbConnected = dbconn.dbconnected;
		
		
		
	}
	
	public Statement getDBStatement(){
		return stmt;
	}
	
	
	public boolean connectedSucces(){
		return dbconn.dbconnected;

	}
	
	public String toString(){
		if(dbConnected == true){
			return "OK \n" + dbconn.toString();
		}else{
			return "FAIL !\n" + dbconn.toString();
		}
	}
	
	
	

}
