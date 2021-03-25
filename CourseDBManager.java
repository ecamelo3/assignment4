import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Emma Camelo
 * 
 * Professor Monshi, CMSC204 3/25/2021 Spring 2021
 * This class is the Manager class of the database. It adds from user input or from a file.
 */
public class CourseDBManager implements CourseDBManagerInterface {
		CourseDBStructure cds = new CourseDBStructure(20);
	
	
	@Override
	/**
	 * Adds a new element to the hashtable
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(element);
	}

	/** Finds a certain element and returns its data
	 * @param crn - a unique number identifying a course
	 * @return strElement - course information based on the crn
	 */
	public String get(int crn) {
			try {
				CourseDBElement element = cds.get(crn);
				String strElement = "";
				strElement += "\nCourse:" + element.id + " CRN:" + String.valueOf(element.crn) + " Credits:" + String.valueOf(element.credits) + " Instructor:" + element.instructor + " Room:" + element.roomNum;
				return strElement;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	/** Takes a file and reads it contents and adds them to the database
	 * @param input - File to be read
	 */
	public void readFile(File input) throws FileNotFoundException {
		Scanner scan = new Scanner(input);
		String id, crn, credits, roomNum,instructor;
		
		while(scan.hasNextLine()) 
		{
			id = scan.next();
			crn =  scan.next();
			credits = scan.next();
			roomNum = scan.next();
			instructor = scan.nextLine();
			
			CourseDBElement element = new CourseDBElement(id, Integer.valueOf(crn), Integer.valueOf(credits), roomNum, instructor);	
			cds.add(element);
		}		
		scan.close();
	}

	@Override
	/**
	 * Displays the elements using an arraylist
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> str = new ArrayList<String>();
		@SuppressWarnings("rawtypes")
		LinkedList[] hashTable = cds.hashTable;
		String strElement = "";
		
		int index = 0;
		while(index < hashTable.length) {
			if(hashTable[index]==null) {
				index++;
			}
			else
			{
				for(int i = 0; i < hashTable[index].size(); i++) 
				{
					CourseDBElement element = (CourseDBElement) hashTable[index].get(i);
					strElement += "\nCourse:" + element.id + " CRN:" + String.valueOf(element.crn) + " Credits:" + String.valueOf(element.credits) + " Instructor:" + element.instructor + " Room:" + element.roomNum;
					str.add(strElement);
					strElement = "";
				}
				index++;
			}
		}
		return str;
	}
}
