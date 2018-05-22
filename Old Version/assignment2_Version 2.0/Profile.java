package assignment;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Abstract Profile class to define basic information of a Profile
 * @version 9.0 15 May 2018
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

		this(name, age, status, null); 
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
		
}
