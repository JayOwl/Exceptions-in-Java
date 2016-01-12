package a00838629.assignment;
import java.io.FileNotFoundException;

import a00838629.assignment.dao.StudentDAO;
import a00838629.assignment.data.Student;
import exceptions.DataInputException;

public class Assignment3 {	
	public static void main(String[] args) throws FileNotFoundException, DataInputException{
		new Assignment3().test();
	}		
	
	public void test() throws FileNotFoundException, DataInputException{		
		Student[] students = StudentDAO.readData("student_data_ver2.txt");		
		StudentDAO.writeData(students, "output.txt");		
	}
}


