package Assignment1;
import java.util.*;
import com.sun.prism.Image;

public class Child extends Profile {
	
	private String status;
	private String dependent[] = new String[2];
	Scanner input = new Scanner(System.in);

	public Child(String name, int age, String status, Image photo, String[] friendlist, String[] dependent) {
		super(name, age, status, photo, friendlist);
		this.dependent = dependent;
	}
	
	public Child(String name, int age, Image photo, String[] friendlist, String[] dependent) {
		this(name, age, null, photo, friendlist, dependent);
	}

	public Child(String name, int age, String status, String[] dependent) {
		this(name, age, status, null, null, dependent);
	}

	public Child(String name, int age, String[] dependent) {
		this(name, age, null, null, null, dependent);
	}
	
	public String[] addDependent(){
		System.out.println("Enter Name of First Dependent: ");
		String d1 = input.nextLine();
		System.out.println("Enter Name of Second Dependent: ");
		String d2 = input.nextLine();
		this.dependent = new String[]{d1,d2};
		return dependent;
	}
	
	public String[] getDependent(){return dependent;}

}
