package assignment;
import java.util.*;
import java.io.*;

/**
 * Driver Class to store profile information
 * Execute all actions on a profile
 * @version 12.0 20 May 2018
 * @author Vishesh Jain
 */

public abstract class Driver {

	static Scanner input = new Scanner(System.in);
	private static HashMap<Integer, Profile> list = new HashMap<Integer, Profile>(){
		{	
			try {
			putAll(Database.getData());
			}
			catch(IOException e) {
				System.err.println(e.getMessage());
			}
		}
	};
		
	public static int addProfile(String name, int age, String status, 
			String dependent1, String dependent2) throws NoParentException, NoSuchAgeException, ProfileExistsException{
		Profile person = null;
		Random randomGenerator = new Random();
		int id = 0;
		int count = 0;

		// Added in GUI
		
		//		System.out.println("Enter Full Name: (Ex: John Doe)");
		//		name = input.nextLine();
		//		name = name.toLowerCase();
		for(int i : list.keySet()) {
			if (list.get(i).getName().contains(name)==true) {
				System.err.println("Profile already exists !"); 
				count++;
			}
		}

		// Added in GUI
		
		//		System.out.println("Enter Age: ");
		//		int age = 0;
		//		try{ 
		//			age = input.nextInt();
		//		} catch (InputMismatchException e) {
		//			System.err.println("Enter a valid number for Age !");
		//		}

		//		input.nextLine();
		//		System.out.println("Add Status? (Y/N)");
		//		String status = " ";
		//		String opt = input.nextLine().toLowerCase();
		//		switch (opt){
		//		case "n":
		//			status = "";
		//			break;
		//		case "y":
		//			System.out.println("Enter Status: ");
		//			status = input.nextLine().toLowerCase();
		//			break;
		//		default:
		//			System.out.println("Invalid Option! Status will be null");
		//			break;
		//		}
		
		if(count!=0) {
			throw new ProfileExistsException("Duplicate Profile with same Name !");
		}
		
		else {

		if(age<16 && age>2){

			// Added in GUI

			//			System.out.println("Enter Full Name of First Dependent: (Ex: John Doe)");
			//			String dependent1 = input.nextLine().toLowerCase();
			//			System.out.println("Enter Full Name of Second Dependent: (Ex: Jane Doe)");
			//			String dependent2 = input.nextLine().toLowerCase();
			if (dependent1.isEmpty() | dependent2.isEmpty()) {
				throw new NoParentException("Parents Mandatory");
			}
			Profile dep1 = profileCheck(dependent1);
			Profile dep2 = profileCheck(dependent2);
			boolean check3 = dependentCheck(new String[]{dep1.getName(),dep2.getName()});
			if (dep1 == null || dep2 == null || check3 == false){
				throw new NoParentException("Dependents Check Failed !");
			}
			else{
				ArrayList<String> parent = new ArrayList<String>() ;
				parent.add(dep1.getName());
				parent.add(dep2.getName());
				person = new Child(name, age, status, parent);
				((Child) person).setParent(dep1.getName());
				((Child) person).setParent(dep2.getName());
				((Adult) dep1).setChild(person.getName());
				((Adult) dep2).setChild(person.getName());
				System.out.println("Your Profile has been added !");
			}
		}
		else if(age<0 | age>150){
			throw new NoSuchAgeException("This age is not possible in today's world");
		}
		else if(age>16) {
			person = new Adult(name, age, status);
			System.out.println("Your Profile has been added !");
		}
		else if(age<2){
			// Added in GUI

			//			System.out.println("Enter Full Name of First Dependent: (Ex: John Doe)");
			//			String dependent1 = input.nextLine().toLowerCase();
			//			System.out.println("Enter Full Name of Second Dependent: (Ex: Jane Doe)");
			//			String dependent2 = input.nextLine().toLowerCase();
			if (dependent1.isEmpty() | dependent2.isEmpty()) {
				throw new NoParentException("Parents Mandatory");
			}
			Profile dep1 = profileCheck(dependent1);
			Profile dep2 = profileCheck(dependent2);
			boolean check3 = dependentCheck(new String[]{dep1.getName(),dep2.getName()});
			if (dep1 == null || dep2 == null || check3 == false){
				throw new NoParentException("Dependents Check Failed !");
			}
			else{
				ArrayList<String> parent = new ArrayList<String>() ;
				parent.add(dep1.getName());
				parent.add(dep2.getName());
				person = new YoungChild(name, age, status, parent);
				((Child) person).setParent(dep1.getName());
				((Child) person).setParent(dep2.getName());
				((Adult) dep1).setChild(person.getName());
				((Adult) dep2).setChild(person.getName());
				System.out.println("Your Profile has been added !");
			}
		}
		do{
			id = randomGenerator.nextInt(9999); //Unique ID is required to be generated
		}while(list.containsKey(id));
		list.put(id,person);
		System.out.println("Your ID is: "+id);
		}
		return id;
	}


