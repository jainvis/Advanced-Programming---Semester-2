package assignment;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Database class to get data from Text File or Database
 * Method to read people.txt written by Natalie Sy
 * Modification to the same method done by Vishesh Jain
 * Other methods for DB Connection, relationData() by Vishesh Jain
 * getData() method and handling in Driver Class done by Vishesh Jain
 * @version 2.0 21 May 2018
 * @author Vishesh Jain, Natalie Sy
 */

public abstract class Database {

	private static HashMap<Integer, Profile> list = new HashMap<Integer, Profile>();
	
	public static HashMap<Integer, Profile> getData() throws IOException{
		
		int count=0;
		try {
			peopleData();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			count++;
		}
		
		try {
			relationData();
		} catch (NotToBeFriendsException | NoParentException | NotToBeChildException | NoAvailableException
				| NotToBeColleaguesException | NotToBeClassmatesException |  IOException e) {
			System.err.println(e.getMessage());
			count++;
		}
		
		if(count!=0) {
			connectDatabase();
			createData();
			insertData();
			viewData();
		}
		
		return list;
	}

	public static void peopleData() throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader("people.txt"));

			int id = 0;
			String name = "";
			int age = 0;
			String status = "";
			String[] lineSplit;
			Profile person = null;

			String line = br.readLine();

			while (line != null) {
				lineSplit = line.split(",");

				id = Integer.parseInt(lineSplit[0]);
				name = lineSplit[1];
				age = Integer.parseInt(lineSplit[2]);
				status = lineSplit[3];
								
				/**
				 * Modified by Vishesh Jain
				 */
				if(age>16) {
				
				person = new Adult(name, age, status);
				}
				else if(age<16 && age>2) {
					person = new Child(name,age,status, new ArrayList<String>());
				}
				else if(age<2 && age>0) {
					person = new YoungChild(name,age,status,new ArrayList<String>());
				}
				
				/**
				 * Modification End
				 */
				
				list.put(id, person);

				System.out.println(" Id: "+id+ " Name: " +name + " Age: " +age + " Status: " +status);
				line = br.readLine();
			}
			br.close();
		}
		catch(FileNotFoundException e) {
			System.err.println("File is missgin from Compilation Folder !");
		}
	}
	
	/**
	 * All below methods created by Vishesh Jain
	 */

	public static void relationData() throws NotToBeFriendsException, NoParentException, NotToBeChildException, NoAvailableException, NotToBeColleaguesException, NotToBeClassmatesException, IOException {

		BufferedReader br = new BufferedReader(new FileReader("relation.txt"));

		String name = "";
		String[] lineSplit;
		String name2 = "";
		String relation = "";
		Profile person1 = null;
		Profile person2 = null;

		String line = br.readLine();

		while (line != null) {
			lineSplit = line.split(",");

			name = lineSplit[0].toLowerCase();
			name2 = lineSplit[1].toLowerCase();
			relation = lineSplit[2].toLowerCase();

			for(int i: list.keySet()) {
				if((list.get(i).getName().contains(name))){
					person1 = list.get(i);
				}
				if((list.get(i).getName().contains(name2))) {
					person2 = list.get(i);
				}
			}

			switch(relation) {
			case "friend":
				try {
					person1.addFriend(person2);
					System.out.println(person2.getName()+" added as a Friend");
					person2.addFriend(person1);
				}
				catch(NotToBeFriendsException e) {
					System.err.println(e.getMessage());
					throw new NotToBeFriendsException(e.getMessage());
				}
				break;
			case "parent":
				try {
					person1.addParent(person2);
					System.out.println(person2.getName()+" added as a Parent");
					person2.addChild(person1);
				}
				catch(NoParentException e) {
					System.err.println(e.getMessage());
					throw new NoParentException(e.getMessage());
				}
				break;
			case "child":
				try {
					person1.addChild(person2);
					System.out.println(person2.getName()+" added as a Child");
					person2.addParent(person1);
				}
				catch(NotToBeChildException e) {
					System.err.println(e.getMessage());
					throw new NotToBeChildException(e.getMessage());
				}
				break;
			case "couple":
				try {
					person1.addCouple(person2);
					System.out.println(person2.getName()+" added as a Spouse");
					person2.addCouple(person1);
				}
				catch(NoAvailableException e) {
					System.err.println(e.getMessage());
					throw new NoAvailableException(e.getMessage());
				}
				break;

			case "colleague":
				try {
					person1.addColleague(person2);
					System.out.println(person2.getName()+" added as a Colleague");
					person2.addColleague(person1);
				}
				catch(NotToBeColleaguesException e) {
					System.err.println(e.getMessage());
					throw new NotToBeColleaguesException(e.getMessage());
				}
				break;
			case "classmate":
				try {
					person1.addClassmate(person2);
					System.out.println(person2.getName()+" added as a Classmate");
					person2.addClassmate(person1);
				}
				catch(NotToBeClassmatesException e) {
					System.err.println(e.getMessage());
					throw new NotToBeClassmatesException(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid Relation Found !");
				break;
			}
			
			System.out.println("Name: "+name+" Second Name: "+name2+" Relation: "+relation);

			line = br.readLine();
		}
		br.close();		
	}
	
	public static void connectDatabase() {
		Connection con = null;
		try {
			//Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");

			if (con!= null){
				System.out.println("Connection created successfully");
			}else{
				System.out.println("Problem with creating connection");
			}

		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void createData() {
		connectDatabase();
		Connection con = null;
		Statement stmt = null;
		int result1 = 0;
		int result2 = 0;

		try {
			//Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			stmt = con.createStatement();
				result1 = stmt.executeUpdate("CREATE TABLE MiniNet_people "
						+ "(id INT NOT NULL, name VARCHAR(50) NOT NULL,age INT NOT NULL, "
						+ "status VARCHAR(50) NOT NULL,PRIMARY KEY (id));");
				
				result2 = stmt.executeUpdate("CREATE TABLE MiniNet_relation "
						+ "(name VARCHAR(50) NOT NULL,name2 VARCHAR(50) NOT NULL, "
						+ "relation VARCHAR(50) NOT NULL,PRIMARY KEY (name,name2,relation));");

		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void insertData() {
		Connection con = null;
		createData();
		Statement stmt = null;
        int result1 = 0;
        int result2 = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result1 = stmt.executeUpdate("INSERT INTO MiniNet_people VALUES "
            		+ "(1001,'john nash',30,'Mathematician'),"
            		+ "(1002,'eleanor stier',30,'Nurse'),"
            		+ "(1003,'david stier',10,' '),"
            		+ "(1004,'alan turing',42,'Computer Scientist'),"
            		+ "(1005,'joan clarke',37,'Cryptanalyst'),"
            		+ "(1006,'paul jobs',44,'United States Coastguard'),"
            		+ "(1007,'clara hagopian',42,'Armenian'),"
            		+ "(1008,'steve jobs',13,'Future Innovator')");
            
            result2 = stmt.executeUpdate("INSERT INTO MiniNet_relation VALUES "
            		+ "('david stier','john nash','parent'),"
            		+ "('david stier','eleanor stier','parent'),"
            		+ "('john nash','eleanor stier','couple'),"
            		+ "('alan turing','joan clarke','couple'),"
            		+ "('alan turing','john nash','colleague'),"
            		+ "('paul jobs','clara hagopian','couple'),"
            		+ "('paul jobs','steve jobs','child'),"
            		+ "('steve jobs','clara hagopian','parent'),"
            		+ "('paul jobs','john nash','friend'),"
            		+ "('david stier','steve jobs','classmate')");
            con.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println(result1 + " rows effected");
        System.out.println("Rows inserted successfully");
    }
	
	public static void viewData() {
		Connection con = null;
	      Statement stmt = null;
	      ResultSet result1 = null;
	      ResultSet result2 = null;
	      String name=null;
	      int age = 0;
	      int id = 0;
	      String status=null;
	      String name2=null;
	      String name3 = null;
	      String relation=null;
	      
	      try {
	         Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         con = DriverManager.getConnection(
	            "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
	         stmt = con.createStatement();
	         result1 = stmt.executeQuery("SELECT * FROM MiniNet_people");
	         result1 = stmt.executeQuery("SELECT * FROM MiniNet_relation");
	         
	         while(result1.next()){
	        	 id = result1.getInt("id");
	        	 name = result1.getString("name");
	        	 age = result1.getInt("age");
	        	 status = result1.getString("status");
	        	 addPeopleData(id,name,age,status);
	         }
	         
	         while(result2.next()){
	        	 name2 = result2.getString("name");
	        	 name3 = result2.getString("name2");
	        	 relation = result2.getString("relation");
	        	 addRelationData(name2,name3,relation);
	         }
	      } catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	   }
	
	public static void addPeopleData(int id, String name, int age, String status) {

		Profile person = null;
		if(age>16) {
		
		person = new Adult(name, age, status);
		}
		else if(age<16 && age>2) {
			person = new Child(name,age,status, new ArrayList<String>());
		}
		else if(age<2 && age>0) {
			person = new YoungChild(name,age,status,new ArrayList<String>());
		}
		
		list.put(id, person);
	}
	
	public static void addRelationData(String name, String name2, String relation) throws NotToBeFriendsException, NoParentException, NotToBeChildException, NoAvailableException, NotToBeColleaguesException, NotToBeClassmatesException {
		
		Profile person1=null;
		Profile person2=null;
		for(int i: list.keySet()) {
			if((list.get(i).getName().contains(name))){
				person1 = list.get(i);
			}
			if((list.get(i).getName().contains(name2))) {
				person2 = list.get(i);
			}
		}

		switch(relation) {
		case "friend":
			try {
				person1.addFriend(person2);
				System.out.println(person2.getName()+" added as a Friend");
				person2.addFriend(person1);
			}
			catch(NotToBeFriendsException e) {
				System.err.println(e.getMessage());
				throw new NotToBeFriendsException(e.getMessage());
			}
			break;
		case "parent":
			try {
				person1.addParent(person2);
				System.out.println(person2.getName()+" added as a Parent");
				person2.addChild(person1);
			}
			catch(NoParentException e) {
				System.err.println(e.getMessage());
				throw new NoParentException(e.getMessage());
			}
			break;
		case "child":
			try {
				person1.addChild(person2);
				System.out.println(person2.getName()+" added as a Child");
				person2.addParent(person1);
			}
			catch(NotToBeChildException e) {
				System.err.println(e.getMessage());
				throw new NotToBeChildException(e.getMessage());
			}
			break;
		case "couple":
			try {
				person1.addCouple(person2);
				System.out.println(person2.getName()+" added as a Spouse");
				person2.addCouple(person1);
			}
			catch(NoAvailableException e) {
				System.err.println(e.getMessage());
				throw new NoAvailableException(e.getMessage());
			}
			break;

		case "colleague":
			try {
				person1.addColleague(person2);
				System.out.println(person2.getName()+" added as a Colleague");
				person2.addColleague(person1);
			}
			catch(NotToBeColleaguesException e) {
				System.err.println(e.getMessage());
				throw new NotToBeColleaguesException(e.getMessage());
			}
			break;
		case "classmate":
			try {
				person1.addClassmate(person2);
				System.out.println(person2.getName()+" added as a Classmate");
				person2.addClassmate(person1);
			}
			catch(NotToBeClassmatesException e) {
				System.err.println(e.getMessage());
				throw new NotToBeClassmatesException(e.getMessage());
			}
			break;
		default:
			System.out.println("Invalid Relation Found !");
			break;
		}
	}
	
}




