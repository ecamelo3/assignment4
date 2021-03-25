
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Emma Camelo
 * 
 *  Professor Monshi, CMSC204 3/25/2021 Spring 2021
 * This class creates a database with a hashtable
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	protected int length;
	protected String testing;
	protected int index;
	@SuppressWarnings("rawtypes")
	LinkedList[] hashTable; 
	
	public CourseDBStructure(int length) {
		this.length = length;
		hashTable = new LinkedList[length];
	}
	
	public CourseDBStructure(String testing, int length) {
		this.testing = testing;
		this.length = length;
		hashTable = new LinkedList[length];
	}
	
	public class Node
	{
		protected int key;
		protected int next;
		CourseDBElement element;
	
		public Node(int hashKey, CourseDBElement element, int nextKey) {
			this.key = hashKey;
			this.element = element;
			this.next = nextKey;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added
	*/
	public void add(CourseDBElement element) {
		//Getting the hash code of the CRN
		String hashStr = String.valueOf(element.crn);
		int hashKey = hashStr.hashCode();
		
		int index = hashKey%length;
		
		if(hashTable[index]==null) {
			hashTable[index] = new LinkedList<CourseDBElement>(); // Node(hashKey, element, 0);		
			hashTable[index].add(element);
		}
		else {
			hashTable[index].add(element);
		}
	}

	@Override
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param element the CDE to be added
	 * @throws IOException 
	 * @throws java.io.IOException 
	*/
	public CourseDBElement get(int crn) throws IOException {	
		String hashStr = String.valueOf(crn);
		int hashKey = hashStr.hashCode(); 
		
		int index = hashKey%length;
		
		for(int x = 0; x < hashTable[index].size(); x++) {
			CourseDBElement element = (CourseDBElement) hashTable[index].get(x);
			if(crn == element.getCRN()) {
				return element;
			}
		}		
		throw new IOException();
	}

	@Override
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	public int getTableSize() {
		return length;
	}

}
