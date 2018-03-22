package Assignment1;
import java.util.*;
public class MiniNet {

	public static void main(String[] args) {

		HashMap<Integer, Profile> list = new HashMap<Integer, Profile>();
		inbuiltData(list); //In built data for the program
		Random randomGenerator = new Random();
		int id = 0;
		int opt = 0;
		do{
			Scanner input = new Scanner(System.in);
			opt = menu();
			switch (opt){
			case 1:
				do{
					id = randomGenerator.nextInt(9999); //Unique ID is required to be generated
				}while(list.containsKey(id));
				list.put(id, Driver.addProfile());
				if(list.get(id) instanceof Child){
					String[] d = ((Child) list.get(id)).getDependent();
					String d1 = d[0];
					String d2 = d[1];
					Profile dep1 = profileCheck(list, d1); //To check if the dependent is on SocioNet
					Profile dep2 = profileCheck(list, d2);
					boolean check3 = dependentCheck(list,d); //Check: The Dependent is not added in another dependent list
					if (dep1 == null || dep2 == null || check3 == false){
						list.remove(id);
						System.out.println("Either one or both of your Dependents do not exist on SocioNet");
						System.out.println("Your Profile was not added !!");
					}
					break;
				}
				else{
					System.out.println("Your Profile is added with Unique ID: "+id);
					System.out.println("Remember this unique ID to access profile in future\n");
				}
				break;

			case 2:
				System.out.println("Enter name of the person");
				String search = input.nextLine();
				Profile person = profileCheck(list, search);
				if(person != null){
					Driver.displayProfile(person, search);}
				else{
					System.out.println("Your Connection is not on SocioNet");
				}
				break;

			case 3:
				System.out.println("Enter Your Unique ID to Access");
				int uid = input.nextInt();
				if(list.get(uid) != null){
					int subopt = 0;
					do{
						subopt = submenu1();
						switch (subopt){
						case 1:
							Driver.updateProfile(list.get(uid));
							break;
						case 2:
							Driver.deleteProfile(list.get(uid));
							break;
						case 3:
							Driver.profileDetails(list.get(uid));
							break;
						case 4:
							input.nextLine();
							System.out.println("Enter 'full name' of your Friend: ");
							String friend = input.nextLine();
							for(int i : list.keySet()){
								if(list.get(i).getName().equals(friend)){
									Driver.addFriend(list.get(uid), list.get(i));
								}
								else{System.out.println("Your Friend is not on SocioNet");}
							}
							break;
						}
						break;

					}while (subopt!=4);
					break;
				}
			case 4:
				break;
			}

		}while(opt!=4);

	}

	public static Profile profileCheck(HashMap<Integer, Profile> list, String name){
		Profile person = null;
		for(int i : list.keySet()){
			if(list.get(i).getName().contains(name) == true){
				person = list.get(i);
			}
		}
		return person;
	}
	
	public static boolean dependentCheck(HashMap<Integer, Profile> list, String[] name){
		boolean check = false;
		for(int i : list.keySet()){
			if(list.get(i) instanceof Child){
			if(((Child)list.get(i)).getDependent().equals(name)){
				check = true;
			}
			else{System.out.println("Your Dependents exists in another profile !");}
		}
		}
		return check;
	}

	public static int menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to SocioNet");
		System.out.println("-------Menu--------");
		System.out.println("1. Add Profile");
		System.out.println("2. Display Profile");
		System.out.println("3. Access Profile");
		System.out.println("4. Exit");
		return input.nextInt();
	}

	public static int submenu1(){
		Scanner input = new Scanner(System.in);
		System.out.println("------PROFILE MENU------");
		System.out.println("1. Update Profile");
		System.out.println("2. Delete Profile");
		System.out.println("3. Profile Details");
		System.out.println("4. Add Friend");
		return input.nextInt();
	}
	
	public static void inbuiltData(HashMap<Integer, Profile> data){
		data.put(1001, new Adult("John Nash",30,"Mathematician"));
		data.put(1002, new Adult("Eleanor Stier",30,"Nurse"));
		data.put(1003, new Child("John David Stier", 10, new String[]{"John Nash","Eleanor Stier"}));
		data.put(1004, new Adult("Alan Turing",42, "Computer Scientist"));
		data.put(1005, new Adult("Joan Clarke",37,"Cryptanalyst"));
		data.put(1006, new Adult("Paul Jobs",44, "United States Coastguard"));
		data.put(1007, new Adult("Clara Hagopian",42,"Armenian"));
		data.put(1008, new Child("Steve Jobs", 13, new String[]{"Paul Jobs","Clara Hagopian"}));			
	}

}

