/**
 * 
 */
package com.tvm.ilp.t154.cao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.*;

/**
 * @author 589964
 *
 */
public class ConnectionUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
	        Connection con=null;
		    Class.forName(DRIVER_NAME);
		    con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    return con;
		
	}
	
	public static void closePreparedStatement(PreparedStatement ps) throws SQLException{
		if(ps!=null)
			ps.close();
	}
		
		public static void closeConnection(Connection con) throws SQLException{
			
			
		if(con!=null)
			con.close();
		
	}

}
