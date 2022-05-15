package logica.exception;

public class CapacidadLlenaException extends Exception {

	public CapacidadLlenaException()
	{
		super("Ya esta ocupado todo los espacio");
	}
}
