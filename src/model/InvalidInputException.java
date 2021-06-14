package model;

public class InvalidInputException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int max;
	private int charAmount;
	
	public InvalidInputException(int max, int legth) {
		super("Useranme way too long");
		charAmount = legth;
		this.max = max;
	}
	
	public String getMessage() {
		return "The amount of characters was exceded by "+(charAmount-max);
	}
}
