package assignment;
import java.awt.image.BufferedImage;
import java.util.*;
/**
 * Child Sub-class of Profile
 * If age is less than 16 & greater than 2, Profile will be store for this class
 * @version 9.0 15 May 2018
 * @author Vishesh Jain
 */
public class Child extends Profile implements Parent, Friend, Classmate {
	
	private ArrayList<Profile> parent = new ArrayList<Profile>(2);
	private ArrayList<Profile> friend = new ArrayList<Profile>();
	private ArrayList<Profile> classmate = new ArrayList<Profile>();

	public Child(String name, int age, String status, BufferedImage photo, 
			ArrayList<Profile> friends, ArrayList<Profile> parents, ArrayList<Profile> classmates) {
		super(name, age, status, photo);
		this.friend.addAll(friends);
		this.parent.addAll(parents);
		this.classmate.addAll(classmates);
	}
	
	public Child(String name, int age, String status, 
			ArrayList<Profile> friends, ArrayList<Profile> parents, ArrayList<Profile> classmates) {
		super(name, age, status);
		this.friend.addAll(friends);
		this.parent.addAll(parents);
		this.classmate.addAll(classmates);
	}

	public Child(String name, int age, String status, 
			ArrayList<Profile> friend, ArrayList<Profile> parents){
		super(name,age,status);
		this.friend.addAll(friend);
		this.parent.addAll(parents);
	}
	
	public Child(String name, int age, String status, ArrayList<Profile> parents){
		super(name,age,status);
		this.parent.addAll(parents);
	}
	
	// Getters
	
	public ArrayList<Profile> getClassmate() {
		return classmate;
	}
	
	public ArrayList<Profile> getFriend() {
		return friend;		
	}
	
	public ArrayList<Profile> getParent(){
		return parent;
	}
	
	// Setters
	
	public void setClassmate(Profile classmate) {
		this.classmate.add(classmate);
	}
	
	public void setFriend(Profile friend) {
		this.friend.add(friend);		
	}
	
	public void setParent(Profile parent){
		this.parent.add(parent);
	}

	// Classmate Interface
	
	@Override
	public void addClassmate(Profile classmate) throws NotToBeClassmatesException {
		if(classmate instanceof Child) {
			setClassmate(classmate);
		}
		else {
			throw new NotToBeClassmatesException("Cannot Be Your Classmate !");
		}
		
	}

	@Override
	public void deleteClassmate(Profile classmate) {
		this.classmate.remove(classmate);
		
	}

	// Friend Interface
	
	@Override
	public void addFriend(Profile friend) throws NotToBeFriendsException {
		if(friend instanceof Child) {
			setFriend(friend);
		}
		else {
			throw new NotToBeFriendsException("Cannot Be Your Friend !");
		}
		
	}

	@Override
	public void deleteFriend(Profile friend) {
		this.friend.remove(friend);		
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

	@Override
	public void addColleague(Profile colleague) throws NotToBeColleaguesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteColleague(Profile colleague) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChild(Profile children) throws NotToBeChildException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteChild(Profile children) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCouple(Profile couple) throws NotToBeCoupledException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCouple(Profile couple) {
		// TODO Auto-generated method stub
		
	}


}
