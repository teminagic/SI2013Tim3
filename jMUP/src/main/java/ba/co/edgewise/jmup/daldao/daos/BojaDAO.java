package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ba.co.edgewise.enums.Boja;
import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;

public class BojaDAO {

	public Boja get(int i) {
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
}
