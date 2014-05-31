package ba.co.edgewise.jmup.daldao.daos;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import ba.co.edgewise.jmup.daldao.ConnectionManager;
import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.NijansaBoje;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.VrstaBoje;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.BojaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;

public class VoziloDAO implements IGenericDAO<Vozilo, Integer> {

	//Odrađeno
	@Override
	public boolean create(Vozilo vozilo) {
		
		boolean success = false;

		//Podaci motora
		Integer motorId;
		Integer zapremina = vozilo.getMotor().getZapreminaMotora();
		Integer maxSnaga = vozilo.getMotor().getMaxSnaga();
		String vrstaGoriva = vozilo.getMotor().getVrstaGoriva().toString();
		String vrstaMotora = vozilo.getMotor().getVrstaMotora().toString();
		String brojMotora = vozilo.getMotor().getBrojMotora();
		
		//Podaci vozila
		Integer voziloId;
		String reg = vozilo.getRegistarskaOznaka();
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
		Double odnosSnageIMase = vozilo.getOdnosSnageIMase();
		Integer brojMjestaZaSjedenje = vozilo.getBrojMjestaZaSjedenje();
		Integer brojMjestaZaStajanje = vozilo.getBrojMjestaZaStajanje();
		Integer brojMjestaZaLezanje = vozilo.getBrojMjestaZaLezanje();
		EkoKarakteristike ekoKarakteristika = vozilo.getEkoKarakteristika();
		Boolean katalizator = vozilo.getKatalizator();
		Date datumPregleda = vozilo.getDatumPregleda();
		BojaVozila boja = vozilo.getBojaVozila();
		Status statusVozila = vozilo.getStatusVozila();
		

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		Savepoint save1 = null;

		try {
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			save1 = connection.setSavepoint();
			//Motor unos

			PreparedStatement statement1 = connection
					.prepareStatement("INSERT INTO `Motor`(`ZapreminaMotora`, `MaksimalnaSnaga`, `VrstaGoriva`, `BrojMotora`, `VrstaMotora`) "
							+ " VALUES (?,?,?,?,?) ");

			statement1.setInt(1, zapremina);
			statement1.setInt(2, maxSnaga);
			statement1.setString(3, vrstaGoriva);
			statement1.setString(4, brojMotora);
			statement1.setString(5, vrstaMotora);

			statement1.executeUpdate();
			
			//Dobavi id novoupisanog motora
			PreparedStatement statement2 = connection
					.prepareStatement("SELECT IDMotora FROM Motor WHERE BrojMotora = ?");
			statement2.setString(1, vozilo.getMotor().getBrojMotora());
			
			ResultSet  qResult = statement2.executeQuery();
			qResult.next();
			
			motorId = qResult.getInt("IDMotora");
			
			//Vozilo unos
			
			PreparedStatement statement3 = connection
					.prepareStatement("INSERT INTO  `sql339553`.`Vozilo` (" +
							"`Vrsta`, `Marka`, `Tip`, `Model`, `BrojSasije`,"+
							"`OblikKaroserije`,`GodinaProizvodnje` ,`MaxTehnickaDozvoljenaMasa` ,"+
							"`MasaVozila` , `DopustenaNosivost` , `Motor` , `OdnosSnageIMase` ,"+
							"`BrojMjestaZaSjedenje` ,`BrojMjestaZaStajanje` ,`BrojMjestaZaLezanje` ," +
							"`EkoKarakteristikaVozila`,`Katalizator`,`DatumPregleda`,`RegOznaka`,`Status`)"+
							"VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			statement3.setString(1, vrsta);
			statement3.setString(2, marka);
			statement3.setString(3, tip);
			statement3.setString(4, model);
			statement3.setString(5, brojSasije);
			statement3.setString(6, oblikKaroserije);
			statement3.setInt(7, godinaProizvodnje);
			statement3.setInt(8, maxTehnickaDozvoljenaMasa);
			statement3.setInt(9, masaVozila);
			statement3.setInt(10, dopustenaNosivost);
			statement3.setInt(11, motorId);
			statement3.setDouble(12, odnosSnageIMase);
			statement3.setInt(13, brojMjestaZaSjedenje);
			statement3.setInt(14, brojMjestaZaStajanje);
			statement3.setInt(15, brojMjestaZaLezanje);
			statement3.setString(16, ekoKarakteristika.toString());
			statement3.setBoolean(17, katalizator);
			statement3.setDate(18, new java.sql.Date(datumPregleda.getTime()));
			statement3.setString(19, reg);
			statement3.setString(20, statusVozila.toString());

			statement3.executeUpdate();
			
			//Dobavi Id novounesenog vozila
			PreparedStatement statement4 = connection
					.prepareStatement("SELECT IDVozila FROM Vozilo WHERE RegOznaka = ?");
			statement4.setString(1, reg);
			qResult = statement4.executeQuery();
			
			qResult.next();
			voziloId = qResult.getInt("IDVozila");
			
			//Unos boje
			PreparedStatement statement5 = connection
					.prepareStatement("INSERT INTO `BojeVozila`(`Nijansa`, `Vrsta`, `Boja`, `Tip`, `Vozilo`) "
							+ " VALUES (?,?,?,?,?) ");

			statement5.setString(1, boja.getNijansa().toString());
			statement5.setString(2, boja.getVrsta().toString());
			
			BojaDAO bDAO = new BojaDAO();
			Integer idBoje = bDAO.getID(boja.getBoja());
			
			statement5.setInt(3, idBoje);
			statement5.setString(4, boja.getTip());
			statement5.setInt(5, voziloId);

			statement5.executeUpdate();
			
			connection.commit();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback(save1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.releaseSavepoint(save1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.closeConnection(connection);
		}

		return success;
	}

	//Završeno
	@Override
	public Vozilo get(Integer id) {

		Vozilo result = new Vozilo();

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;

		try {
			PreparedStatement statement1 = connection
					.prepareStatement("SELECT * " + "FROM Vozilo "
							+ "WHERE IDVozila = ?");

			statement1.setInt(1, id);
			qResult = statement1.executeQuery();

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
				result.setRegistarskaOznaka(qResult.getString("RegOznaka"));
				result.setStatusVozila(Status.getStatus(qResult.getString("Status")));
				
				BojeVozilaDAO bojaDAO = new BojeVozilaDAO();
				BojaVozila boja = bojaDAO.get(result.getId());
				result.setBojaVozila(boja);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	public Vozilo getByReg(String reg) {

		Vozilo result = new Vozilo();

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Vozilo "
							+ "WHERE RegOznaka  = ?");

			statement.setString(1, reg);
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
				result.setRegistarskaOznaka(qResult.getString("RegOznaka"));
				result.setStatusVozila(Status.getStatus(qResult.getString("Status")));
				
				BojeVozilaDAO bojaDAO = new BojeVozilaDAO();
				BojaVozila boja = bojaDAO.get(result.getId());
				result.setBojaVozila(boja);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	public ArrayList<Vozilo> getByDate(Integer date) {

		ArrayList<Vozilo> result = new ArrayList<Vozilo>();

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Pocetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Vozilo " + "WHERE GodinaProizvodnje = ?");
			statement.setInt(1, date);
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
				temp.setRegistarskaOznaka(qResult.getString("RegOznaka"));
				temp.setStatusVozila(Status.getStatus(qResult.getString("Status")));
				
				BojeVozilaDAO bojaDAO = new BojeVozilaDAO();
				BojaVozila boja = bojaDAO.get(temp.getId());
				temp.setBojaVozila(boja);
				
				result.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	
	public ArrayList<Vozilo> getByType(String type) {

		ArrayList<Vozilo> result = new ArrayList<Vozilo>();

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Pocetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Vozilo " + "WHERE Vrsta = ?");
			statement.setString(1, type);
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
				temp.setRegistarskaOznaka(qResult.getString("RegOznaka"));
				temp.setStatusVozila(Status.getStatus(qResult.getString("Status")));
				
				BojeVozilaDAO bojaDAO = new BojeVozilaDAO();
				BojaVozila boja = bojaDAO.get(temp.getId());
				temp.setBojaVozila(boja);
				
				result.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}
	
	public ArrayList<Vozilo> getByMark(String marka) {

		ArrayList<Vozilo> result = new ArrayList<Vozilo>();

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		// Pocetak pripreme upita
		ResultSet qResult = null;

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * " + "FROM Vozilo " + "WHERE Marka = ?");
			statement.setString(1, marka);
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
				temp.setRegistarskaOznaka(qResult.getString("RegOznaka"));
				temp.setStatusVozila(Status.getStatus(qResult.getString("Status")));
				
				BojeVozilaDAO bojaDAO = new BojeVozilaDAO();
				BojaVozila boja = bojaDAO.get(temp.getId());
				temp.setBojaVozila(boja);
				
				result.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	//
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
				temp.setRegistarskaOznaka(qResult.getString("RegOznaka"));
				temp.setStatusVozila(Status.getStatus(qResult.getString("Status")));
				
				BojeVozilaDAO bojaDAO = new BojeVozilaDAO();
				BojaVozila boja = bojaDAO.get(temp.getId());
				temp.setBojaVozila(boja);
				
				result.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

		return result;
	}

	//Izmjenjen, nije testirana
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
		String reg = vozilo.getRegistarskaOznaka();
		Status statusVozila = vozilo.getStatusVozila();
		
		Integer zapremina = vozilo.getMotor().getZapreminaMotora();
		Integer maxSnaga = vozilo.getMotor().getMaxSnaga();
		String vrstaGoriva = vozilo.getMotor().getVrstaGoriva().toString();
		String vrstaMotora = vozilo.getMotor().getVrstaMotora().toString();
		String brojMotora = vozilo.getMotor().getBrojMotora();
		
		NijansaBoje nijansa = vozilo.getBojaVozila().getNijansa();
		VrstaBoje vrstaBoje = vozilo.getBojaVozila().getVrsta();
		
		BojaDAO bDAO = new BojaDAO();
		Integer boja = bDAO.getID(vozilo.getBojaVozila().getBoja());
		
		String tipBoje = vozilo.getBojaVozila().getTip();
		

		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		Savepoint save1 = null;

		try {
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			save1 = connection.setSavepoint();
			
			
			PreparedStatement statement1 = connection
					.prepareStatement("UPDATE `Vozilo`"
							+ " SET Vrsta = ?, Marka = ?, Tip = ?, Model = ?, BrojSasije = ?, "
							+ "OblikKaroserije =?, GodinaProizvodnje = ?, MaxTehnickaDozvoljenaMasa = ?,"
							+ "MasaVozila=?, DopustenaNosivost = ?, Motor = ?, "
							+ "OdnosSnageIMase = ?, BrojMjestaZaSjedenje = ?, BrojMjestaZaStajanje =?, "
							+ "BrojMjestaZaLezanje = ?, EkoKarakteristikaVozila = ?,"
							+ " Katalizator = ?, DatumPregleda = ?, RegOznaka = ?, Status = ?" 
							+ " WHERE IDVozila=?");

			statement1.setString(1, vrsta);
			statement1.setString(2, marka);
			statement1.setString(3, tip);
			statement1.setString(4, model);
			statement1.setString(5, brojSasije);
			statement1.setString(6, oblikKaroserije);
			statement1.setInt(7, godinaProizvodnje);
			statement1.setInt(8, maxTehnickaDozvoljenaMasa);
			statement1.setInt(9, masaVozila);
			statement1.setInt(10, dopustenaNosivost);
			statement1.setInt(11, motor.getId());
			statement1.setDouble(12, odnosSnageIMase);
			statement1.setInt(13, brojMjestaZaSjedenje);
			statement1.setInt(14, brojMjestaZaStajanje);
			statement1.setInt(15, brojMjestaZaLezanje);
			statement1.setString(16, ekoKarakteristika.toString());
			statement1.setBoolean(17, katalizator);
			statement1.setDate(18, new java.sql.Date(datumPregleda.getTime()));
			statement1.setString(19, reg);
			statement1.setString(20, statusVozila.toString());
			statement1.setInt(21, vozilo.getId());
			
			statement1.executeUpdate();
			
			
			PreparedStatement statement2 = connection
					.prepareStatement("UPDATE `Motor`"
							+ " SET ZapreminaMotora = ? , MaksimalnaSnaga= ?, VrstaGoriva= ?, VrstaMotora= ?, BrojMotora = ? "
							+ " WHERE IDMotora = ? ");

			statement2.setInt(1, zapremina);
			statement2.setInt(2, maxSnaga);
			statement2.setString(3, vrstaGoriva);
			statement2.setString(4, vrstaMotora);
			statement2.setString(5, brojMotora);
			statement2.setInt(6, motor.getId());

			statement2.executeUpdate();
			
			PreparedStatement statement3 = connection
					.prepareStatement("UPDATE `BojeVozila`"
							+ " SET Nijansa = ?, Vrsta= ? , Boja= ? , Tip= ?"
							+ " WHERE Vozilo = ?");

			statement3.setString(1, nijansa.toString());
			statement3.setString(2, vrstaBoje.toString());
			statement3.setInt(3, boja);
			statement3.setString(4, tipBoje.toString());
			statement3.setInt(5, id);

			statement3.executeUpdate();
			
			connection.commit();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback(save1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionManager.closeConnection(connection);
			try {
				connection.releaseSavepoint(save1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return success;
	}
	
	//deaktivira vozilo
	@Override
	public boolean delete(Integer id) {
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		boolean success = false;

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE `Vozilo`"
							+ " SET Status = ?"
							+ " WHERE IDVozila = ?");
			statement.setString(1, "Neaktivan");
			statement.setInt(2, id);
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
		VoziloDAO v = new VoziloDAO();
		v.delete(65);
	}
}
