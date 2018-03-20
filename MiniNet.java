package Assignment1;
import java.util.*;
public class MiniNet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Profile> list = new HashMap<Integer, Profile>();
		Random randomGenerator = new Random();
		int id = 0;
		int opt = 0;
		do{
			Scanner input = new Scanner(System.in);
			opt = menu();
			switch (opt){
			case 1:
				do{
					id = randomGenerator.nextInt(9999); //Unique ID are required to be generated
				}while(list.containsKey(id));
				list.put(id, Driver.addProfile());
				System.out.println("Your Profile is added with Unique ID: "+id);
				System.out.println("Remember this unique ID to access profile in future\n");
				break;

			case 2:
				System.out.println("Enter name of the person");
				String search = input.nextLine();
				for(int i : list.keySet()){
					if(list.get(i).getName().contains(search)){
						Driver.displayProfile(search);}
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
								int subopt2 = submenu2();
								System.out.println("Enter full name of your Friend: ");
								String friend = input.nextLine();
									for(int i : list.keySet()){
										if(list.get(i).getName().equals(friend)){
											Driver.addFriend(list.get(uid), list.get(i));
										}
										else{System.out.println("Your Friend is not on SocioNet");}
									}
								}
								break;
								
					}while (subopt!=4);
					break;
				}
			case 4:
				
			}

		}while(opt!=5);

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
		System.out.println("3. Add Friend");
		return input.nextInt();
	}

	public static int submenu2(){
		Scanner input = new Scanner(System.in);
		System.out.println("------PROFILE MENU------");
		System.out.println("1. Update Profile");
		System.out.println("2. Delete Profile");
		System.out.println("3. Add Friend");
		System.out.println("4. Add Dependent");
		return input.nextInt();
	}
}

