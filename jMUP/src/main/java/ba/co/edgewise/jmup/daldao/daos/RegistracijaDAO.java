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
		
		String regOznaka = registracija.getRegistarskaOznaka();
		Date datumRegist = registracija.getDatumRegistrovanja();
		Date datumIsteka = registracija.getDatumIsteka();
		int idVozila = registracija.getVozilo().getId();
		int idOsobe = registracija.getOsoba().getId();
		int idRegistracije=registracija.getId();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Registracija(RegistarskaOznaka, Od, Do, Vozilo, Osoba) VALUES (?, ?, ?, ?, ?)");
		
			statement.setString(1, regOznaka);
			statement.setDate(2, new java.sql.Date(datumRegist.getTime()));
			statement.setDate(3, new java.sql.Date(datumIsteka.getTime()));
			statement.setInt(4, idVozila);
			statement.setInt(5, idOsobe);

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
				result.setRegistarskaOznaka(qResult.getString("RegistarskaOznaka"));
				result.setDatumRegistrovanja(qResult.getDate("Od"));
				result.setDatumIsteka(qResult.getDate("Do"));
				
				VoziloDAO vDAO = new VoziloDAO();
				result.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				result.setOsoba(oDAO.get(qResult.getInt("Osoba")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
	}

	@Override
	public List<Registracija> getAll() {
		List<Registracija> result = new ArrayList<Registracija>();
		
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
				temp.setRegistarskaOznaka(qResult.getString("RegistarskaOznaka"));
				temp.setDatumRegistrovanja(qResult.getDate("Od"));
				temp.setDatumIsteka(qResult.getDate("Do"));
				
				VoziloDAO vDAO = new VoziloDAO();
				temp.setVozilo(vDAO.get(qResult.getInt("Vozilo")));
				
				OsobaDAO oDAO = new OsobaDAO();
				temp.setOsoba(oDAO.get(qResult.getInt("Osoba")));
				
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
					+" SET RegistarskaOznaka = ?, Od = ? , Do = ?, "
					+ "Vozilo = ?, Osoba = ?" 
					+" WHERE IDRegistracije = ? "
					);

			statement.setString(1, r.getRegistarskaOznaka());
			statement.setDate(2, new java.sql.Date(r.getDatumRegistrovanja().getTime()));
			statement.setDate(3, new java.sql.Date(r.getDatumIsteka().getTime()));
			statement.setInt(4, r.getVozilo().getId());
			statement.setInt(5, r.getOsoba().getId());
			statement.setInt(6, id);
			
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
		
		return success;//
	}
	
	/*public static void main(String[] args) throws ParseException {
		RegistracijaDAO rDAO = new RegistracijaDAO();
		VoziloDAO vDAO = new VoziloDAO();
		OsobaDAO oDAO = new OsobaDAO();
		Vozilo v = vDAO.getByReg("87");
		Osoba o = oDAO.getByJMBG("11111");
		Date odKad=new SimpleDateFormat("yyyy-MM-dd").parse("1991-2-1");
		Date doKad=new SimpleDateFormat("yyyy-MM-dd").parse("1992-2-1");
		Registracija r = new Registracija(5, "b-b",odKad, doKad, v,o);
		System.out.print(rDAO.create(r));
	}*/
	
}
