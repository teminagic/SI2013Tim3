package ba.co.edgewise.components.helpers;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import ba.co.edgewise.jmup.klase.Vlasnicka;

public class TableModelVlasnicka extends AbstractTableModel {

	private static final long serialVersionUID = -263608234994707920L;

	private String[] columnNames = { 
			"Broj potvrde",
			"Registarska oznaka", 
			"Ime i prezime", 
			"JMBG vlasnika"
			};

	private ArrayList<Vlasnicka> data;

	public TableModelVlasnicka() {
		super();
		this.data = new ArrayList<Vlasnicka>();
	}

	public TableModelVlasnicka(ArrayList<Vlasnicka> data) {
		super();
		this.data = data;
	}

	public ArrayList<Vlasnicka> getData() {
		return data;
	}

	public void setData(ArrayList<Vlasnicka> data) {
		this.data = data;
	}

	@Override
	public void fireTableChanged(TableModelEvent e) {
		super.fireTableChanged(e);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    Object o = (Object) (data.get(rowIndex).toObjectArray())[columnIndex];
		return o;
	}

	@Override //bug
	public Class<?> getColumnClass(int columnIndex) {
		Object value = getValueAt(0, columnIndex);
		return value != null ? value.getClass() : String.class;
	}
	
	public void clearAll()
	{
		int rowCount = this.getRowCount();
		data.removeAll(data);
		this.fireTableRowsDeleted(0, rowCount);
	}
	
	public void addAll(ArrayList<Vlasnicka> novi){
		int rowCount = this.getRowCount();
		for(Vlasnicka u : novi){
			data.add(u);
		}
		this.fireTableRowsInserted(rowCount, rowCount + novi.size());
	}

	public void addTableModelListener(JTable table) {
		// TODO Auto-generated method stub
		
	}


}