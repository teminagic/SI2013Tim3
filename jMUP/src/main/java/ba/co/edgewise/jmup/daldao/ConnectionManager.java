package ba.co.edgewise.jmup.daldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;;

public class ConnectionManager {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql339553";
	private static final String USERNAME = "sql339553";
	private static final String PASSWORD = "mJ2!wY8%";

	private PoolingDataSource dataSource = null;
	
	public ConnectionManager()
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		dataSource = setupDataSource();
	}
	
	private PoolingDataSource setupDataSource(){
		GenericObjectPool.Config config = new GenericObjectPool.Config();
		config.maxActive = 50;
		config.maxIdle = 20;
		config.minIdle = 10;
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
	
	public static void main(String[] args)
	{
		ConnectionManager manager = new ConnectionManager();
		
		Connection connection = manager.getConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet rs = null;
		String querry = "SELECT username FROM m_users";
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery(querry);
			while (rs.next())
			{
				System.out.println(rs.getString("username"));
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			closeStatement(stmt);
			closeResultSet(rs);
			closeConnection(connection);
		}
	}
	
}
