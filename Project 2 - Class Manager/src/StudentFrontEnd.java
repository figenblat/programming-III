
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

// interface (implemented with proposal)

interface StudentFrontEndInterface {
  /**
   * @param searchEngine allows user to call methods from the backend to be used in the frontend
   */
  public void run(StudentBackEnd studentEngine);

  // Here is a sample of the minimal set of options that
  // this front end will support:
  // Class Manager Command Menu:
  // 1. Insert New Student
  // 2. Lookup student info using student ID
  // 3. Display current class size
  // 4. Clear all student information for a new semester
  // 5. Quit
  public void insertStudent(StudentBackEnd studentEngine); // references backend methods

  public void search_Info(StudentBackEnd studentEngine);

  public void class_Size(StudentBackEnd studentEngine);

  public void clear(StudentBackEnd studentEngine);
  
  public boolean quit();


}

// public class (implemented primarily in final app week)


/**
 * 
 * 
 */
public class StudentFrontEnd implements StudentFrontEndInterface {
	
	 Scanner word = new Scanner(System.in);
	 
	
	@Override
	public void run(StudentBackEnd studentEngine) {
		 
	    boolean status = true;
	    String option =   "select a number from the following: \n1. Insert a Student \n2. Search For Student using Student ID \n3. Get class size \n4. Clear class for a new semester \n5. quit \n";
	    while (status = true) { 
	      System.out.println(option);
	      String choice = word.nextLine();
	      if (choice.equals("1")) { 
	        insertStudent(studentEngine);
	      } else if (choice.equals("2")) { 
	        search_Info(studentEngine);
	      } else if (choice.equals("3")) { 
	        class_Size(studentEngine);
	      } else if (choice.equals("4")) {
	        clear(studentEngine);
	      } else if (choice.equals("5")) {
	        quit();
	        if(quit()==true) {
	        	break;
	        }
	      } else {
	        System.out.println("you didn't select a valid option try again"); 
	      }
	    }
	}


	@Override
	public void insertStudent(StudentBackEnd studentEngine) {
		 System.out.println("Enter the student name"); 
		    String name = word.nextLine();
		    System.out.println("Enter student ID"); 
		    int id = word.nextInt();
		    System.out.println("Enter student GPA"); 
		    double gpa = word.nextInt();
		    System.out.println("Enter student birthday");
		    String birthday = word.nextLine();
		    System.out.println("Enter student's year in school (ie: freshman, sophmore, etc)"); 
		    String year = word.nextLine();
		    
		    StudentData student = new StudentData(name, id, gpa, birthday, year); 
		    
		    studentEngine.addStudent(student);  

		
	}

	@Override
	public void search_Info(StudentBackEnd studentEngine) {
		System.out.println("Enter the student ID");
	    int idNum = word.nextInt(); 
	    String matchingStudent = studentEngine.findNames(idNum); 
	    
	    if(studentEngine.findNames(idNum) == null) { 
	    	System.out.println("No students matching that ID number, try again");
	    	return;
	    }
	    
	    System.out.println(matchingStudent);
	    		
	}

	@Override
	public void class_Size(StudentBackEnd studentEngine) {
		int classSize = 10;
	    System.out.println("Class size: " + classSize);		
	}

	@Override
	public void clear(StudentBackEnd studentEngine) {
		  System.out.println("Class emptied for a new semster. Current class size = 0.");		
	}
	
	@Override
	public boolean quit() {
		System.out.println("You are now quiting the application! If you would like to continue quitting please press \"y\" if you would like"
				+ "to continue please press \"n\"."); 
		String quit = word.next();
		if (quit == "y" || quit == "Y") {
			return true;
		}
		else {
			return false;
		}
        

	}
 


}


