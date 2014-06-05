package ba.co.edgewise.components.helpers;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import ba.co.edgewise.jmup.klase.Log;

public class TableModelLogovi extends AbstractTableModel {

	private static final long serialVersionUID = 4383722515943486912L;
	
	private String[] columnNames = { "Korisnik", "Datum", "Korisni\u010Dko ime",
			"Detaljnije"};
	private ArrayList<Log> data;

	public TableModelLogovi(){
		super();
		this.data = new ArrayList<Log>();
	}

	public TableModelLogovi(ArrayList<Log> data) {
		super();
		this.data = data;
	}
	
	

	public ArrayList<Log> getData() {
		return data;
	}

	public void setData(ArrayList<Log> data) {
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
	
	public void addAll(ArrayList<Log> novi){
		int rowCount = this.getRowCount();
		for(Log u : novi){
			data.add(u);
		}
		this.fireTableRowsInserted(rowCount, rowCount + novi.size());
	}

}
