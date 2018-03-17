package Assignment1;
import java.util.*;

import com.sun.prism.Image;
public abstract class Profile {
	
	private String name;
	private int age;
	private String status;
	private Image photo;
	private String friendlist[];
	
	public Profile(String name, int age, String status, Image photo, String friendlist[]){
		
		this.name = name;
		this.age = age;
		this.status = status;
		this.photo = photo;
		this.friendlist = friendlist;
	}
	
	public Profile(String name, int age, Image photo, String friendlist[]){
		
		this(name, age, null, photo, friendlist);	//Complete Constructor of the Class
	}
	
	public Profile(String name, int age, String status){

		this(name, age, status, null, null ); //Constructor if photo and friend list is not given
	}
	
	public Profile(String name, int age){

		this(name, age, null, null, null ); //Constructor if only name and age are used
	}
	
	//Getters for the Class	
	public String getName() { return name; }
	
	public int getAge() {return age;} 
	
	public String getStatus() {return status;}
	
	public Image getPhoto(){return photo;}
	
	public String[] getFriendlist(){return friendlist;}
	
	//Setters for the Class
	public void setName(String name){this.name = name;}
	
	public void setAge(int age){this.age = age;}
	
	public void setStatus(String status){this.status = status;}
	
	public void setFriend(String friend){
		for(int i = 0;i < friend.length();i++){
			if(friendlist[i]==null){
				friendlist[i] = friend;
			}
		}
	}
		
}
