package net.azurewebsites.krystiankatafoniapp.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
/**
 * This class is a provider for database connection.
 * ConnectionProvider class allow to get data
 * from file context.xml, this data is need for
 * connection with database
 * 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-30
 */

public class ConnectionProvider {
	
	/*Data source object which will be return in getDataSource() method*/
	private static DataSource dataSource;
	
	/**
	 * 
	 * @return Data Source from context.xml file
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return getDataSource().getConnection();
	}
	/**
	 * If dataSource is null create new context
	 * and save this context to dataSource object
	 * @return dataSource object with data for connection from context.xml file
	 */
	public static DataSource getDataSource(){
		if(dataSource == null){
			try{
				Context initialContext = new InitialContext();
                Context envContext = (Context) initialContext
                        .lookup("java:comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/myshopping");
                dataSource = ds;
            } catch (NamingException e) {
                e.printStackTrace();
            }
		}
		return dataSource;
	}
}
