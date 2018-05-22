package assignment;
import java.awt.image.BufferedImage;
import java.util.*;
/**
 * Adult Sub-class of Profile
 * If the Age is greater than 16, Profile will be stored for this class
 * @version 11.0 20 May 2018
 * @author Vishesh Jain
 */

public class Adult extends Profile implements Friend, Children, Colleague, Couple {

	// Instance Variables handling Relations of an Adult
	
	private ArrayList<String> children = new ArrayList<String>();
	private ArrayList<String> friend = new ArrayList<String>();
	private ArrayList<String> colleagues = new ArrayList<String>();
	private ArrayList<String> couple = new ArrayList<String>(1);
	private ArrayList<String> classmate = new ArrayList<String>();
	
	//	Constructors
	public Adult(String name, int age, String status, BufferedImage photo, 
			ArrayList<String> friend, ArrayList<String> children, ArrayList<String> colleagues,
			ArrayList<String> couple, ArrayList<String> classmate) {
		super(name, age, status, photo);
		this.friend.addAll(friend);
		this.children.addAll(children);
		this.colleagues.addAll(colleagues);
		this.couple.addAll(couple);
		this.classmate.addAll(classmate);
	}

	public Adult(String name, int age,String status, ArrayList<String> friend, 
			ArrayList<String> children, ArrayList<String> colleagues, ArrayList<String> couple,
			ArrayList<String> classmate) {
		super(name, age, status);
		this.friend.addAll(friend);
		this.children.addAll(children);
		this.colleagues.addAll(colleagues);
		this.couple.addAll(couple);
		this.classmate.addAll(classmate);
	}
			
	public Adult(String name, int age,String status, 
			ArrayList<String> friend, ArrayList<String> colleagues) {
		this(name, age, status, friend);
		this.colleagues.addAll(colleagues);
	}
	
	public Adult(String name, int age, String status, ArrayList<String> friend) {
		super(name,age,status);
		this.friend=friend;
	}

	public Adult(String name, int age, String status) {
		super(name,age,status);
	}
	
	public Adult(String name, int age) {
		super(name,age);
	}

	//Getters
	
	public ArrayList<String> getFriend() {
		return friend;		
	}

	public ArrayList<String> getChild() {
		return children;
	}
	
	public ArrayList<String> getColleague() {
		return colleagues;
	}
	
	public ArrayList<String> getCouple() {
		return couple;
	}
	
	public ArrayList<String> getClassmate(){
		return classmate;
	}

	//Setters

	public void setChild(String child) {
		this.children.add(child);
	}

	public void setFriend(String friend) {
		this.friend.add(friend);
	}
	
	public void setColleague(String colleague) {
		this.friend.add(colleague);
	}
	
	public void setCouple(String couple) {
		this.couple.add(couple);
	}
	
	public void setClassmate(String classmate) {
		this.classmate.add(classmate);
	}

	@Override
	//--------------------------Friend Relation-----------------------------//
	
	public void addFriend(Profile one) throws NotToBeFriendsException {
		if(one instanceof Adult) {
			setFriend(one.getName());
		}
		else {
			throw new NotToBeFriendsException("Cannot Be Friends !");
		}

	}

	@Override
	public void deleteFriend(Profile one) {
		this.friend.remove(one.getName());		
	}
	
	//--------------------------End of Friend Relation-----------------------------//

	@Override
	//--------------------------Child Relation-----------------------------//
	
	public void addChild(Profile child) throws NotToBeChildException {
		if(child instanceof Child || child instanceof YoungChild) {
			setChild(child.getName());
		}
		else {
			throw new NotToBeChildException("Cannot Be Your Child !");
		}
		
	}

	@Override
	public void deleteChild(Profile child) {
		this.children.remove(child.getName());
	}

	//--------------------------End of Child Relation-----------------------------//
	
	@Override
	//--------------------------Colleague Relation-----------------------------//
	
	public void addColleague(Profile colleague) throws NotToBeColleaguesException {
		if(colleague instanceof Adult) {
			setColleague(colleague.getName());
		}
		else {
			throw new NotToBeColleaguesException("Cannot Be Your Child !");
		}
		
	}

	@Override
	public void deleteColleague(Profile colleague) {
		this.colleagues.remove(colleague.getName());
		
	}
	
	//--------------------------End of Colleague Relation-----------------------------//
	
	//--------------------------Couple Relation-----------------------------//
	@Override
	public void addCouple(Profile couple) throws NoAvailableException {
		if(couple instanceof Adult) {
			setCouple(couple.getName());
		}
		else {
			throw new NoAvailableException("Cannot Be Your Partner !");
		}
		
	}

	@Override
	public void deleteCouple(Profile couple) {
		this.couple.remove(couple.getName());
		
	}
	
	//--------------------------End of Couple Relation-----------------------------//
	
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

	//--------------------------No Action Relations--------------------------------//
	@Override
	public void addParent(Profile parent) throws NoParentException {}

	@Override
	public void deleteParent(Profile parent) {}

	@Override
	public ArrayList<String> getParent() {return new ArrayList<String>();}


	@Override
	public void setParent(String parent) {}

}
