// --== CS400 Project Two File Header ==--
// Name: Noa Figenblat
// Email: figenblat@wisc.edu
// Team: red
// Group: CP
// TA: Evan Wireman
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;
import java.util.List;

public class ClassManagerApp {
	 public static void main(String[] args) throws Exception {
	        System.out.println("Welcome to Class Manager!");
	        List<StudentData> students = new StudentDataLoader().loadStudents("students.txt");
	        StudentBackEnd engine = new StudentBackEnd();
	        for(StudentData student : students) engine.addStudent(student);
	        StudentFrontEndInterface ui = new StudentFrontEnd();
	        ui.run(engine);
	       
	       
	    }

}
