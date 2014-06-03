package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Log;

public class LogDAO implements IGenericDAO<Log, Integer> {

	@Override
	public boolean create(Log log) {

		Boolean success = false;

		String username = log.getUsername();
		Date datum = new Date(log.getDatum().getTime());
		String akcija = log.getAkcija();
		String opis = log.getOpis();

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Logovi (Username, Datum, Akcija, Description) "
							+ " VALUES (?, ?, ?, ?);");

			statement.setString(1, username);
			statement.setDate(2, datum);
			statement.setString(3, akcija);
			statement.setString(4, opis);

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
	public Log get(Integer id) {
		Log result = new Log();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement =connection.prepareStatement("SELECT * FROM Logovi WHERE ID = ?");
			statement.setInt(1, id);
			
			qResult = statement.executeQuery();
			
			if (qResult.next()) {
				result.setId(qResult.getInt("ID"));
				result.setUsername(qResult.getString("Username"));
				result.setDatum(qResult.getTimestamp("Datum"));
				result.setAkcija(qResult.getString("Akcija"));
				result.setOpis(qResult.getString("Description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}
		
		return result;
	}

	@Override
	public ArrayList<Log> getAll() {

		ArrayList<Log> result = new ArrayList<Log>();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		ResultSet qResult = null;
		
		try {
			PreparedStatement statement =connection.prepareStatement("SELECT * FROM Logovi");
			
			qResult = statement.executeQuery();
			
			while (qResult.next()) {
				Log tmp = new Log();
				
				tmp.setId(qResult.getInt("ID"));
				tmp.setUsername(qResult.getString("Username"));
				tmp.setDatum(qResult.getTimestamp("Datum"));
				tmp.setAkcija(qResult.getString("Akcija"));
				tmp.setOpis(qResult.getString("Description"));
				
				result.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}

	@Override
	public boolean update(Integer id, Log log) {
		boolean success = false;
		
		String username = log.getUsername();
		Date datum = new Date(log.getDatum().getTime());
		String akcija = log.getAkcija();
		String opis = log.getOpis();
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE Logovi"
					+ "SET Username = ?, Datum = ?, Akcija = ?, Description = ? "
					+ "WHERE ID = ?");
			
			statement.setString(1, username);
			statement.setDate(2, datum);
			statement.setString(3, akcija);
			statement.setString(4, opis);
			
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

	@Override
	public boolean delete(Integer id) {
		boolean success = false;
		
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Logovi"
					+ "WHERE ID = ?;");
			
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
		LogDAO lDAO = new LogDAO();
		for(Log l : lDAO.getAll())
			System.out.println(l.getAkcija());
	}

}
