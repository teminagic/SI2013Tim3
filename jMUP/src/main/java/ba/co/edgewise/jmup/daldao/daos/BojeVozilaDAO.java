package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.enums.Boja;
import ba.co.edgewise.jmup.enums.NijansaBoje;
import ba.co.edgewise.jmup.enums.VrstaBoje;
import ba.co.edgewise.jmup.klase.BojaVozila;
import ba.co.edgewise.jmup.klase.Vozilo;

public class BojeVozilaDAO implements IGenericDAO<BojaVozila, Integer> {

	@Override
	public boolean create(BojaVozila bv) {
		boolean success = false;
		NijansaBoje nijansa = bv.getNijansa();
		VrstaBoje vrsta = bv.getVrsta();

		BojaDAO bDAO = new BojaDAO();
		Integer boja = bDAO.getID(bv.getBoja()); 

		VoziloDAO vDAO = new VoziloDAO();
		Vozilo v = vDAO.get(bv.getVozilo().getId());
		Integer vozilo = v.getId();

		String tip = bv.getTip();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `BojeVozila`(IDBojeVozila, `Nijansa`, `Vrsta`, `Boja`, `Tip`, `Vozilo`) "
							+ " VALUES (null, ?,?,?,?,?) ");

			statement.setString(1, nijansa.toString());
			statement.setString(2, vrsta.toString());
			statement.setInt(3, boja);
			statement.setString(4,tip );
			statement.setInt(5,vozilo);

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
	public BojaVozila get(Integer idVozila) {
		BojaVozila result = new BojaVozila();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Poèetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM BojeVozila "
							+ "WHERE Vozilo = ?");

			statement.setInt(1, idVozila);
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next()) {

				BojaDAO bDAO = new BojaDAO();
				Boja boja = bDAO.get(qResult.getInt("Boja"));
				result.setBoja(boja); 
				
				VoziloDAO vDAO = new VoziloDAO();
				Vozilo v = vDAO.get(qResult.getInt("Vozilo"));
				result.setVozilo(v);
				result.setNijansa((NijansaBoje.getNijansaBoje(qResult
						.getString("Nijansa"))));
				result.setVrsta((VrstaBoje.getVrstaBoje(qResult
						.getString("Vrsta"))));
				result.setTip(qResult.getString("Tip"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	@Override
	public List<BojaVozila> getAll() {
		List<BojaVozila> result = new ArrayList<BojaVozila>();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Poèetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM BojeVozila ");

			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			while (qResult.next()) {
				BojaVozila temp = new BojaVozila();
				
				BojaDAO bDAO = new BojaDAO();
				Boja boja = bDAO.get(qResult.getInt("Boja"));				
				temp.setBoja(boja);
				
				VoziloDAO vDAO = new VoziloDAO();
				Vozilo v = vDAO.get(qResult.getInt("Vozilo"));
				temp.setVozilo(v);
				temp.setNijansa((NijansaBoje.getNijansaBoje(qResult
						.getString("Nijansa"))));
				temp.setVrsta((VrstaBoje.getVrstaBoje(qResult
						.getString("Vrsta"))));
				temp.setTip(qResult.getString("Tip"));
				result.add(temp);
			}

			// ako je prazno baci exception
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
	public boolean update(Integer id, BojaVozila bv) {
		boolean success = false;
		NijansaBoje nijansa = bv.getNijansa();
		VrstaBoje vrsta = bv.getVrsta();
		
		BojaDAO bDAO = new BojaDAO();
		Integer boja = bDAO.getID(bv.getBoja());
		
		VoziloDAO vDAO = new VoziloDAO();
		Vozilo v = vDAO.get(bv.getVozilo().getId());
		Integer vozilo = v.getId();
		
		String tip = bv.getTip();

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE `BojeVozila`"
							+ " SET, Nijansa = ?, Vrsta= ? , Boja= ? , Tip= ?"
							+ " WHERE Vozilo = ?");

			statement.setString(1, nijansa.toString());
			statement.setString(2, vrsta.toString());
			statement.setInt(3, boja);
			statement.setString(4, tip);
			statement.setInt(5, vozilo);

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
	public boolean delete(Integer idVozila) {
		boolean success = false;

		// Dobavljanje konekcije
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("DELETE`" + " FROM BojeVozila"
							+ " WHERE Vozilo = ? ");

			statement.setInt(1, idVozila);
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
		// TODO Auto-generated method stub
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo=vdao.get(1);
		
		BojeVozilaDAO b=new BojeVozilaDAO();
		BojaVozila bv=new BojaVozila(Boja.CRNA, vozilo, NijansaBoje.STANDARDNA, VrstaBoje.METALIK, "tip" );
		//Boja boja, Vozilo vozilo, NijansaBoje nijansa,
		//VrstaBoje vrsta, String tip
		b.create(bv);

	}

}
