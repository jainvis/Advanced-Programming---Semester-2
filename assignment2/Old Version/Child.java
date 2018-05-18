package assignment;
import java.awt.image.BufferedImage;
import java.util.*;
/**
 * Child Sub-class of Profile
 * If age is less than 16 & greater than 2, Profile will be store for this class
 * @version 8.0 28 Mar 2018
 * @author Vishesh Jain
 */
public class Child extends Profile {
	
	private String dependent[] = new String[2];

	public Child(String name, int age, String status, BufferedImage photo, ArrayList<String> friendlist, String[] dependent) {
		super(name, age, status, photo, friendlist);
		this.dependent = dependent;
	}
	
	public Child(String name, int age, String status, ArrayList<String> friendlist, String[] dependent) {
		super(name, age, status, friendlist);
		this.dependent = dependent;
	}

	public Child(String name, int age, String status, String[] dependent){
		this(name, age, status, null, new ArrayList<String>(), dependent);
	}

	public void setDependent(String d1, String d2){
		this.dependent = new String[]{d1,d2};
	}
	
	public String[] getDependent(){return dependent;}

}
