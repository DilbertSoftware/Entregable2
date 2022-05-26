package tabla;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logica.Persona;

public class TablaPersona implements TableModel{

	private LinkedList<Persona>personas;
	public TablaPersona(LinkedList<Persona>personas)
	{
		this.personas=personas;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return personas.size();
	}

	@Override
	public int getColumnCount() {
		
		return 7;
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
			case 2:
				nombre="Apellido";
				break;
			case 3:
				nombre="Fecha de Nacimiento";
				break;
			case 4:
				nombre="Edad";
				break;
			case 5:
				nombre="Departamento";
				break;
			default:
				nombre="Cantidad de hijos";
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
			case 2:
				return String.class;
			case 3:
				return LocalDate.class;
			case 4:
				return Integer.class;
			case 5:
				return Integer.class;
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
		Persona persona=personas.get(rowIndex);
		Object respuesta=null;
		switch(columnIndex)
		{
			case 0:
				respuesta=persona.getIdPersona();
				break;
			case 1:
				respuesta=persona.getNombre();
				break;
			case 2:
				respuesta=persona.getApellido();
				break;
			case 3:
				respuesta=persona.getFechaNacimiento();
				break;
			case 4:
				respuesta=persona.edad();
				break;
			case 5:
				respuesta=persona.getDeptoResidencia();
				break;
			default:
				respuesta=persona.getCantHijos();
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
