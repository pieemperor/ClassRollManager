/**
 * ---------------------------------------------------------------------------
 * File name: RollManager.java
 * Project name: Project1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dakota Cowell, cowelld@goldmail.etsu.edu
 * Course:  CSCI 1260-002
 * Creation Date: Apr 3, 2016
 * ---------------------------------------------------------------------------
 */

package rollManager;

import java.io.*;
import java.util.*;

/**
 * Maintains and does operations on a list of students
 *
 * <hr>
 * Date created: Apr 3, 2016
 * <hr>
 * @author Dakota Cowell
 */
public class RollManager
{
	private ArrayList<Student> classRoll = new ArrayList<Student>();
	private String courseNumber;
	private String courseName;
	private String instructor;
	private boolean saveNeeded;
	
	
	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Apr 3, 2016 
	 *
	 * 
	 * @param classRoll
	 * @param courseNumber
	 * @param courseName
	 * @param instructor
	 */
	public RollManager ()
	{
		super ( );
		setCourseNumber("CSCI 1260-090"); //set courseNumber to default value
		setCourseName("Introduction to Computer Science"); //set courseName to default value
		setInstructor("Kellie Price"); //set instructor to default value
		setSaveNeeded(false);
	}
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 3, 2016 
	 *
	 * 
	 * @param classRoll
	 * @param courseNumber
	 * @param courseName
	 * @param instructor
	 */
	public RollManager (ArrayList <Student> classRoll, String courseNumber, String courseName,
						String instructor)
	{
		super ( );
		setClassRoll(classRoll);
		setCourseNumber(courseNumber);
		setCourseName(courseName);
		setInstructor(instructor);
		setSaveNeeded(false);
	}

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 3, 2016 
	 *
	 * 
	 * @param classRoll
	 * @param courseNumber
	 * @param courseName
	 * @param instructor
	 */
	public RollManager (RollManager original)
	{
		super ( );
		setClassRoll(original.classRoll);
		setCourseNumber(original.courseNumber);
		setCourseName(original.courseName);
		setInstructor(original.instructor);
		setSaveNeeded(false);
	}
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 3, 2016 
	 *
	 * 
	 * @param courseNumber
	 * @param courseName
	 * @param instructor
	 */
	public RollManager (String courseNumber, String courseName,
						String instructor)
	{
		super ( );
		setCourseNumber(courseNumber);
		setCourseName(courseName);
		setInstructor(instructor);
		setSaveNeeded(false);

	}
	
	
	/**
	 * @return classRoll
	 */
	public ArrayList <Student> getClassRoll ( )
	{
		return classRoll;
	}
	
	/**
	 * @param classRoll the classRoll to set
	 */
	public void setClassRoll (ArrayList <Student> classRoll)
	{
		for(int i = 0; i<classRoll.size ( );i++)
		{
			classRoll.add (classRoll.get(i));
		}
		this.classRoll = classRoll;
		setSaveNeeded(true);

	}
	
	/**
	 * @return courseNumber
	 */
	public String getCourseNumber ( )
	{
		return courseNumber;
	}
	
	/**
	 * @param courseNumber the courseNumber to set
	 */
	public void setCourseNumber (String courseNumber)
	{
		this.courseNumber = courseNumber;
		setSaveNeeded(true);
	}
	
	/**
	 * @return courseName
	 */
	public String getCourseName ( )
	{
		return courseName;
	}
	
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName (String courseName)
	{
		this.courseName = courseName;
		setSaveNeeded(true);
	}
	
	/**
	 * @return instructor
	 */
	public String getInstructor ( )
	{
		return instructor;
	}
	
	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor (String instructor)
	{
		this.instructor = instructor;
		setSaveNeeded(true);
	}
	
	public void setSaveNeeded(boolean saveNeeded)
	{
		this.saveNeeded = saveNeeded;
	}
	
	public boolean getSaveNeeded()
	{
		return saveNeeded;
	}
	
	public void addStudent(Student s1)
	{
		classRoll.add(s1);
		setSaveNeeded(true);
	}
	
