package api_support;
import java.sql.* ;  // for standard JDBC programs

public class DBConnection {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	private static String dbURL = "jdbc:oracle:thin:@localhost:1522:orcl";
	
	private static String userName;
	private static String password;
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public boolean dbconnected = false;
	
	public DBConnection(String phost, String pport, String pdbname,String puserName, String ppassword){
	
		
		
		dbURL = "jdbc:oracle:thin:@" + phost + ":" + pport + ":"+pdbname;
		userName = puserName;
		password = ppassword;
	
	    System.out.println("with url:" + dbURL + "\n"+ "Username: "+userName + "\nPassword:" +password);

	}
	
	public Statement connectToDB(){
		try {
			
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      conn = DriverManager.getConnection(dbURL, userName, password);      
		      stmt = conn.createStatement();
		      dbconnected = true;
		      
		      System.out.println(stmt.executeQuery("Select * from all_users"));
		      return stmt;
		      
			}
			catch(Exception ex) {
			    System.out.println("DBConnection class error !");
				dbconnected = false;
				return stmt;
			}
	
	}
	
	public String toString(){
		return "DBConnection info:\n"+ JDBC_DRIVER+"\n"+ dbURL + "\n" + userName + "\n" + password ;		
		
	}
	

	
	
	
}
