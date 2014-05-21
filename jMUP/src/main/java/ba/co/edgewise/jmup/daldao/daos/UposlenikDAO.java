package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import ba.co.edgewise.jmup.daldao.ConnectionManager;

import java.awt.image.BufferedImage;

import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.klase.Vozilo;


public class UposlenikDAO implements IGenericDAO<Uposlenik, String> {
	@Override
	public boolean create(Uposlenik uposlenik) {
		boolean success = false;
		String ime=uposlenik.getIme();
		String prezime=uposlenik.getPrezime();
		BufferedImage slikaKorisnika=uposlenik.getSlikaKorisnika();
		String korisnickoIme=uposlenik.getKorisnickoIme();
		String password=uposlenik.getPassword();
		Boolean status=uposlenik.getStatus();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		try {
			//Izmedju prezime i korisnicko ime fali slika
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `Uposlenik`(`Ime`,`Prezime`,"
					+ "`KorisnickoIme`,`Password`,`Status`) VALUES (?,?,?,?,?)");
			statement.setString(1, ime);
			statement.setString(2, prezime);
			//Treba dodati sliku
			statement.setString(3, korisnickoIme);
			statement.setString(4, password);
			statement.setBoolean(5, status);
			statement.executeUpdate();
			//success = true; - treba se srediti slika :)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return success;
	}
	
	public Uposlenik get(String korisnickoIme) {
		Uposlenik result = new Uposlenik();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Uposlenik WHERE KorisnickoIme = ?");
			statement.setString(1, korisnickoIme);
			qResult = statement.executeQuery();
			if (qResult.next()) {
				result.setIme(qResult.getString("Ime"));
				result.setPrezime(qResult.getString("Prezime"));
				//Sliku dodati
				result.setKorisnickoIme(qResult.getString("KorisnickoIme"));
				result.setPassword(qResult.getString("Password"));
				result.setStatus(qResult.getBoolean("Status"));
			}
			if (result == null) throw new EmptyStackException();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}
	
	@Override
	public List<Uposlenik> getAll() {
		List<Uposlenik> result = new ArrayList<Uposlenik>();
		Uposlenik uposlenik = new Uposlenik();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Uposlenik");
			qResult = statement.executeQuery();
			while (qResult.next()) {
				uposlenik.setIme(qResult.getString("Ime"));
				uposlenik.setPrezime(qResult.getString("Prezime"));
				// Slika
				uposlenik.setKorisnickoIme(qResult.getString("KorisnickoIme"));
				uposlenik.setPassword(qResult.getString("Password"));
				//Provjeriti je li moze ovo getBoolean
				uposlenik.setStatus(qResult.getBoolean("Status"));		
				result.add(uposlenik);
			}
			if (result.size() == 0) throw new EmptyStackException();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}
	
	@Override
	public boolean update(Uposlenik uposlenik) {
		boolean success = false;
		String ime=uposlenik.getIme();
		String prezime=uposlenik.getPrezime();
		BufferedImage slikaKorisnika=uposlenik.getSlikaKorisnika();
		String korisnickoIme=uposlenik.getKorisnickoIme();
		String password=uposlenik.getPassword();
		Boolean status=uposlenik.getStatus();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		try {
			//Dodati sliku
			PreparedStatement statement = connection.prepareStatement("UPDATE `Uposlenik`"
							+ " SET Ime = ?, Prezime = ?, KorisnickoIme = ?, Password = ?, Status =?"
							+ " WHERE KorisnickoIme=?");
			statement.setString(1, ime);
			statement.setString(2, prezime);
			//Treba dodati sliku
			statement.setString(3, korisnickoIme);
			statement.setString(4, password);
			statement.setBoolean(5, status);
			statement.executeUpdate();
			//success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return success;
	}
	public boolean delete(String korisnickoIme) {
		boolean success = false;
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Uposlenik WHERE KorisnickoIme = ?;");
			statement.setString(1, korisnickoIme);
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
		/*
		Uposlenik u = new Uposlenik("Irma","Balic","IrmaB","pass",true);
		UposlenikDAO udao = new UposlenikDAO();
		udao.create(u);
		udao.get("IrmaB");
		List<Uposlenik> uposlenici = new ArrayList<Uposlenik>();
		uposlenici = udao.getAll();
		udao.delete("IrmaB");
		uposlenici = udao.getAll();
		*/
	}
}
