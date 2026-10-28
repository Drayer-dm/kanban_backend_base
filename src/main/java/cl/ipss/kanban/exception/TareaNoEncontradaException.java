package cl.ipss.kanban.exception;

public class TareaNoEncontradaException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	
	public TareaNoEncontradaException (Long id) {
		super ("No Existe la tarea con ID: " + id);
	}
	
	

}
