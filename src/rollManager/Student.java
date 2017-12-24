package rollManager;
/**
 * ---------------------------------------------------------------------------
 * File name: Student.java
 * Project name: Project1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * Course:  CSCI 1260-002
 * Creation Date: Feb 16, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * To be able to make Student objects to save their information
 *
 * <hr>
 * Date created: Feb 16, 2016
 * <hr>
 * @author Dakota Cowell
 */
public class Student
{
	private String lastName; //attribute to store a student's last name
	private String firstName; //attribute to store a student's first name
	private String major; //attribute to store a student's major
	private int hoursCompleted; //attribute to store hours completed
	private double gpa; //attribute to store gpa
	private String photoFile; //attribute to store a photo file
	private Classification classification; //enum attribute to store a classification
	
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Feb 16, 2016 
	 *
	 * 
	 */
	
	public Student()
	{
		super ( );
		setLastName("XXXXXX"); //setting last name to default
		setFirstName("XXXXXX"); //setting first name to default
		setMajor("XXXX"); //setting major to default
		setHoursCompleted(0); //setting hours completed to default
		setGpa(0.0); //setting gpa to default
		setPhotoFile("XXXX.XXX"); //setting photo file to default
		setClassification(Classification.OTHER); //setting classification to default
	}
	
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Feb 22, 2016 
	 *
	 * 
	 * @param firstName
	 * @param lastName
	 * @param major
	 * @param hoursCompleted
	 * @param gpa
	 * @param photoFile
	 * @param classification
	 */
	public Student (String firstName, String lastName,  String major, int hoursCompleted, double gpa,
					String photoFile, Classification classification)
	{
		super ( );
		setLastName(lastName); //setting last name to name passed in
		setFirstName(firstName); //setting first name to name passed in
		setMajor(major); //setting major to major passed in
		setHoursCompleted(hoursCompleted); //setting hoursCompleted to hours passed in
		setGpa(gpa); //setting gpa to number passed in
		setPhotoFile(photoFile); //setting photo file to name passed in
		setClassification(classification); //setting classification to classification passed in
	}
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Feb 22, 2016 
	 *
	 * 
	 * @param original
	 */
	public Student (Student original)
	{
		setFirstName(original.firstName); //set new students first name equal to original students first name
		setLastName(original.lastName);//set new students last name equal to original students last name
		setMajor(original.major); //set new students major equal to original students major
		setHoursCompleted(original.hoursCompleted); //set new students hours equal to original students hours
		setGpa(original.gpa); //set new students gpa equal to original students gpa
		setPhotoFile(original.photoFile); //set new students photo equal to original students photo
		setClassification(original.classification); //set new students classification equal to original students classification
	}
	
	
	
	/**
	 * Method to get the students last name      
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @return lastName returns a String of the Student's last name
	 */
	public String getLastName ( )
	{
		return lastName;
	}
	
	/**
	 *  Method to set the students last name        
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @param lastName
	 */
	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 *  Method to get the students first name         
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @return firstName returns a String of the Student's first name
	 */
	public String getFirstName ( )
	{
		return firstName;
	}
	
	/**
	 * Method to set the students first name             
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @param firstName
	 */
	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * Method to get the students major               
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @return major returns a String storing the Student's major
	 */
	public String getMajor ( )
	{
		return major;
	}
	
	/**
	 * Method to set the students major          
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @param major
	 */
	public void setMajor (String major)
	{
		if(major.length() == 4)
		{
			this.major = major.toUpperCase();
		}
		else 
		{
			this.major = "XXXX";
		}
	}
	
	/**
	 * Method to get the students hours completed          
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @return hoursCompleted returns an int of hours the student has completed
	 */
	public int getHoursCompleted ( )
	{
		return hoursCompleted;
	}
	/**
	 * Method to set the students hours completed        
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @param hoursCompleted
	 */
	public void setHoursCompleted (int hoursCompleted)
	{
		if(hoursCompleted > 0)
		{
			this.hoursCompleted = hoursCompleted;
		}
		else
		{
			this.hoursCompleted = 0;
		}
	}
	/**
	 * Method to get the students gpa 
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @return gpa returns a double that stores the student's gpa
	 */
	public double getGpa ( )
	{
		return gpa;
	}
	/**
	 * Method to set the students gpa       
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @param gpa
	 */
	public void setGpa (double gpa)
	{
		if(hoursCompleted > 0)
		{
			if(gpa > 0 && gpa <= 4.0)
			{
				this.gpa = gpa;
			}
			else
			{
				this.gpa = 0.0;
			}
		}
		else
		{
			this.gpa = 0.0;
		}
	}
	
	/**
	 * Method to get the students photo file   
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @return photoFile returns a String of the file for a Student's picture
	 */
	public String getPhotoFile ( )
	{
		return photoFile;
	}
	
	/**
	 * Method to set the students photo file      
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @param photoFile
	 */
	public void setPhotoFile (String photoFile)
	{
		this.photoFile = photoFile;
	}

	/**
	 * Method to return a string that displays all of the students' information      
	 *
	 * <hr>
	 * Date created: Feb 22, 2016 
	 *
	 * <hr>
	 * @return classification returns a Classification object of 
	 * the student's classification
	 * @see java.lang.Object#toString()
	 */
	
	public Classification getClassification()
	{
		return classification;
	}
	
	/**
	 * Method to set the students classification    
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @param classification
	 */
	public void setClassification(Classification classification)
	{
		this.classification = classification;
	}
	
	public void setClassification(String temp)
	{
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
	}
	
	/**
	 * Method to convert the info to a string used to display     
	 *
	 * <hr>
	 * Date created: Feb 22, 2016
	 *
	 * <hr>
	 * @return str is a String object returning the Student's info
	 */
	public String toString()
	{

		String str = "     First Name: " + firstName + "\n" +
				     "      Last Name: " + lastName +  "\n" +
				     "          Major: " + major + "\n" +
				     " Classification: " + classification + "\n" +
				     "Hours Completed: " + hoursCompleted + "\n" +
				     "            GPA: " + gpa +  "\n" +
				     "  JPG File Name: " + photoFile;
		
		
		return str;
	}
}
