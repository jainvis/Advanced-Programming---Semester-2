package Assignment1;

import java.util.*;

public abstract class Driver {

	static Profile adult;
	static Scanner input = new Scanner(System.in);

	public static Profile addProfile(){

		System.out.println("Enter Name");
		String name = input.nextLine();
		System.out.println("Enter Age");
		int age = input.nextInt();
		System.out.println("Add Status? (Y/N)");
		String status = null;
		String opt = input.next();
		if(opt=="N"){
			status = null;
		}
		else if(opt=="Y"){
			status = input.nextLine();
		}

		if(age<16 && age>2){
			String[] dependent = ((Child) adult).addDependent();
			adult = new Child(name, age, status, dependent);
		}
		else if(age>16){
			adult = new Adult(name, age, status);
		}
		return adult;

	}

	public static int displayProfile(String search, Profile adult){
		int count = 0;
		if(search.equals(adult.getName())){
			System.out.println("Name: "+adult.getName()+" ,Age: "+adult.getAge()+" ,Status: "+adult.getStatus());
			count++;
		}
		return count;
	}
	
	public static void updateProfile(Profile adult){
		System.out.println("1. Update Name");
		System.out.println("2. Update Age");
		System.out.println("3. Update Status");
		System.out.println("4. Go To Previous Menu");
		int opt = input.nextInt();
		switch (opt){
		case 1:
			System.out.println("Enter new Name: ");
			String nname = input.nextLine();
			adult.setName(nname);
			break;
			
		case 2:
			System.out.println("Enter new Age: ");
			int nage = input.nextInt();
			adult.setAge(nage);
			break;
			
		case 3:
			System.out.println("Enter new Status: ");
			String nstatus = input.nextLine();
			adult.setStatus(nstatus);
			break;
			
		case 4:
			break;
		}

	}
	
	public static void deleteProfile(Profile adult){
		System.out.println("Are you Sure? (Y/N)");
		String choice = input.nextLine();
		switch (choice){
		case "Y":
			adult = null;
			break;
		case "N":
			break;			
		}
	}
	
	public static void addFriend(Profile adult){
		System.out.println("Enter name of your Friend: ");
		String friend = input.nextLine();
		adult.setFriend(friend);
	}



}
