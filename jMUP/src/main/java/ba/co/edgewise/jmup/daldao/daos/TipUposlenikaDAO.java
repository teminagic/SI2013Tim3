package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericEnumDAO;
import ba.co.edgewise.jmup.enums.TipUposlenika;

public class TipUposlenikaDAO implements
		IGenericEnumDAO<TipUposlenika, Integer> {

	@Override
	public TipUposlenika get(Integer index) {

		TipUposlenika result = null;

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Poèetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM TipUposlenika "
							+ "WHERE 	IDTipaKorisnika = ?");
			statement.setInt(1, index);

			// Izvrsenje upita
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next())
				result = TipUposlenika.getTipUposlenika(qResult
						.getString("Naziv"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	@Override
	public Integer getID(TipUposlenika tip) {
		Integer result = null;

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Poèetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM TipUposlenika "
							+ "WHERE 	Naziv = ?");
			statement.setString(1, tip.toString());

			// Izvrsenje upita
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next())
				result = qResult.getInt("IDTipaKorisnika");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	public static void main(String[] args) {
		TipUposlenikaDAO noviDAO = new TipUposlenikaDAO();
		System.out.println(noviDAO.get(1));
	}
}
