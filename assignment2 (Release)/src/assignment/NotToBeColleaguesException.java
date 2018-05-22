package assignment;

/**
 * Sub-Class of MiniNetException
 * When trying to connect two profile as colleagues
 * Example: an adult cannot have a child/youngchild as colleague
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class NotToBeColleaguesException extends MiniNetException {

	public NotToBeColleaguesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotToBeColleaguesException() {
		super();
	}

}
