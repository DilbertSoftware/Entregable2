package logica;

import java.awt.Color;
import java.time.LocalDate;
import java.util.LinkedList;

public class Util {
	public static final int TAMANIO_ARRAY =10;
	
	public static final String COLORES[] = {"BLANCO","GRIS","NEGRO","ROSADO","AMARILLO","VIOLETA","AZUL","ROJO","NARANJA","VERDE","CELESTE"};
	public static final Color COLORES_SISTEMA[] = {Color.WHITE,Color.GRAY,Color.BLACK,Color.PINK,Color.YELLOW,Color.MAGENTA,Color.BLUE,Color.RED,Color.ORANGE,Color.GREEN,Color.CYAN};
	
	public static LinkedList<Persona> precargado()
	{
		LinkedList<Persona> retornar=new LinkedList<>();
		Persona persona1=new Persona("Luis","Zunino","Montevideo", (byte) 1, LocalDate.of(1981,6,1));
		Persona persona2=new Persona("Paloma","Peirano","Durazno", (byte) 3, LocalDate.of(1992,8,10));
		Persona persona3=new Persona("Yamila","Martinez","Salto", (byte) 0, LocalDate.of(1992,8,10));	
		Persona persona4=new Persona("Carlos","Sanchez","Montevideo", (byte) 2, LocalDate.of(1979,2,6));
		Persona persona5=new Persona("Guillermo","Leites","Montevideo", (byte) 2, LocalDate.of(1979,2,6));
		
		retornar.add(persona1);
		retornar.add(persona2);
		retornar.add(persona3);
		retornar.add(persona4);
		retornar.add(persona5);
		
		return retornar;
	}
}
