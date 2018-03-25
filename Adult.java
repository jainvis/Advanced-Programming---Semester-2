package Assignment1;

import java.util.*;

import com.sun.prism.Image;

public class Adult extends Profile {

	public Adult(String name, int age, String status, Image photo, ArrayList<String> friendlist) {
		super(name, age, status, photo, friendlist);
	}

	public Adult(String name, int age, Image photo, ArrayList<String> friendlist) {
		super(name, age, photo, friendlist);
	}

	public Adult(String name, int age, String status) {
		super(name, age, status);
	}

	public Adult(String name, int age) {
		super(name, age);
	}

	public void addFriend(String fname) {
		super.setFriend(fname);
	}

}
