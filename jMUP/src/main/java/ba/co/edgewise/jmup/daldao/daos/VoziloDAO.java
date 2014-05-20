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

public class VoziloDAO  implements IGenericDAO<Vozilo, String> {
	
	@Override
	public boolean create(Vozilo vozilo)
	{
		boolean success = false;
		
		// Posto se radi o create-u, prvo je potrebno saznati podatke koje zelimo upisati u bazu
		// Koristimo gettere :D
		/*String marka = vozilo.get_marka();
		String tip = vozilo.get_tip();
		String model = vozilo.get_model();
		String brojSasije =  vozilo.get_brojSasije();
		String oblikKaroserije = vozilo.get_oblikKaroserije();
		String godinaProizvodnje = vozilo.get_godinaProizvodnje();
		Integer motor = vozilo.get_motor();
		Double odnosSnageIMase = vozilo.get_odnosSnageIMase();
		Integer brojMjestaZaSjedenje = vozilo.get_brojMjestaZaSjedenje();
		Integer brojMjestaZaStajanje = vozilo.get_brojMjestaZaStajanje();
		Integer brojMjestaZaLezanje = vozilo.get_brojMjestaZaLezanje();
		String ekoKarakteristike = vozilo.get_ekoKarakteristike();
		Integer katalizator = vozilo.get_katalizator();*/
		Vozilo v = new Vozilo("Audi", "limuzina", "A4", "54", "oblikkaroserije", "2013",3,5.1,5,0,0,"maksimalna",1);
		String marka ="Audi";
		String tip = "limuzina";
		String model = "A4";
		String brojSasije = "54";
		String oblikKaroserije = "oblik";
		String godinaProizvodnje = "2013";
		Integer motor = 3;
		Double odnosSnageIMase = 5.1;
		Integer brojMjestaZaSjedenje = 5;
		Integer brojMjestaZaStajanje = 0;
		Integer brojMjestaZaLezanje = 0;
		String ekoKarakteristike = "maksimalna";
		Integer katalizator = 1;
		
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		try {
			PreparedStatement statement = 	connection.prepareStatement(
					"INSERT INTO `Vozilo`(`Marka`,`Tip`,`Model`,`BrojSasije`,`OblikKaroserije`,`GodinaProizvodnje`,`Motor`,"
					+ "`OdnosSnageIMase`,`BrojMjestaZaSjedenje`,`BrojMjestaZaStajanje`,`BrojMjestaZaLezanje`,`EkoKarakteristikaVozila`,"
					+ "`Katalizator`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			
			statement.setString(1,marka);
			statement.setString(2,tip);
			statement.setString(3,model);
			statement.setString(4,brojSasije);
			statement.setString(5,oblikKaroserije);
			statement.setString(6,godinaProizvodnje);
			statement.setInt(7,motor);
			statement.setDouble(8,odnosSnageIMase);
			statement.setInt(9,brojMjestaZaSjedenje);
			statement.setInt(10,brojMjestaZaStajanje);
			statement.setInt(11,brojMjestaZaLezanje);
			statement.setString(12,ekoKarakteristike);
			statement.setInt(13,katalizator);
			
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
	 public Vozilo get(String Id)
	{
		
		Vozilo result = new Vozilo();
		
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		return result;
	}
	
	@Override
	 public List<Vozilo> getAll()
	{
		List<Vozilo> result = new ArrayList<Vozilo>();
		Vozilo temp = new Vozilo();
		
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		
		boolean success = false;
		return result;
	}
	
	@Override
	 public boolean update(Vozilo v)
	{
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		boolean success = false;
		return false;
	}
	
	@Override
	 public boolean delete(String id)
	{
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		boolean success = false;
		return false;
	}
	
	
	public static void main (String[] args){
		Vozilo v = new Vozilo("Audi", "limuzina", "A4", "54", "oblikkaroserije", "2013",3,5.1,5,0,0,"maksimalna",1);
		VoziloDAO vdao = new VoziloDAO();
		vdao.create(v);
	}
	
}