	public static void displayProfile(Profile person){
		//		String display = ("Name: "+person.getName().toUpperCase()+" ,Age: "+person.getAge()+" ,Status: "+person.getStatus().toUpperCase());
		System.out.println("Name: "+person.getName().toUpperCase()+" ,Age: "+person.getAge()+" ,Status: "+person.getStatus().toUpperCase());
		//		return display;
	}

	public static void profileDetails(Profile profile){
		if(profile instanceof Adult){
			System.out.println("Name: "+profile.getName().toUpperCase()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus().toUpperCase());
			System.out.println("Friend List: \n"+(((Adult) profile).getFriend()));
			System.out.println("Children : \n"+((Adult) profile).getChild());
			System.out.println("Colleagues: \n"+ ((Adult) profile).getColleague());
			System.out.println("Spouse: \n"+ ((Adult) profile).getCouple());
		}
		if(profile instanceof Child){
			System.out.println("Name: "+profile.getName().toUpperCase()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus().toUpperCase());
			System.out.println("Dependents: \n" + ((Child) profile).getParent());
			System.out.println("Friends: \n" + ((Child) profile).getFriend());
			System.out.println("Classmates: \n" + ((Child) profile).getClassmate());
		}
		if(profile instanceof YoungChild) {
			System.out.println("Name: "+profile.getName().toUpperCase()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus().toUpperCase());
			System.out.println("Dependents: \n" + ((YoungChild) profile).getParent());
		}
	}

	public static void updateProfile(int id, String name, int age, String status) throws NoSuchAgeException{
		Profile person = list.get(id);
		if (!name.isEmpty()) {
			person.setName(name);
			System.out.println("New Name"+person.getName());
		}

		if (age!=0) {
			try {
				person.setAge(age);
				System.out.println(person.getAge());
			}
			catch(NoSuchAgeException e) {
				throw new NoSuchAgeException("Invalid Age");
			}
		}

		if(!status.isEmpty()) {
			person.setStatus(status);
			System.out.println(person.getStatus());
		}

		list.put(id, person);
		System.out.println("Profile: "+list.get(id));

		//		int opt = 0;
		//		do{
		//			try{
		//				opt = uprofilemenu();
		//			} catch (InputMismatchException e) {
		//				System.err.println("Enter a valid number to choose !");
		//			}
		//			switch (opt){
		//			case 1:
		//				System.out.println("Enter new Name !");
		//				input.nextLine(); //Added to consume any spaces left after nextInt()
		//				String nname = input.nextLine().toLowerCase();
		//				adult.setName(nname);
		//				break;
		//
		//			case 2:
		//				System.out.println("Enter new Age:");
		//				int nage = adult.getAge();
		//				try{ nage = input.nextInt();
		//				} catch (InputMismatchException e) {
		//					System.err.println("Enter a valid integer for Age !");
		//				}
		//				try {
		//					adult.setAge(nage);
		//				}
		//				catch (NoSuchAgeException e) {
		//					System.err.println(adult.getName()+" has impossible age.");
		//					System.err.println(e.getMessage());
		//					//					return e.getMessage();
		//				}
		//				break;
		//
		//			case 3:
		//				System.out.println("Enter new Status: ");
		//				input.nextLine();
		//				String nstatus = input.nextLine().toLowerCase();
		//				adult.setStatus(nstatus);
		//				break;
		//
		//			case 4:
		//				break;
		//			default: 
		//				System.out.println("Select a Valid Option !");
		//				break;
		//			}
		//		}while(opt!=4);
	}

	public static void deleteProfile(int id) throws NoParentException{

			if (!(list.get(id).getChild().isEmpty()) ||	!(list.get(id).getParent().isEmpty())){
				throw new NoParentException("Dependents Exist !");
			}
			else {
				list.remove(id);
				System.out.println("Profile Deleted !");
			}

	}