	public Student getStudent(int num)
	{
		return classRoll.get (num);
	}
	
	public Student getStudent(String fName, String lName)
	{
		Student stud = null;
		for(int i = 0; i<classRoll.size();i++)
		{
			if(classRoll.get(i).getFirstName ( ).toString ( ).equals (fName) && 
			   classRoll.get(i).getLastName ( ).toString ( ).equals (lName))
			{
				stud = classRoll.get (i);
			}
			
		}
		return stud;
	}
	public int classSize()
	{
		return classRoll.size ( );
	}

	public void dropStudent(int userChoice)
	{
		classRoll.remove (userChoice-1);
		setSaveNeeded(true);
	}
	
	public void setStudent(int position, Student stud)
	{
		classRoll.set (position, stud);
		setSaveNeeded(true);
	}

	public void sortByGpa()
	{
		int max;
		
		Student temp;
		
		for(int i = 0; i < classRoll.size() -1; i++)
		{
			max = i;
			
			for(int x = i+1; x < classRoll.size();x++)
			{
				if(classRoll.get(max).getGpa() < (classRoll.get (x).getGpa()))
					max = x;
			}
			
			temp = classRoll.get(i);
			classRoll.set(i, classRoll.get(max));
			classRoll.set(max, temp);
		}
		setSaveNeeded(true);
	}
	
	
	
	public void nameSort()
	{
		int max;
		
		Student temp;
		
		for(int i = 0; i < classRoll.size() -1; i++)
		{
			max = i;
			
			for(int x = i+1; x < classRoll.size();x++)
			{
				if(classRoll.get(max).getLastName().compareToIgnoreCase(
										classRoll.get(x).getLastName()) > 0)
					max = x;
			}
			
			temp = classRoll.get(i);
			classRoll.set(i, classRoll.get(max));
			classRoll.set(max, temp);
		}
		setSaveNeeded(true);

	}
	
	public void fillFromFile(String fileName) throws InputMismatchException, Exception
	{
		File myFile = new File(fileName);
		Scanner inputFile = new Scanner(myFile);
		
		
		while(inputFile.hasNext())
		{
			String str = inputFile.nextLine();
			String[] fields = str.split ("\\|");
			Student temp = new Student();


			if(fields.length == 3)
			{
				setCourseNumber(fields[0]);
				setCourseName(fields[1]);
				setInstructor(fields[2]);
			}
			else if(fields.length == 7)
			{

				temp.setFirstName (fields[0]);
				temp.setLastName (fields[1]);
				temp.setMajor(fields[2]);
				temp.setClassification (fields[3]);
				temp.setHoursCompleted(Integer.parseInt (fields[4]));
				temp.setGpa (Double.parseDouble(fields[5]));
				temp.setPhotoFile (fields[6]);
			
				
//				temporary = Classification.valueOf(fields[3].toUpperCase());
//				temp = new Student(fields[0], fields[1], fields[2], 
//					   Integer.parseInt (fields[4]), Double.parseDouble(fields[5]),
//					   fields[6], temporary);
				classRoll.add (temp);
			}
		}//end while
		setSaveNeeded(false);
		inputFile.close ( );
		
	}
	
	public void saveToFile(String fileName) throws Exception
	{
		PrintWriter outFile = new PrintWriter(fileName);
		
		
		outFile.println(getCourseNumber() +  "|" + getCourseName() + 
			"|" + getInstructor());
		for(int i = 0; i < classRoll.size();i++)
		{
			outFile.println(classRoll.get(i).getFirstName() + "|" + 
							classRoll.get(i).getLastName()  + "|" +
							classRoll.get(i).getMajor()  + "|" +
							classRoll.get(i).getClassification()  + "|" +
							classRoll.get(i).getHoursCompleted()  + "|" +
							classRoll.get(i).getGpa()  + "|" +
							classRoll.get(i).getPhotoFile());
		}
		setSaveNeeded(false);
		outFile.close ( );
	}
}//end RollManager
