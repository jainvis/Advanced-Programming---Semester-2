package Assignment1;

import java.util.*;

public abstract class Driver {

	static Profile adult;
	static Scanner input = new Scanner(System.in);

	public static Profile addProfile(){
		input.nextLine();
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

	public static void displayProfile(String search){
			System.out.println("Name: "+adult.getName()+" ,Age: "+adult.getAge()+" ,Status: "+adult.getStatus());
	}
	
	public static void updateProfile(Profile adult){
		int opt = 0;
		do{
			opt = uprofilemenu();
		switch (opt){
		case 1:
			System.out.println("Enter new Name");
			input.nextLine(); //Added to consume any spaces left after nextInt()
			String nname = input.nextLine();
			adult.setName(nname);
			break;
			
		case 2:
			System.out.println("Enter new Age:");
			int nage = input.nextInt();
			adult.setAge(nage);
			break;
			
		case 3:
			System.out.println("Enter new Status: ");
			input.nextLine();
			String nstatus = input.nextLine();
			adult.setStatus(nstatus);
			break;
			
		case 4:
			break;
		}
		}while(opt!=4);
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
	
	public static void addFriend(Profile profile, Profile friend){
		if(profile instanceof Child && profile.getAge() - friend.getAge() < 4){
		profile.setFriend(friend.getName());
		}
	}
	
	public static int uprofilemenu(){
		System.out.println("1. Update Name");
		System.out.println("2. Update Age");
		System.out.println("3. Update Status");
		System.out.println("4. Go To Previous Menu");
		return input.nextInt();
	}



}
