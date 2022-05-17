package logica;

import java.util.HashMap;

public class Idioma {

	private HashMap<String,String> diccionario; 
	
	public Idioma()
	{
		diccionario= new HashMap<>();
	}
	public String traduccion(String clave)
	{
		return diccionario.get(clave);
	}
	
	public void agregar(String clave,String traduccion)
	{
		diccionario.put(clave, traduccion);
	}
	
	public void inicializar()
	{
		diccionario.clear();
	}
	
}
