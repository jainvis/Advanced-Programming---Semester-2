package assignment;

/**
 * Sub-Class of MiniNetException
 * When trying to add a profile that already exists on the network
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class ProfileExistsException extends MiniNetException {

	public ProfileExistsException(String message) {
		super(message);
	}

	public ProfileExistsException() {
	}

}
