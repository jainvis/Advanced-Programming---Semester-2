package Assignment1;

import java.util.*;

public abstract class Driver {

	static Profile adult;
	static Scanner input = new Scanner(System.in);
	static Scanner line = new Scanner(System.in);

	public static Profile addProfile(){
		
		System.out.println("Enter Name");
		String name = input.nextLine();
		System.out.println("Enter Age");
		int age = input.nextInt();
		input.nextLine();
		System.out.println("Add Status? (Y/N)");
		String status = null;
		String opt = line.nextLine();
		if("N".equals(opt)){
			status = null;
		}
		else if("Y".equals(opt)){
			System.out.println("Enter Status: ");
			status = input.nextLine();
		}
		
		if(age<16 && age>2){
			System.out.println("Enter Full Name of First Dependent");
			String dependent1 = input.nextLine();
			System.out.println("Enter Full Name of Second Dependent");
			String dependent2 = input.nextLine();
			adult = new Child(name, age, status, new String[]{dependent1, dependent2});
			((Child) adult).setDependent(dependent1, dependent2);
		}
		else if(age>16){
			adult = new Adult(name, age, status);
		}
		return adult;

	}

	public static void displayProfile(Profile adult){
		System.out.println("Name: "+adult.getName()+" ,Age: "+adult.getAge()+" ,Status: "+adult.getStatus());
	}
	
	public static void profileDetails(Profile profile){
		if(profile instanceof Adult){
			System.out.println("Name: "+profile.getName()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus());
			System.out.println("Friend List: \n"+profile.getFriendlist());
		}
		if(profile instanceof Child){
			System.out.println("Name: "+profile.getName()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus());
			System.out.println("Dependents: \n"+Arrays.toString(((Child) profile).getDependent()));
			System.out.println("Friend List: \n"+profile.getFriendlist());
		}
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
		if(profile instanceof Child && profile.getAge() - friend.getAge() < 4 && friend instanceof Child){
			profile.setFriend(friend.getName());
		}
		if(profile instanceof Adult && friend instanceof Adult){
			profile.setFriend(friend.getName());
		}
	}
	
	//Taking Assumption that once dependents are added they cannot be altered, we might give edit option
	//public static void addDependent(Profile profile, Profile dependent){
		//if(profile instanceof Child && dependent instanceof Adult){
			//((Child)profile).setDependent();
		//}
		
	//}

	public static int uprofilemenu(){
		System.out.println("1. Update Name");
		System.out.println("2. Update Age");
		System.out.println("3. Update Status");
		System.out.println("4. Go To Previous Menu");
		return input.nextInt();
	}



}
