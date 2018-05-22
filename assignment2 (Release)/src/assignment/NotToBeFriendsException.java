package assignment;

/**
 * Sub-Class of MiniNetException
 * When trying to connect two profiles as adults
 * An adult cannot be friends with a child or young child
 * The age difference between two children as friends cannot be more than 3 years
 * Young Child cannot have friends
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class NotToBeFriendsException extends MiniNetException {

	public NotToBeFriendsException() {
		super();
	}
	
	public NotToBeFriendsException(String message) {
		super(message);
	}

}
