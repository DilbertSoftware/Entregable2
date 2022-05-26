package tabla;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logica.Vehiculo;

public class TablaVehiculo implements TableModel{

	private Object[] vehiculos;
	public TablaVehiculo(Object[] vehiculos)
	{
		this.vehiculos=vehiculos;
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vehiculos.length;
	}

	@Override
	public int getColumnCount() {
		
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String nombre="";
		switch(columnIndex)
		{
			case 0:
				nombre="id";
				break;
			case 1:
				nombre="Nombre";
				break;
			default:
				nombre="Color";
				break;
				
		}
		
		return nombre;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex)
		{
			case 0:
				return Integer.class;
			case 1:
				return String.class;
			default:
				return String.class;
				
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vehiculo vehiculo=(Vehiculo)vehiculos[rowIndex];
		Object respuesta=null;
		switch(columnIndex)
		{
			case 0:
				respuesta=vehiculo.getIdVehiculo();
				break;
			case 1:
				respuesta=vehiculo.getNombre();
				break;
			
			default:
				respuesta=vehiculo.getColor();
				break;
				
		}
		return respuesta;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
