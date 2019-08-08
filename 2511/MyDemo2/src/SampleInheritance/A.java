package SampleInheritance;

/**
 * Demo file, it may not be correct and/or complete.  
 * Please watch the corresponding lecture(s) for more explanations.
 * 
 * @author ashesh
 *
 */

public class A {
	int x = 25;
	int y = 2;

	/**
	 * No-arg constructor
	 */
	public A() {

	}

	/**
	 * 2-args constructor
	 * @param x
	 * @param y
	 */
	public A(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Example of method overriding
	 * @return returns x+y
	 */
	public int f() {
		System.out.println("In Class A, Method f");
		System.out.println(">   x is " + x + " and y is " + y);

		return x + y;
	}

	/**
	 * Example of method overloading
	 * @param a
	 * @param b
	 * @return
	 */
	public int myAdd(int a, int b) {

		return a + b;
	}

	/**
	 * Example of method overloading
	 * @param a
	 * @param b
	 * @return
	 */
	public int myAdd(String a, String b) {

		int val1 = Integer.parseInt(a);
		int val2 = Integer.parseInt(b);

		return val1 + val2;

	}

	
	/**
	 * Example of overriding toString() method
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "[ x: " + x + ", y: " + y + "]";
		return str;
	}

	/**
	 * Example of overriding equals() method
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		
		if( obj instanceof A) {
			A a1 = (A) obj;
			
			if (a1.x == this.x && a1.y == this.y) {
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
