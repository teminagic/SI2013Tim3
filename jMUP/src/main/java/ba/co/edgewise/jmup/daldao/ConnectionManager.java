package ba.co.edgewise.jmup.daldao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;;

public class ConnectionManager {
	Properties prop = new Properties();
	InputStream input = null;
	
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;

	private PoolingDataSource dataSource = null;
	
	public ConnectionManager()
	{
		try {
			try {
				input = new FileInputStream("./db.properties");
				prop.load(input);
			} catch (IOException e) {
				input = this.getClass().getClassLoader().getResourceAsStream("db.properties");
				try {
					prop.load(input);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
			DRIVER = prop.getProperty("DRIVER");
			URL = prop.getProperty("URL");
			USERNAME = prop.getProperty("USERNAME");
			PASSWORD = prop.getProperty("PASSWORD");
			
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		dataSource = setupDataSource();
	}
	
	private PoolingDataSource setupDataSource(){
		GenericObjectPool.Config config = new GenericObjectPool.Config();
		config.maxActive = 10;
		config.maxIdle = 0;
		config.minIdle = 0;
		config.maxWait = 1000;
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ObjectPool connectionPool = new GenericObjectPool(null, config);
		
		ConnectionFactory connectionFactory = 
				new DriverManagerConnectionFactory(URL, USERNAME, PASSWORD);
		
		@SuppressWarnings("unused")
		PoolableConnectionFactory poolableConnectionFactory =
				new PoolableConnectionFactory(connectionFactory, connectionPool, 
						null, null, false, true);
		
		PoolingDataSource poolingDataSource = new PoolingDataSource(connectionPool);
		
		return poolingDataSource;
	}
	
	public synchronized Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement stmt) {

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
