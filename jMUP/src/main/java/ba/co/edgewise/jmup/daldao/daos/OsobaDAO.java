package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Osoba;

public class OsobaDAO implements IGenericDAO<Osoba, String> {

	public boolean create(Osoba o) {
		boolean success = false;
		String jmbg_id = o.get_jmbg_id();
		String prezime = o.get_prezime();
		String ime = o.get_ime();
		String prebivaliste = o.get_prebivaliste();
		boolean pravnoLice = o.is_pravnoLice();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			String sql = "INSERT INTO Osoba (IDOsobe, JMB_ID, Prezime, Ime, Prebivalište, PravnoLice)"
					+ " VALUES (null, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, jmbg_id);
			statement.setString(2, prezime);
			statement.setString(3, ime);
			statement.setString(4, prebivaliste);
			if (pravnoLice == true)
				statement.setInt(5, 1); // 1 oznaka za pravno lice u bazi
										// podataka
			else
				statement.setInt(5, 0); // 0 oznaka za fizicko lice u bazi
										// podataka

			statement.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return success;
	}

	public Osoba get(String id) {
		Osoba result = new Osoba();

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Osoba "
							+ "WHERE JMB_ID = ?");
			statement.setString(1, id);

			// Izvrsenje upita
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next())
				result.set_jmbg_id(qResult.getString("JMB_ID"));
			result.set_prezime(qResult.getString("Prezime"));
			result.set_ime(qResult.getString("Ime"));
			result.set_prebivaliste(qResult.getString("Prebivalište"));
			if (qResult.getInt("PravnoLice") == 1)
				result.set_pravnoLice(true);
			else
				result.set_pravnoLice(false);

			if (result == null)
				throw new EmptyStackException();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	public List<Osoba> getAll() {
		List<Osoba> result = new ArrayList<Osoba>();
		Osoba osoba = new Osoba();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Poèetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Osoba;");

			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			while (qResult.next()) {
				osoba.set_jmbg_id(qResult.getString("JMB_ID"));
				osoba.set_prezime(qResult.getString("Prezime"));
				osoba.set_ime(qResult.getString("Ime"));
				osoba.set_prebivaliste(qResult.getString("Prebivalište"));
				if (qResult.getInt("PravnoLice") == 1)
					osoba.set_pravnoLice(true);
				else
					osoba.set_pravnoLice(false);
				result.add(osoba);
			}

			if (result.size() == 0)
				throw new EmptyStackException();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	public boolean update(Osoba o) {
		boolean success = false;
		String jmbg_id = o.get_jmbg_id();
		String prezime = o.get_prezime();
		String ime = o.get_ime();
		String prebivaliste = o.get_prebivaliste();
		boolean pravnoLice = o.is_pravnoLice();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE Osoba SET Prezime = ?, Ime= ?, Prebivalište= ?, PravnoLice= ? "
							+ " WHERE JMB_ID = ? ");

			statement.setString(1, prezime);
			statement.setString(2, ime);
			statement.setString(3, prebivaliste);
			if (pravnoLice == true)
				statement.setInt(4, 1);
			else
				statement.setInt(4, 0);
			statement.setString(5, jmbg_id);

			statement.executeUpdate();

			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return success;
	}

	public boolean delete(String id) {
		boolean success = false;

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM Osoba WHERE JMB_ID = ?;");

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
}
