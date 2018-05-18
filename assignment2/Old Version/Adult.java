package assignment;
import java.awt.image.BufferedImage;
import java.util.*;
/**
 * Adult Sub-class of Profile
 * If the Age is greater than 16, Profile will be stored for this class
 * @version 8.0 28 Mar 2018
 * @author Vishesh Jain
 */


public class Adult extends Profile{
	
	private ArrayList<String> childlist = new ArrayList<String>();
//	private ArrayList<T> partner = new ArrayList<T>();

	public Adult(String name, int age, String status, BufferedImage photo, ArrayList<String> friendlist, ArrayList<String> childlist) {
		super(name, 0, status, photo, friendlist);
	this.childlist.addAll(childlist);
	}

	public Adult(String name, int age,String status, BufferedImage photo, ArrayList<String> friendlist) {
		super(name, age, status, photo, friendlist);
	}

	public Adult(String name, int age,String status, ArrayList<String> friendlist, ArrayList<String> childlist) {
		super(name, age, status, friendlist);
		this.childlist.addAll(childlist);
	}
	
	public Adult(String name, int age,String status, ArrayList<String> friendlist) {
		super(name, age, status, friendlist);
	}
	
	public Adult(String name, int age, String status) {
		super(name, age, status);
		}

	public ArrayList<String> getChildlist() {
		return childlist;
	}

	public void setChildlist(String childname) {
		this.childlist.add(childname);
	}

//	public void setPartner(Couple one) {
//		this.partner.add(one);
//	}

//	@Override
//	public void partner(Profile one, Profile two) {
//		
//	}

}
