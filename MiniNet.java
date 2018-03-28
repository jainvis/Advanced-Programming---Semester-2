// Author: Vishesh Jain
// Student ID: S3666202

package Assignment1;
import java.util.*;
public class MiniNet implements Data {

	public static void main(String[] args) {

		HashMap<Integer, Profile> list = new HashMap<Integer, Profile>();
		list.putAll(inbuilt);
		Driver.manageNetwork(list);
//
//		Random randomGenerator = new Random();
//		int id = 0;
//		int opt = 0;
//		do{
//			Scanner input = new Scanner(System.in);
//			try{opt = menu();
//			} catch (InputMismatchException e) {
//				System.err.println("Enter a valid number to choose !");
//			}
//			switch (opt){
//			case 1:
//				do{
//					id = randomGenerator.nextInt(9999); //Unique ID is required to be generated
//				}while(list.containsKey(id));
//				list.put(id, Driver.addProfile(list));
//				if(list.get(id) != null){ 
//					System.out.println("Your Profile is added with Unique ID: "+id);
//					System.out.println("Remember this unique ID to access profile in future\n");
//				}
//				else{
//					System.err.println("Your Profile was not Added !");
//				}
//				break;
//
//			case 2:
//				System.out.println("Enter name of the person");
//				String search = input.nextLine();
//				Profile person = Driver.profileCheck(list, search);
//				if(person != null){
////					System.out.println("Name: "+person.getName().toUpperCase()+" ,Age: "+person.getAge()+" ,Status: "+person.getStatus().toUpperCase());
//					Driver.displayProfile(person);
//					}
//				else{
//					System.err.println("Your Connection is not on SocioNet");
//				}
//				break;
//
//			case 3:
//				System.out.println("Enter Your Unique ID to Access: ");
//				int uid = input.nextInt();
//				if(list.get(uid) != null){
//					int subopt = 0;	
//					do{
//						try{ if(list.get(uid) instanceof Adult){
//							subopt = submenu1();}
//						else if(list.get(uid) instanceof Child){
//							subopt = submenu2();
//						}
//						} catch (InputMismatchException e) {
//							System.err.println("Enter a valid number to choose !");
//						}
//						switch (subopt){
//						case 1:
//							Driver.updateProfile(list.get(uid));
//							break;
//						case 2:
//							Driver.deleteProfile(list.get(uid));
//							break;
//						case 3:
//							Driver.profileDetails(list.get(uid));
//							break;
//						case 4:
//							input.nextLine();
//							System.out.println("Enter 'full name' of your Friend: ");
//							String friend = input.nextLine().toLowerCase();
//							int count = 0;
//							for(int i : list.keySet()){
//								if(list.get(i).getName().equals(friend)){
//									Driver.addFriend(list.get(uid), list.get(i));
//									count++;
//								}
//							}
//							if (count == 0){System.out.println("Your Friend is not on SocioNet");}
//							else{System.out.println("Your Friend is added to your friendlist");}
//							break;
//						case 5:
//							if(list.get(uid) instanceof Child){
//								System.out.println("Current Dependents: \n"+Arrays.toString(((Child) list.get(uid)).getDependent()));
//								input.nextLine();
//								System.out.println("Enter full name of first dependent: ");
//								String d1 = input.nextLine().toLowerCase();
//								System.out.println("Enter full name of second dependent: ");
//								String d2 = input.nextLine().toLowerCase();
//								Profile dep1 = Driver.profileCheck(list, d1); //To check if the dependent is on SocioNet
//								Profile dep2 = Driver.profileCheck(list, d2);
//								boolean check3 = Driver.dependentCheck(list,new String[]{dep1.getName(),dep2.getName()}); 
//								if (dep1 == null || dep2 == null || check3 == false){
//									System.out.println("Dependents check Failed !");
//									System.err.println("Dependents Not Changed !");
//									break;
//								}
//								else{
//									((Child) list.get(uid)).setDependent(dep1.getName(),dep2.getName());
//									((Adult) dep1).setChildlist(list.get(uid).getName());
//									((Adult) dep2).setChildlist(list.get(uid).getName());
//									System.out.println("Dependents Updated !");
//									System.out.println("Also, you are added to your parents' list as a Child !");
//								}
//							}
//							break;
//						default:
//							System.out.println("Please select valid option !");
//							break;
//						}
//					}while (subopt!=5);
//				}
//				break;
//			case 4:
//				System.out.println("Enter name of the first Person");
//				String n1 = input.nextLine().toLowerCase();
//				System.out.println("Enter name of the second Person");
//				String n2 = input.nextLine().toLowerCase();
//				Driver.connectionCheck(list,n1,n2);
//				break;
//			case 5:
//				break;
//			default:
//				System.err.println("Choose a valid option!");
//				break;
//			}
//
//		}while(opt!=5);
//
//	}
//
//	public static int menu(){
//		Scanner input = new Scanner(System.in);
//		System.out.println("Welcome to SocioNet");
//		System.out.println("-------Menu--------");
//		System.out.println("1. Add Profile");
//		System.out.println("2. Display Profile");
//		System.out.println("3. Access Profile");
//		System.out.println("4. Check Connection");
//		System.out.println("5. Exit");
//		return input.nextInt();
//	}
//
//	public static int submenu1(){
//		Scanner input = new Scanner(System.in);
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
}
}

