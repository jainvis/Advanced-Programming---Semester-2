package assignment;
import java.util.*;

/**
 * Driver Class to store profile information
 * Execute all actions on a profile
 * @version 11.0 17 May 2018
 * @author Vishesh Jain
 */

public abstract class Driver implements Data {

	static Scanner input = new Scanner(System.in);
	private static HashMap<Integer, Profile> list = new HashMap<Integer, Profile>();

	public static void runNetwork(){
		list.putAll(inbuilt);
		Random randomGenerator = new Random();
		int id = 0;
		int opt = 0;
		do{
			Scanner input = new Scanner(System.in);
			try{opt = menu();
			} catch (InputMismatchException e) {
				System.err.println("Enter a valid number to choose !");
			}
			switch (opt){
			case 1:
				do{
					id = randomGenerator.nextInt(9999); //Unique ID is required to be generated
				}while(list.containsKey(id));
				//				try{
				////				list.put(id, addProfile(list));
				//				}
				//				catch (NoSuchAgeException e1) {
				//					System.err.println(e1.getMessage());
				//				}
				//				catch (NoParentException e2){
				//					System.err.println(e2.getMessage());
				//				}
				if(list.get(id) != null){ 
					System.out.println("Your Profile is added with Unique ID: "+id);
					System.out.println("Remember this unique ID to access profile in future\n");
				}
				else{
					System.err.println("Your Profile was not Added !");
				}
				break;

			case 2:
				System.out.println("Enter name of the person");
				String search = input.nextLine();
				Profile person = profileCheck(search);
				if(person != null){
					displayProfile(person);
				}
				else{
					System.err.println("Your Connection is not on SocioNet");
				}
				break;

			case 3:
				System.out.println("Enter Your Unique ID to Access: ");
				int uid = input.nextInt();
				if(list.get(uid) != null){
					int subopt = 0;	
					do{
						try{ if(list.get(uid) instanceof Adult){
							subopt = submenu1();}
						else if(list.get(uid) instanceof Child){
							subopt = submenu2();
						}
						} catch (InputMismatchException e) {
							System.err.println("Enter a valid number to choose !");
						}
						switch (subopt){
						case 1:
							Driver.updateProfile(list.get(uid));
							break;
						case 2:
							try{
								list = Driver.deleteProfile(uid, list);
							}
							catch(NoParentException e){
								System.err.println(e.getMessage());
							}
							break;
						case 3:
							Driver.profileDetails(list.get(uid));
							break;
						case 4:
							input.nextLine();
							System.out.println("Enter name of your Friend: "); // Changed statement
							//							String friend = input.nextLine().toLowerCase();
							String f = input.nextLine().toLowerCase();
							Profile friend = Driver.profileCheck(f); //To check if friend is on socioNet
							if(friend!= null){

								// Need new methods to add connections

								//								try {
								////									Driver.addFriend(list.get(uid), friend);
								//									System.out.println(friend.getName()+" added to your friendlist");
								//								} catch (NotToBeFriendsException e) {
								//									System.err.println(friend.getName()+" cannot be added.");;
								//								}
							}
							else{System.err.println("Your Friend is not on SocioNet !!");}
							//							int count = 0;
							//							for(int i : list.keySet()){
							//								if(list.get(i).getName().equals(friend)){
							//									try {
							//										Driver.addFriend(list.get(uid), list.get(i));
							//										count++;
							//									} catch (NotToBeFriendsException e) {
							//										System.err.println(e.getMessage());;
							//									}
							//
							//									}
							//							}
							//							if (count == 0){System.out.println("Your Friend is not on SocioNet");}
							//							else{System.out.println("Your Friend is added to your friendlist");}
							break;
						case 5:
							if(list.get(uid) instanceof Child){
								System.out.println("Current Dependents: \n" + (((Child) list.get(uid)).getParent()));
								input.nextLine();
								System.out.println("Enter full name of first dependent: ");
								String d1 = input.nextLine().toLowerCase();
								System.out.println("Enter full name of second dependent: ");
								String d2 = input.nextLine().toLowerCase();
								Profile dep1 = Driver.profileCheck(d1); //To check if the dependent is on SocioNet
								Profile dep2 = Driver.profileCheck(d2);
								boolean check3 = Driver.dependentCheck(new String[]{dep1.getName(),dep2.getName()}); 
								if (dep1 == null || dep2 == null || check3 == false){
									System.out.println("Dependents check Failed !");
									System.err.println("Dependents Not Changed !");
									break;
								}
								else{

									((Child) list.get(uid)).setParent(dep1);
									((Child) list.get(uid)).setParent(dep2);
									System.err.println(list.get(uid).getName()+" has No Parents !");
									System.err.println("Therefore, Cannot be added.");

									((Adult) dep1).setChild(list.get(uid));
									((Adult) dep2).setChild(list.get(uid));
									System.out.println("Dependents Updated !");
									System.out.println("Also, you are added to your parents' list as a Child !");
								}
							}
							break;
						default:
							System.out.println("Please select valid option !");
							break;
						}
					}while (subopt!=5);
				}
				break;
			case 4:
				System.out.println("Enter name of the first Person");
				String n1 = input.nextLine().toLowerCase();
				System.out.println("Enter name of the second Person");
				String n2 = input.nextLine().toLowerCase();
				Driver.connectionCheck(n1,n2);
				break;
			case 5:
				break;
			default:
				System.err.println("Choose a valid option!");
				break;
			}

		}while(opt!=5);

	}


