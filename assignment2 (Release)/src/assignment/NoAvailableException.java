package assignment;

/**
 * Sub-Class of MiniNetException 
 * When a Profile is not available to be added as a relation (couple)
 * When trying to make two adults a couple and at least one of them is 
 * already connected with another adult as a couple.
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class NoAvailableException extends MiniNetException {

	public NoAvailableException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoAvailableException() {
		// TODO Auto-generated constructor stub
	}

}
