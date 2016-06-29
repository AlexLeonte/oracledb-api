package api_support;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
			}else{
				rs = stmt.executeQuery(queryOrFile);
				rsmd = rs.getMetaData();
				columnsNumber =rsmd.getColumnCount();
				
				while(rs.next()){
					for(int i = 1; i<= columnsNumber; i++){
						result = result + rs.getString(i) + "	";
						
					}
					result = result + "\n";
				
				}
			}
			return result;
		}catch(Exception ex){
			System.out.println("ERROR IN APPENGINE EXECUTE QUERYFILE FUNCTION !! ");
			return "ERROR";
		}
	}
	
	
}
