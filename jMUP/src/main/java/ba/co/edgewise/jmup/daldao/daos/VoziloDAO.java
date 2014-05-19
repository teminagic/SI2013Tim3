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
	public boolean create(Vozilo v)
	{
		boolean success = false;
		
		// Konekcija:
		ConnectionManager manager = new ConnectionManager();
		Connection connection = manager.getConnection();
		
		return false;
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
		Vozilo v = new Vozilo();
		VoziloDAO vdao = new VoziloDAO();
	}
	
}
