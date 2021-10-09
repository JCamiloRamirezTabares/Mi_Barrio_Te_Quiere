package exceptions;

public class DayAndIdException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DayAndIdException() {
		super("El usuario no le corresponde ingresar hoy");
	}

}
