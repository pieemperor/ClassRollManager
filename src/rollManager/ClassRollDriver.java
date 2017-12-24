/**
 * ---------------------------------------------------------------------------
 * File name: ClassRollDriver.java
 * Project name: Project1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * Course:  CSCI 1260-002
 * Creation Date: Apr 3, 2016
 * ---------------------------------------------------------------------------
 */

package rollManager;

import java.util.*;
import javax.swing.JFileChooser;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 3, 2016
 * <hr>
 * @author Dakota Cowell
 */
public class ClassRollDriver
{

	/**
	 * To create an interactive Class Roll System       
	 *
	 * <hr>
	 * Date created: Apr 3, 2016
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		
		int menuChoice = 0;
		int studentToEdit;
		int attributeToEdit;
		int studentToDelete = -1;
		String studentFirstName;
		String studentLastName;
		String classification;

		RollManager rollBook = new RollManager();

		
		
		Scanner kb = new Scanner(System.in);
//		System.out.println("Hello! Welcome the the Class Roll Manager application. "
//						+  "Press enter to continue.");
		
		do{
			menuChoice = displayMenu();	
			switch(menuChoice)
			{
				case 1: 	
					try{
						System.out.println("What is the course number?");
						rollBook.setCourseNumber(kb.nextLine());
				
						System.out.println("What is the course name?");
						rollBook.setCourseName(kb.nextLine());

						System.out.println("Who is the instructor?");
						rollBook.setInstructor(kb.nextLine());
						rollBook.setSaveNeeded(true);
					}
					catch(Exception e)
					{
						System.out.println("Invalid Course Information: "+  e.getMessage( ));
					}
								break;
								
				case 2:
					try{
						rollBook.addStudent(getStudentInfo());
						rollBook.setSaveNeeded(true);
					}
					catch(InputMismatchException exe)
					{
						System.out.println("Invalid Input.  The student was not saved " + exe.getMessage());
					}
					catch(Exception e)
					{
						System.out.println("Unable to add student: "+  e.getMessage( ));
					}
								break;
								
				case 3: 
					try
					{
						displayStudentNames(rollBook);
						System.out.println("\n");
						System.out.println("Which Student would you like to edit? " +
										  "(Please enter the number of the student)");
						studentToEdit = kb.nextInt ( ) -1;
						kb.nextLine ( );
						
						attributeToEdit = editMenu();
						switch(attributeToEdit)
						{
							case 1:
								String fName;
								System.out.println("What is the student's first name?");
								fName = kb.nextLine ( );
								rollBook.getStudent(studentToEdit).setFirstName (fName);
									break;
								
							case 2:
								String lName;
								System.out.println("What is the student's last name?");
								lName = kb.nextLine ( );
								rollBook.getStudent(studentToEdit).setLastName (lName);
									break;
								
							case 3:
								String major;
								System.out.println("What is the student's major?");
								major = kb.nextLine ( );
								rollBook.getStudent(studentToEdit).setMajor(major);
									break;
									
							case 4:
								int hoursCompleted;
								System.out.println("How many hours has the student completed?");
								hoursCompleted = kb.nextInt ( );
								kb.nextLine ( );
								rollBook.getStudent(studentToEdit).setHoursCompleted(hoursCompleted);
									break;
							case 5:
								double gpa;
								System.out.println("What is the student's gpa? ");
								gpa = kb.nextDouble();
								rollBook.getStudent(studentToEdit).setGpa(gpa);
									break;
								
							case 6:
								String photoFile;
								System.out.println("What is the name of the file you would " +
												"like to use as your picture file?");
								photoFile = kb.nextLine();
								rollBook.getStudent(studentToEdit).setPhotoFile(photoFile);
									break;
								
							case 7:
								System.out.println("What is your classification?");
								String temp = kb.nextLine ( );
								Classification classification1 = Classification.OTHER;
								if(temp.equalsIgnoreCase("FRESHMAN"))
								{
									classification1 = (Classification.FRESHMAN);
								}
								else if(temp.equalsIgnoreCase("SOPHOMORE"))
								{
									classification1 = Classification.SOPHOMORE;
								}
								else if(temp.equalsIgnoreCase("JUNIOR"))
								{
									classification1 = Classification.JUNIOR;
								}
								else if(temp.equalsIgnoreCase("SENIOR"))
								{
									classification1 = Classification.SENIOR;
								}
								else if(temp.equalsIgnoreCase("GRADUATE"))
								{
									classification1 = Classification.GRADUATE;
								}		
								else
								{
									classification1 = Classification.OTHER;
								}
								
								rollBook.getStudent(studentToEdit).setClassification (classification1);
								
									break;	
						}//end switch
								rollBook.setSaveNeeded(true);		
								break;
					}//end try
					catch(Exception e)
					{
	
							System.out.println("Unable to edit student:"+  e.getMessage( ));
							
							try{
								saveToFile(rollBook);
							}
							catch(Exception ex)
							{
								System.out.println("Unable to save: " + ex.getMessage());
							}
						
					}
				case 4: 
					
					try
					{
						do{

							displayStudentNames(rollBook);
							System.out.println("Which student would you like to delete? "
											+  "(Please enter the number of the student) ");
							studentToDelete = kb.nextInt ( );
							kb.nextLine ( );
							}while(studentToDelete < 1 || studentToDelete > rollBook.classSize());
							rollBook.dropStudent(studentToDelete);
							rollBook.setSaveNeeded(true);
					}
					catch(InputMismatchException ex)
					{
						System.out.println("Invalid input: " + ex.getMessage());
					}
					catch(Exception e)
					{
						System.out.println("Unable to drop student. ");
					}
								break;
								
				case 5:
					displayAll(rollBook);
								break;
								
				case 6: 
					try{
						displayStudentNames(rollBook);
						
						System.out.println("Please enter the student's first name that "+ 
										   "you would like to display.");
						studentFirstName = kb.nextLine();
						
						System.out.println("Please enter the student's last name that "+ 
										   "you would like to display.");
						studentLastName = kb.nextLine();
						
						System.out.println("\n");
						System.out.println(rollBook.getStudent(studentFirstName, studentLastName));
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid Data: " + e.getMessage());
					}
					catch(Exception e)
					{
						System.out.println("An error has ocured: " + e.getMessage ( ));
					}
								break;
								
				case 7: 
					try
					{
						System.out.println("Which classification would you like to display?");
						classification = kb.nextLine ( ).toUpperCase();
						displayByClassification(classification, rollBook);
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid data: " + e.getMessage());
					}
					catch(Exception ex)
					{
						System.out.println("An error has ocured: " + ex.getMessage ( ));
					}

								break;
								
				case 8: 
					try{
						rollBook.nameSort();
						rollBook.setSaveNeeded (true);
					}
					catch(IndexOutOfBoundsException e)
					{
						System.out.println("Cannot sort names: " + e.getMessage());
					}
					catch(Exception ex)
					{
						System.out.println("An error has occured: " +ex.getMessage());
					}
								break;
								
				case 9: 
					try{
						rollBook.sortByGpa();
						rollBook.setSaveNeeded (true);
					}
					catch(IndexOutOfBoundsException e)
					{
						System.out.println("Cannot sort names: " + e.getMessage());
					}
					catch(Exception ex)
					{
						System.out.println("An error has occured: " +ex.getMessage());
					}
								break;
								
				case 10:
					try
					{
						rollBook = new RollManager();
					}
					catch(Exception e)
					{
						System.out.println("An error has occured: " + e.getMessage());
					}
								break;
								
				case 11:
					try{
						JFileChooser dlg = new JFileChooser("RollData");
							int result = dlg.showOpenDialog (null);
							if(result == JFileChooser.APPROVE_OPTION)
							{
								rollBook.fillFromFile(dlg.getSelectedFile().getPath());
							}


					}
					catch(Exception e)
					{
						System.out.println("An error has occured: " + e.getMessage());
					}		
								break;
								
								
				case 12:
					try{
							saveToFile(rollBook);
					}
					catch(Exception e)
					{
						System.out.println("Cannot save the file" + e.getMessage());
					}
								break;

			}//end switch
		}while(menuChoice != 13);
		
//		kb.close ( );

	}//end main

	public static int displayMenu()
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("1. Create a new Course for the Class Roll Manager.");
		System.out.println("2. Create a new Student object and add it to " 
						+  "the RollManager's classRoll.");
		System.out.println("3. Edit an existing Student from the RollManager’s classRoll.");
		System.out.println("4. Drop a Student from the classRoll.");
		System.out.println("5. Display all Students on the classRoll");
		System.out.println("6. Find and display a Student by name");
		System.out.println("7. Display all Students on the classRoll of a given Classification");
		System.out.println("8. Sort the Students by name (last, first)");
		System.out.println("9. Sort the Students by GPA");
		System.out.println("10. Create a new RollManager class roll");
		System.out.println("11. Populate a RollManager class roll from a file");
		System.out.println("12. Save a RollManager class roll from a file");
		System.out.println("13. Exit");
		
		System.out.println("Please select an option 1-13 from the menu.");
		int choice = kb.nextInt();
		kb.nextLine ( );
//		kb.close ( );
		return choice;
	}
	
	public static int editMenu()
	{
		Scanner kb = new Scanner(System.in);
		int studToReturn;
		
		System.out.println("Which field would you like to edit? ");
		System.out.println("1. First Name");
		System.out.println("2. Last Name");
		System.out.println("3. Major");
		System.out.println("4. Hours Completed");
		System.out.println("5. GPA");
		System.out.println("6. Photo File");
		System.out.println("7. Classification");
		
		studToReturn = kb.nextInt ( );
		kb.nextLine ( );
		return studToReturn;
		
	}
	
	public static Student getStudentInfo()
	{
		Scanner kb = new Scanner(System.in);
		Student stud; //temporary student object

		//request the student information from the user
		System.out.println("What is the student's first name?");
		String firstName = kb.nextLine();
		
		System.out.println("What is the student's last name?");
		String lastName = kb.nextLine();
		
		System.out.println("What is the student's major?");
		String major = kb.nextLine();
		
		System.out.println("How many hours has the student completed?");
		int completedHours = kb.nextInt();
		
		System.out.println("What is the student's GPA?");
		double GPA = kb.nextDouble();
		
		kb.nextLine();
		
		System.out.println("What is the name of the file you would " +
						"like to use as your picture file?");
		String photoFile = kb.nextLine ( );
		
		System.out.println("What is your classification?");
		String temp = kb.nextLine ( );
		Classification classification = Classification.OTHER;
		if(temp.equalsIgnoreCase("FRESHMAN"))
		{
			classification = (Classification.FRESHMAN);
		}
		else if(temp.equalsIgnoreCase("SOPHOMORE"))
		{
			classification = Classification.SOPHOMORE;
		}
		else if(temp.equalsIgnoreCase("JUNIOR"))
		{
			classification = Classification.JUNIOR;
		}
		else if(temp.equalsIgnoreCase("SENIOR"))
		{
			classification = Classification.SENIOR;
		}
		else if(temp.equalsIgnoreCase("GRADUATE"))
		{
			classification = Classification.GRADUATE;
		}		
		else
		{
			classification = Classification.OTHER;
		}

		
		//create the student object with information entered by the user
		stud = new Student(firstName, lastName, major, completedHours, GPA, photoFile, classification);

//		kb.close ( );
		
		//return the newly created student object
		return stud;

	}//end getStudentInfo

	
	public static void displayStudentNames(RollManager studs)
	{
		for(int i = 0; i < studs.classSize(); i++)
		{
			System.out.println((i+1) + ".  "+ studs.getStudent(i).getFirstName() + " " 
								+ studs.getStudent(i).getLastName());
		}
	}
	
	
	
	
	public static void displayByClassification(String classification, RollManager book)
	{
		for(int i = 0; i<book.classSize ( );i++)
		{
			if(book.getStudent(i).getClassification().toString().equals(classification))
			{
				System.out.println(book.getStudent(i) + "\n");
			}
		}
	}
	
	public static void displayAll(RollManager book)
	{
		String str = "";
		
		for(int i = 0; i < book.classSize();i++)
		{
			str += book.getStudent(i) + "\n\n";
		}
		System.out.println(str);
	}//end displayAll
	
	public static void saveToFile(RollManager rollBook) throws Exception
	{
		JFileChooser dlg = new JFileChooser("RollData");
		int result = dlg.showSaveDialog (null);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			rollBook.saveToFile(dlg.getSelectedFile().getPath());
		}
	}

}//end ClassRollDriver
