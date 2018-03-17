package Assignment1;
import java.util.*;
public class MiniNet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Profile list[] = new Profile[10];
		int opt = 0;
		do{
			Scanner input = new Scanner(System.in);
			opt = menu();
			switch (opt){
			case 1:			
				for(int i=0;i < list.length; i++){
					if(list[i]==null){
						list[i] = Driver.addProfile();
						break;
					}
				}
				break;

			case 2:
				int count = 0;
				System.out.println("Enter name of the person");
				String search = input.nextLine();
				for(int i=0; i<list.length;i++){
					count = Driver.displayProfile(search, list[i]);
					if(count>0){
						int subopt = 0;
						do{
							subopt = submenu1();
							switch (subopt){
							case 1:
								Driver.updateProfile(list[i]);
								break;
							case 2:
								Driver.deleteProfile(list[i]);
								break;
							case 3:
								if(list[i] instanceof Child){
									int subopt2 = submenu2();
									System.out.println("Enter name of your Friend: ");
									String friend = input.nextLine();
									if(Arrays.asList(list).contains(friend)){
										list[i].setFriend(friend);
									}
									else{System.out.println("Your Friend is not on SocioNet");}
								}
								break;
							}
						}while (subopt!=4);
					}
				}

				if(count==0){System.out.println("No Profile Found");}
				break;
			}
		}while(opt!=5);

	}

	public static int menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to SocioNet");
		System.out.println("-------Menu--------");
		System.out.println("1. Add Profile");
		System.out.println("2. Display Profile");
		System.out.println("3. Exit");
		return input.nextInt();
	}

	public static int submenu1(){
		Scanner input = new Scanner(System.in);
		System.out.println("------PROFILE MENU------");
		System.out.println("1. Update Profile");
		System.out.println("2. Delete Profile");
		System.out.println("3. Add Connection");
		return input.nextInt();
	}

	public static int submenu2(){
		Scanner input = new Scanner(System.in);
		System.out.println("------CONNECTION MENU------");
		System.out.println("1. Add Friend");
		System.out.println("2. Add Dependent");
		System.out.println("3. Previous Menu");
		return input.nextInt();
	}
}

