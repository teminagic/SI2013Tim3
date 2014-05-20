package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Vozilo;

public class VoziloDAO implements IGenericDAO<Vozilo, String> {

	@Override
	public boolean create(Vozilo vozilo) {
		boolean success = false;

		// Posto se radi o create-u, prvo je potrebno saznati podatke koje
		// zelimo upisati u bazu
		// Koristimo gettere :D
		String marka = vozilo.get_marka();
		String tip = vozilo.get_tip();
		String model = vozilo.get_model();
		String brojSasije = vozilo.get_brojSasije();
		String oblikKaroserije = vozilo.get_oblikKaroserije();
		String godinaProizvodnje = vozilo.get_godinaProizvodnje();
		Integer motor = vozilo.get_motor();
		Double odnosSnageIMase = vozilo.get_odnosSnageIMase();
		Integer brojMjestaZaSjedenje = vozilo.get_brojMjestaZaSjedenje();
		Integer brojMjestaZaStajanje = vozilo.get_brojMjestaZaStajanje();
		Integer brojMjestaZaLezanje = vozilo.get_brojMjestaZaLezanje();
		String ekoKarakteristike = vozilo.get_ekoKarakteristike();
		Integer katalizator = vozilo.get_katalizator();
		/*
		 * Vozilo v = new Vozilo("Audi", "limuzina", "A4", "54",
		 * "oblikkaroserije", "2013",3,5.1,5,0,0,"maksimalna",1); String marka
		 * ="Audi"; String tip = "limuzina"; String model = "A4"; String
		 * brojSasije = "54"; String oblikKaroserije = "oblik"; String
		 * godinaProizvodnje = "2013"; Integer motor = 3; Double odnosSnageIMase
		 * = 5.1; Integer brojMjestaZaSjedenje = 5; Integer brojMjestaZaStajanje
		 * = 0; Integer brojMjestaZaLezanje = 0; String ekoKarakteristike =
		 * "maksimalna"; Integer katalizator = 1;
		 */

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `Vozilo`(`Marka`,`Tip`,`Model`,`BrojSasije`,`OblikKaroserije`,`GodinaProizvodnje`,`Motor`,"
							+ "`OdnosSnageIMase`,`BrojMjestaZaSjedenje`,`BrojMjestaZaStajanje`,`BrojMjestaZaLezanje`,`EkoKarakteristikaVozila`,"
							+ "`Katalizator`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ");

			statement.setString(1, marka);
			statement.setString(2, tip);
			statement.setString(3, model);
			statement.setString(4, brojSasije);
			statement.setString(5, oblikKaroserije);
			statement.setString(6, godinaProizvodnje);
			statement.setInt(7, motor);
			statement.setDouble(8, odnosSnageIMase);
			statement.setInt(9, brojMjestaZaSjedenje);
			statement.setInt(10, brojMjestaZaStajanje);
			statement.setInt(11, brojMjestaZaLezanje);
			statement.setString(12, ekoKarakteristike);
			statement.setInt(13, katalizator);

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
	public Vozilo get(String brojSasije) {

		Vozilo result = new Vozilo();

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Vozilo "
							+ "WHERE BrojSasije = ?");

			statement.setString(1, brojSasije);
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next()) {
				result.set_marka(qResult.getString("Marka"));
				result.set_tip(qResult.getString("Tip"));
				result.set_model(qResult.getString("Model"));
				result.set_brojSasije(qResult.getString("BrojSasije"));
				result.set_oblikKaroserije(qResult.getString("OblikKaroserije"));
				result.set_godinaProizvodnje(qResult
						.getString("GodinaProizvodnje"));
				result.set_motor(qResult.getInt("Motor"));
				result.set_odnosSnageIMase(qResult.getDouble("OdnosSnageIMase"));
				result.set_brojMjestaZaSjedenje(qResult
						.getInt("BrojMjestaZaSjedenje"));
				result.set_brojMjestaZaStajanje(qResult
						.getInt("BrojMjestaZaStajanje"));
				result.set_brojMjestaZaStajanje(qResult
						.getInt("BrojMjestaZaLezanje"));
				result.set_ekoKarakteristike(qResult
						.getString("EkoKarakteristikaVozila"));
				result.set_katalizator(qResult.getInt("Katalizator"));
			}

