package Assignment1;
import java.util.*;
import com.sun.prism.Image;

public class Child extends Profile {
	
	private String status;
	private String dependent[] = new String[2];
	Scanner input = new Scanner(System.in);

	public Child(String name, int age, String status, Image photo, ArrayList<String> friendlist, String[] dependent) {
		super(name, age, status, photo, friendlist);
		this.dependent = dependent;
	}
	
	public Child(String name, int age, Image photo, ArrayList<String> friendlist, String[] dependent) {
		this(name, age, null, photo, friendlist, dependent);
	}

	public Child(String name, int age, String status, String[] dependent) {
		this(name, age, status, null, new ArrayList<String>(), dependent);
	}

	public Child(String name, int age, String[] dependent) {
		this(name, age, null, null, new ArrayList<String>(), dependent);
	}
	
	public void setDependent(String d1, String d2){
		this.dependent = new String[]{d1,d2};
	}
	
	public String[] getDependent(){return dependent;}

}
