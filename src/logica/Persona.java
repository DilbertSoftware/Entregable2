package logica;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

import logica.exception.VehiculoException;

public class Persona {
	
	private int idPersona;
	private String nombre;
	private String apellido;
	private String deptoResidencia;
	private byte cantHijos;
	private LocalDate fechaNacimiento;
	private LinkedList<Vehiculo> listaVehiculos;
	
	public Persona() {
		super();
		idPersona=0;
		nombre="";
		apellido="";
		deptoResidencia="";
		cantHijos=0;
		fechaNacimiento=LocalDate.now();
		listaVehiculos=new LinkedList<>();
	}

	public Persona( String nombre, String apellido, String deptoResidencia, byte cantHijos,
			LocalDate fechaNacimiento) {
		super();
		this.idPersona = 0;
		this.nombre = nombre;
		this.apellido = apellido;
		this.deptoResidencia = deptoResidencia;
		this.cantHijos = cantHijos;
		this.fechaNacimiento = fechaNacimiento;
		listaVehiculos=new LinkedList<>();
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDeptoResidencia() {
		return deptoResidencia;
	}

	public void setDeptoResidencia(String deptoResidencia) {
		this.deptoResidencia = deptoResidencia;
	}

	public byte getCantHijos() {
		return cantHijos;
	}

	public void setCantHijos(byte cantHijos) {
		this.cantHijos = cantHijos;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", apellido=" + apellido + ", Departamento =" + deptoResidencia
				+ ", cantidad Hijos=" + cantHijos + ", fecha Nacimiento=" + fechaNacimiento;
	}
	
	public int edad()
	{
		
		LocalDate hoy=LocalDate.now();
		int edad=hoy.getYear()-fechaNacimiento.getYear();
		if(hoy.getMonth().getValue()<fechaNacimiento.getMonth().getValue())
		{
			edad--;
		}
		else {
			if(hoy.getMonth().getValue()==fechaNacimiento.getMonth().getValue())
			{
				if(hoy.getDayOfMonth()<fechaNacimiento.getDayOfMonth())
				{
					edad--;
				}
			}
			
		}
		
		return edad;
	}	
	
	public void agregar(Vehiculo vehiculo) throws VehiculoException
	{
		if(!listaVehiculos.contains(vehiculo))
		{
			listaVehiculos.add(vehiculo);
		}
		else {
			throw new VehiculoException("El vehiculo ya lo tiene");
		}
	}
	
	public Iterator<Vehiculo> listadoVehiculos()
	{
		return listaVehiculos.iterator();
	}
	
	public Object[] getVehiculos()
	{
		return listaVehiculos.toArray();
	}
	
}
