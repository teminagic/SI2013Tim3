package ba.co.edgewise.jmup.daldao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import ba.co.edgewise.enums.TipUposlenika;
import ba.co.edgewise.jmup.daldao.ConnectionManager;

import java.awt.image.BufferedImage;

import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.klase.Uposlenik;

public class UposlenikDAO implements IGenericDAO<Uposlenik, Integer> {
	@Override
	public boolean create(Uposlenik uposlenik) {
		boolean success = false;
		String ime = uposlenik.getIme();
		String prezime = uposlenik.getPrezime();
		@SuppressWarnings("unused")
		BufferedImage slikaKorisnika = uposlenik.getSlikaKorisnika();
		String korisnickoIme = uposlenik.getKorisnickoIme();
		String password = uposlenik.getPassword();
		Boolean status = uposlenik.getStatus();

		TipUposlenikaDAO tuDAO = new TipUposlenikaDAO();
		int tip = tuDAO.getID(uposlenik.getTip());

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();

		try {
			// Izmedju prezime i korisnicko ime fali slika
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `Uposlenik`(`Ime`,`Prezime`,"
							+ "`KorisnickoIme`,`Sifra`,`StatusKorisnika`, `TipKorisnika`) VALUES (?,?,?,?,?,?)");
			statement.setString(1, ime);
			statement.setString(2, prezime);
			// Treba dodati sliku
			statement.setString(3, korisnickoIme);
			statement.setString(4, password);
			statement.setBoolean(5, status);
			statement.setInt(6, tip);
			statement.executeUpdate();
			success = true; // - treba se srediti slika :)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return success;
	}

	@Override
	public Uposlenik get(Integer id) {
		Uposlenik result = new Uposlenik();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Uposlenik WHERE IdKorisnika = ?");
			statement.setInt(1, id);
			qResult = statement.executeQuery();
			if (qResult.next()) {
				result.setIme(qResult.getString("Ime"));
				result.setPrezime(qResult.getString("Prezime"));
				// Sliku dodati
				result.setKorisnickoIme(qResult.getString("KorisnickoIme"));
				result.setPassword(qResult.getString("Sifra"));
				result.setStatus(qResult.getBoolean("StatusKorisnika"));

				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				result.setTip(tipDAO.get(idTipa));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}

	public Uposlenik get(String korisnickoIme) {
		Uposlenik result = new Uposlenik();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Uposlenik WHERE KorisnickoIme = ?");
			statement.setString(1, korisnickoIme);
			qResult = statement.executeQuery();
			if (qResult.next()) {
				result.setId(qResult.getInt("IDUposlenika"));
				result.setIme(qResult.getString("Ime"));
				result.setPrezime(qResult.getString("Prezime"));
				// Sliku dodati
				result.setKorisnickoIme(qResult.getString("KorisnickoIme"));
				result.setPassword(qResult.getString("Sifra"));
				result.setStatus(qResult.getBoolean("StatusKorisnika"));
				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				result.setTip(tipDAO.get(idTipa));
			} else
				throw new EmptyStackException();
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
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Uposlenik");
			qResult = statement.executeQuery();
			while (qResult.next()) {
				Uposlenik uposlenik = new Uposlenik();
				uposlenik.setId(qResult.getInt("IDUposlenika"));
				uposlenik.setIme(qResult.getString("Ime"));
				uposlenik.setPrezime(qResult.getString("Prezime"));
				// Slika
				uposlenik.setKorisnickoIme(qResult.getString("KorisnickoIme"));
				uposlenik.setPassword(qResult.getString("Sifra"));
				// Provjeriti je li moze ovo getBoolean
				uposlenik.setStatus(qResult.getBoolean("StatusKorisnika"));
				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				uposlenik.setTip(tipDAO.get(idTipa));
				result.add(uposlenik);
			}
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
	public boolean update(Integer id, Uposlenik uposlenik) {
		boolean success = false;
		String ime = uposlenik.getIme();
		String prezime = uposlenik.getPrezime();
		// BufferedImage slikaKorisnika=uposlenik.getSlikaKorisnika();
		String korisnickoIme = uposlenik.getKorisnickoIme();
		String password = uposlenik.getPassword();
		Boolean status = uposlenik.getStatus();

		TipUposlenikaDAO tuDAO = new TipUposlenikaDAO();
		int tip = tuDAO.getID(uposlenik.getTip());

		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		try {
			// Dodati sliku
			PreparedStatement statement = connection
					.prepareStatement("UPDATE `Uposlenik`"
							+ " SET Ime = ?, Prezime = ?, KorisnickoIme = ?, Sifra = ?,"
							+ " StatusKorisnika = ?, TipKorisnika = ?"
							+ " WHERE IDKorisnika = ?");
			statement.setString(1, ime);
			statement.setString(2, prezime);
			// Treba dodati sliku
			statement.setString(3, korisnickoIme);
			statement.setString(4, password);
			statement.setBoolean(5, status);
			statement.setInt(6, tip);
			statement.setInt(7, id);

			statement.executeUpdate();

			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return success;
	}

	public boolean delete(Integer id) {
		boolean success = false;
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM Uposlenik WHERE IDKorisnika = ?;");
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
		Uposlenik u = new Uposlenik(1, "Irma", "Balic", "IrmaB", "pass", true,
				TipUposlenika.MENADZER);
		UposlenikDAO udao = new UposlenikDAO();
		udao.update(3, u);
		// udao.create(u);
		// udao.delete("AB");
		Uposlenik novi = udao.get("IrmaB");
		System.out.println(novi.getIme());
		// Uposlenik u=udao.get("IrmaB");

		List<Uposlenik> uposlenici = new ArrayList<Uposlenik>();
		// uposlenici.add(novi);
		uposlenici = udao.getAll();
		// System.out.println(uposlenici.get(1).getKorisnickoIme());
		// System.out.println(uposlenici.size());

		for (int i = 0; i < uposlenici.size(); i++) {
			System.out.println(uposlenici.get(i).getKorisnickoIme());
		}

		/*
		 * udao.delete("IrmaB"); uposlenici = udao.getAll();
		 */
	}
}
