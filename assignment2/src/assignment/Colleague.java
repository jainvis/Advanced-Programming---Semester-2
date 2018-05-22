package assignment;

/**
 * Colleague Interface
 * For relationship Colleague
 * @version 1.0 15 May 2018
 * @author Vishesh Jain
 */

import java.util.ArrayList;

public interface Colleague {
	
	public void setColleague(String colleague);
	
	public ArrayList<String> getColleague();

	public void addColleague(Profile colleague) throws NotToBeColleaguesException;
	
	public void deleteColleague(Profile colleague);
}
