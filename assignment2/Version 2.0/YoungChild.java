package assignment;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * YoungChild Sub-class of Profile
 * If age is less than 2, Profile will be store for this class
 * @version 1.0 15 May 2018
 * @author Vishesh Jain
 */

public class YoungChild extends Profile implements Parent {
	
	private ArrayList<Profile> parent = new ArrayList<Profile>(2);

	public YoungChild(String name, int age, String status, BufferedImage photo, 
			ArrayList<Profile> parent) {
		super(name, age, status, photo);
		this.parent.addAll(parent);
	}
	
	public YoungChild(String name, int age, String status, 
			ArrayList<Profile> parent) {
		super(name, age, status);
		this.parent.addAll(parent);
	}
	
	public YoungChild(String name, int age, 
			ArrayList<Profile> parent) {
		super(name, age);
		this.parent.addAll(parent);
	}
	
	// Getters
	
	public ArrayList<Profile> getParent(){
		return parent;
	}
	
	// Setters
	
	public void setParent(Profile parent) {
		this.parent.add(parent);
	}

	// Parent Interface
	
	@Override
	public void addParent(Profile parent) throws NoParentException {
		if(parent instanceof Adult) {
			setParent(parent);
		}
		else {
			throw new NoParentException("Cannot Be Your Parent !");
		}		
	}

	@Override
	public void deleteParent(Profile parent) {
		this.parent.remove(parent);		
	}
	

}
