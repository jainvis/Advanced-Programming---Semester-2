package assignment;
import java.awt.image.BufferedImage;
import java.util.*;
/**
 * Adult Sub-class of Profile
 * If the Age is greater than 16, Profile will be stored for this class
 * @version 10.0 15 May 2018
 * @author Vishesh Jain
 */

public class Adult extends Profile implements Friend, Children, Colleague, Couple {

	// Instance Variables handling Relations of an Adult
	
	private ArrayList<Profile> children = new ArrayList<Profile>();
	private ArrayList<Profile> friend = new ArrayList<Profile>();
	private ArrayList<Profile> colleagues = new ArrayList<Profile>();
	private ArrayList<Profile> couple = new ArrayList<Profile>(1);
	
	//	Constructors
	public Adult(String name, int age, String status, BufferedImage photo, 
			ArrayList<Profile> friend, ArrayList<Profile> children, ArrayList<Profile> colleagues,
			ArrayList<Profile> couple) {
		super(name, age, status, photo);
		this.friend.addAll(friend);
		this.children.addAll(children);
		this.colleagues.addAll(colleagues);
		this.couple.addAll(couple);
	}

	public Adult(String name, int age,String status, ArrayList<Profile> friend, 
			ArrayList<Profile> children, ArrayList<Profile> colleagues, ArrayList<Profile> couple) {
		super(name, age, status, null);
		this.friend.addAll(friend);
		this.children.addAll(children);
		this.colleagues.addAll(colleagues);
		this.couple.addAll(couple);
	}
	
//	public Adult(String name, int age,String status, ArrayList<Profile> friend, ArrayList<Profile> children) {
//		this(name, age, status, null, friend, new ArrayList<Profile>());
//	}
	
	public Adult(String name, int age,String status, BufferedImage photo, ArrayList<Profile> friend) {
		super(name, age, status, photo);
		this.friend.addAll(friend);
	}
	
	public Adult(String name, int age,String status, 
			ArrayList<Profile> friend, ArrayList<Profile> colleagues) {
		this(name, age, status, friend);
		this.colleagues.addAll(colleagues);
	}
	
	public Adult(String name, int age,String status, ArrayList<Profile> friend) {
		this(name, age, status, null, friend, new ArrayList<Profile>(), new ArrayList<Profile>());
	}

	public Adult(String name, int age, String status) {
		super(name,age,status);
	}
	
	public Adult(String name, int age) {
		super(name,age);
	}

	//Getters
	
	public ArrayList<Profile> getFriend() {
		return friend;		
	}

	public ArrayList<Profile> getChildren() {
		return children;
	}
	
	public ArrayList<Profile> getColleague() {
		return colleagues;
	}
	
	public ArrayList<Profile> getCouple() {
		return couple;
	}

	//Setters

	public void setChild(Profile child) {
		this.children.add(child);
	}

	public void setFriend(Profile friend) {
		this.friend.add(friend);
	}
	
	public void setColleague(Profile colleague) {
		this.friend.add(colleague);
	}
	
	public void setCouple(Profile couple) {
		this.couple.add(couple);
	}

	@Override
	// Friend Interface
	
	public void addFriend(Profile one) throws NotToBeFriendsException {
		if(one instanceof Adult) {
			setFriend(one);
		}
		else {
			throw new NotToBeFriendsException("Cannot Be Friends !");
		}

	}

	@Override
	public void deleteFriend(Profile one) {
		this.friend.remove(one);		
	}

	@Override
	// Children Interface
	
	public void addChild(Profile child) throws NotToBeChildException {
		if(child instanceof Child) {
			setFriend(child);
		}
		else {
			throw new NotToBeChildException("Cannot Be Your Child !");
		}
		
	}

	@Override
	public void deleteChild(Profile child) {
		this.children.remove(child);
	}

	@Override
	// Colleague Interface
	
	public void addColleague(Profile colleague) throws NotToBeColleaguesException {
		if(colleague instanceof Adult) {
			setColleague(colleague);
		}
		else {
			throw new NotToBeColleaguesException("Cannot Be Your Child !");
		}
		
	}

	@Override
	public void deleteColleague(Profile colleague) {
		this.colleagues.remove(colleague);
		
	}
	
	// Couple Interface
	@Override
	public void addCouple(Profile couple) throws NotToBeCoupledException {
		if(couple instanceof Adult) {
			setCouple(couple);
		}
		else {
			throw new NotToBeCoupledException("Cannot Be Your Partner !");
		}
		
	}

	@Override
	public void deleteCouple(Profile couple) {
		this.couple.remove(couple);
		
	}

	@Override
	public void addParent(Profile parent) throws NoParentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteParent(Profile parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClassmate(Profile classmate) throws NotToBeClassmatesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClassmate(Profile classmate) {
		// TODO Auto-generated method stub
		
	}

}
