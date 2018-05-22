package assignment;

/**
 * Sub-Class of MiniNetException
 * This Exception is used as a multi-purpose exception
 * When Parents do not exist for a Child/Young Child while adding the profile
 * When Parents being added in a relation already exists in another profiles
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class NoParentException extends MiniNetException {

	public NoParentException(String message) {
		super(message);
	}

	public NoParentException() {
		super();
	}

}
