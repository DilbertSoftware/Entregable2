package logica;

public class Avion extends Vehiculo{

	private double longitud;
	private int cantPasajeros;
	public Avion( String nombre, String color, double longitud, int cantPasajeros) {
		super(nombre, color);
		this.longitud = longitud;
		this.cantPasajeros = cantPasajeros;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public int getCantPasajeros() {
		return cantPasajeros;
	}
	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}
	@Override
	public String toString() {
		return "Tipo : Avion "+super.toString()+" longitud=" + longitud + ", cantidad de Pasajeros = " + cantPasajeros ;
	}
}
