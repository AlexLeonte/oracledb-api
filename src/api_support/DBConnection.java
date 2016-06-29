package api_support;
import java.sql.* ;  // for standard JDBC programs

import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	    final JPanel panel = new JPanel();

		try {
			
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      conn = DriverManager.getConnection(dbURL, userName, password);      
		      stmt = conn.createStatement();
		      dbconnected = true;
		      
		      System.out.println(stmt.executeQuery("Select * from all_users"));
		      return stmt;
		      
			}
			catch(Exception ex) {
			    JOptionPane.showMessageDialog(panel, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);

				dbconnected = false;
				return stmt;
			}catch(Exception ex){
			    JOptionPane.showMessageDialog(panel, "DBConnection \n" + ex.getMessage() + "\n" + ex.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);

			}
	
	}
	
	public String toString(){
		return "DBConnection info:\n"+ JDBC_DRIVER+"\n"+ dbURL + "\n" + userName + "\n" + password ;		
		
	}
	

	
	
	
}
