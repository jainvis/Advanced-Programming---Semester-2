	package assignment;

import java.util.ArrayList;

/**
 * Child Interface
 * For relationship Child
 * @version 1.0 15 May 2018
 * @author Vishesh Jain
 */

public interface Children {
	
	public void setChild(String children);
	
	public ArrayList<String> getChild();

	public void addChild(Profile children) throws NotToBeChildException;
	
	public void deleteChild(Profile children);
}
