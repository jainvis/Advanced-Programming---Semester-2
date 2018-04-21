package assignment;

import java.util.ArrayList;

import com.sun.prism.Image;

public class YoungChild extends Profile {
	
	private String dependent[] = new String[2];

	public YoungChild(String name, int age, String status, Image photo, ArrayList<String> friendlist, String[] dependent) {
		super(name, age, status, photo, friendlist);
		this.dependent = dependent;
	}
	
	public YoungChild(String name, int age, String status, ArrayList<String> friendlist, String[] dependent) {
		super(name, age, status, friendlist);
		this.dependent = dependent;
	}

	public YoungChild(String name, int age, String status, String[] dependent) {
		this(name, age, status, null, new ArrayList<String>(), dependent);
	}

	public void setDependent(String d1, String d2){
		this.dependent = new String[]{d1,d2};
	}
	
	public String[] getDependent(){return dependent;}


}
