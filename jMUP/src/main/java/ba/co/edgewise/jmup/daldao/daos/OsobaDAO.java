package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.klase.Vozilo;

public class OsobaDAO implements IGenericDAO<Osoba, Integer> {

	public boolean create(Osoba o) {
		boolean success = false;
		String jmbg_id = o.getJmbg_Id();
		String prezime = o.getPrezime();
		String ime = o.getIme();
		String prebivaliste = o.getPrebivaliste();
		boolean pravnoLice = o.isPravnoLice();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			String sql = "INSERT INTO Osoba (JMB_ID, Prezime, Ime, Prebivaliste, PravnoLice)"
					+ " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, jmbg_id);
			statement.setString(2, prezime);
			statement.setString(3, ime);
			statement.setString(4, prebivaliste);
			statement.setBoolean(5, pravnoLice);

			statement.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return success;
	}

	public Osoba get(Integer id) {
		Osoba result = new Osoba();

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Osoba "
							+ "WHERE IDOsobe = ?");
			statement.setInt(1, id);

			// Izvrsenje upita
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next()) {
				result.setId(qResult.getInt("IDOsobe"));
				result.setJmbg_Id(qResult.getString("JMB_ID"));
				result.setPrezime(qResult.getString("Prezime"));
				result.setIme(qResult.getString("Ime"));
				result.setPrebivaliste(qResult.getString("Prebivaliste"));
				result.setPravnoLice(qResult.getBoolean("PravnoLice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	public ArrayList<Osoba> getAll() {
		ArrayList<Osoba> result = new ArrayList<Osoba>();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Po�etak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Osoba;");

			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			while (qResult.next()) {
				Osoba osoba = new Osoba();
				osoba.setId(qResult.getInt("IDOsobe"));
				osoba.setJmbg_Id(qResult.getString("JMB_ID"));
				osoba.setPrezime(qResult.getString("Prezime"));
				osoba.setIme(qResult.getString("Ime"));
				osoba.setPrebivaliste(qResult.getString("Prebivaliste"));
				if (qResult.getInt("PravnoLice") == 1)
					osoba.setPravnoLice(true);
				else
					osoba.setPravnoLice(false);
				result.add(osoba);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	
	public ArrayList<Osoba> getByIme(String ime) {
		ArrayList<Osoba> result = new ArrayList<Osoba>();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Po�etak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Osoba Where Ime = ? ");
			statement.setString(1, ime);
			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			while (qResult.next()) {
				Osoba osoba = new Osoba();
				osoba.setId(qResult.getInt("IDOsobe"));
				osoba.setJmbg_Id(qResult.getString("JMB_ID"));
				osoba.setPrezime(qResult.getString("Prezime"));
				osoba.setIme(qResult.getString("Ime"));
				osoba.setPrebivaliste(qResult.getString("Prebivaliste"));
				if (qResult.getInt("PravnoLice") == 1)
					osoba.setPravnoLice(true);
				else
					osoba.setPravnoLice(false);
				result.add(osoba);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	public ArrayList<Osoba> getByPrezime(String prezime) {
		ArrayList<Osoba> result = new ArrayList<Osoba>();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Po�etak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Osoba Where Prezime = ? ");
			statement.setString(1, prezime);
			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			while (qResult.next()) {
				Osoba osoba = new Osoba();
				osoba.setId(qResult.getInt("IDOsobe"));
				osoba.setJmbg_Id(qResult.getString("JMB_ID"));
				osoba.setPrezime(qResult.getString("Prezime"));
				osoba.setIme(qResult.getString("Ime"));
				osoba.setPrebivaliste(qResult.getString("Prebivaliste"));
				if (qResult.getInt("PravnoLice") == 1)
					osoba.setPravnoLice(true);
				else
					osoba.setPravnoLice(false);
				result.add(osoba);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	public ArrayList<Osoba> getByImeiPrezime(String ime, String prezime) {
		ArrayList<Osoba> result = new ArrayList<Osoba>();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Po�etak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Osoba Where Ime = ? AND Prezime = ? ");
			statement.setString(1, ime);
			statement.setString(2, prezime);
			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			while (qResult.next()) {
				Osoba osoba = new Osoba();
				osoba.setId(qResult.getInt("IDOsobe"));
				osoba.setJmbg_Id(qResult.getString("JMB_ID"));
				osoba.setPrezime(qResult.getString("Prezime"));
				osoba.setIme(qResult.getString("Ime"));
				osoba.setPrebivaliste(qResult.getString("Prebivaliste"));
				if (qResult.getInt("PravnoLice") == 1)
					osoba.setPravnoLice(true);
				else
					osoba.setPravnoLice(false);
				result.add(osoba);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	public Osoba getByJMBG(String jmbg) {
		Osoba result = new Osoba();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Po�etak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Osoba Where JMB_ID = ? ");
			statement.setString(1, jmbg);
			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			if (qResult.next()) {
					result.setId(qResult.getInt("IDOsobe"));
					result.setJmbg_Id(qResult.getString("JMB_ID"));
					result.setPrezime(qResult.getString("Prezime"));
					result.setIme(qResult.getString("Ime"));
					result.setPrebivaliste(qResult.getString("Prebivaliste"));
					result.setPravnoLice(qResult.getBoolean("PravnoLice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	
	
	public boolean update(Integer id, Osoba o) {
		boolean success = false;
		String jmbg_id = o.getJmbg_Id();
		String prezime = o.getIme();
		String ime = o.getIme();
		String prebivaliste = o.getPrebivaliste();
		boolean pravnoLice = o.isPravnoLice();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE Osoba SET Prezime = ?, Ime= ?, Prebivaliste= ?, PravnoLice= ?, JMB_ID = ? "
							+ " WHERE IDOsobe = ? ");

			statement.setString(1, prezime);
			statement.setString(2, ime);
			statement.setString(3, prebivaliste);
			statement.setBoolean(4, pravnoLice);
			statement.setString(5, jmbg_id);
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

	public boolean delete(Integer id) {
		boolean success = false;

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM Osoba WHERE IDOsobe = ?;");

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
	public static void main(String[] args) {
		//Osoba o = new Osoba(1,"b","b","b","b",true);
		OsobaDAO oDao = new OsobaDAO();
		List<Osoba> osobe = new ArrayList<Osoba>();
		osobe = oDao.getAll();
		for(Osoba o:osobe) System.out.println(o.getIme()+","+o.getPrezime()+","+o.getJmbg_Id());
	}
}
