package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Vozilo;

public class RegistracijaDAO implements IGenericDAO<Registracija, Integer> {

	@Override
	public boolean create(Registracija registracija) {
		boolean success = false;
		
		Date datumRegist = registracija.getDatumRegistrovanja();
		Date datumIsteka = registracija.getDatumIsteka();
		int idVozila = registracija.getVozilo();
		int idOsobe = registracija.getOsoba();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Registracija(Od, Do, Vozilo, Osoba) VALUES (?, ?, ?, ?)");
		
			statement.setDate(1, new java.sql.Date(datumRegist.getTime()));
			statement.setDate(2, new java.sql.Date(datumIsteka.getTime()));
			statement.setInt(3, idVozila);
			statement.setInt(4, idOsobe);

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
	public Registracija get(Integer id) {
		Registracija result = new Registracija();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Registracija "+
					"WHERE IDRegistracije = ?"
					);
			
			statement.setInt(1, id);
			qResult = statement.executeQuery();
			
			if(qResult.next()){
				result.setId(qResult.getInt("IDRegistracije"));
				result.setDatumRegistrovanja(qResult.getDate("Od"));
				result.setDatumIsteka(qResult.getDate("Do"));
				
				result.setVozilo(qResult.getInt("Vozilo"));
				
				result.setOsoba(qResult.getInt("Osoba"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
	}

	@Override
	public ArrayList<Registracija> getAll() {
		ArrayList<Registracija> result = new ArrayList<Registracija>();
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		//Pocetak pripreme upita
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"SELECT * "+ 
					"FROM Registracija "
					);
			
			qResult = statement.executeQuery();
			//Dobavljanje rezultata
			while(qResult.next()) {
				
				Registracija temp = new Registracija();
				
				temp.setId(qResult.getInt("IDRegistracije"));
				temp.setDatumRegistrovanja(qResult.getDate("Od"));
				temp.setDatumIsteka(qResult.getDate("Do"));
				

				temp.setVozilo(qResult.getInt("Vozilo"));
				

				temp.setOsoba(qResult.getInt("Osoba"));
				
				result.add(temp);
				} 
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
	}

	@Override
	public boolean update(Integer id, Registracija r) {
		boolean success = false;
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
	
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"UPDATE `Registracija`" 
					+" SET Od = ? , Do = ?, "
					+ "Vozilo = ?, Osoba = ?" 
					+" WHERE IDRegistracije = ? "
					);

			statement.setDate(1, new java.sql.Date(r.getDatumRegistrovanja().getTime()));
			statement.setDate(2, new java.sql.Date(r.getDatumIsteka().getTime()));
			statement.setInt(3, r.getVozilo());
			statement.setInt(4, r.getOsoba());
			statement.setInt(5, id);
			
			statement.executeUpdate();
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return success;
	}

	public boolean updateSaIDVozila(Integer idVozila, Date odKad, Date doKad) {
		boolean success = false;
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
	
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"UPDATE `Registracija`" 
					+" SET Od = ? , Do = ? " 
					+" WHERE Vozilo = ? "
					);

			statement.setDate(1, new java.sql.Date(odKad.getTime()));
			statement.setDate(2, new java.sql.Date(doKad.getTime()));
			statement.setInt(3, idVozila);
			
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
	public boolean delete(Integer id) {
		boolean success = false;
		
		//Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"DELETE" +
					" FROM `Registracija` " + 
					" WHERE IDRegistracije = ? "
					);
			
			statement.setInt(1, id);
			statement.executeUpdate();
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return success;
	}
	
	public static void main(String[] args) throws ParseException {
		RegistracijaDAO rDAO = new RegistracijaDAO();
		VoziloDAO vDAO = new VoziloDAO();
		OsobaDAO oDAO = new OsobaDAO();
		Vozilo v = vDAO.getByReg("1");
		Osoba o = oDAO.getByJMBG("2");
		Date odKad=new SimpleDateFormat("yyyy-MM-dd").parse("1991-2-1");
		Date doKad=new SimpleDateFormat("yyyy-MM-dd").parse("1992-2-1");
		//Registracija r = new Registracija(5,odKad, doKad, v,o);
		//System.out.print(rDAO.create(r));
	}
	
}
