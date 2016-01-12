package a00838629.assignment.dao;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import a00838629.assignment.data.Student;
import a00838629.assignment.data.StudentMarks;
import a00838629.assignment.ui.UIDisplay;
import exceptions.DataInputException;

public class StudentDAO {

	public static Student[] readData(String filename)
			throws FileNotFoundException, DataInputException {

		Student[] students = new Student[3];
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File(filename));
		for (int i = 0; i < students.length; i++) {
			String lineData = scanner.nextLine();
			System.out.println(lineData);
			String[] studentData = lineData.split("\\|");
			
			if(studentData.length != 6){
				throw new DataInputException("Oh no");
			}
			try{
			students[i] = new Student(studentData[0], studentData[1],
					studentData[2]);
			students[i].setTheMarks(new StudentMarks(Double
					.parseDouble(studentData[3]), Double
					.parseDouble(studentData[4]), Double
					.parseDouble(studentData[5])));
			}catch(Exception e){
				throw new DataInputException("Oh yes");
			}
		}
		return students;
	}	
		
	

	public static void writeData(Student[] students, String filename)
			throws FileNotFoundException {

		PrintWriter output = new PrintWriter(new File(filename));

		for (Student student : students) {
			UIDisplay.display(student);
			output.print(student.getFullName() + ", " + student.getStudentID());
			output.print(" - Quizzes: " + student.getTheMarks().getQuizzes());
			output.print(", Assignment: "
					+ student.getTheMarks().getAssignments());
			output.println(", Exams: " + student.getTheMarks().getExams());
		}
		output.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static Student[] readData_ver2(String filename)
			throws FileNotFoundException {

		Student[] students = new Student[3];
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File(filename));

		while (scanner.hasNext()) {
			// String lineData = scanner.nextLine();
			// System.out.println(lineData);
			// String[] studentData = lineData.split("\\|");
			for (int i = 0; i < students.length; i++) {
				students[i] = new Student(scanner.next(), scanner.next(),
						scanner.next());
				students[i].setTheMarks(new StudentMarks(scanner.nextDouble(),
											scanner.nextDouble(), 
											scanner.nextDouble()));
			}

		}

		return students;
	}

}
