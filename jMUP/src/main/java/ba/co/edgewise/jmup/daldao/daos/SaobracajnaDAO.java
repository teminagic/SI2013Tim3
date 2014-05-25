package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.klase.Vozilo;

public class SaobracajnaDAO implements IGenericDAO<Saobracajna, String> {

	@Override
	public boolean create(Saobracajna s)
	{
		boolean success = false;
	
		String regOznaka = s.getRegOznaka();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `Saobracajna`(`Marka`) VALUES (?) ");

			statement.setString(1, regOznaka);

			statement.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return success;
		
	}

	@Override
	public Saobracajna get(String regOznaka){
		
		Saobracajna result = new Saobracajna();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Saobracajna "+
					"WHERE RegOznaka = ?"
					);
			
			statement.setString(1, regOznaka);
			qResult = statement.executeQuery();
			
			//Dobavljanje rezultata, sta ovdje napisati?
			/*if(qResult.next()) {
				
			}*/
		
		//ako je prazno baci exception
		if(result == null)
			throw new EmptyStackException();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
		
	} 

	@Override
	 public List<Saobracajna> getAll()
	{
		List<Saobracajna> result = new ArrayList<Saobracajna>();
		Saobracajna temp = new Saobracajna();
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		//Pocetak pripreme upita
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Saobracajna "
					);
			
			qResult = statement.executeQuery();
			//Dobavljanje rezultata
			while(qResult.next()) {
				// ovdje?
				result.add(temp);
			}
			
			//ako je prazno da se baci exception
			if(result.size() == 0)
				throw new EmptyStackException();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
	}
	
	@Override
	 public boolean update(Saobracajna s)
	{
		boolean success = false;
		String regOznaka = s.getRegOznaka();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
	
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"UPDATE `Saobracajna`" +
					" SET RegOznaka = ? " + 
					" WHERE BrojMotora = ? "
					);

			statement.setString(1, regOznaka);
			
			statement.executeUpdate();
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return success;
	}
	
	@Override
	 public boolean delete(String regOznaka)
	{
		boolean success = false;
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"DELETE" +
					" FROM `Saobracajna` " + 
					" WHERE RegOznaka = ? "
					);
			
			statement.setString(1, regOznaka);
			statement.executeUpdate();
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return success;
		
	}
	
}