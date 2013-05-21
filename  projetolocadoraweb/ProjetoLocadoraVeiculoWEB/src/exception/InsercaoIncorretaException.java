package exception;

public class InsercaoIncorretaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsercaoIncorretaException(Exception e){
		super("Paramatros incorretos" , e);
	}
	
}
