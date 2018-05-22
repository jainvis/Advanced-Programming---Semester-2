package assignment;

/**
 * Connection Class
 * To name and relation of a Profile in one ArrayList and use in GUI
 * @version 1.0 20 May 2018
 * @author Vishesh Jain
 */

public class Connections {

		String name;
		String relation;
		Connections(String name, String relation){
			this.name=name;
			this.relation=relation;
		}
		public String getName() {
			return name;
		}
		
		public String getRelation() {
			return relation;
		}

	}
