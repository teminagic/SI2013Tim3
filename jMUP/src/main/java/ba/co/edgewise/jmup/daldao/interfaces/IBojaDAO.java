package ba.co.edgewise.jmup.daldao.interfaces;

import ba.co.edgewise.jmup.enums.Boja;

public interface IBojaDAO {
	public Boja get(int id);
	public Integer getID(String boja);
}
