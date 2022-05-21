package logica.ordenamiento;

import java.util.Comparator;

import logica.Persona;

public class OrdernarPorEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona persona1, Persona persona2) {
		
		return persona1.edad()-persona2.edad();
	}

}
