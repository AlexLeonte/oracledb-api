package api_support;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AppEngine {
	Statement stmt = null;

	public AppEngine(Statement x){
		stmt = x;
	}
	
	public String executeQueryFile(String queryOrFile){
		
		
		File f ;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        int columnsNumber = 0 ;

        String result = "";
		
		try{
			f= new File(queryOrFile);
			if(f.exists()){
				//open file and execute script of sql commands ! ( maybe list of strings ) 
				return "unimplemented";
			}else{
				rs = stmt.executeQuery(queryOrFile);
				rsmd = rs.getMetaData();
				columnsNumber =rsmd.getColumnCount();
				
				for(int i=1;i<=columnsNumber;i++ ){
					result = result + rsmd.getColumnLabel(i) + "	";
				}
				result = result + "\n";
				
				while(rs.next()){
					for(int i = 1; i<= columnsNumber; i++){
						result = result + rs.getString(i) + "	";
						
					}
					result = result + "\n";
				
				}
			}
			return result;
		}catch(SQLException se) {
			
			return se.getErrorCode() +"\n" +  se.getMessage();
			
		}catch(Exception e){
			return e.getMessage() + "\n" + e.getLocalizedMessage();
		}
	}
	
	public String listTableStructure(String tableName){
		
		
		ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        int columnsNumber = 0 ;
        String result = "";
        
		try{		
			/*SELECT * FROM ALL_TAB_COLS WHERE TABLE_NAME = 'EMP' AND     OWNER = 'SCOTT';*/
			rs = stmt.executeQuery("select * FROM " + tableName);
				rsmd = rs.getMetaData();
				
				columnsNumber =rsmd.getColumnCount();
				
				for(int i=1;i<=columnsNumber;i++ ){
					result = result + rsmd.getColumnLabel(i) + "	";
				}
				result = result + "\n";
				
				for(int i=1;i<=columnsNumber;i++){
					result = result + rsmd.getColumnTypeName(i) + "\t";
				}
				
			return result;
		}catch(SQLException se) {
			
			return se.getErrorCode() +"\n" +  se.getMessage();
			
		}catch(Exception e){
			return e.getMessage() + "\n" + e.getLocalizedMessage();
		}
	
	}
	
	
	
}
