package example;

import example.StaffMember;
import example.Lecturer;

public class staffTest{
	StaffMember t;
	public static void printStaffDetails(StaffMember q) {
		System.out.println("Detail: " + q.toString());
	}
	
	public static void main(String arg[]) {
		// created a staff
		StaffMember b = new StaffMember("Ronaldo", 20000, "2003", "2019");
		printStaffDetails(b);
		
		//created a lecturer
		Lecturer n1 = new Lecturer("Ronaldo", 20000, "2003", "2019", "cse", "new");
		printStaffDetails(n1);
		
		// compare staff and a lecturer 
		System.out.println("It is reflexive: for any non-null reference value x, x.equals(x) should return true.");
		System.out.println(b.equals(b));
		
		System.out.println("For any non-null reference value x, x.equals(null) should return false.");
		System.out.println(b.equals(null));
		
		System.out.println("It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.");
		StaffMember c = new StaffMember("Ronaldo", 20000, "2003", "2019");
		StaffMember d = c;
		System.out.println(b.equals(c));
		System.out.println(c.equals(d));
		System.out.println(b.equals(d));
		
		System.out.println("It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.");
		System.out.println(b.equals(c));
		System.out.println(b.equals(c));
		System.out.println(b.equals(c));
		
		System.out.println("It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.");
		System.out.println(b.equals(n1));
		System.out.println(n1.equals(b));

		
	}
}
