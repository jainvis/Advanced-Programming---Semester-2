package Assignment1;

import java.util.*;

import com.sun.prism.Image;

public class Adult extends Profile {
	
	private ArrayList<String> childlist = new ArrayList<String>();

	public Adult(String name, int age, String status, Image photo, ArrayList<String> friendlist, ArrayList<String> childlist) {
		super(name, age, status, photo, friendlist);
		this.childlist.addAll(childlist);
	}

	public Adult(String name, int age, Image photo, ArrayList<String> friendlist) {
		super(name, age, photo, friendlist);
	}

	public Adult(String name, int age, String status) {
		super(name, age, status);
		this.childlist = new ArrayList<String>();
		}

	public Adult(String name, int age) {
		super(name, age);
	}

	public void addFriend(String fname) {
		super.setFriend(fname);
	}

	public ArrayList<String> getChildlist() {
		return childlist;
	}

	public void setChildlist(String childname) {
		this.childlist.add(childname);
	}

}
