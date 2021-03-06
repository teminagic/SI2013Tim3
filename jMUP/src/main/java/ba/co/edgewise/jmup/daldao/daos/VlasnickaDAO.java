package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;

public class VlasnickaDAO implements IGenericDAO<Vlasnicka, String> {

	@Override
	public boolean create(Vlasnicka vlasnicka)
	{
		boolean success = false;
		
		int vozilo = vlasnicka.getVozilo().getId();
		int vlasnik = vlasnicka.getVlasnik().getId();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `Vlasnicka`(`Vozilo`, `Vlasnik`, `BrojDozvole`) VALUES (?, ?, ?)");

			statement.setInt(1, vozilo);
			statement.setInt(2, vlasnik);
			statement.setString(3, vlasnicka.getBrojDozvole());

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
	public Vlasnicka get(String brojDozvole){
		
		Vlasnicka result = new Vlasnicka();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Vlasnicka "+
					"WHERE BrojDozvole = ?"
					);
			
			statement.setString(1, brojDozvole);
			qResult = statement.executeQuery();
			
			if (qResult.next())
			{
				result.setBrojDozvole(qResult.getString("BrojDozvole"));
				
				VoziloDAO vDAO = new VoziloDAO();
				result.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				result.setVlasnik(oDAO.get(qResult.getInt("Vlasnik")));
			}
			else
				result = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
		
	} 
	
	public String getBrojVlasnickih()
	{
		Integer result = null;

		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		//Pocetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT Count(BrojDozvole) "+ 
					"FROM Vlasnicka "
					);
			qResult = statement.executeQuery();
			//Dobavljanje rezultata
			if(qResult.next()) {
				result = qResult.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result.toString();
	}
	
	
	public Vlasnicka getByVlasnik(Integer id){
		
		Vlasnicka result = new Vlasnicka();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Vlasnicka "+
					"WHERE Vlasnik = ?"
					);
			
			statement.setInt(1, id);
			qResult = statement.executeQuery();
			
			if (qResult.next())
			{
				result.setBrojDozvole(qResult.getString("BrojDozvole"));
				
				VoziloDAO vDAO = new VoziloDAO();
				result.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				result.setVlasnik(oDAO.get(qResult.getInt("Vlasnik")));
			} else result = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
		
	} 
	
public Vlasnicka getByVozilo(Integer id){
		
		Vlasnicka result = new Vlasnicka();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Vlasnicka "+
					"WHERE Vozilo = ?"
					);
			
			statement.setInt(1, id);
			qResult = statement.executeQuery();
			
			if (qResult.next())
			{
				result.setBrojDozvole(qResult.getString("BrojDozvole"));
				
				VoziloDAO vDAO = new VoziloDAO();
				result.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				result.setVlasnik(oDAO.get(qResult.getInt("Vlasnik")));
			} else result = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
		
	} 

	@Override
	public ArrayList<Vlasnicka> getAll()
	{
		ArrayList<Vlasnicka> result = new ArrayList<Vlasnicka>();
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		//Pocetak pripreme upita
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Vlasnicka "
					);
			
			qResult = statement.executeQuery();
			//Dobavljanje rezultata
			while(qResult.next()) {
				
				Vlasnicka temp = new Vlasnicka();
				
				temp.setBrojDozvole(qResult.getString("BrojDozvole"));
				
				VoziloDAO vDAO = new VoziloDAO();
				temp.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				temp.setVlasnik(oDAO.get(qResult.getInt("Vlasnik")));
				
				result.add(temp);
			} 			
			if(result.size()==0) result = null;

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
	}
	
	@Override
	public boolean update(String brojDozvole, Vlasnicka v)
	{
		boolean success = false;
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
	
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"UPDATE `Vlasnicka`" +
					" SET Vozilo = ?, Vlasnik = ? " + //
					" WHERE BrojDozvole = ? "
					);

			statement.setInt(1, v.getVozilo().getId());
			statement.setInt(2, v.getVlasnik().getId());
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
					" FROM `Vlasnicka` " + 
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
	
	public static void main(String[] args) {
	 
		VlasnickaDAO vd = new VlasnickaDAO();
		ArrayList<Vlasnicka> v = new ArrayList<Vlasnicka>();
		
		
	}
	
}
