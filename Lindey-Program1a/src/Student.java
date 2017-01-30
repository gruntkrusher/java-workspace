/*
 * Student.java
 * Author: Jacob Lindey
 * Project: Lindey-Program1a
 * Start Date: 1/25/17 
 */

// Default imports
import java.util.Comparator;
///////////////////////////////////////////////////////////////

class Student implements Comparator<Student>, Comparable<Student> {
	
	public String lastName;		// Student Last Name
	public String firstName;	// Student First Name
	public int age;				// Student Age
	public float gpa;			// Student Grade Point Average
	
	public void setData(String _lN, String _fN, int _age, float _gpa)
	{
		lastName = _lN;
		firstName = _fN;
		age = _age;
		gpa = _gpa;
	}
	
	public int compare(Student a, Student b)
	{
		// If the Student's last names don't match
		if(!(a.lastName).equals(b.lastName))
		{
			// Compare their last names
			return (a.lastName).compareTo(b.lastName);
		}
		else
		{
			// Compare their first names
			return (a.firstName).compareTo(b.firstName);
		}
	}
	
	public int compareTo(Student b)
	{
		return compare(this, b);
	}

}
