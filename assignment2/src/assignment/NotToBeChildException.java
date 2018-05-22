package assignment;

/**
 * Sub-Class of MiniNetException
 * When a child/ young child cannot be connected to an adult
 * @version 1.0 21 April 2018 
 * @author Vishesh Jain 
 */

public class NotToBeChildException extends MiniNetException {

	public NotToBeChildException() {
		super();
	}
	
	public NotToBeChildException(String message) {
		super(message);
	}

}
