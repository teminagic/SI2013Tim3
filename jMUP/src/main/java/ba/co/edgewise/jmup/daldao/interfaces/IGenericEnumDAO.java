package ba.co.edgewise.jmup.daldao.interfaces;

import java.io.Serializable;

public interface IGenericEnumDAO<dbName, PK extends Serializable> {
	public dbName get(PK index);
	public PK getID(dbName Naziv);
}