	//	public static void addFriend(Profile profile, Profile friend) throws NotToBeFriendsException{
	//		
	//		if(profile instanceof Child && friend instanceof Adult){
	//			throw new NotToBeFriendsException("Cannot be friends");
	//		}
	//		
	//		else if(profile instanceof Adult && friend instanceof Child){
	//			throw new NotToBeFriendsException("Cannot be friends");
	//		}
	//		
	//		else{
	//			if(profile.getAge() - friend.getAge() > 3){
	//				throw new NotToBeFriendsException("Cannot be friends");
	//			}
	//			else{
	//				((Adult) profile).setFriend(friend);
	//				((Adult) friend).setFriend(profile);
	//			}
	//		}

	//		if(profile instanceof Child && profile.getAge() - friend.getAge() < 4 && friend instanceof Child){
	//			profile.setFriend(friend.getName());
	//			friend.setFriend(profile.getName());
	//		}
	//		
	//		else if(profile instanceof Adult && friend instanceof Adult){
	//			profile.setFriend(friend.getName());
	//			friend.setFriend(profile.getName());
	//		}
	//		else{
	//			System.out.println(friend.getName()+" and "+profile.getName()+" both are not adults");
	//		}
	//	}

	// Need new menu and method to add connections

	public static boolean dependentCheck(String[] name){
		boolean check = false;
		int count1 = 0;
		int count2 = 0;
		Profile one = profileCheck(name[0]);
		Profile two = profileCheck(name[1]);
		for(int i : list.keySet()){
			if(list.get(i) instanceof Child | list.get(i) instanceof YoungChild){
				if(list.get(i).getParent().contains(one.getName())){
					count1++;
				}
				if(list.get(i).getParent().contains(two.getName())){
					count2++;
				}
				if(count1 != count2){
					check = false;
					break;
				}
				else
					check=true;
			}
			else {
				check = true;
			}
		}
		return check;
	}

	public static Profile profileCheck(String name){
		Profile person = null;
		int count = 0;
		for(int i : list.keySet()){
			if(list.get(i).getName().contains(name.toLowerCase())==true){
				person = list.get(i);
				count++;
			}
		}
		if(count == 0){System.out.println(name.toUpperCase()+" Profile not found on SocioNet");}
		return person;
	}

	public static String connectionCheck(String n1, String n2) throws NoRelationException{
		//check connection method
		// Change this method to check all the connections
		String relation = "No Relation";
		Profile one = profileCheck(n1);
		Profile two = profileCheck(n2);
		
		if (one.getFriend().contains(two.getName()) || two.getFriend().contains(one.getName())) {
			System.out.println(two.getName().toUpperCase()+" is a friend of " +one.getName().toUpperCase());
			relation = two.getName().toUpperCase()+" is a friend of " +one.getName().toUpperCase();
		}
		
		else if(one.getParent().contains(two.getName()) || two.getChild().contains(one.getName())) {
			System.out.println(two.getName().toUpperCase()+" is a Parent of "+one.getName().toUpperCase());
			relation = two.getName().toUpperCase()+" is a Parent of "+one.getName().toUpperCase();
		}
		
		else if(one.getChild().contains(two.getName()) || two.getParent().contains(one.getName())) {
			System.out.println(two.getName().toUpperCase()+" is a child of "+one.getName().toUpperCase());
			relation = two.getName().toUpperCase()+" is a child of "+one.getName().toUpperCase();
		}
		
		else if(one.getCouple().contains(two.getName()) || two.getCouple().contains(one.getName())) {
			System.out.println(two.getName().toUpperCase()+" is a spouse of " +one.getName().toUpperCase());
			relation = two.getName().toUpperCase()+" is a spouse of " +one.getName().toUpperCase();
		}
		
		else if(one.getClassmate().contains(two.getName()) || two.getClassmate().contains(one.getName())) {
			System.out.println(two.getName().toUpperCase()+" is a classmate of " +one.getName().toUpperCase());
			relation = two.getName().toUpperCase()+" is a classmate of " +one.getName().toUpperCase();
		}
		
		else if(one.getColleague().contains(two.getName()) || two.getColleague().contains(one.getName())) {
			System.out.println(two.getName().toUpperCase()+" is a colleague of " +one.getName().toUpperCase());
			relation = two.getName().toUpperCase()+" is a colleague of " +one.getName().toUpperCase();
		}

		if (relation=="No Relation") {
			System.out.println(two.getName().toUpperCase()+" is not a connection of " +one.getName().toUpperCase());
			throw new NoRelationException("Not Related in this World");
		}
		return relation;
	}

