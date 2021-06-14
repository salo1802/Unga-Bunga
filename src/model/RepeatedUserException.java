package model;

public class RepeatedUserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	public RepeatedUserException(String rUser) {
		super("Repeated username");
		username = rUser;
	}
	
	public String getMessage() {
		return username+" is already registered";
	}

}
