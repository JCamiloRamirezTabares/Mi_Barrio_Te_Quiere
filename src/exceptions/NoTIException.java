package exceptions;

public class NoTIException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoTIException() {
		super("El tipo de documento no puede ser TI");
	}
	
}
