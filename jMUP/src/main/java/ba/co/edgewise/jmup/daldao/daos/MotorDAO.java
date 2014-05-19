package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Motor;


public class MotorDAO implements IGenericDAO<Motor, String> {

	@Override
	public boolean create(Motor m)
	{
		
		boolean success = false;
		Integer zapremina = m.get_zapreminaMotora();
		Integer maxSnaga = m.get_maxSnaga();
		String vrstaGoriva = m.get_vrstaGoriva();
		String vrstaMotora= m.get_vrstaMotora();
		String brojMotora = m.get_brojMotora();
		
		//primjer za test
		/*Integer zapremina = 200;
		Integer maxSnaga = 300;
		String vrstaGoriva = "dizel";
		String vrstaMotora= "dizel";
		String brojMotora = "aaaa4444";*/
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"INSERT INTO `Motor`(`ZapreminaMotora`, `MaksimalnaSnaga`, `VrstaGoriva`, `BrojMotora`, `VrstaMotora`) " +
					" VALUES (?,?,?,?,?) ");
			
			statement.setInt(1, zapremina);
			statement.setInt(2, maxSnaga);
			statement.setString(3, vrstaGoriva);
			statement.setString(4, brojMotora);
			statement.setString(5, vrstaMotora);
			
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
	 public Motor get(String Id)
	{
		
		Motor result = new Motor();
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		//Poèetak pripreme upita
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Motor "+
					"WHERE BrojMotora = ?"
					);
			
			statement.setString(1, Id);
			qResult = statement.executeQuery();
			
			//Dobavljanje rezultata
			if(qResult.next()) {
				result.set_maxSnaga(qResult.getInt("MaksimalnaSnaga"));
				result.set_vrstaGoriva(qResult.getString("VrstaGoriva"));
				result.set_brojMotora(qResult.getString("BrojMotora"));
				result.set_vrstaMotora(qResult.getString("VrstaMotora"));
				result.set_zapreminaMotora(qResult.getInt("ZapreminaMotora"));
			}
		
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
	 public List<Motor> getAll()
	{
		List<Motor> result = new ArrayList<Motor>();
		Motor temp = new Motor();
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		//Poèetak pripreme upita
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Motor "
					);
			
			qResult = statement.executeQuery();
			//Dobavljanje rezultata
			while(qResult.next()) {
				temp.set_maxSnaga(qResult.getInt("MaksimalnaSnaga"));
				temp.set_vrstaGoriva(qResult.getString("VrstaGoriva"));
				temp.set_brojMotora(qResult.getString("BrojMotora"));
				temp.set_vrstaMotora(qResult.getString("VrstaMotora"));
				temp.set_zapreminaMotora(qResult.getInt("ZapreminaMotora"));
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
	 public boolean update(Motor m)
	{
		boolean success = false;
		Integer zapremina = m.get_zapreminaMotora();
		Integer maxSnaga = m.get_maxSnaga();
		String vrstaGoriva = m.get_vrstaGoriva();
		String vrstaMotora= m.get_vrstaMotora();
		String brojMotora = m.get_brojMotora();
		
		//primjer za test
		/*Integer zapremina = 400;
		Integer maxSnaga = 300;
		String vrstaGoriva = "dizel";
		String vrstaMotora= "dizel";
		String brojMotora = "aaaa4444";*/
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"UPDATE `Motor`" +
					" SET ZapreminaMotora = ? , MaksimalnaSnaga= ?, VrstaGoriva= ?, VrstaMotora= ? " + 
					" WHERE BrojMotora = ? "
					);

			statement.setInt(1, zapremina);
			statement.setInt(2, maxSnaga);
			statement.setString(3, vrstaGoriva);
			statement.setString(4, vrstaMotora);
			statement.setString(5, brojMotora);
			
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
	 public boolean delete(String id)
	{
		boolean success = false;
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"DELETE" +
					" FROM `Motor` " + 
					" WHERE BrojMotora = ? "
					);
			
			statement.setString(1, id);
			statement.executeUpdate();
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return success;
		
	}
	
	public static void main (String[] args){
		
		Motor m = new Motor();
		MotorDAO d = new MotorDAO();
		//d.create(m);
		//m = d.get("aaaa3333");
		//System.out.println(m.get_brojMotora());
		
		//List<Motor> motori = new ArrayList<Motor>(); 
		//motori = d.getAll();
		//System.out.println(motori.size());
		
	}

}
