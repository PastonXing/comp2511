package example;

/**
 * A lecturer
 * @author XING XING
 * modified by XING XING z5142063
 */
public class Lecturer extends StaffMember {
	
	String school;
	String status;
	
	// Staff constructor
	public Lecturer(String name, double salary, String hire_date, String end_date, String school, String status){
		super(name,salary,hire_date,end_date);
		this.school = school;
		this.status = status;
	}
	
	// setter and getters
	/**
	 * 
	 * @param newSchool
	 */
	public void setSchool(String newSchool){
		this.school = newSchool;
	}
	
	/**
	 * 
	 * @return school
	 */
	public String getSchool(){
		return school;
	}
	/**
	 * 
	 * @param newStatus
	 */
	public void setStatus(String newStatus){
		this.status = newStatus;
	}
	
	/**
	 * 
	 * @return school
	 */
	public String getStatus(){
		return status;
	}
	
	@Override
	public String toString() {
		String str = super.toString() + " "+ this.school+ " " + this.status;
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		
		Lecturer a1 = (Lecturer) obj;
		// satisfying 6 equal and return the final true
		
		if(a1.getSchool() == this.getSchool() && a1.getStatus() == this.getStatus()) {
			return true;
		} 

		return false;
	}
}
