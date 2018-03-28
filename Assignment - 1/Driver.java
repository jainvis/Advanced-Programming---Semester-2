package Assignment1;
import java.util.*;

/**
 * Driver Class to store profile information
 * Execute all actions on a profile
 * @version 7.0 28 Mar 2018
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
				list.put(id, addProfile(list));
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
							list = Driver.deleteProfile(uid, list);
							break;
						case 3:
							Driver.profileDetails(list.get(uid));
							break;
						case 4:
							input.nextLine();
							System.out.println("Enter 'full name' of your Friend: ");
							String friend = input.nextLine().toLowerCase();
							int count = 0;
							for(int i : list.keySet()){
								if(list.get(i).getName().equals(friend)){
									Driver.addFriend(list.get(uid), list.get(i));
									count++;
								}
							}
							if (count == 0){System.out.println("Your Friend is not on SocioNet");}
							else{System.out.println("Your Friend is added to your friendlist");}
							break;
						case 5:
							if(list.get(uid) instanceof Child){
								System.out.println("Current Dependents: \n"+Arrays.toString(((Child) list.get(uid)).getDependent()));
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
									((Child) list.get(uid)).setDependent(dep1.getName(),dep2.getName());
									((Adult) dep1).setChildlist(list.get(uid).getName());
									((Adult) dep2).setChildlist(list.get(uid).getName());
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


	public static Profile addProfile(HashMap<Integer, Profile> list){
		Profile person = null;
		System.out.println("Enter Full Name: (Ex: John Doe)");
		String name = input.nextLine();
		name = name.toLowerCase();
		System.out.println("Enter Age: ");
		int age = 0;
		try{ 
			age = input.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Enter a valid number for Age !");
		}
		input.nextLine();
		System.out.println("Add Status? (Y/N)");
		String status = " ";
		String opt = input.nextLine().toLowerCase();
		switch (opt){
		case "n":
			status = " ";
			break;
		case "y":
			System.out.println("Enter Status: ");
			status = input.nextLine().toLowerCase();
			break;
		default:
			System.out.println("Invalid Option! Status will be null");
			break;
		}

		if(age<16 && age>2){
			System.out.println("Enter Full Name of First Dependent: (Ex: John Doe)");
			String dependent1 = input.nextLine().toLowerCase();
			System.out.println("Enter Full Name of Second Dependent: (Ex: Jane Doe)");
			String dependent2 = input.nextLine().toLowerCase();
			Profile dep1 = profileCheck(dependent1);
			Profile dep2 = profileCheck(dependent2);
			boolean check3 = dependentCheck(new String[]{dep1.getName(),dep2.getName()});
			if (dep1 == null || dep2 == null || check3 == false){
				System.out.println("Dependents check Failed !");
			}
			else{
				person = new Child(name, age, status, new String[]{dependent1, dependent2});
				((Child) person).setDependent(dependent1, dependent2);
				((Adult) dep1).setChildlist(person.getName());
				((Adult) dep2).setChildlist(person.getName());
			}
		}
		else if(age>16){
			person = new Adult(name, age, status);
		}
		else{
			System.out.println("You are too young to join SocioNet !");
		}
		return person;

	}

	public static void displayProfile(Profile person){
		System.out.println("Name: "+person.getName().toUpperCase()+" ,Age: "+person.getAge()+" ,Status: "+person.getStatus().toUpperCase());
	}

	public static void profileDetails(Profile profile){
		if(profile instanceof Adult){
			System.out.println("Name: "+profile.getName().toUpperCase()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus().toUpperCase());
			System.out.println("Friend List: \n"+profile.getFriendlist());
			System.out.println("Children : \n"+((Adult) profile).getChildlist());
		}
		if(profile instanceof Child){
			System.out.println("Name: "+profile.getName().toUpperCase()+" ,Age: "+profile.getAge()+" ,Status: "+profile.getStatus().toUpperCase());
			System.out.println("Dependents: \n"+Arrays.toString(((Child) profile).getDependent()));
			System.out.println("Friend List: \n"+profile.getFriendlist());
		}
	}

	public static void updateProfile(Profile adult){
		int opt = 0;
		do{
			try{opt = uprofilemenu();
			} catch (InputMismatchException e) {
				System.err.println("Enter a valid number to choose !");
			}
			switch (opt){
			case 1:
				System.out.println("Enter new Name");
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
				adult.setAge(nage);
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

	public static HashMap<Integer, Profile> deleteProfile(int id, HashMap<Integer, Profile> plist){
		System.out.println("Are you Sure? (Y/N)");
		String choice = input.nextLine();
		switch (choice){
		case "Y":
			plist.remove(id);
			break;
		case "N":
			break;
		default:
			System.out.println("Choose a valid Option !");
			break;
		}
		return plist;
	}

	public static void addFriend(Profile profile, Profile friend){
		if(profile instanceof Child && profile.getAge() - friend.getAge() < 4 && friend instanceof Child){
			profile.setFriend(friend.getName());
			friend.setFriend(profile.getName());
		}
		
		else if(profile instanceof Adult && friend instanceof Adult){
			profile.setFriend(friend.getName());
			friend.setFriend(profile.getName());
		}
		else{
			System.out.println(friend.getName()+" and "+profile.getName()+" both are not adults");
		}
	}

	public static boolean dependentCheck(String[] name){
		boolean check = false;
		int count1 = 0;
		int count2 = 0;
		String n1 = name[0];
		String n2 = name[1];
		for(int i : list.keySet()){
			if(list.get(i) instanceof Child){
				if(Arrays.asList(((Child) list.get(i)).getDependent()).contains(n1)){
					count1++;
				}
				if(Arrays.asList(((Child) list.get(i)).getDependent()).contains(n2)){
					count2++;
				}
				if(count1 != count2){
					check = false;
					break;
				}
				else
					check=true;
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

	public static void connectionCheck(String n1, String n2){
		//check connection method
		Profile one = profileCheck(n1);
		Profile two = profileCheck(n2);
		if((one instanceof Adult && two instanceof Child)){
			if(Arrays.asList(((Child) two).getDependent()).contains(one.getName())==true){
				System.out.println(two.getName().toUpperCase()+" is a child of "+one.getName().toUpperCase());
			}
		}
		else if((two instanceof Adult && one instanceof Child)){
			if(Arrays.asList(((Child) one).getDependent()).contains(two.getName())==true){
				System.out.println(one.getName().toUpperCase()+" is a child of "+two.getName().toUpperCase());
			}
		}
		else if(one instanceof Adult && two instanceof Adult){
			if(one.getFriendlist().contains(two.getName())==true || two.getFriendlist().contains(one.getName())==true){
				System.out.println(one.getName().toUpperCase()+" is a friend of " +two.getName().toUpperCase());
			}
		}
		else
			System.out.println(one.getName().toUpperCase()+" is not a connection of " +two.getName().toUpperCase());
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



}
