package ba.co.edgewise.components.helpers;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import ba.co.edgewise.jmup.klase.Uposlenik;

public class TableModelKorisnik extends AbstractTableModel {

	private static final long serialVersionUID = -263608234994707920L;

	private String[] columnNames = { "Ime", "Prezime", "Korisni\u010Dko ime",
			"Tip ra\u010Duna", "Status" };
	private ArrayList<Uposlenik> data;

	public TableModelKorisnik() {
		super();
		this.data = new ArrayList<Uposlenik>();
	}

	public TableModelKorisnik(ArrayList<Uposlenik> data) {
		super();
		this.data = data;
	}

	public ArrayList<Uposlenik> getData() {
		return data;
	}

	public void setData(ArrayList<Uposlenik> data) {
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
	
	public void addAll(ArrayList<Uposlenik> novi){
		int rowCount = this.getRowCount();
		for(Uposlenik u : novi){
			data.add(u);
		}
		this.fireTableRowsInserted(rowCount, rowCount + novi.size());
	}

}