package assignment;

/**
 * Couple Interface
 * For relationship Spouse
 * @version 1.0 15 May 2018
 * @author Vishesh Jain
 */

import java.util.ArrayList;

public interface Couple {
	
	public void setCouple(String couple);
	
	public ArrayList<String> getCouple();

	public void addCouple(Profile couple) throws NoAvailableException;

	public void deleteCouple(Profile couple);

}
