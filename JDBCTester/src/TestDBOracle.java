import java.sql.*;

public class TestDBOracle {

public static void main(String[] args)
		throws ClassNotFoundException, SQLException 
	{ 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//The below jdbc string uses a TNS name for a load balanced setup. TNS names are usually shorter for single nodes	
	String url = "jdbc:oracle:thin:@(DESCRIPTION_LIST=(FAILOVER=on)(LOAD_BALANCE=off)(DESCRIPTION=(CONNECT_TIMEOUT=20)(TRANSPORT_CONNECT_TIMEOUT=30)(ADDRESS_LIST=(LOAD_BALANCE=on)(ADDRESS=(PROTOCOL=TCP)(HOST=<insert_host_name>)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=<insert_service_name>)))(DESCRIPTION=(CONNECT_TIMEOUT=5)(TRANSPORT_CONNECT_TIMEOUT=3)(ADDRESS_LIST=(LOAD_BALANCE=on)(ADDRESS=(PROTOCOL=TCP)(HOST=<insert_host_name>)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=<insert_service_name))))";
	Connection conn = DriverManager.getConnection(url,"<insert_username>","<insert_password>");
	
		
	conn.setAutoCommit(false); 
	Statement stmt = conn.createStatement(); 
	ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION"); 
	while (rset.next()) { 
		System.out.println (rset.getString(1)); 
	} 
	stmt.close();     
	
	System.out.println ("Success!");
	
	} 
}