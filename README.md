# oracledb-api
Requirements:
 oracle database 12c 
ojdbc7.jar ( oracledb-api/ojdbc7)
jdk 1.8
$ORACLE_HOME/bin/lsnrctl star 
sqlplus 
startup; 


Feature1: Connect to the database
Input:Hostname, Port, Username (sys as sysdba or any user..) , Password ,Database name
Output:connection succes or not .

Feature2:List table structure
Input:table name
Output: shows column name and type

Feature3:Execute  ( !!! ONLY QUERY,  FILE OPTION IS NOT IMPLEMENTED "YET" ) 
Input: query ... without " ; "
Output: shows ...whatever you asked for

Feature4:Clear button ( I did not know how to implement scroll bar into textArea) 

Future development:
Help button
Query from file 
New class OutputDevice for coustomizing the output

