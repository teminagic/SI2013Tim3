package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericEnumDAO;
import ba.co.edgewise.jmup.enums.Boja;

public class BojaDAO implements IGenericEnumDAO<Boja, Integer> {
	//Vraceno na staro
	@Override
	public Boja get(Integer i) {
		Boja result = null;

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Boja "
							+ "WHERE IDBoje = ?");
			statement.setInt(1, i);

			// Izvrsenje upita
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next())
				result = Boja.getBoja(qResult.getString("Naziv"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	@Override
	public Integer getID(Boja boja) {
		Integer result = null;

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Boja "
							+ "WHERE Naziv = ?");
			statement.setString(1, boja.toString());

			// Izvrsenje upita
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next())
				result = qResult.getInt("IDBoje");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
}
