package assignment;

/**
 * Sub-Class of MiniNetException
 * When trying to connect two profiles as classmates
 * Example: an adult cannot have a child as classmate
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class NotToBeClassmatesException extends MiniNetException {

	public NotToBeClassmatesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotToBeClassmatesException() {
		super();
	}

}
