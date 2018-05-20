import java.io.*;
import java.util.HashMap;

public class Database {
	public static void main(String[] args) throws IOException {

		HashMap<Integer, Profile> list = new HashMap<Integer, Profile>();
		BufferedReader br = new BufferedReader(new FileReader("people.txt"));

		int id = 0;
		String name = "";
		int age = 0;
		String status = "";
		String[] lineSplit;
		Profile Adult = null;

		String line = br.readLine();

		while (line != null) {
			lineSplit = line.split(",");

			id = Integer.parseInt(lineSplit[0]);
			name = lineSplit[1];
			age = Integer.parseInt(lineSplit[2]);
			status = lineSplit[3];

			Adult = new Profile(name, age, status);
			list.put(id, Adult);
			
			System.out.println(" Id: "+id+ " Name: " +name + " Age: " +age + " Status: " +status);
			line = br.readLine();
		}
		br.close();		
	}
}
		/*
		BufferedReader br1 = new BufferedReader(new FileReader("relations.txt"));
		String name1 = "";
		String name2 = "";
		String relation = "";
		
		String line1 = br1.readLine();
		
		while (line1 != null) {
			lineSplit = line1.split(",");

			name1 = lineSplit[0];
			name2 = lineSplit[1];
			relation = lineSplit[2];

			System.out.println(" Name1: "+name1+ " Name2: " +name2 + " Relation: " +relation);

			line1 = br1.readLine();
		}
		br1.close();
		 */				
	
	

