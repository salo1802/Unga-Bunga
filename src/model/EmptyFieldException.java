package model;

public class EmptyFieldException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String emptyFields;
	
	public EmptyFieldException(String emptyFields) {
		super("There are empty fields");
		this.emptyFields = emptyFields;
	}
	
	public String getMessage() {
		return emptyFields;
	}
}
