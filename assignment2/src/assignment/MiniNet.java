package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.*;

/**
 * MiniNet - JAVAfx 
 * GUI for the social networking application
 * @version 3.0 20 May 2018
 * @author Vishesh Jain, Natalie Sy
 * Structural Layout created by Vishesh Jain
 * Basic Layout extension by Natalie Sy
 * Layout enhancement and Binding done by Vishesh Jain
 * Comments added by Vishesh Jain
 */

public class MiniNet extends Application {

	public static void main(String[] args) {

		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		//------------------Welcome to SocioNet-------------------------------//
		GridPane pane = new GridPane();
		Alert alert = new Alert(AlertType.ERROR);
		Alert message = new Alert(AlertType.INFORMATION);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		pane.setMinSize(300, 300);

		// Place nodes in the pane
		Button btadd = new Button("Add Profile");
		Button btdisplay = new Button("Display Profile");
		Button btaccess = new Button("Access Profile");
		Button btcheckconn = new Button ("Check Connection");
		Button btexit = new Button("Exit");

		/**
		 * Layout Changes by Vishesh Jain 18.05.2018
		 */
		btadd.setMaxWidth(200);
		btdisplay.setMaxWidth(200);
		btaccess.setMaxWidth(200);
		btcheckconn.setMaxWidth(200);
		btexit.setMaxWidth(300);
		pane.add(new Label("WELCOME TO SOCIONET"),0,0);
		pane.add(btadd, 0, 2);
		pane.add(btdisplay, 0, 3);
		pane.add(btaccess, 0, 4);
		pane.add(btcheckconn, 0, 5);
		pane.add(btexit, 0, 7);

		/**
		 * End of Changes
		 */

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

		//------------------------ADD PROFILE ------------------------//
		
		btadd.setOnAction((ActionEvent add) -> {
			primaryStage.hide();
			Stage stageAddProfile = new Stage(); // Create a new stage
			stageAddProfile.setTitle("ADD PROFILE"); // Set the stage title
			// Set a scene with a button in the stage
			GridPane paneAP = new GridPane();
			paneAP.setAlignment(Pos.CENTER);
			paneAP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			paneAP.setHgap(5.5);
			paneAP.setVgap(5.5);
			paneAP.setMinSize(300, 300);
			Button saveAP = new Button("Save");
			saveAP.setMaxWidth(150);
			Button backAP = new Button("Back");
			backAP.setMaxWidth(150);

			// Place nodes in the pane
			paneAP.add(new Label("ADD PROFILE"),0,0);
			paneAP.add(new Label("Name"), 0, 1);
			TextField name = new TextField();
			paneAP.add(name, 1, 1);
			paneAP.add(new Label("Age"), 0, 2);
			TextField age = new TextField();
			paneAP.add(age, 1, 2);
			paneAP.add(new Label("Status"), 0, 3);
			TextField status = new TextField();
			paneAP.add(status, 1, 3);

			/**
			 * Layout Changes by Vishesh Jain 18.05.2018
			 */
			paneAP.add(new Label("Father's Name: "), 0, 4); 
			TextField parent1 = new TextField(); 
			paneAP.add(parent1, 1, 4); 
			paneAP.add(new Label("Mother's Name: "), 0, 5);
			TextField parent2 = new TextField();
			paneAP.add(parent2, 1, 5);
			/**
			 * End Changes - VJ
			 */

			paneAP.add(saveAP, 0, 7);
			paneAP.add(backAP, 1, 7);

			saveAP.setOnAction((ActionEvent save) -> {
				/**
				 * Add Profile Actions Added by Vishesh Jain 19.05.2018
				 */
				String nname = name.getText().toLowerCase();
				String nstatus = status.getText().toLowerCase();
				String nparent1 = parent1.getText().toLowerCase();
				String nparent2 = parent2.getText().toLowerCase();
				int nage = 0;
				try {
					nage = Integer.parseInt(age.getText());
				}
				catch (NumberFormatException e) {
					alert.setTitle("Age Exception");
					alert.setHeaderText("Age");
					alert.setContentText("Invalid Number");
					Label label = new Label(e.getMessage().toString());
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				}

				if(nage >16 && (nparent1.isEmpty() | nparent2.isEmpty())) {
					nparent1 = " ";
					nparent2 = " ";
				}

				try {
					int id = Driver.addProfile(nname, nage, nstatus, nparent1, nparent2);
					message.setTitle("Confirmed !");
					message.setHeaderText("PROFILE ID: "+id);
					message.setContentText("Profile Successfully Added !");
					Label label = new Label("Welcome to the world of SocioNet :)");
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Message into the dialog pane.
					message.getDialogPane().setExpandableContent(expContent);
					message.showAndWait();
				}
				catch(NoSuchAgeException e1) {
					alert.setTitle("Age Exception");
					alert.setHeaderText("Age");
					alert.setContentText("Invalid Number");
					Label label = new Label(e1.getMessage().toString());
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				}
				catch(NoParentException e2) {
					alert.setTitle("Parents Exception");
					alert.setHeaderText("Parents");
					alert.setContentText("Parents check failed");
					Label label = new Label(e2.getMessage().toString());
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				} catch (ProfileExistsException e3) {
					alert.setTitle("Duplicate Name !");
					alert.setHeaderText("Duplicate Profile Found");
					alert.setContentText("Profile with same name already exists !");
					Label label = new Label(e3.getMessage().toString());
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				}

			});

			/**
			 * End of Action Add Profile - VJ
			 */

			backAP.setOnAction((ActionEvent back) -> {
				stageAddProfile.close();
				primaryStage.show();
			});


			Scene sceneAddProfile = new Scene(paneAP);
			stageAddProfile.setScene(sceneAddProfile);
			stageAddProfile.show();
		});

		//-------------------------End Of Add Profile-----------------------------//

		//-------------------------DISPLAY PROFILE--------------------------------//
		btdisplay.setOnAction((ActionEvent display) -> {
			primaryStage.hide();

			Stage stageDisplay = new Stage(); // Create a new stage
			stageDisplay.setTitle("DISPLAY PROFILE"); 

			GridPane paneACP = new GridPane(); // New Pane
			paneACP.setAlignment(Pos.CENTER);
			paneACP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			paneACP.setMinSize(300, 300);
			paneACP.setHgap(5.5);
			paneACP.setVgap(5.5);
			Button okDP = new Button("Ok");
			okDP.setMaxWidth(150);
			Button backDP = new Button("Back");
			backDP.setMaxWidth(150);
			TextField name = new TextField();

			// Place nodes in the pane

			paneACP.add(new Label("Name"), 0, 1);
			paneACP.add(name, 1, 1);
			paneACP.add(okDP, 0, 5);
			paneACP.add(backDP, 1, 5);

			okDP.setOnAction((ActionEvent confirm) -> {

				/**
				 * Display Profile Action Added by Vishesh Jain 19.05.2018
				 */
				String search = name.getText();

				// Error Box if Field is Empty
				if (search.isEmpty()) {
					alert.setTitle("Blank Field !");
					alert.setHeaderText("Empty Field");
					alert.setContentText("Empty Field !");
					Label label = new Label("Field Cannot be Blank !");
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				}

				else {

					Profile person = Driver.profileCheck(search);
					Driver.displayProfile(person);

					// Label for Age if name is given
					paneACP.add(new Label("Age: "), 0, 2);
					paneACP.add(new Label(Integer.toString(person.getAge())), 1, 2);

					// Label for Status if name is given
					paneACP.add(new Label("Status: "), 0, 3);
					paneACP.add(new Label(person.getStatus()), 1, 3);	
				}

			});
			/**
			 * End of Display Profile Actions - VJ
			 */

			backDP.setOnAction((ActionEvent back) -> {
				stageDisplay.close();
				primaryStage.show();
			});

			Scene sceneDisplay = new Scene(paneACP);
			stageDisplay.setScene(sceneDisplay);
			stageDisplay.show();	

		});

		//---------------------End Of Display Profile-------------------------//

		//---------------------ACCESS PROFILE--------------------------------//
		
		btaccess.setOnAction((ActionEvent access) -> {
			primaryStage.hide();

			Stage stageAccess = new Stage(); // Create a new stage
			stageAccess.setTitle("ACCESSS PROFILE"); 

			GridPane paneDP = new GridPane(); // Create a new Pane
			paneDP.setAlignment(Pos.CENTER);
			paneDP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			paneDP.setHgap(5.5);
			paneDP.setVgap(5.5);
			paneDP.setMinSize(300, 300);
			Button okDP = new Button("Ok");
			okDP.setMaxWidth(150);
			Button backDP = new Button("Back");
			backDP.setMaxWidth(150);
			TextField id = new TextField();

			// Place nodes in the pane
			paneDP.add(new Label("ID"), 0, 1);
			paneDP.add(id, 1, 1);
			paneDP.add(okDP, 0, 2);
			paneDP.add(backDP, 1, 2);

			okDP.setOnAction((ActionEvent confirm) -> {
				/**
				 * Access Profile Actions Added by Vishesh Jain on 19.05.2018
				 */
				// Access Profile Menu
				String accessID = id.getText();
				Profile accessProfile = null;

				// If Field is Empty on Confirmation
				if(accessID.isEmpty()) {
					alert.setTitle("Blank Field !");
					alert.setHeaderText("Empty Field");
					alert.setContentText("Empty Field !");
					Label label = new Label("Field Cannot be Blank !");
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				}

				else {
					int aid = 0;
					try {
						aid = Integer.parseInt(accessID);
					}
					catch (NumberFormatException e) {
						alert.setTitle("ID Exception");
						alert.setHeaderText("ID");
						alert.setContentText("Invalid Number");
						Label label = new Label(e.getMessage().toString());
						GridPane expContent = new GridPane();
						expContent.setMaxWidth(Double.MAX_VALUE);
						expContent.add(label, 0, 0);
						// Set expandable Exception into the dialog pane.
						alert.getDialogPane().setExpandableContent(expContent);
						alert.showAndWait();

					}

					// Checking ID Validity
					try {
						accessProfile = Driver.checkID(aid);
					}
					catch(NoAvailableException e) {
						alert.setTitle("ID Exception");
						alert.setHeaderText("ID");
						alert.setContentText("Invalid ID");
						Label label = new Label(e.getMessage().toString());
						GridPane expContent = new GridPane();
						expContent.setMaxWidth(Double.MAX_VALUE);
						expContent.add(label, 0, 0);
						// Set expandable Exception into the dialog pane.
						alert.getDialogPane().setExpandableContent(expContent);
						alert.showAndWait();
					}

					// Need to figure out a way to stay on same stage if exception is caught
					if (accessProfile!=null) {
						int updateID = aid;
						String accessName = accessProfile.getName();
						String accessAge = Integer.toString(accessProfile.getAge());
						String accessStatus = accessProfile.getStatus();
						final Profile allAccess = accessProfile;
						stageAccess.close();
						Stage stageAccess1 = new Stage(); // Create a new stage
						stageAccess1.setTitle("Profile Access Menu"); 

						// Set a scene with a button in the stage
						GridPane paneACP = new GridPane();
						paneACP.setAlignment(Pos.CENTER);
						paneACP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
						paneACP.setHgap(5.5);
						paneACP.setVgap(5.5);
						paneACP.setMinSize(300, 300); // Added by VJ : 18052018
						Button update = new Button("Update Profile");
						Button delete = new Button("Delete Profile");
						Button details = new Button("Profile Details");
						Button relation = new Button("Add Relation");
						Button backACP = new Button("Back");

						/**
						 * Layout Modification by Vishesh Jain on 18.05.2018
						 */
						update.setMaxWidth(200);
						delete.setMaxWidth(200);
						details.setMaxWidth(200);
						relation.setMaxWidth(200);
						backACP.setMaxWidth(300);
						/**
						 * End of Layout Changes
						 */

						// Buttons for Profile Menu added to the Pane
						paneACP.add(new Label("PROFILE ACCESS MENU"),0,0);
						paneACP.add(update, 0, 1);
						paneACP.add(delete, 0, 2);
						paneACP.add(details, 0, 3);
						paneACP.add(relation, 0, 4);			
						paneACP.add(backACP, 0, 5);

						//--------------UPDATE PROFILE----------------------//
						
						update.setOnAction((ActionEvent uProfile) -> {
							
							stageAccess1.close();
							
							Stage stageUpdate = new Stage(); // Create a new stage
							stageUpdate.setTitle("UPDATE PROFILE");
							// Set a scene with a button in the stage
							GridPane paneUP = new GridPane();
							paneUP.setAlignment(Pos.CENTER);
							paneUP.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
							paneUP.setHgap(5.5);
							paneUP.setVgap(5.5);
							
							/**
							 * Layout Changes by Vishesh Jain on 18.05.2018
							 */
							paneUP.setMinSize(300, 300);
							TextField nameUP = new TextField(accessName.toUpperCase());
							TextField ageUP = new TextField(accessAge);
							TextField statusUP = new TextField(accessStatus.toUpperCase());
							Button saveUP = new Button("Save");
							Button backUP = new Button("Back");
							saveUP.setMaxWidth(150);
							backUP.setMaxWidth(150);
							nameUP.setMaxWidth(200);
							ageUP.setMaxWidth(200);
							statusUP.setMaxWidth(200);
							/**
							 * End of Layout Changes
							 */

							// Place nodes in the pane
							paneUP.add(new Label("Name"), 0, 1);
							paneUP.add(nameUP, 1, 1);
							paneUP.add(new Label("Age"), 0, 2);
							paneUP.add(ageUP, 1, 2);
							paneUP.add(new Label("Status"), 0, 3);
							paneUP.add(statusUP, 1, 3);
							paneUP.add(saveUP, 0, 4);
							paneUP.add(backUP, 1, 4);

							saveUP.setOnAction((ActionEvent save) -> {
								/**
								 * Update Profile Action added by Vishesh Jain on 18.05.2018
								 */
								String updateName = nameUP.getText();
								int updateAge = 0;
								try {
									updateAge = Integer.parseInt(ageUP.getText());
								}
								catch(NumberFormatException e) {
									alert.setTitle("Format Error");
									alert.setHeaderText("Age");
									alert.setContentText("Invalid Age");
									Label label = new Label(e.getMessage().toString());
									GridPane expContent = new GridPane();
									expContent.setMaxWidth(Double.MAX_VALUE);
									expContent.add(label, 0, 0);
									// Set expandable Exception into the dialog pane.
									alert.getDialogPane().setExpandableContent(expContent);
									alert.showAndWait();
								}
								String updateStatus = statusUP.getText();

								try {
									Driver.updateProfile(updateID, updateName, updateAge, updateStatus);
									message.setTitle("Update !");
									message.setHeaderText("Update Information !");
									message.setContentText("ID: "+updateID+" Update Successfull !");
									Label label = new Label("Fields have been updated !");
									GridPane expContent = new GridPane();
									expContent.setMaxWidth(Double.MAX_VALUE);
									expContent.add(label, 0, 0);
									// Set expandable Exception into the dialog pane.
									message.getDialogPane().setExpandableContent(expContent);
									message.showAndWait();
								} catch (NoSuchAgeException e) {
									alert.setTitle("ID Exception");
									alert.setHeaderText("ID");
									alert.setContentText("Invalid ID");
									Label label = new Label(e.getMessage().toString());
									GridPane expContent = new GridPane();
									expContent.setMaxWidth(Double.MAX_VALUE);
									expContent.add(label, 0, 0);
									// Set expandable Exception into the dialog pane.
									alert.getDialogPane().setExpandableContent(expContent);
									alert.showAndWait();
								}
							});
							
							/**
							 * End of Update Profile Actions - VJ
							 */

							backUP.setOnAction((ActionEvent back) -> {
								stageUpdate.close();
								stageAccess1.show();
							});

							Scene sceneUpdate = new Scene(paneUP);
							stageUpdate.setScene(sceneUpdate);
							stageUpdate.show();

						});

						//-----------End of Update Profile------------//

						//-----------Delete Profile-------------------//
						delete.setOnAction((ActionEvent deProfile) -> {
							/**
							 * Delete Profile Action added by Vishesh Jain on 18.05.2018
							 */
							Alert confAlert = new Alert(AlertType.CONFIRMATION);
							confAlert.setTitle("Sure !");
							confAlert.setHeaderText("Think Again !");
							confAlert.setContentText("Sure to Leave this World?");
							Optional<ButtonType> result = confAlert.showAndWait();

							if(result.isPresent() && result.get()==ButtonType.OK) {
								try {
									Driver.deleteProfile(updateID);
									message.setTitle("Good Bye !");
									message.setHeaderText("You have left SocioNet");
									message.setContentText("Hope to see you AGAIN !");
									Label label = new Label("Profile Deleted !");
									GridPane expContent = new GridPane();
									expContent.setMaxWidth(Double.MAX_VALUE);
									expContent.add(label, 0, 0);

									message.getDialogPane().setExpandableContent(expContent);
									message.showAndWait();

									stageAccess.close();
									primaryStage.show();

								} catch (NoParentException e) {
									alert.setTitle("Delete Exception");
									alert.setHeaderText("Cannot Delete");
									alert.setContentText("Dependents Exist !");
									Label label = new Label(e.getMessage().toString());
									GridPane expContent = new GridPane();
									expContent.setMaxWidth(Double.MAX_VALUE);
									expContent.add(label, 0, 0);
									// Set expandable Exception into the dialog pane.
									alert.getDialogPane().setExpandableContent(expContent);
									alert.showAndWait();
								}
							}
							else {}
							/**
							 * End of Delete Profile Actions - VJ
							 */

						});

						//----------------End of Delete Profile-----------------//

						//----------------Profile Details----------------------//

						details.setOnAction((ActionEvent dProfile) -> {
							stageAccess1.close();

							Stage stageDetails = new Stage(); // Create a new stage
							stageDetails.setTitle("PROFILE DETAILS"); 
							
							GridPane panePD = new GridPane();
							ScrollPane detailPane = new ScrollPane();
							panePD.setAlignment(Pos.CENTER);
							panePD.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
							panePD.setHgap(5.5);
							panePD.setVgap(5.5);
							panePD.setMinSize(300, 300); //Added by VJ on 19.05.2018
							Button backPD = new Button("Back");
							backPD.setMaxWidth(150);  //Added by VJ on 19.05.2018
							Button relationPD = new Button("See Connections");
							relationPD.setMaxWidth(150);  //Added by VJ on 19.05.2018

							// Place nodes in the pane
							/**
							 * Layout Changes by Vishesh Jain on 19.05.2018
							 */
							panePD.add(new Label("Name"), 0, 1);
							panePD.add(new Label (allAccess.getName().toUpperCase()), 1, 1);
							panePD.add(new Label("Age"), 0, 3);
							panePD.add(new Label(Integer.toString(allAccess.getAge())), 1, 3);
							panePD.add(new Label("Status"), 0, 5);
							panePD.add(new Label(allAccess.getStatus().toUpperCase()), 1, 5);
							panePD.add(relationPD, 0, 7);
							panePD.add(backPD, 1, 7);
							/**
							 * End of Layout Changes - VJ
							 */

							relationPD.setOnAction((ActionEvent connection) -> {
								/**
								 * Profile Details Action added by Vishesh Jain on 19.05.2018
								 */
								stageDetails.close();

								Stage stageConnection = new Stage(); // Create a new stage
								stageDetails.setTitle("CONNECTIONS !"); 

								GridPane paneC = new GridPane(); // Create new Pane
								ScrollPane connectionPane = new ScrollPane();
								paneC.setAlignment(Pos.CENTER);
								paneC.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
								paneC.setHgap(5.5);
								paneC.setVgap(5.5);
								paneC.setMinSize(300, 300); // Added by VJ 19.05.2018
								paneC.setMaxSize(300, 300); // Added by VJ 19.05.2018

								ArrayList<Connections> pconnection = Driver.getConnection(allAccess);

								ObservableList<Connections> onames = FXCollections.observableArrayList(pconnection);

								TableView<Connections> table = new TableView<Connections>();
								
								// To Keep Only Two Columns in View
								table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

								table.setItems(onames);

								TableColumn<Connections, String> personName = new TableColumn<>("Name");
								personName.setCellValueFactory(new PropertyValueFactory<Connections, String>("name"));
								TableColumn<Connections, String> personRelation = new TableColumn<>("Relation");
								personRelation.setCellValueFactory(new PropertyValueFactory<Connections, String>("relation"));
								table.getColumns().add(personName);
								table.getColumns().add(personRelation);

								connectionPane.setContent(table);

								Button backC = new Button("Back");
								backC.setMaxWidth(300);

								paneC.add(backC, 0, 2);
								paneC.add(connectionPane, 0, 1);

								backC.setOnAction((ActionEvent back) -> {
									stageConnection.close();
									stageDetails.show();
								});

								Scene sceneConnection = new Scene(paneC);
								stageConnection.setScene(sceneConnection);
								stageConnection.show();

							});
							/**
							 * End of Profile Details Action - VJ
							 */

							backPD.setOnAction((ActionEvent back) -> {
								stageDetails.close();
								stageAccess1.show();
							});

							Scene sceneDetails = new Scene(panePD);
							stageDetails.setScene(sceneDetails);
							stageDetails.show();

						});

						backDP.setOnAction((ActionEvent back) -> {
							stageAccess.close();
							primaryStage.show();
						});

						//-----------------End of Profile Details--------------//

						//--------------------Add Relation--------------------//

						relation.setOnAction((ActionEvent addConnection) -> {
							stageAccess1.close();
							
							Stage stageRelation = new Stage(); // Create a new stage
							stageRelation.setTitle("ADD RELATION");

							GridPane paneAR = new GridPane();
							
							/**
							 * Layout Changes added by Vishesh Jain on 19.05.2018
							 */
							final ComboBox<String> relationBox = new ComboBox<>();
							relationBox.getItems().addAll(
									"FRIEND",
									"PARENT",
									"CHILD",
									"SPOUSE",
									"COLLEAGUE",
									"CLASSMATE");
							relationBox.setValue("FRIEND");
							/**
							 * End of Layout Changes - VJ
							 */
							paneAR.setAlignment(Pos.CENTER);
							paneAR.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
							paneAR.setHgap(6.5);
							paneAR.setVgap(6.5);
							paneAR.setMinSize(300, 300); // Added by VJ 19.05.2018
							Button saveAR = new Button("Save");
							saveAR.setMaxWidth(150); // Added by VJ 19.05.2018
							Button backAR = new Button("Back");
							backAR.setMaxWidth(150); // Added by VJ 19.05.2018
							TextField rname = new TextField();

							// Place nodes in the pane
							paneAR.add(new Label("Full Name"), 0, 1);
							paneAR.add(rname, 1, 1);
							paneAR.add(relationBox, 0, 3);
							paneAR.add(saveAR, 0, 12);
							paneAR.add(backAR, 1, 12);

							saveAR.setOnAction((ActionEvent save) -> {
								
								/**
								 * Add Relation Actions Added by Vishesh Jain on 19.05.2018
								 */
								String relationName = rname.getText();

								if(relationName.isEmpty()) {
									alert.setTitle("Field Empty !");
									alert.setHeaderText("Cannot Be Empty !");
									alert.setContentText("Name Cannot Be Empty !");
									Label label = new Label("Enter a Name in Text Field");
									GridPane expContent = new GridPane();
									expContent.setMaxWidth(Double.MAX_VALUE);
									expContent.add(label, 0, 0);
									// Set expandable Exception into the dialog pane.
									alert.getDialogPane().setExpandableContent(expContent);
									alert.showAndWait();
								}

								else {

									String option = relationBox.getValue().toString();
									if(option.isEmpty()) {
										alert.setTitle("Option Error !");
										alert.setHeaderText("Choose an Option !");
										alert.setContentText("Option Cannot be Blank !");
										Label label = new Label("Choose a relation from Drop-down List");
										GridPane expContent = new GridPane();
										expContent.setMaxWidth(Double.MAX_VALUE);
										expContent.add(label, 0, 0);
									
										alert.getDialogPane().setExpandableContent(expContent);
										alert.showAndWait();
									}
									else {
										try {
												Driver.addConnection(option, allAccess, relationName);
											message.setTitle("SUCCESS !");
											message.setHeaderText("Relation Added !");
											message.setContentText("Relation Added Successfully");
											Label label = new Label(relationName.toUpperCase()+
													" Added as a "+option.toUpperCase());
											GridPane expContent = new GridPane();
											expContent.setMaxWidth(Double.MAX_VALUE);
											expContent.add(label, 0, 0);
											
											message.getDialogPane().setExpandableContent(expContent);
											message.showAndWait();
										} catch (NoProfileException | NoParentException | NotToBeCoupledException
												| NotToBeColleaguesException | NotToBeFriendsException | NotToBeChildException
												| NotToBeClassmatesException | NoAvailableException e) {
											alert.setTitle("Relation Error !");
											alert.setHeaderText("Error !");
											alert.setContentText(e.getMessage());
											Label label = new Label(e.getMessage());
											GridPane expContent = new GridPane();
											expContent.setMaxWidth(Double.MAX_VALUE);
											expContent.add(label, 0, 0);
											
											alert.getDialogPane().setExpandableContent(expContent);
											alert.showAndWait();
										}

									}
								}

							});
							
							/**
							 * End of Add Relation Actions - VJ
							 */

							backAR.setOnAction((ActionEvent back) -> {
								stageRelation.close();
								stageAccess1.show();
							});

							Scene sceneRelation = new Scene(paneAR);
							stageRelation.setScene(sceneRelation);
							stageRelation.show();

						});

						backACP.setOnAction((ActionEvent back) -> {
							stageAccess1.close();
							stageAccess.show();
						});

						Scene sceneAccess1 = new Scene(paneACP);
						stageAccess1.setScene(sceneAccess1);
						stageAccess1.show();
					}
				}
			});

			backDP.setOnAction((ActionEvent back) -> {
				stageAccess.close();
				primaryStage.show();
			});

			Scene sceneAccess = new Scene(paneDP);
			stageAccess.setScene(sceneAccess);
			stageAccess.show();			
		});
		
		//----------------------End of Profile Details--------------------------//


		//---------------------Check Connection----------------------------------//
		
		btcheckconn.setOnAction((ActionEvent checkconn) -> {
			primaryStage.hide();

			Stage stageCheckConnection = new Stage(); // Create a new stage
			stageCheckConnection.setTitle("CHECK CONNECTION");
			// Set a scene with a button in the stage
			GridPane paneCN = new GridPane();
			paneCN.setAlignment(Pos.CENTER);
			paneCN.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			paneCN.setHgap(5.5);
			paneCN.setVgap(5.5);
			paneCN.setMinSize(300, 300); // Added by VJ 19.05.2018
			Button okCN = new Button("Ok");
			okCN.setMaxWidth(150); // Added by VJ 19.05.2018
			Button backCN = new Button("Back");
			backCN.setMaxWidth(150); // Added by VJ 19.05.2018
			TextField name1 = new TextField();
			TextField name2 = new TextField();

			// Place nodes in the pane
			paneCN.add(new Label("First Name"), 0, 1);
			paneCN.add(name1, 1, 1);
			paneCN.add(new Label("Second Name"), 0, 2);
			paneCN.add(name2, 1, 2);
			paneCN.add(okCN, 0, 3);
			paneCN.add(backCN, 1, 3);

			okCN.setOnAction((ActionEvent okConnectionCheck) -> {
				/**
				 * Check Connection Actions added by Vishesh Jain 19.05.2018
				 */
				String n1 = name1.getText();
				String n2 = name2.getText();
				String relation;
				try {
					relation = Driver.connectionCheck(n1, n2);
					message.setTitle("Connection Result !");
					message.setHeaderText("Connection is: ");
					message.setContentText(relation);
					Label label = new Label("You found them !");
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					message.getDialogPane().setExpandableContent(expContent);
					message.showAndWait();
				} catch (NoRelationException e) {
					alert.setTitle("Connection Error !");
					alert.setHeaderText("No Connection !");
					alert.setContentText(e.getMessage());
					Label label = new Label(e.getMessage());
					GridPane expContent = new GridPane();
					expContent.setMaxWidth(Double.MAX_VALUE);
					expContent.add(label, 0, 0);
					// Set expandable Exception into the dialog pane.
					alert.getDialogPane().setExpandableContent(expContent);
					alert.showAndWait();
				}
			});
			
			/**
			 * End of Check Connection Action - VJ
			 */

			backCN.setOnAction((ActionEvent back) -> {
				stageCheckConnection.close();
				primaryStage.show();
			});

			Scene sceneDisplay = new Scene(paneCN);
			stageCheckConnection.setScene(sceneDisplay);
			stageCheckConnection.show();


		});
		
		//-------------------------End of Check Connection-------------------------//

		//-------------------------------Exit Action-------------------------------//
		btexit.setOnAction((ActionEvent exit) -> {
			System.exit(0);
		});

	}

}
