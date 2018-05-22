package assignment;

/**
 * Sub-Class of MiniNetException
 * When trying to make a child as a couple with an adult
 * Also, when trying to connect two adults and one is already a spouse of someone else
 * @version 1.0 21 April 2018
 * @author Vishesh Jain 
 *
 */

public class NotToBeCoupledException extends MiniNetException {

	public NotToBeCoupledException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotToBeCoupledException() {
		super();
	}

}
