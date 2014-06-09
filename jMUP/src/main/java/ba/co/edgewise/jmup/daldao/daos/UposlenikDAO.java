package ba.co.edgewise.jmup.daldao.daos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ba.co.edgewise.jmup.daldao.ConnectionManager;

import java.awt.image.BufferedImage;

import ba.co.edgewise.jmup.daldao.interfaces.IGenericDAO;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.klase.Uposlenik;

public class UposlenikDAO implements IGenericDAO<Uposlenik, Integer> {
	//hesiranje
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
 
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getMD5("Javarmi.com"));
    }
	@Override
	public boolean create(Uposlenik uposlenik) {
		boolean success = false;
		String ime = uposlenik.getIme();
		String prezime = uposlenik.getPrezime();
		@SuppressWarnings("unused")
		BufferedImage slikaKorisnika = uposlenik.getSlikaKorisnika();
		String korisnickoIme = uposlenik.getKorisnickoIme();
		String password = getMD5(uposlenik.getPassword());
		Status status = uposlenik.getStatus();

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
			statement.setString(5, status.toString());
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
					.prepareStatement("SELECT * FROM Uposlenik WHERE IdUposlenika = ?");
			statement.setInt(1, id);
			qResult = statement.executeQuery();
			if (qResult.next()) {
				result.setIme(qResult.getString("Ime"));
				result.setPrezime(qResult.getString("Prezime"));
				// Sliku dodati
				result.setKorisnickoIme(qResult.getString("KorisnickoIme"));
				result.setPassword(qResult.getString("Sifra"));
				result.setStatus(Status.getStatus(qResult.getString("StatusKorisnika")));

				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				result.setTip(tipDAO.get(idTipa));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
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
				result.setStatus(Status.getStatus(qResult.getString("StatusKorisnika")));
				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				result.setTip(tipDAO.get(idTipa));
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
	public ArrayList<Uposlenik> getAll() {
		ArrayList<Uposlenik> result = new ArrayList<Uposlenik>();
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
				uposlenik.setStatus(Status.getStatus(qResult.getString("StatusKorisnika")));
				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				uposlenik.setTip(tipDAO.get(idTipa));
				result.add(uposlenik);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}
	
	public ArrayList<Uposlenik> getAllByIme(String ime) {
		ArrayList<Uposlenik> result = new ArrayList<Uposlenik>();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Uposlenik WHERE Ime = ?");
			statement.setString(1, ime);
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
				uposlenik.setStatus(Status.getStatus(qResult.getString("StatusKorisnika")));
				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				uposlenik.setTip(tipDAO.get(idTipa));
				result.add(uposlenik);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(qResult);
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}
	
	public ArrayList<Uposlenik> getAllByPrezime(String prezime) {
		ArrayList<Uposlenik> result = new ArrayList<Uposlenik>();
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		ResultSet qResult = null;
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Uposlenik WHERE Prezime = ?");
			statement.setString(1, prezime);
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
				uposlenik.setStatus(Status.getStatus(qResult.getString("StatusKorisnika")));
				// Tip uposlenika enum
				int idTipa = qResult.getInt("TipKorisnika");
				TipUposlenikaDAO tipDAO = new TipUposlenikaDAO();
				uposlenik.setTip(tipDAO.get(idTipa));
				result.add(uposlenik);
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
	public boolean update(Integer id, Uposlenik uposlenik) {
		boolean success = false;
		String ime = uposlenik.getIme();
		String prezime = uposlenik.getPrezime();
		// BufferedImage slikaKorisnika=uposlenik.getSlikaKorisnika();
		String korisnickoIme = uposlenik.getKorisnickoIme();
		String password = getMD5(uposlenik.getPassword());
		Status status = uposlenik.getStatus();

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
							+ " WHERE IDUposlenika = ?");
			statement.setString(1, ime);
			statement.setString(2, prezime);
			// Treba dodati sliku
			statement.setString(3, korisnickoIme);
			statement.setString(4, password);
			statement.setString(5, status.toString());
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
					.prepareStatement("DELETE FROM Uposlenik WHERE IDUposlenika = ?;");
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
}
