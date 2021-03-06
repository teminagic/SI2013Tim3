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
		return (Object) (data.get(rowIndex).toObjectArray())[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	public void clearAll()
	{
		int rowCount = this.getRowCount();
		data.removeAll(data);
		this.fireTableRowsDeleted(0, rowCount);
	}
	
	public void addAll(ArrayList<Vlasnicka> novi){
		if(novi == null)
			return;
		int rowCount = this.getRowCount();
		for(Vlasnicka u : novi){
			if(u==null)
				return;
			data.add(u);
		}
		this.fireTableRowsInserted(rowCount, rowCount + novi.size());
	}

	public void addTableModelListener(JTable table) {
		// TODO Auto-generated method stub
		
	}


}