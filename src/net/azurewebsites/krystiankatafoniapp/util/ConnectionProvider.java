package net.azurewebsites.krystiankatafoniapp.util;

import java.sql.Connection;
import java.sql.SQLException;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionProvider {
	
	private static DriverManagerDataSource dataSource;
	public static Connection getConnection() throws SQLException{
		return getDataSource().getConnection();
	}
	public static DataSource getDataSource(){
		if(dataSource == null){
			/*try{
				Context initialContext = new InitialContext();
                Context envContext = (Context) initialContext
                        .lookup("java:comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/myshoppingkk");
                dataSource = ds;
            } catch (NamingException e) {
                e.printStackTrace();
            }*/
			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://myshoppingkk.mysql.database.azure.com:3306/myshopping?verifyServerCertificate=true&useSSL=true&requireSSL=false");
			dataSource.setUsername("erotomat@myshoppingkk");
			dataSource.setPassword("new2.haslO");
		}
		return dataSource;
	}
}