	public static void addConnection(String option, Profile primary, String name) throws NoProfileException, NoParentException, NotToBeCoupledException, NotToBeColleaguesException, NotToBeFriendsException, NotToBeChildException, NotToBeClassmatesException, NoAvailableException {
		Profile secondary = profileCheck(name);
		if (secondary != null) {
			switch(option) {
			case "FRIEND":
				try {
					primary.addFriend(secondary);
					System.out.println(secondary.getName()+" added as a Friend");
					secondary.addFriend(primary);
				}
				catch(NotToBeFriendsException e) {
					System.err.println(e.getMessage());
					throw new NotToBeFriendsException(e.getMessage());
				}
				break;
			case "PARENT":
				boolean dcCheck;
				try {
					dcCheck = dcrelationCheck(secondary);

					if (!(primary).getParent().isEmpty()) {
						throw new NoParentException ("Dependents Already Exist !");
					}

					else {
						try {
							primary.addParent(secondary);
							System.out.println(secondary.getName()+" added as a Parent");
							secondary.addChild(primary);
						}
						catch(NoParentException e) {
							System.err.println(e.getMessage());
							throw new NoParentException(e.getMessage());
						}
					}
				} 
				catch (NoParentException e2) {
					throw new NoParentException("Someone Else's Parent !");
				}
				break;
			case "CHILD":
				try {
					primary.addChild(secondary);
					System.out.println(secondary.getName()+" added as a Child");
					secondary.addParent(primary);
				}
				catch(NotToBeChildException e) {
					System.err.println(e.getMessage());
					throw new NotToBeChildException(e.getMessage());
				}
				break;
			case "SPOUSE":
				boolean CoupleCheck;
				try {
					CoupleCheck = dcrelationCheck(secondary);

					if (!(secondary).getCouple().isEmpty()) {
						throw new NotToBeCoupledException ("Spouse Exists, Dont Cheat !");
					}

					else {

						try {
							primary.addCouple(secondary);
							System.out.println(secondary.getName()+" added as a Spouse");
							secondary.addCouple(primary);
						}
						catch(NoAvailableException e) {
							System.err.println(e.getMessage());
							throw new NoAvailableException(e.getMessage());
						}
					}
				}
				catch (NotToBeCoupledException e1) {
					throw new NotToBeCoupledException("Someone Else's Partner ! Check Name Again");
				}
				break;

			case "COLLEAGUE":
				try {
					primary.addColleague(secondary);
					System.out.println(secondary.getName()+" added as a Colleague");
					secondary.addColleague(primary);
				}
				catch(NotToBeColleaguesException e) {
					System.err.println(e.getMessage());
					throw new NotToBeColleaguesException(e.getMessage());
				}
				break;
			case "CLASSMATE":
				try {
					primary.addClassmate(secondary);
					System.out.println(secondary.getName()+" added as a Classmate");
					secondary.addClassmate(primary);
				}
				catch(NotToBeClassmatesException e) {
					System.err.println(e.getMessage());
					throw new NotToBeClassmatesException(e.getMessage());
				}
				break;
			default:
				System.out.println("Enter a Valid Option !");
				break;
			}
		}
		else {
			throw new NoProfileException("Entered Name does not Exist");
		}
	}


	public static ArrayList<Connections> getConnection(Profile primary){

		ArrayList<Connections> connection = new ArrayList<Connections>();

		if(!(primary.getFriend()==null)) {

			for(int i = 0; i < primary.getFriend().size(); i++) {
				Connections relationFriend = new Connections(primary.getFriend().get(i).toUpperCase(), "FRIEND");
				connection.add(relationFriend);
			}
		}

		if (!(primary.getParent()==null)) {

			for(int i = 0; i < primary.getParent().size(); i++) {
				Connections relationParent = new Connections(primary.getParent().get(i).toUpperCase(), "PARENT");
				connection.add(relationParent);
			}
		}

		if(!(primary.getChild()==null)) {

			for(int i = 0; i < primary.getChild().size(); i++) {
				Connections relationChild = new Connections(primary.getChild().get(i).toUpperCase(), "CHILD");
				connection.add(relationChild);
			}
		}

		if(!(primary.getCouple()==null)) {

			for(int i = 0; i < primary.getCouple().size(); i++) {
				Connections relationCouple = new Connections(primary.getCouple().get(i).toUpperCase(), "SPOUSE");
				connection.add(relationCouple);
			}
		}

		if(!(primary.getColleague()==null)) {

			for(int i = 0; i < primary.getColleague().size(); i++) {
				Connections relationColleague = new Connections(primary.getColleague().get(i).toUpperCase(), "COLLEAGUE");
				connection.add(relationColleague);
			}
		}

		if(!(primary.getClassmate()==null)) {
			for(int i = 0; i < primary.getClassmate().size(); i++) {
				Connections relationClassmate = new Connections(primary.getClassmate().get(i).toUpperCase(), "CLASSMATE");
				connection.add(relationClassmate);
			}
		}
		return connection;
	}


