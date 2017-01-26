import java.io.File;
import java.io.FileNotFoundException;
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
				// Parse text from file
				lastName = src.next();
				firstName = src.next();
				numAge = src.nextInt();
				numGpa = src.nextFloat();
				
				// Store data inside of student object
				tempStdt = new Student();
				tempStdt.setData(lastName, firstName, numAge, numGpa);
				
				// Add student object to students list
				students.add(tempStdt);
			}
			
			// Sort students list
			Collections.sort(students);
			
			// Print sorted students list
			for( Student s : students )
			{
				System.out.println(s.age + " " + s.gpa + " " + s.firstName + " " + s.lastName);
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.print("main: Oops, FileNotFoundException caught");
		}
		
	}

}

