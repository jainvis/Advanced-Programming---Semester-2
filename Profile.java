package Assignment1;

public class Profile {
	
	private String name;
	private int age;
	private String status;
	
	public Profile(String name, int age, String status){
		
		this.name = name;
		this.age = age;
		this.status = status;
	}
	
	public Profile(String name, int age){
		
		this.name = name;
		this.age = age;
		status = null;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
}
