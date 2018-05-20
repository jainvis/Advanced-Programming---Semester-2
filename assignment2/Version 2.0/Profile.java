public class Profile
{
	private String name;
	private int age;
	private String status;
	//private BufferedImage photo;
	
	
	public Profile(String name, int age, String status)
	{
		this.name = name;
		//this.photo = photo;
		this.status = status;
		this.age = age;
	}
	
	public void setName(String name){
	      
	       this.name = name;
	   }
	  
	   public String getName(){
	      
	       return name;
	   }

	  	


}

