package example;

/**
 * A staff member
 * @author Robert Clifton-Everest
 * modified by XING XING z5142063
 */
public class StaffMember {
	
	String name;
	double salary;
	String hire_date;
	String end_date;
	
	// Staff constructor
	public StaffMember(String name,double salary,String hire_date,String end_date){
	  this.name = name;
	  this.salary = salary;
	  this.hire_date = hire_date;
	  this.end_date = end_date;
	}
	
	//setters and getters
	/**
	 * 
	 * @param new_name
	 */
	public void setname(String new_name){
		this.name = new_name;
	}

	/**
	 * 
	 * @return name
	 */
	public String getname(){
		return name;
	}
	
	/**
	 * 
	 * @param new_salary
	 */
	public void setsalary(double new_salary){
		this.salary = new_salary;
	}
	
	/**
	 * 
	 * @return salary
	 */
	public double getsalary(){
		return salary;
	}
	
	/**
	 * 
	 * @param new_date
	 */
	public void set_hire_date(String new_date){
		this.hire_date = new_date;
	}
	
	/**
	 * 
	 * @return hire_date
	 */
	public String get_hire_date(){
		return hire_date;
	}
	
	/**
	 * 
	 * @param new_datee
	 */
	public void set_end_date(String new_datee){
		this.end_date = new_datee;
	}
	
	/**
	 *
	 * @return end_date
	 */
	public String get_end_date(){
		return end_date;
	}
	
	// showing info *
	public void printEmployee(){
	      System.out.println("Name:"+ name);
	      System.out.println("Salary:" + salary);
	      System.out.println("Hire Date:" + hire_date);
	      System.out.println("End Date:" + end_date);
	}
	 
	// override
	@Override
	public String toString() {
		String str = this.getClass().getName() + ": " + this.name ;
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		else if(obj == this) {
			return true;
		}
		else if(this.getClass() == obj.getClass()) {
			StaffMember a1 = (StaffMember) obj;
			if ((a1.getname().equals(this.getname()) && a1.getsalary() == this.getsalary()) && (a1.get_hire_date() == this.get_hire_date() && a1.get_end_date() == this.get_end_date())) {
				return true;
			} else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
