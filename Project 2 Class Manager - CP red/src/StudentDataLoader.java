import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.LinkedList;
/**
 *Represents a java class that loads a number of students from a txt file, where elements are singly spaced 
 *and the amount of students total is listed as an integer at the top of the file
 **/

public class StudentDataLoader {
    LinkedList<StudentData> students = new LinkedList<>();

    public LinkedList<StudentData> loadStudents(String fileName) throws FileNotFoundException{
        InputStream input = StudentDataLoader.class.getResourceAsStream(fileName);
        Scanner sc = new Scanner(input);
        int numOfStudents = sc.nextInt();
        for(int i = 0; i < numOfStudents; i++) {
            students.add(new StudentData(sc.next(), sc.nextInt(), sc.nextDouble(), sc.next(), sc.next()));
        }
        sc.close();  //closes the scanner
        return students;
    }
}