package rollManager;
/**
 * ---------------------------------------------------------------------------
 * File name: StudentDriver.java
 * Project name: Project1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * Course:  CSCI 1260-002
 * Creation Date: Feb 17, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Feb 17, 2016
 * <hr>
 * @author Dakota Cowell
 */

import javax.swing.JOptionPane;
public class StudentDriver
{

	/**
	 * Driver for Student class to make a roll book        
	 *
	 * <hr>
	 * Date created: Feb 17, 2016
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		String userName = "XXXX"; //variable to store the user's name
		int menuChoice = 0; //variable to hold the user's menu choice
		int studentChoice = 0; //variable to hold the user's choice of student to display
		int numStudents = 0; //variable to hold the number of students
		final int MAX_STUDENTS = 5; //constant to store the max number of students		
		
		//create new student array
		Student[] students = new Student[MAX_STUDENTS];
		
		
		//Display introduction menu
		JOptionPane.showMessageDialog (null, "Hello! My name is Dakota.  In this program," + "\n" +
											 "you can create up to 5 Student objects and " + "\n" +
											 "     display their student information.  ");

		//Prompt for user's name
		userName = JOptionPane.showInputDialog ("What is your name?");
		
		do{
			//display menu and save user choice to variable
			menuChoice = displayMenu();
			
			
			//Check to see which choice they chose
			if(menuChoice == 1)
			{
				//Prompt for student info
				students[numStudents] = new Student(getStudentInfo());
				numStudents++; 
			}
			//if choice is 2, display the menu of students to display
			else if(menuChoice == 2)
			{
				//check to make sure there are students to display, then display the one they chose
				if(numStudents > 0)
				{
					studentChoice = displaySubMenu(students, numStudents);
					if(studentChoice == 1)
					{
						JOptionPane.showMessageDialog(null,students[0]);
					}
					else if(studentChoice == 2)
					{
						JOptionPane.showMessageDialog(null,students[1]);
					}
					else if(studentChoice == 3)
					{
						JOptionPane.showMessageDialog(null,students[2]);
					}
					else if(studentChoice == 4)
					{
						JOptionPane.showMessageDialog(null,students[3]);
					}
					else if(studentChoice == 5)
					{
						JOptionPane.showMessageDialog(null,students[4]);
					}
					//make sure they enter a valid number
					else
					{
						JOptionPane.showMessageDialog(null, "That is an invalid number. Please enter" +
															" a valid number.");
					}
				}
				//if choice = 3, tell them goodbye and use their name
			else if(menuChoice == 3)
				{
					JOptionPane.showMessageDialog (null, "Goodbye " + userName + "! Thank you for using this software. ");
				}
			//if numstudents is not greater than 0, tell the user no students to display
			else
				{
					JOptionPane.showMessageDialog(null,"There are no students to display.");
				}
	
			}
		}while(menuChoice != 3);//end do while
		
		System.exit(0); //needed when using JOptionPane
	}//end main
	
	
	
	
	
	/**
	  * Method Name: 	displayMenu<br>
	  * Method Purpose: displays a menu of options to the user and returns the user's
	  *					selection <br>
	  *
	  * <hr>
	  * Date created: 2/18/16 <br>
	  * Date last modified: 2/22/16 <br>
	  *
	  * <hr>
	  * Notes of specifications, special algorithms, and assumptions:
	  *
	  * <hr>
	  *	@return int the user's menu selection
	  */
	public static int displayMenu()
	{
		String str;
		int menuChoice = 0;
		str = JOptionPane.showInputDialog ("Project1:  Student Menu " + "\n" +
	                                 "-----------------------" + "\n\n" +
						             "1. Create a new Student" + "\n" +
	                                 "2. Display a Student" + "\n" + 
						             "3. End the program" + "\n\n" +
	                                 "Please type the number of your choice");
		menuChoice = Integer.parseInt(str);
		return menuChoice;
	}//end displayMenu
	
	
	/**
	  * Method Name: 	displaySubMenu<br>
	  * Method Purpose: displays a menu of studen namesto the user and returns
	  *					the user's selection <br>
	  *
	  * <hr>
	  * Date created: 2/18/16 <br>
	  * Date last modified: 2/22/16 <br>
	  *
	  * <hr>
	  * Notes of specifications, special algorithms, and assumptions:
	  *
	  * <hr>
	  * @param students Student[] - the list of students to be displayed
	  *	@return int the user's menu selection
	  */
	public static int displaySubMenu(Student[] students, int numStudents)
	{
		//build the menu
		String menu = 	  " ~~ Please select a student to display ~~ \n\n";

		for (int i = 0; i < numStudents; i++)
			menu += "\n    " + (i+1) + ". " + students[i].getFirstName() + " "  
											+ students[i].getLastName() ;

		menu += "\n    " + (numStudents+1) + ". Return to main menu\n"
			 + "\n\n What is your selection? ";

		//return the user's selection (the integer returned by the JOptionPane)
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}//end displaySubMenu

	
	
	
	/**
	  * Method Name: 	getStudentInfo<br>
	  * Method Purpose: prompts the user for the student information, creates a new
	  *					student object populating it with the student information,
	  *					and returns the object. <br>
	  *
	  * <hr>
	  * Date created: 2/18/16 <br>
	  * Date last modified: 2/22/16 <br>
	  *
	  * <hr>
	  * Notes of specifications, special algorithms, and assumptions:  n/a
	  *
	  * <hr>
	  *	@return Student the newly created Student object
	  */
	public static Student getStudentInfo()
	{
		Student stud; //temporary student object

		//request the student information from the user
		String firstName = JOptionPane.showInputDialog("What is the student's first name?");
		String lastName =  JOptionPane.showInputDialog("What is the student's last name?");
		String major =  JOptionPane.showInputDialog("What is the student's major?");
		int completedHours =
			Integer.parseInt(JOptionPane.showInputDialog("How many hours has the student completed?"));
		double GPA =
			Double.parseDouble(JOptionPane.showInputDialog("What is the student's GPA?"));
		String photoFile = JOptionPane.showInputDialog ("What is the name of the file you would " +
														"you like to use as your picture file?");
		Classification classification = Classification.valueOf (JOptionPane.showInputDialog ("What is your classification?"));
		//create the student object with information entered by the user
		stud = new Student(firstName, lastName, major, completedHours, GPA, photoFile, classification);

		//return the newly created student object
		return stud;
	}//end getStudentInfo
}//end StudentDriver
