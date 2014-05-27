package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ba.co.edgewise.enums.EkoKarakteristike;
import ba.co.edgewise.enums.VrstaVozila;
import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Vozilo;

public class VoziloDAO implements IGenericDAO<Vozilo, Integer> {

	@Override
	public boolean create(Vozilo vozilo) {
		boolean success = false;

		// Posto se radi o create-u, prvo je potrebno saznati podatke koje
		// zelimo upisati u bazu
		// Koristimo gettere :D
		String vrsta = vozilo.getVrsta().toString();
		String marka = vozilo.getMarka();
		String tip = vozilo.getTip();
		String model = vozilo.getModel();
		String brojSasije = vozilo.getBrojSasije();
		String oblikKaroserije = vozilo.getOblikKaroserije();
		int godinaProizvodnje = vozilo.getGodinaProizvodnje();
		int maxTehnickaDozvoljenaMasa = vozilo.getMaxTehnickaDozvoljenaMasa();
		int masaVozila = vozilo.getMasaVozila();
		int dopustenaNosivost = vozilo.getDopustenaNosivost();
		Motor motor = vozilo.getMotor();
		Double odnosSnageIMase = vozilo.getOdnosSnageIMase();
		Integer brojMjestaZaSjedenje = vozilo.getBrojMjestaZaSjedenje();
		Integer brojMjestaZaStajanje = vozilo.getBrojMjestaZaStajanje();
		Integer brojMjestaZaLezanje = vozilo.getBrojMjestaZaLezanje();
		EkoKarakteristike ekoKarakteristika = vozilo.getEkoKarakteristika();
		Boolean katalizator = vozilo.getKatalizator();
		Date datumPregleda = vozilo.getDatumPregleda();
		

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO  `sql339553`.`Vozilo` (" +
							"`Vrsta`, `Marka`, `Tip`, `Model`, `BrojSasije`,"+
							"`OblikKaroserije`,`GodinaProizvodnje` ,`MaxTehnickaDozvoljenaMasa` ,"+
							"`MasaVozila` , `DopustenaNosivost` , `Motor` , `OdnosSnageIMase` ,"+
							"`BrojMjestaZaSjedenje` ,`BrojMjestaZaStajanje` ,`BrojMjestaZaLezanje` ," +
							"`EkoKarakteristikaVozila` ,`Katalizator` ,`DatumPregleda`)" +
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

			statement.setString(1, vrsta);
			statement.setString(2, marka);
			statement.setString(3, tip);
			statement.setString(4, model);
			statement.setString(5, brojSasije);
			statement.setString(6, oblikKaroserije);
			statement.setInt(7, godinaProizvodnje);
			statement.setInt(8, maxTehnickaDozvoljenaMasa);
			statement.setInt(9, masaVozila);
			statement.setInt(10, dopustenaNosivost);
			statement.setInt(11, motor.getId());
			statement.setDouble(12, odnosSnageIMase);
			statement.setInt(13, brojMjestaZaSjedenje);
			statement.setInt(14, brojMjestaZaStajanje);
			statement.setInt(15, brojMjestaZaLezanje);
			statement.setString(16, ekoKarakteristika.toString());
			statement.setBoolean(17, katalizator);
			statement.setDate(18, new java.sql.Date(datumPregleda.getTime()));
			
			

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
	public Vozilo get(Integer id) {

		Vozilo result = new Vozilo();

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Vozilo "
							+ "WHERE IDVozila = ?");

			statement.setInt(1, id);
			qResult = statement.executeQuery();

			// Dobavljanje rezultata
			if (qResult.next()) {
				result.setId(qResult.getInt("IDVozila"));
				result.setVrsta(VrstaVozila.getVrstaVozila(qResult.getString("Vrsta")));
				result.setMarka(qResult.getString("Marka"));
				result.setTip(qResult.getString("Tip"));
				result.setModel(qResult.getString("Model"));
				result.setBrojSasije(qResult.getString("BrojSasije"));
				result.setOblikKaroserije(qResult.getString("OblikKaroserije"));
				result.setGodinaProizvodnje(qResult.getInt("GodinaProizvodnje"));
				result.setMaxTehnickaDozvoljenaMasa(qResult.getInt("MaxTehnickaDozvoljenaMasa"));
				result.setMasaVozila(qResult.getInt("MasaVozila"));
				result.setDopustenaNosivost(qResult.getInt("DopustenaNosivost"));
				
				MotorDAO motorDAO = new MotorDAO();
				result.setMotor(motorDAO.get(qResult.getInt("Motor")));
				
				result.setOdnosSnageIMase(qResult.getDouble("OdnosSnageIMase"));
				result.setBrojMjestaZaSjedenje(qResult.getInt("BrojMjestaZaSjedenje"));
				result.setBrojMjestaZaStajanje(qResult.getInt("BrojMjestaZaStajanje"));
				result.setBrojMjestaZaLezanje(qResult.getInt("BrojMjestaZaLezanje"));
				result.setEkoKarakteristika(EkoKarakteristike.getEkoKarakteristike
						(qResult.getString("EkoKarakteristikaVozila")));
				result.setKatalizator(qResult.getBoolean("Katalizator"));
				result.setDatumPregleda(qResult.getDate("DatumPregleda"));
			}

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
				
				Vozilo temp = new Vozilo();
				
				temp.setId(qResult.getInt("IDVozila"));
				temp.setVrsta(VrstaVozila.getVrstaVozila(qResult.getString("Vrsta")));
				temp.setMarka(qResult.getString("Marka"));
				temp.setTip(qResult.getString("Tip"));
				temp.setModel(qResult.getString("Model"));
				temp.setBrojSasije(qResult.getString("BrojSasije"));
				temp.setOblikKaroserije(qResult.getString("OblikKaroserije"));
				temp.setGodinaProizvodnje(qResult.getInt("GodinaProizvodnje"));
				temp.setMaxTehnickaDozvoljenaMasa(qResult.getInt("MaxTehnickaDozvoljenaMasa"));
				temp.setMasaVozila(qResult.getInt("MasaVozila"));
				temp.setDopustenaNosivost(qResult.getInt("DopustenaNosivost"));
				
				MotorDAO motorDAO = new MotorDAO();
				temp.setMotor(motorDAO.get(qResult.getInt("Motor")));
				
				temp.setOdnosSnageIMase(qResult.getDouble("OdnosSnageIMase"));
				temp.setBrojMjestaZaSjedenje(qResult.getInt("BrojMjestaZaSjedenje"));
				temp.setBrojMjestaZaStajanje(qResult.getInt("BrojMjestaZaStajanje"));
				temp.setBrojMjestaZaLezanje(qResult.getInt("BrojMjestaZaLezanje"));
				temp.setEkoKarakteristika(EkoKarakteristike.getEkoKarakteristike
						(qResult.getString("EkoKarakteristikaVozila")));
				temp.setKatalizator(qResult.getBoolean("Katalizator"));
				temp.setDatumPregleda(qResult.getDate("DatumPregleda"));
				result.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	@Override
	public boolean update(Integer id, Vozilo vozilo) {
		boolean success = false;

		String vrsta = vozilo.getVrsta().toString();
		String marka = vozilo.getMarka();
		String tip = vozilo.getTip();
		String model = vozilo.getModel();
		String brojSasije = vozilo.getBrojSasije();
		String oblikKaroserije = vozilo.getOblikKaroserije();
		int godinaProizvodnje = vozilo.getGodinaProizvodnje();
		int maxTehnickaDozvoljenaMasa = vozilo.getMaxTehnickaDozvoljenaMasa();
		int masaVozila = vozilo.getMasaVozila();
		int dopustenaNosivost = vozilo.getDopustenaNosivost();
		Motor motor = vozilo.getMotor();
		Double odnosSnageIMase = vozilo.getOdnosSnageIMase();
		Integer brojMjestaZaSjedenje = vozilo.getBrojMjestaZaSjedenje();
		Integer brojMjestaZaStajanje = vozilo.getBrojMjestaZaStajanje();
		Integer brojMjestaZaLezanje = vozilo.getBrojMjestaZaLezanje();
		EkoKarakteristike ekoKarakteristika = vozilo.getEkoKarakteristika();
		Boolean katalizator = vozilo.getKatalizator();
		Date datumPregleda = vozilo.getDatumPregleda();

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE `Vozilo`"
							+ " SET Vrsta = ?, Marka = ?, Tip = ?, Model = ?, BrojSasije = ?, "
							+ "OblikKaroserije =?, GodinaProizvodnje = ?, MaxTehnickaDozvoljenaMasa = ?"
							+ "MasaVozila=?, DopustenaNosivost = ?, Motor = ?, "
							+ "OdnosSnageIMase = ?, BrojMjestaZaSjedenje = ?, BrojMjestaZaStajanje =?, "
							+ "BrojMjestaZaLezanje = ?, EkoKarakteristikaVozila = ?,"
							+ " Katalizator = ?, DatumPregleda = ?" 
							+ " WHERE IDVozila=?");

			statement.setString(1, vrsta);
			statement.setString(2, marka);
			statement.setString(3, tip);
			statement.setString(4, model);
			statement.setString(5, brojSasije);
			statement.setString(6, oblikKaroserije);
			statement.setInt(7, godinaProizvodnje);
			statement.setInt(8, maxTehnickaDozvoljenaMasa);
			statement.setInt(9, masaVozila);
			statement.setInt(10, dopustenaNosivost);
			statement.setInt(11, motor.getId());
			statement.setDouble(12, odnosSnageIMase);
			statement.setInt(13, brojMjestaZaSjedenje);
			statement.setInt(14, brojMjestaZaStajanje);
			statement.setInt(15, brojMjestaZaLezanje);
			statement.setString(16, ekoKarakteristika.toString());
			statement.setBoolean(17, katalizator);
			statement.setDate(18, new java.sql.Date(datumPregleda.getTime()));

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
	public boolean delete(Integer id) {
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		boolean success = false;

		try {
			PreparedStatement statement = connection.prepareStatement("DELETE"
					+ " FROM `Vozilo` " + " WHERE IDVozila = ? ");
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
		// Vozilo v = new Vozilo("Audi", "limuzina", "A1", "aaa54",
		// "oblikkaroserije", "2013",3,5.1,5,0,0,"maksimalna",1);
		
		//MotorDAO mDAO = new MotorDAO();
		//Motor motor = mDAO.getAll().get(1);
		
		//Vozilo v = new Vozilo(null, VrstaVozila.Putnicki_automobil, "Audi", "limuzina",
		//			"A1", "aaa54", "oblikkaroserije", 2013, 4500,
		//			3000, 1500, motor, 5.1, 5, 0, 0, EkoKarakteristike.Euro_2, true, new Date());
		VoziloDAO vdao = new VoziloDAO();
		
		//vdao.create(v);
		Vozilo voz = vdao.get(21);
		System.out.println("Ovo je: " + voz.getVrsta());
		//List<Vozilo> vozilice = new ArrayList<Vozilo>();
		//vozilice = vdao.getAll();
		//for (Vozilo tmp: vozilice)
		//{
		//	System.out.println("Ovo je: " + tmp.getMarka() + tmp.getId());
		//}
		// vdao.delete("aa54");
		// vdao.update(v);
	}

}
