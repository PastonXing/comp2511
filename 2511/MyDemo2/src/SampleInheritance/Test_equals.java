package SampleInheritance;

/**
 * Demo file, it may not be correct and/or complete.  
 * Please watch the corresponding lecture(s) for more explanations.
 * 
 * @author ashesh
 *
 */

public class Test_equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A a1 = new A(4, 5);
		A a2 = new A(4, 5);
		
		//if( a1 == a2 ) {   // compares references, which are different
		
		if(a1.equals(a2)) {
			System.out.println(" a1 == a2 is True");
		}
		else {
			System.out.println(" a1 == a2 is False");			
		}
		
		
	}

}
