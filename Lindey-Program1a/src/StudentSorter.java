import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * StudentSorter.java
 * Author: Jacob Lindey
 * Project: Lindey-Program1a
 * Start Date: 1/25/2017
 */

public class StudentSorter {
	
	public static void main(String[] args) {
		
		int numAge;			// holder for entry age
		float numGpa;		// holder for entry gpa
		String lastName;	// holder for entry lastName
		String firstName;	// holder for entry firstName
		
		Scanner src; 		// File Scanner
		Student tempStdt;	// temporary holder for Student info
		
		List<Student> students;	// Array of student info
		
		students = new ArrayList<Student>();	
				
		try
		{
			src = new Scanner(new File ("data.txt")).useDelimiter(",|\r\n|\n");
			
			while(src.hasNextLine())
			{
				lastName = src.next();
				firstName = src.next();
				numAge = src.nextInt();
				numGpa = src.nextFloat();
				
				tempStdt = new Student();
				tempStdt.setData(lastName, firstName, numAge, numGpa);
				
				students.add(tempStdt);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.print("main: Oops, FileNotFoundException caught");
		}
		catch(IOException e)
		{
			System.out.print("main: Oops, IOException caught");
		}
		
		Collections.sort(students);
		
		for( Student s : students )
		{
			System.out.println(s.getAge() + " " + s.getGpa() + " " + s.getFirstName() + " " + s.getLastName());
		} 

	}

}

