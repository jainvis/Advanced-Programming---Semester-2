package assignment;

/**
 * Parent Interface
 * For relationship Parent
 * @version 1.0 15 May 2018
 * @author Vishesh Jain
 */

import java.util.ArrayList;

public interface Parent {
	
	public void setParent(String parent);
	
	public ArrayList<String> getParent();
	
	public void addParent(Profile parent) throws NoParentException;

	public void deleteParent(Profile parent);


}
