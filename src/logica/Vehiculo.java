package logica;

public class Vehiculo {
	private int idVehiculo;
	private String nombre;
	private String color;
	
	public Vehiculo(int idVehiculo, String nombre, String color) {
		super();
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	@Override
	public String toString() {
		return "idVehiculo=" + idVehiculo + ", nombre=" + nombre + ", color=" + color;
	}
	
	
	
	
}
