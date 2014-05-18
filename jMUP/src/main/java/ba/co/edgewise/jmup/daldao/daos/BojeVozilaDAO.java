package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.enums.NijansaBoje;
import ba.co.edgewise.enums.VrstaBoje;
import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.BojaVozila;
import ba.co.edgewise.jmup.klase.Motor;

public class BojeVozilaDAO implements IGenericDAO<BojaVozila, Integer> {
	 
	 @Override
	 public boolean create(BojaVozila bv)
	 {
		 boolean success = false;
		 String nijansa = bv.get_nijansa();
		 String vrsta = bv.get_vrsta();
		 Integer boja = null; //bv.getBojaID(); //*****Treba mi u klasi boja da se vrati ID boje**********
		 Integer vozilo = null; //bv.getVoziloID();// *****Treba mi u klasi vozilo da se vrati ID vozila**********
		 String tip = bv.get_tip();
			
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"INSERT INTO `Motor`(`Nijansa`, `Vrsta`, `Boja`, `Tip`, `Vozilo`) " +
						" VALUES (?,?,?,?,?) ");
				
				statement.setString(1, nijansa);
				statement.setString(2, vrsta);
				statement.setInt(3, boja);
				statement.setInt(4, vozilo);
				statement.setString(5, tip);
				
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
	 public BojaVozila get(Integer idVozila)
	 {
		 	BojaVozila result = new BojaVozila();
			
			//Dobavljanje konekcije
			ConnectionManager manager = new ConnectionManager();
			Connection connection = manager.getConnection();
			
			//Poèetak pripreme upita
			ResultSet qResult = null;
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"SELECT * "+ 
						"FROM BojeVozila "+
						"WHERE Vozilo = ?"
						);
				
				statement.setInt(1, idVozila);
				qResult = statement.executeQuery();
				
				//Dobavljanje rezultata
				if(qResult.next()) {
				   result.set_boja(qResult.getInt("Boja")); // *****ovdje treba pozvati ENUM boja
				   result.set_vozilo(qResult.getInt("Vozilo")); // *****treba metoda konverzija ID u objekat vozilo
				   result.set_nijansa((NijansaBoje.getNijansaBoje(qResult.getString("Nijansa"))).toString());
				   result.set_vrsta((VrstaBoje.getVrstaBoje(qResult.getString("Vrsta"))).toString());
				   result.set_tip(qResult.getString("Tip"));
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
	 public List<BojaVozila> getAll()
	 {
		 	List<BojaVozila> result = new ArrayList<BojaVozila>();
		 	BojaVozila temp = new BojaVozila();
			
			//Dobavljanje konekcije
			ConnectionManager manager = new ConnectionManager();
			Connection connection = manager.getConnection();
			
			//Poèetak pripreme upita
			ResultSet qResult = null;
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"SELECT * "+ 
						"FROM BojeVozila "
						);
				
				qResult = statement.executeQuery();
				
				//Dobavljanje rezultata
				while(qResult.next()) {
				   temp.set_boja(qResult.getInt("Boja")); // *****ovdje treba pozvati ENUM boja
				   temp.set_vozilo(qResult.getInt("Vozilo")); // *****treba metoda konverzija ID u objekat vozilo
				   temp.set_nijansa((NijansaBoje.getNijansaBoje(qResult.getString("Nijansa"))).toString());
				   temp.set_vrsta((VrstaBoje.getVrstaBoje(qResult.getString("Vrsta"))).toString());
				   temp.set_tip(qResult.getString("Tip"));
				   result.add(temp);
				}
			
			//ako je prazno baci exception
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
	 public boolean update(BojaVozila bv)
	 {
		 boolean success = false;
		 String nijansa = bv.get_nijansa();
		 String vrsta = bv.get_vrsta();
		 Integer boja = null; //bv.getBojaID(); //*****Treba mi u klasi boja da se vrati ID boje**********
		 Integer vozilo = null; //bv.getVoziloID();// *****Treba mi u klasi vozilo da se vrati ID vozila**********
		 String tip = bv.get_tip();
			
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"UPDATE `BojeVozila`"
						+ " SET, Nijansa = ?, Vrsta= ? , Boja= ? , Tip= ?"
						+ " WHERE Vozilo = ?");
				
				statement.setString(1, nijansa);
				statement.setString(2, vrsta);
				statement.setInt(3, boja);
				statement.setString(4, tip);
				statement.setInt(5, vozilo);
				
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
	 public boolean delete(Integer idVozila)
	 {
		 boolean success = false;
			
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"DELEATE`"
						+ " FROM BojeVozila"
						+ " WHERE Vozilo = ? ");
				
				statement.setInt(1, idVozila);
				statement.executeUpdate();
				success = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.closeConnection(connection);
			}
		return success;
			
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