	// Checking Parents and Couples Existence in Other Profiles
	public static boolean dcrelationCheck(Profile person) throws NoParentException, NotToBeCoupledException{
		boolean check = false;
		for(int i : list.keySet()){
			if(list.get(i) instanceof Child | list.get(i) instanceof YoungChild){
				if((list.get(i)).getParent().contains(person.getName())){
					check=false;
					throw new NoParentException("Parent Exist in Another Profile");
				}
				else {
					check=true;
				}
			}
			else if(list.get(i) instanceof Adult) {
				if((list.get(i)).getCouple().contains(person.getName())) {
					check=false;
					throw new NotToBeCoupledException("This Person is someone else's partner !");		
				}
				else {
					check = true;
				}
			}
		}
		return check;
	}


	// Getter
	public static HashMap<Integer, Profile> getList() {
		return list;
	}

	public static Profile checkID(int ID) throws NoAvailableException {
		Profile check = null;
		if(list.containsKey(ID)) {
			check = list.get(ID);
		}
		else {
			throw new NoAvailableException("ID Does Not Exist");
		}
		return check;
	}

	// Accessor
	public void setList(HashMap<Integer, Profile> list) {
		this.list = list;
	}

	public static int menu(){
//		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to SocioNet");
		System.out.println("-------Menu--------");
		System.out.println("1. Add Profile");
		System.out.println("2. Display Profile");
		System.out.println("3. Access Profile");
		System.out.println("4. Check Connection");
		System.out.println("5. Exit");
		return input.nextInt();
	}

//	public static int submenu1(){
////		Scanner input = new Scanner(System.in);
//		System.out.println("------PROFILE MENU------");
//		System.out.println("1. Update Profile");
//		System.out.println("2. Delete Profile");
//		System.out.println("3. Profile Details");
//		System.out.println("4. Add Friend");
//		System.out.println("9. Main Menu");
//		return input.nextInt();
//	}
//
//	public static int submenu2(){
//		Scanner input = new Scanner(System.in);
//		System.out.println("------PROFILE MENU------");
//		System.out.println("1. Update Profile");
//		System.out.println("2. Delete Profile");
//		System.out.println("3. Profile Details");
//		System.out.println("4. Add Friend");
//		System.out.println("5. Edit Dependent");
//		System.out.println("9. Main Menu");
//		return input.nextInt();
//	}
//
//
//	public static int uprofilemenu(){
//		System.out.println("1. Update Name");
//		System.out.println("2. Update Age");
//		System.out.println("3. Update Status");
//		System.out.println("4. Go To Previous Menu");
//		return input.nextInt();
//	}
//
//	public static int relationMenu(){
//		System.out.println("1. Friend");
//		System.out.println("2. Parent");
//		System.out.println("3. Child");
//		System.out.println("4. Couple");
//		System.out.println("5. Colleague");
//		System.out.println("6. Classmate");
//		System.out.println("7. Go To Previous Menu");
//		return input.nextInt();
//	}

//	public static void runNetwork(){
////list.putAll(inbuilt);
//Random randomGenerator = new Random();
//int id = 0;
//int opt = 0;
//do{
//	Scanner input = new Scanner(System.in);
//	try{opt = menu();
//	} catch (InputMismatchException e) {
//		System.err.println("Enter a valid number to choose !");
//	}
//	switch (opt){
//	case 1:
//		do{
//			id = randomGenerator.nextInt(9999); //Unique ID is required to be generated
//		}while(list.containsKey(id));
//		//				try{
//		////				list.put(id, addProfile(list));
//		//				}
//		//				catch (NoSuchAgeException e1) {
//		//					System.err.println(e1.getMessage());
//		//				}
//		//				catch (NoParentException e2){
//		//					System.err.println(e2.getMessage());
//		//				}
//		if(list.get(id) != null){ 
//			System.out.println("Your Profile is added with Unique ID: "+id);
//			System.out.println("Remember this unique ID to access profile in future\n");
//		}
//		else{
//			System.err.println("Your Profile was not Added !");
//		}
//		break;
//
//	case 2:
//		System.out.println("Enter name of the person");
//		String search = input.nextLine();
//		Profile person = profileCheck(search);
//		if(person != null){
//			displayProfile(person);
//		}
//		else{
//			System.err.println("Your Connection is not on SocioNet");
//		}
//		break;
//
//	case 3:
//		System.out.println("Enter Your Unique ID to Access: ");
//		int uid = input.nextInt();
//		if(list.get(uid) != null){
//			int subopt = 0;	
//			do{
//				try{ if(list.get(uid) instanceof Adult){
//					subopt = submenu1();}
//				else if(list.get(uid) instanceof Child){
//					subopt = submenu2();
//				}
//				} catch (InputMismatchException e) {
//					System.err.println("Enter a valid number to choose !");
//				}
//				switch (subopt){
//				case 1:
//					//							Driver.updateProfile(list.get(uid));
//					break;
//				case 2:
//					try{
//						Driver.deleteProfile(uid);
//					}
//					catch(NoParentException e){
//						System.err.println(e.getMessage());
//					}
//					break;
//				case 3:
//					Driver.profileDetails(list.get(uid));
//					break;
//				case 4:
//					input.nextLine();
//					System.out.println("Enter name of your Friend: "); // Changed statement
//					//							String friend = input.nextLine().toLowerCase();
//					String f = input.nextLine().toLowerCase();
//					Profile friend = Driver.profileCheck(f); //To check if friend is on socioNet
//					if(friend!= null){
//
//						// Need new methods to add connections
//
//						//								try {
//						////									Driver.addFriend(list.get(uid), friend);
//						//									System.out.println(friend.getName()+" added to your friendlist");
//						//								} catch (NotToBeFriendsException e) {
//						//									System.err.println(friend.getName()+" cannot be added.");;
//						//								}
//					}
//					else{System.err.println("Your Friend is not on SocioNet !!");}
//					//							int count = 0;
//					//							for(int i : list.keySet()){
//					//								if(list.get(i).getName().equals(friend)){
//					//									try {
//					//										Driver.addFriend(list.get(uid), list.get(i));
//					//										count++;
//					//									} catch (NotToBeFriendsException e) {
//					//										System.err.println(e.getMessage());;
//					//									}
//					//
//					//									}
//					//							}
//					//							if (count == 0){System.out.println("Your Friend is not on SocioNet");}
//					//							else{System.out.println("Your Friend is added to your friendlist");}
//					break;
//				case 5:
//					if(list.get(uid) instanceof Child){
//						System.out.println("Current Dependents: \n" + (((Child) list.get(uid)).getParent()));
//						input.nextLine();
//						System.out.println("Enter full name of first dependent: ");
//						String d1 = input.nextLine().toLowerCase();
//						System.out.println("Enter full name of second dependent: ");
//						String d2 = input.nextLine().toLowerCase();
//						Profile dep1 = Driver.profileCheck(d1); //To check if the dependent is on SocioNet
//						Profile dep2 = Driver.profileCheck(d2);
//						boolean check3 = Driver.dependentCheck(new String[]{dep1.getName(),dep2.getName()}); 
//						if (dep1 == null || dep2 == null || check3 == false){
//							System.out.println("Dependents check Failed !");
//							System.err.println("Dependents Not Changed !");
//							break;
//						}
//						else{
//
//							((Child) list.get(uid)).setParent(dep1.getName());
//							((Child) list.get(uid)).setParent(dep2.getName());
//							System.err.println(list.get(uid).getName()+" has No Parents !");
//							System.err.println("Therefore, Cannot be added.");
//
//							((Adult) dep1).setChild(list.get(uid).getName());
//							((Adult) dep2).setChild(list.get(uid).getName());
//							System.out.println("Dependents Updated !");
//							System.out.println("Also, you are added to your parents' list as a Child !");
//						}
//					}
//					break;
//				default:
//					System.out.println("Please select valid option !");
//					break;
//				}
//			}while (subopt!=5);
//		}
//		break;
//	case 4:
//		System.out.println("Enter name of the first Person");
//		String n1 = input.nextLine().toLowerCase();
//		System.out.println("Enter name of the second Person");
//		String n2 = input.nextLine().toLowerCase();
//		try {
//			Driver.connectionCheck(n1,n2);
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
//		break;
//	case 5:
//		break;
//	default:
//		System.err.println("Choose a valid option!");
//		break;
//	}
//
//}while(opt!=5);
//
//}


}
