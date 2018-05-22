package assignment;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * YoungChild Sub-class of Profile
 * If age is less than 2, Profile will be store for this class
 * @version 2.0 20 May 2018
 * @author Vishesh Jain
 */

public class YoungChild extends Profile implements Parent {
	
	private ArrayList<String> parent = new ArrayList<String>(2);

	public YoungChild(String name, int age, String status, BufferedImage photo, 
			ArrayList<String> parent) {
		super(name, age, status, photo);
		this.parent.addAll(parent);
	}
	
	public YoungChild(String name, int age, String status, 
			ArrayList<String> parent) {
		super(name, age, status);
		this.parent.addAll(parent);
	}
	
	public YoungChild(String name, int age, 
			ArrayList<String> parent) {
		super(name, age);
		this.parent.addAll(parent);
	}
	
	// Getters
	
	public ArrayList<String> getParent(){
		return parent;
	}
	
	// Setters
	
	public void setParent(String parent) {
		this.parent.add(parent);
	}

	//--------------------------------Parent Relation------------------------//
	
	@Override
	public void addParent(Profile parent) throws NoParentException {
		if(parent instanceof Adult) {
			setParent(parent.getName());
		}
		else {
			throw new NoParentException("Cannot Be Your Parent !");
		}		
	}

	@Override
	public void deleteParent(Profile parent) {
		this.parent.remove(parent.getName());		
	}
	
	//------------------------End of Parent Relation------------------------//
	
	//------------------------No Action Relations------------------------//

	@Override
	public ArrayList<String> getFriend() {return new ArrayList<String>();}

	@Override
	public ArrayList<String> getCouple() {return new ArrayList<String>();}

	@Override
	public ArrayList<String> getClassmate() {return new ArrayList<String>();}

	@Override
	public ArrayList<String> getColleague() {return new ArrayList<String>();}

	@Override
	public ArrayList<String> getChild() {return new ArrayList<String>();}

	@Override
	public void setChild(String children) {}

	@Override
	public void setClassmate(String classmate) {}

	@Override
	public void setColleague(String colleague) {}

	@Override
	public void setCouple(String couple) {}

	@Override
	public void addCouple(Profile couple) throws NoAvailableException {
		throw new NoAvailableException("A young child cannot have a spouse");
	}

	@Override
	public void deleteCouple(Profile couple) {}

	@Override
	public void addChild(Profile children) throws NotToBeChildException {
		throw new NotToBeChildException("A young child cannot have children");
	}

	@Override
	public void deleteChild(Profile children) {}

	@Override
	public void addClassmate(Profile classmate) throws NotToBeClassmatesException {
		throw new NotToBeClassmatesException("Too young to have classmates");
	}

	@Override
	public void deleteClassmate(Profile classmate) {}

	@Override
	public void addColleague(Profile colleague) throws NotToBeColleaguesException {
		throw new NotToBeColleaguesException("Too young to have colleagues");
	}

	@Override
	public void deleteColleague(Profile colleague) {}

	@Override
	public void addFriend(Profile one) throws NotToBeFriendsException {
		throw new NotToBeFriendsException("Too young to have friends");
	}

	@Override
	public void deleteFriend(Profile one) {}

	@Override
	public void setFriend(String friend) {
		// TODO Auto-generated method stub
		
	}
	

}
