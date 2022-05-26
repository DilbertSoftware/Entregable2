package logica;

import java.io.Serializable;

public class Barco extends Vehiculo  implements Serializable{
	private double eslora;
	private double manga;
	public Barco(String nombre, String color, double eslora, double manga) {
		super( nombre, color);
		this.eslora = eslora;
		this.manga = manga;
	}
	public double getEslora() {
		return eslora;
	}
	public void setEslora(double eslora) {
		this.eslora = eslora;
	}
	public double getManga() {
		return manga;
	}
	public void setManga(double manga) {
		this.manga = manga;
	}
	@Override
	public String toString() {
		return "Tipo : Barco "+super.toString()+ " eslora=" + eslora + ", manga=" + manga + "]";
	}
	
	
}
