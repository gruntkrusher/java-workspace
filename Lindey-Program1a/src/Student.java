import java.util.Comparator;


class Student implements Comparator<Student>, Comparable<Student> {
	
	private String m_lastName;
	private String m_firstName;
	private int m_age;
	private float m_gpa;
	
	public void setData(String lastName, String firstName, int age, float gpa)
	{
		m_lastName = lastName;
		m_firstName = firstName;
		m_age = age;
		m_gpa = gpa;
	}
	
	public String getLastName(){ return m_lastName; }
	public String getFirstName() { return m_firstName; }
	public int getAge() { return m_age; }
	public float getGpa() { return m_gpa; }
	
	public int compare(Student a, Student b)
	{
		if(!(a.getLastName()).equals(b.getLastName()))
		{
			return (a.getLastName()).compareTo(b.getLastName());
		}
		else
		{
			return (a.getFirstName()).compareTo(b.getFirstName());
		}
	}
	
	public int compareTo(Student b)
	{
		if(!(getLastName()).equals(b.getLastName()))
		{
			return (getLastName()).compareTo(b.getLastName());
		}
		else
		{
			return (getFirstName()).compareTo(b.getFirstName());
		}
	}

}
