import java.util.Comparator;


class Student implements Comparator<Student>, Comparable<Student> {
	
	public String lastName;		
	public String firstName;
	public int age;
	public float gpa;
	
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
