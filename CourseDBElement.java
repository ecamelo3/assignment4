/**
 * @author Emma Camelo
 * 
 * Professor Monshi, CMSC204 3/25/2021 Spring 2021
 * This class creates the CourseDBElement 
 */
public class CourseDBElement implements Comparable{

	public CourseDBElement() {}
	
	protected int crn;
	protected int credits;
	protected String roomNum;
	protected String instructor;
	protected String id;
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		super();
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public int compareTo(Object CDE) {
		return 0;
	}
}
