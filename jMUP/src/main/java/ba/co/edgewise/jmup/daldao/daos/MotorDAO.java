package ba.co.edgewise.jmup.daldao.daos;

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
		/*Integer id = 2;
		Integer zapremina = 200;
		Integer maxSnaga = 300;
		String vrstaGoriva = "benzin";
		String vrstaMotora= "benzin";
		String brojMotora = "aaaa2222";*/
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		//Poèetak pripreme upita
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"INSERT INTO `Motor`(`IDMotora`, `ZapreminaMotora`, `MaksimalnaSnaga`, `VrstaGoriva`, `BrojMotora`, `VrstaMotora`) " +
					" VALUES (?,?,?,?,?,?) ");
			
			statement.setInt(1, id);
			statement.setInt(2, zapremina);
			statement.setInt(3, maxSnaga);
			statement.setString(4, vrstaGoriva);
			statement.setString(5, brojMotora);
			statement.setString(6, vrstaMotora);
			
			statement.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}
		
		return success;
		
		
	}
	
	@Override
	 public boolean get(String Id)
	{
		return false;
		
	}
	
	@Override
	 public boolean update(Motor m)
	{
		return false;
		
	}
	
	@Override
	 public boolean delete(Motor m)
	{
		return false;
		
	}
	
	@Override
	 public boolean getAll()
	{
		return false;
	}
	
	public static void main (String[] args){
		
		TipUposlenikaDAO noviDAO = new TipUposlenikaDAO();
		System.out.println(noviDAO.get(1));
		Motor m = new Motor();
		MotorDAO d = new MotorDAO();
		d.create(m);
		
		
	}

}
