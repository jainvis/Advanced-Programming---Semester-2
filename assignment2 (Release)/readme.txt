SocioNet - ReadMe

This code is developed in JAVA 10.0 - eclipse oxygen IDE

MiniNet.java is required to be run for GUI execution

Also, make sure .txt files are in the compilation folder

The code for Database connection is written but is required to be connected through the compilation unit
Also, connection for HSQLDB required a .jar file

The zip folder contains the following file
- people.txt: This contains data of profile, keep this file in the compilation folder
- relation.txt: This contatains data of relations between two profiles, also keep this file in the compilation folder
- .settings folder: This is required for successful compilation of code
- src folder: This contains package named assignment which contains the following classes
 
 - MiniNet: JAVAfx class, for GUI
 - Driver: This class perform actions for the GUI
 - Database: This class perform .txt file read and database connection
 - Profile: Super-class of three types of Profile
 - Adult: Sub-Class of Profile
 - Child: Sub-Class of Profile
 - YoungChild: Sub-Class of Profile
 - Exception Classes: MiniNetException is the super-class of customised exceptions and extends Exception
 	- NoAvailableException, NoParentException, NoProfileException, NoRelationException, NoSuchAgeException
	- NotToBeChildException, NotToBeClassmatesException, NotToBeColleaguesException, NotToBeCoupledException
	- NotToBeFriendsException, ProfileExistsException, TooYoungException
 - Interfaces: These are built to implement different relations in a profile
	- Friend, Parent, Couple, Colleague, Children, Classmate

Developers:

Vishesh Jain - 90% Contribution
 - Author of Driver, Profile, Adult, Child, YoungChild and Exception Classes
 - Developed and implemented interfaces for handling relations in each profile
 - Co-Author of Database Class: 
	- Modified the code for reading people.txt
	- Developed the code for reading relation.txt
	- Developed the code to get data to the Driver class
	- Developed code for database connection, create data, insert data and view data using HSQLDB
 - Co-Author of MiniNet (GUI)
	- Developed basic layout of GUI and passed for layout development to other developer
	- Modified the basic layout
		- Fixed the width of panes and button for better presentation
	- Developed code for binding Driver class with GUI
	- Inserted a table view to display details of relations of each Profile
	- Inserted a Combo-Box to select the type of relation while adding the same
	- Developed code for handling exceptions and message dialog box
 - Created readme.txt and design.pdf docs

Natalie Sy - 10% Contribution

 - Helped in the design of the new classes added in Assignment 2
 - Contributed codes to layout and design of GUI
 - Contributed codes to read data from people textfile and store in Hashmap 
 - Contributed codes to JUnit Testing 