			// ako je prazno baci exception
			if (result == null)
				throw new EmptyStackException();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	@Override
	public List<Vozilo> getAll() {
		List<Vozilo> result = new ArrayList<Vozilo>();
		Vozilo temp = new Vozilo();

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Pocetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Vozilo ");

			qResult = statement.executeQuery();
			// Dobavljanje rezultata
			while (qResult.next()) {
				temp.set_marka(qResult.getString("Marka"));
				temp.set_tip(qResult.getString("Tip"));
				temp.set_model(qResult.getString("Model"));
				temp.set_brojSasije(qResult.getString("BrojSasije"));
				temp.set_oblikKaroserije(qResult.getString("OblikKaroserije"));
				temp.set_godinaProizvodnje(qResult
						.getString("GodinaProizvodnje"));
				temp.set_motor(qResult.getInt("Motor"));
				temp.set_odnosSnageIMase(qResult.getDouble("OdnosSnageIMase"));
				temp.set_brojMjestaZaSjedenje(qResult
						.getInt("BrojMjestaZaSjedenje"));
				temp.set_brojMjestaZaStajanje(qResult
						.getInt("BrojMjestaZaStajanje"));
				temp.set_brojMjestaZaStajanje(qResult
						.getInt("BrojMjestaZaLezanje"));
				temp.set_ekoKarakteristike(qResult
						.getString("EkoKarakteristikaVozila"));
				temp.set_katalizator(qResult.getInt("Katalizator"));
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
	public boolean update(Vozilo vozilo) {
		boolean success = false;

		// Posto se radi o create-u, prvo je potrebno saznati podatke koje
		// zelimo upisati u bazu
		// Koristimo gettere :D
		String marka = vozilo.get_marka();
		String tip = vozilo.get_tip();
		String model = vozilo.get_model();
		String brojSasije = vozilo.get_brojSasije();
		String oblikKaroserije = vozilo.get_oblikKaroserije();
		String godinaProizvodnje = vozilo.get_godinaProizvodnje();
		Integer motor = vozilo.get_motor();
		Double odnosSnageIMase = vozilo.get_odnosSnageIMase();
		Integer brojMjestaZaSjedenje = vozilo.get_brojMjestaZaSjedenje();
		Integer brojMjestaZaStajanje = vozilo.get_brojMjestaZaStajanje();
		Integer brojMjestaZaLezanje = vozilo.get_brojMjestaZaLezanje();
		String ekoKarakteristike = vozilo.get_ekoKarakteristike();
		Integer katalizator = vozilo.get_katalizator();

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE `Vozilo`"
							+ " SET Marka = ?, Tip = ?, Model = ?, BrojSasije = ?, OblikKaroserije =?,"
							+ " GodinaProizvodnje = ?, Motor = ?, "
							+ "OdnosSnageIMase = ?, BrojMjestaZaSjedenje = ?, BrojMjestaZaStajanje =?, "
							+ "BrojMjestaZaLezanje = ?, EkoKarakteristikaVozila = ?,"
							+ " Katalizator = ? " + " WHERE BrojSasije=?");

			statement.setString(1, marka);
			statement.setString(2, tip);
			statement.setString(3, model);
			statement.setString(4, brojSasije);
			statement.setString(5, oblikKaroserije);
			statement.setString(6, godinaProizvodnje);
			statement.setInt(7, motor);
			statement.setDouble(8, odnosSnageIMase);
			statement.setInt(9, brojMjestaZaSjedenje);
			statement.setInt(10, brojMjestaZaStajanje);
			statement.setInt(11, brojMjestaZaLezanje);
			statement.setString(12, ekoKarakteristike);
			statement.setInt(13, katalizator);
			statement.setString(14, brojSasije);

			statement.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return success;
	}

	// Nije provjerena!
	@Override
	public boolean delete(String brojSasije) {
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		boolean success = false;

		try {
			PreparedStatement statement = connection.prepareStatement("DELETE"
					+ " FROM `Vozilo` " + " WHERE BrojSasije = ? ");
			statement.setString(1, brojSasije);
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
		// Vozilo v = new Vozilo("Audi", "limuzina", "A1", "aaa54",
		// "oblikkaroserije", "2013",3,5.1,5,0,0,"maksimalna",1);
		// VoziloDAO vdao = new VoziloDAO();
		// vdao.create(v);
		// Vozilo voz = new Vozilo();
		// vdao.get("aa54");
		// List<Vozilo> vozilice = new ArrayList<Vozilo>();
		// vozilice = vdao.getAll();
		// vdao.delete("aa54");
		// vdao.update(v);
	}

}
