package assignment;

/**
 * Classmate Interface
 * For relationship Classmate
 * @version 1.0 15 May 2018
 * @author Vishesh Jain
 */

import java.util.ArrayList;

public interface Classmate {
	
	public void setClassmate(String classmate);
	
	public ArrayList<String> getClassmate();
	
	public void addClassmate(Profile classmate) throws NotToBeClassmatesException;

	public void deleteClassmate(Profile classmate);

}
