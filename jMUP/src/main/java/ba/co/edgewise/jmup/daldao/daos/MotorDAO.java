package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.enums.VrstaGoriva;
import ba.co.edgewise.jmup.enums.VrstaMotora;
import ba.co.edgewise.jmup.klase.Motor;

public class MotorDAO implements IGenericDAO<Motor, Integer> {

	@Override
	public boolean create(Motor m) {

		boolean success = false;
		Integer zapremina = m.getZapreminaMotora();
		Integer maxSnaga = m.getMaxSnaga();
		VrstaGoriva vrstaGoriva = m.getVrstaGoriva();
		VrstaMotora vrstaMotora = m.getVrstaMotora();
		String brojMotora = m.getBrojMotora();

		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `Motor`(`ZapreminaMotora`, `MaksimalnaSnaga`, `VrstaGoriva`, `BrojMotora`, `VrstaMotora`) "
							+ " VALUES (?,?,?,?,?) ");

			statement.setInt(1, zapremina);
			statement.setInt(2, maxSnaga);
			statement.setString(3, vrstaGoriva.toString());
			statement.setString(4, brojMotora);
			statement.setString(5, vrstaMotora.toString());

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
	public Motor get(Integer Id) {

		Motor result = new Motor();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Po�etak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Motor "
							+ "WHERE IDMotora = ?");

			statement.setInt(1, Id);
			qResult = statement.executeQuery();
			

			// Dobavljanje rezultata
			if (qResult.next()) {
				result.setId(qResult.getInt("IDMotora"));
				result.setMaxSnaga(qResult.getInt("MaksimalnaSnaga"));
				result.setVrstaGoriva(VrstaGoriva.getVrstaGoriva(qResult.getString("VrstaGoriva")));
				result.setBrojMotora(qResult.getString("BrojMotora"));
				result.setVrstaMotora(VrstaMotora.getMotor(qResult.getString("VrstaMotora")));
				result.setZapreminaMotora(qResult.getInt("ZapreminaMotora"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;

	}

	@Override
	public List<Motor> getAll() {
		List<Motor> result = new ArrayList<Motor>();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Po�etak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Motor ");

			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			while (qResult.next()) {
				Motor temp = new Motor();
				temp.setId(qResult.getInt("IDMotora"));
				temp.setMaxSnaga(qResult.getInt("MaksimalnaSnaga"));
				temp.setVrstaGoriva(VrstaGoriva.getVrstaGoriva(qResult.getString("VrstaGoriva")));
				temp.setBrojMotora(qResult.getString("BrojMotora"));
				temp.setVrstaMotora(VrstaMotora.getMotor(qResult.getString("VrstaMotora")));
				temp.setZapreminaMotora(qResult.getInt("ZapreminaMotora"));
				result.add(temp);
			}

			// ako je prazno da se baci exception
			if (result.size() == 0)
				throw new EmptyStackException();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	@Override
	public boolean update(Integer id, Motor m) {
		boolean success = false;
		Integer zapremina = m.getZapreminaMotora();
		Integer maxSnaga = m.getMaxSnaga();
		String vrstaGoriva = m.getVrstaGoriva().toString();
		String vrstaMotora = m.getVrstaMotora().toString();
		String brojMotora = m.getBrojMotora();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE `Motor`"
							+ " SET ZapreminaMotora = ? , MaksimalnaSnaga= ?, VrstaGoriva= ?, VrstaMotora= ?, BrojMotora = ? "
							+ " WHERE IDMotora = ? ");

			statement.setInt(1, zapremina);
			statement.setInt(2, maxSnaga);
			statement.setString(3, vrstaGoriva);
			statement.setString(4, vrstaMotora);
			statement.setString(5, brojMotora);
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

	@Override
	public boolean delete(Integer id) {
		boolean success = false;

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement("DELETE"
					+ " FROM `Motor` " + " WHERE IDMotora = ? ");

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

}
