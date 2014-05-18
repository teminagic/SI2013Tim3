package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		String brojMotora = "aaaa3333";*/
		
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
