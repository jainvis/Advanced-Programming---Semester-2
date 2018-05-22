package assignment;

/**
 * Sub-Class of MiniNetException
 * When trying to add a person whose age is given negative or greater than 150
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class NoSuchAgeException extends MiniNetException {

	public NoSuchAgeException(String message) {
		super(message);
	}

	public NoSuchAgeException() {
		super();
	}

}
