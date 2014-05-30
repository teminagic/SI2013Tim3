package ba.co.edgewise.components.helpers;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import ba.co.edgewise.jmup.klase.Saobracajna;

public class TableModelSaobracajna extends AbstractTableModel {

	private static final long serialVersionUID = -263608234994707920L;

	private String[] columnNames = { 
			"Broj potvrde",
			"Registarska oznaka", 
			"Ime i prezime", 
			"JMBG vozača"
			};
	private ArrayList<Saobracajna> data;

	public TableModelSaobracajna() {
		super();
		this.data = new ArrayList<Saobracajna>();
	}

	public TableModelSaobracajna(ArrayList<Saobracajna> data) {
		super();
		this.data = data;
	}

	public ArrayList<Saobracajna> getData() {
		return data;
	}

	public void setData(ArrayList<Saobracajna> data) {
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
	
	public void addAll(ArrayList<Saobracajna> novi){
		int rowCount = this.getRowCount();
		for(Saobracajna u : novi){
			data.add(u);
		}
		this.fireTableRowsInserted(rowCount, rowCount + novi.size());
	}

	public void addTableModelListener(JTable table) {
		// TODO Auto-generated method stub
		
	}


}