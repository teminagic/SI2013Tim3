package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Saobracajna;

public class SaobracajnaDAO implements IGenericDAO<Saobracajna, String> {

	@Override
	public boolean create(Saobracajna s)
	{
		boolean success = false;
		
		int vozilo = s.getVozilo().getId();
		int korisnik = s.getKorisnik().getId();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `Saobracajna`(`Vozilo`, `Korisnik`, `BrojDozvole`) VALUES (?, ?, ?)");

			statement.setInt(1, vozilo);
			statement.setInt(2, korisnik);
			statement.setString(3, s.getBrojDozvole());//

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
	public Saobracajna get(String brojDozvole){
		
		Saobracajna result = new Saobracajna();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Saobracajna "+
					"WHERE BrojDozvole = ?"
					);
			
			statement.setString(1, brojDozvole);
			qResult = statement.executeQuery();
			
			if(qResult.next()){
				result.setBrojDozvole(qResult.getString("BrojDozvole"));
				
				VoziloDAO vDAO = new VoziloDAO();
				result.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				result.setKorisnik(oDAO.get(qResult.getInt("Korisnik")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
		
	} 

	@Override
	 public ArrayList<Saobracajna> getAll()
	{
		ArrayList<Saobracajna> result = new ArrayList<Saobracajna>();
		
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
				
				Saobracajna temp = new Saobracajna();
				
				temp.setBrojDozvole(qResult.getString("BrojDozvole"));
				
				VoziloDAO vDAO = new VoziloDAO();
				temp.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				temp.setKorisnik(oDAO.get(qResult.getInt("Korisnik")));
				
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
	
	// treba mi niz ne barci!
	 public ArrayList<Saobracajna> getByPotvrda(String potvrda)
		{
			ArrayList<Saobracajna> result = new ArrayList<Saobracajna>();
			
			//Dobavljanje konekcije
			ConnectionManager manager = new ConnectionManager();
			Connection connection = manager.getConnection();
			
			//Pocetak pripreme upita
			ResultSet qResult = null;
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"SELECT * "+ 
						"FROM Saobracajna "+
						"WHERE BrojDozvole = ?"
						);
				statement.setString(1, potvrda);
				qResult = statement.executeQuery();
				//Dobavljanje rezultata
				while(qResult.next()) {
					
					Saobracajna temp = new Saobracajna();
					
					temp.setBrojDozvole(qResult.getString("BrojDozvole"));
					
					VoziloDAO vDAO = new VoziloDAO();
					temp.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
					
					OsobaDAO oDAO = new OsobaDAO();
					temp.setKorisnik(oDAO.get(qResult.getInt("Korisnik")));
					
					result.add(temp);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.closeConnection(connection);
			}
			
			return result;
		}
	 
	 // korisnik ID jednistven vraca po jedan result
	 public Saobracajna getByName(Integer id)
		{
			Saobracajna result = new Saobracajna();
			
			//Dobavljanje konekcije
			ConnectionManager manager = new ConnectionManager();
			Connection connection = manager.getConnection();
			
			//Pocetak pripreme upita
			ResultSet qResult = null;
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"SELECT * "+ 
						"FROM Saobracajna "+
						"WHERE Korisnik = ?"
						);
				statement.setInt(1, id);
				qResult = statement.executeQuery();
				//Dobavljanje rezultata
				if(qResult.next()) {
					
					result.setBrojDozvole(qResult.getString("BrojDozvole"));
					
					VoziloDAO vDAO = new VoziloDAO();
					result.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
					
					OsobaDAO oDAO = new OsobaDAO();
					result.setKorisnik(oDAO.get(qResult.getInt("Korisnik")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.closeConnection(connection);
			}
			
			return result;
		}
	 
	 // korisnik ID jednistven vraca po jedan result
	 public Saobracajna getByReg(Integer id)
		{
			Saobracajna result = new Saobracajna();
			
			//Dobavljanje konekcije
			ConnectionManager manager = new ConnectionManager();
			Connection connection = manager.getConnection();
			
			//Pocetak pripreme upita
			ResultSet qResult = null;
			
			try {
				PreparedStatement statement = 	connection.prepareStatement(
						"SELECT * "+ 
						"FROM Saobracajna "+
						"WHERE Vozilo = ?"
						);
				statement.setInt(1, id);
				qResult = statement.executeQuery();
				//Dobavljanje rezultata
				if(qResult.next()) {
					
					result.setBrojDozvole(qResult.getString("BrojDozvole"));
					
					VoziloDAO vDAO = new VoziloDAO();
					result.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
					
					OsobaDAO oDAO = new OsobaDAO();
					result.setKorisnik(oDAO.get(qResult.getInt("Korisnik")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.closeConnection(connection);
			}
			
			return result;
		}
	
	@Override
	public boolean update(String brojDozvole, Saobracajna s)
	{
		boolean success = false;
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
	
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"UPDATE `Saobracajna`" +
					" SET Vozilo = ?, Korisnik = ? " + 
					" WHERE BrojDozvole = ? "
					);

			statement.setInt(1, s.getVozilo().getId());
			statement.setInt(2, s.getKorisnik().getId());
			statement.setString(3, brojDozvole);
			
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
	public boolean delete(String brojDozvole)
	{
		boolean success = false;
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"DELETE" +
					" FROM `Saobracajna` " + 
					" WHERE BrojDozvole = ? "
					);
			
			statement.setString(1, brojDozvole);
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
