package assignment;
import java.awt.image.BufferedImage;
import java.util.*;
/**
 * Child Sub-class of Profile
 * If age is less than 16 & greater than 2, Profile will be store for this class
 * @version 10.0 20 May 2018
 * @author Vishesh Jain
 */
public class Child extends Profile implements Parent, Friend, Classmate {
	
	private ArrayList<String> parent = new ArrayList<String>(2);
	private ArrayList<String> friend = new ArrayList<String>();
	private ArrayList<String> classmate = new ArrayList<String>();

	public Child(String name, int age, String status, BufferedImage photo, 
			ArrayList<String> friends, ArrayList<String> parents, ArrayList<String> classmates) {
		super(name, age, status, photo);
		this.friend.addAll(friends);
		this.parent.addAll(parents);
		this.classmate.addAll(classmates);
	}
	
	public Child(String name, int age, String status, 
			ArrayList<String> friends, ArrayList<String> parents, ArrayList<String> classmates) {
		super(name, age, status);
		this.friend.addAll(friends);
		this.parent.addAll(parents);
		this.classmate.addAll(classmates);
	}

	public Child(String name, int age, String status, 
			ArrayList<String> friend, ArrayList<String> parents){
		super(name,age,status);
		this.friend.addAll(friend);
		this.parent.addAll(parents);
	}
	
	public Child(String name, int age, String status, ArrayList<String> parents){
		super(name,age,status);
		this.parent.addAll(parents);
	}
	
	// Getters
	
	public ArrayList<String> getClassmate() {
		return classmate;
	}
	
	public ArrayList<String> getFriend() {
		return friend;		
	}
	
	public ArrayList<String> getParent(){
		return parent;
	}
	
	// Setters
	
	public void setClassmate(String classmate) {
		this.classmate.add(classmate);
	}
	
	public void setFriend(String friend) {
		this.friend.add(friend);		
	}
	
	public void setParent(String parent){
		this.parent.add(parent);
	}

	//---------------------------Classmate Relation----------------------------//
	
	@Override
	public void addClassmate(Profile classmate) throws NotToBeClassmatesException {
		if(classmate instanceof Child) {
			setClassmate(classmate.getName());
		}
		else {
			throw new NotToBeClassmatesException("Cannot Be Your Classmate !");
		}
		
	}

	@Override
	public void deleteClassmate(Profile classmate) {
		this.classmate.remove(classmate.getName());
		
	}
	//---------------------------End of Classmate Relation-----------------------------//

	//---------------------------Friend Relation----------------------------//
	
	@Override
	public void addFriend(Profile friend) throws NotToBeFriendsException {
		if(friend instanceof Child && Math.abs(getAge() - friend.getAge())<=3) {
			setFriend(friend.getName());
		}
		else {
			throw new NotToBeFriendsException("Cannot Be Your Friend !");
		}
		
	}

	@Override
	public void deleteFriend(Profile friend) {
		this.friend.remove(friend.getName());		
	}
	//---------------------------End of Friend Relation-----------------------------//
	
	//---------------------------Parent Relation----------------------------//

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
	
	//---------------------------End of Parent Relation-----------------------------//
	
	//---------------------------No Action Relations-------------------------------//
	@Override
	public void addColleague(Profile colleague) throws NotToBeColleaguesException {
		throw new NotToBeColleaguesException("Cannot be colleagues !");
	}

	@Override
	public void deleteColleague(Profile colleague) {}

	@Override
	public void addChild(Profile children) throws NotToBeChildException {
		throw new NotToBeChildException("A Child cannot have children !");
	}

	@Override
	public void deleteChild(Profile children) {}

	@Override
	public void addCouple(Profile couple) throws NoAvailableException {
		throw new NoAvailableException("Cannot have a spouse !");
	}

	@Override
	public void deleteCouple(Profile couple) {}

	@Override
	public ArrayList<String> getCouple() {return new ArrayList<String>();}

	@Override
	public ArrayList<String> getColleague() {return new ArrayList<String>();}

	@Override
	public ArrayList<String> getChild() {return new ArrayList<String>();}

	@Override
	public void setChild(String children) {}

	@Override
	public void setColleague(String colleague) {}

	@Override
	public void setCouple(String couple) {}


}