	public static void addProfile(String name, int age, String status, 
			String dependent1, String dependent2) throws NoParentException, NoSuchAgeException{
		Profile person = null;
		Random randomGenerator = new Random();
		int id = 0;
//		System.out.println("Enter Full Name: (Ex: John Doe)");
		// Added in GUI
		//		name = input.nextLine();
		//		name = name.toLowerCase();
		for(int i : list.keySet()) {
			if (list.get(i).getName().contains(name)==true) {
				System.err.println("Profile already exists !"); // Can see about an exception here
			}
		}

//		System.out.println("Enter Age: ");

		// Added in GUI

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

		if(age<16 && age>2){

			// Added in GUI

			//			System.out.println("Enter Full Name of First Dependent: (Ex: John Doe)");
			//			String dependent1 = input.nextLine().toLowerCase();
			//			System.out.println("Enter Full Name of Second Dependent: (Ex: Jane Doe)");
			//			String dependent2 = input.nextLine().toLowerCase();
			Profile dep1 = profileCheck(dependent1);
			Profile dep2 = profileCheck(dependent2);
			boolean check3 = dependentCheck(new String[]{dep1.getName(),dep2.getName()});
			if (dep1 == null || dep2 == null || check3 == false){
				throw new NoParentException("Dependents Check Failed !");
			}
			else{
				ArrayList<Profile> parent = new ArrayList<Profile>() ;
				parent.add(dep1);
				parent.add(dep2);
				person = new Child(name, age, status, parent);
				((Child) person).setParent(dep1);
				((Child) person).setParent(dep2);
				((Adult) dep1).setChild(person);
				((Adult) dep2).setChild(person);
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
		else {
			// Added in GUI

			//			System.out.println("Enter Full Name of First Dependent: (Ex: John Doe)");
			//			String dependent1 = input.nextLine().toLowerCase();
			//			System.out.println("Enter Full Name of Second Dependent: (Ex: Jane Doe)");
			//			String dependent2 = input.nextLine().toLowerCase();
			Profile dep1 = profileCheck(dependent1);
			Profile dep2 = profileCheck(dependent2);
			boolean check3 = dependentCheck(new String[]{dep1.getName(),dep2.getName()});
			if (dep1 == null || dep2 == null || check3 == false){
				throw new NoParentException("Dependents Check Failed !");
			}
			else{
				ArrayList<Profile> parent = new ArrayList<Profile>() ;
				parent.add(dep1);
				parent.add(dep2);
				person = new YoungChild(name, age, status, parent);
				((Child) person).setParent(dep1);
				((Child) person).setParent(dep2);
				((Adult) dep1).setChild(person);
				((Adult) dep2).setChild(person);
				System.out.println("Your Profile has been added !");
			}
		}
		do{
			id = randomGenerator.nextInt(9999); //Unique ID is required to be generated
		}while(list.containsKey(id));
		list.put(id,person);
		System.out.println("Your ID is: "+id);
	}

	public static String displayProfile(Profile person){
		String display = ("Name: "+person.getName().toUpperCase()+" ,Age: "+person.getAge()+" ,Status: "+person.getStatus().toUpperCase());
		System.out.println("Name: "+person.getName().toUpperCase()+" ,Age: "+person.getAge()+" ,Status: "+person.getStatus().toUpperCase());
		return display;
	}

	public static void profileDetails(Profile profile){
		if(profile instanceof Adult){
			System.out.println("Name: "+profile.getName().toUpperCase()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus().toUpperCase());
			System.out.println("Friend List: \n"+(((Adult) profile).getFriend()));
			System.out.println("Children : \n"+((Adult) profile).getChildren());
			System.out.println("Colleagues: \n"+ ((Adult) profile).getColleague());
			System.out.println("Partner: \n"+ ((Adult) profile).getCouple());
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

	public static void updateProfile(Profile adult){
		int opt = 0;
		do{
			try{
				opt = uprofilemenu();
			} catch (InputMismatchException e) {
				System.err.println("Enter a valid number to choose !");
			}
			switch (opt){
			case 1:
				System.out.println("Enter new Name !");
				input.nextLine(); //Added to consume any spaces left after nextInt()
				String nname = input.nextLine().toLowerCase();
				adult.setName(nname);
				break;

			case 2:
				System.out.println("Enter new Age:");
				int nage = adult.getAge();
				try{ nage = input.nextInt();
				} catch (InputMismatchException e) {
					System.err.println("Enter a valid integer for Age !");
				}
				try {
					adult.setAge(nage);
				}
				catch (NoSuchAgeException e) {
					System.err.println(adult.getName()+" has impossible age.");
					System.err.println(e.getMessage());
					//					return e.getMessage();
				}
				break;

			case 3:
				System.out.println("Enter new Status: ");
				input.nextLine();
				String nstatus = input.nextLine().toLowerCase();
				adult.setStatus(nstatus);
				break;

			case 4:
				break;
			default: 
				System.out.println("Select a Valid Option !");
				break;
			}
		}while(opt!=4);
	}

	public static HashMap<Integer, Profile> deleteProfile(int id, HashMap<Integer, Profile> plist) throws NoParentException{
		System.out.println("Are you Sure? (Y/N)");
		String choice = input.nextLine();
		switch (choice){
		case "Y":
			if (((Adult) plist.get(id)).getChildren() != null){
				throw new NoParentException("Dependents Exist !");
			}
			else if (((Child) plist.get(id)).getParent() !=null | 
					((YoungChild) plist.get(id)).getParent() != null){
				throw new NoParentException("Dependents Exist !");
			}
			else {
				plist.remove(id);
			}
			break;
		case "N":
			break;
		default:
			System.out.println("Choose a valid Option !");
			break;
		}
		return plist;
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
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		Profile one = profileCheck(name[0]);
		Profile two = profileCheck(name[1]);
		for(int i : list.keySet()){
			if(list.get(i) instanceof Child){
				if(((Child) list.get(i)).getParent().contains(one)){
					count1++;
				}
				if(((Child) list.get(i)).getParent().contains(two)){
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

	public static String connectionCheck(String n1, String n2){
		//check connection method
		// Change this method to check all the connections
		String relation = "No Relation";
		Profile one = profileCheck(n1);
		Profile two = profileCheck(n2);
		if((one instanceof Adult && two instanceof Child)){
			if(((Child) two).getParent().contains(one)==true){
				System.out.println(two.getName().toUpperCase()+" is a child of "+one.getName().toUpperCase());
				relation = "friend";
			}
		}
		else if((two instanceof Adult && one instanceof Child)){
			if(((Child) one).getParent().contains(two)==true){
				System.out.println(one.getName().toUpperCase()+" is a child of "+two.getName().toUpperCase());
				relation = "Child";
			}
		}
		else if(one instanceof Adult && two instanceof Adult){
			if(((Adult) one).getFriend().contains(two)==true || ((Adult) two).getFriend().contains(one)==true){
				System.out.println(one.getName().toUpperCase()+" is a friend of " +two.getName().toUpperCase());
				relation = "Friend";
			}
			else if(((Adult) one).getCouple().contains(two)==true || ((Adult) two).getCouple().contains(one)==true){
				System.out.println(one.getName().toUpperCase()+" is partner of " +two.getName().toUpperCase());
				relation = "Couple";
			}
			else if(((Adult) one).getColleague().contains(two)==true || ((Adult) two).getColleague().contains(one)==true){
				System.out.println(one.getName().toUpperCase()+" is a colleague of " +two.getName().toUpperCase());
				relation = "Colleague";
			}
		}
		if (relation=="No Relation") {
			System.out.println(one.getName().toUpperCase()+" is not a connection of " +two.getName().toUpperCase());
		}
		return relation;
	}

	public static void addConnection(Profile primary, String name) throws NoProfileException {
		Profile secondary = profileCheck(name);
		int opt =0;
		do{
			opt = relationMenu();

			switch(opt) {
			case 1:
				try {
					primary.addFriend(secondary);
				}
				catch(NotToBeFriendsException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				try {
					primary.addParent(secondary);
				}
				catch(NoParentException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				try {
					primary.addChild(secondary);
				}
				catch(NotToBeChildException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					primary.addCouple(secondary);
				}
				catch(NotToBeCoupledException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				try {
					primary.addColleague(secondary);
				}
				catch(NotToBeColleaguesException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 6:
				try {
					primary.addClassmate(secondary);
				}
				catch(NotToBeClassmatesException e) {
					System.err.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Enter a Valid Option !");
				break;
			}
		}while (opt !=7);
	}

	// Getter
	public HashMap getList() {
		return list;
	}

	// Accessor
	public void setList(HashMap<Integer, Profile> list) {
		this.list = list;
	}

	public static int menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to SocioNet");
		System.out.println("-------Menu--------");
		System.out.println("1. Add Profile");
		System.out.println("2. Display Profile");
		System.out.println("3. Access Profile");
		System.out.println("4. Check Connection");
		System.out.println("5. Exit");
		return input.nextInt();
	}

	public static int submenu1(){
		Scanner input = new Scanner(System.in);
		System.out.println("------PROFILE MENU------");
		System.out.println("1. Update Profile");
		System.out.println("2. Delete Profile");
		System.out.println("3. Profile Details");
		System.out.println("4. Add Friend");
		System.out.println("9. Main Menu");
		return input.nextInt();
	}

	public static int submenu2(){
		Scanner input = new Scanner(System.in);
		System.out.println("------PROFILE MENU------");
		System.out.println("1. Update Profile");
		System.out.println("2. Delete Profile");
		System.out.println("3. Profile Details");
		System.out.println("4. Add Friend");
		System.out.println("5. Edit Dependent");
		System.out.println("9. Main Menu");
		return input.nextInt();
	}


	public static int uprofilemenu(){
		System.out.println("1. Update Name");
		System.out.println("2. Update Age");
		System.out.println("3. Update Status");
		System.out.println("4. Go To Previous Menu");
		return input.nextInt();
	}

	public static int relationMenu(){
		System.out.println("1. Friend");
		System.out.println("2. Parent");
		System.out.println("3. Child");
		System.out.println("4. Couple");
		System.out.println("5. Colleague");
		System.out.println("6. Classmate");
		System.out.println("7. Go To Previous Menu");
		return input.nextInt();
	}



}
