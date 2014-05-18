package ba.co.edgewise.jmup.daldao.interfaces;
import java.io.Serializable;

// generic interface za basic CRUD operacije
// dbName -> naziv tabele
// PK -> Primary key

public interface IGenericDAO<dbName, PK extends Serializable> {
	 public boolean create(dbName name);
	 public dbName get(PK id);
	 public dbName[] getAll();
	 public boolean update(dbName name);
	 public boolean delete(dbName name);
}
