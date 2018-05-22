package assignment;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Abstract Profile class to define basic information of a Profile
 * @version 10.0 20 May 2018
 * @author Vishesh Jain
 */

public abstract class Profile implements Friend, Parent, Colleague, Classmate, Children, Couple  {
	
	private String name;
	private int age;
	private String status;
	private BufferedImage photo;
	
	public Profile (String name, int age, String status, BufferedImage photo){
		
		this.name = name;
		this.age = age;
		this.status = status;
		this.photo = photo;
	}
	
	public Profile(String name, int age, BufferedImage photo){
		
		this(name, age, "", photo);	//If Status not given
	}
	
	public Profile(String name, int age, String status){

		this(name, age, status, new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB)); 
	}
	
	public Profile(String name, int age){

		this(name, age, "");
	}
	
	
	//Getters 
	
	public String getName() { return name; }
	
	public int getAge() {return age;} 
	
	public String getStatus() {return status;}
	
	public BufferedImage getPhoto(){return photo;}
		
	//Setters
	
	public void setName(String name){this.name = name;}
	
	public void setStatus(String status){this.status = status;}
	
	public void setAge(int age) throws NoSuchAgeException{
		if (age <0 | age >150) {
			throw new NoSuchAgeException("This age is not possible in today's world");
		}
		else {
			this.age = age;
			}
		}
	
	//----------------------------Relation Handling in Sub-Classes----------------------------//

	public abstract void addCouple(Profile couple) throws NoAvailableException;

	public abstract void deleteCouple(Profile couple);

	public abstract void addChild(Profile children) throws NotToBeChildException;

	public abstract void deleteChild(Profile children);

	public abstract void addClassmate(Profile classmate) throws NotToBeClassmatesException;

	public abstract void deleteClassmate(Profile classmate);

	public abstract void addColleague(Profile colleague) throws NotToBeColleaguesException;

	public abstract void deleteColleague(Profile colleague);

	public abstract void addParent(Profile parent) throws NoParentException;

	public abstract void deleteParent(Profile parent);

	public abstract void addFriend(Profile one) throws NotToBeFriendsException;

	public abstract void deleteFriend(Profile one);

	public abstract ArrayList<String> getFriend();

	public abstract ArrayList<String> getParent();

	public abstract ArrayList<String> getCouple();

	public abstract ArrayList<String> getClassmate();

	public abstract ArrayList<String> getColleague();

	public abstract ArrayList<String> getChild();
		
}
