import java.lang.invoke.MethodHandles;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.console.ConsoleLauncher;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
public class P2Tests {


// TODO: Add test methods with the @Test annotation for each role here

	//Data Wrangler JUnit 5 tests
	//@Test
	
	public static void wranglerTest1() {
		StudentDataLoader s = new StudentDataLoader();
		LinkedList<StudentData> students;
		try {
			students = s.loadStudents("students.txt");
			assertEquals(10, students.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public static void wranglerTest2() {
		File f = new File("students.txt");
		assertNotNull(f);
	}
	

	//Back End Developer JUnit 5 tests
	

	//Front End Developer JUnit 5 tests  
	/*
	 * Not entirely sure we will have any. Our front end developer dropped the class, and we are waiting
	 * on a response from CP blue team's front end developer on whether or not he will be sharing his code
	 * with us.
	 */


	// Integration Manager JUnit 5 tests
	
	/*
	 *Author: Noa Figenblat 
	 *Team role: Integration Manager
	 */
	

	@Test
	public static void IntegrationManager_TestDataWrangler(){
		StudentData student = new StudentData("Test", 300, 2.4, "01/02/03", "Sophomore");
		//Testing getName()
		assertEquals("Test", student.getName());
		//Testing getID()
		assertEquals(300, student.getID());
		//Testing getGPA()
		assertEquals(2.4, student.getGPA());
		//Testing getBirthday()
		assertEquals("01/02/03", student.getBirthday());
		//Testing getYear()
		assertEquals("Sophomore", student.getYear());
	}

	@Test
	public static void IntegrationManager_TestBackEnd(){
		StudentBackEnd imTest = new StudentBackEnd();
		StudentData student1 = new StudentData("Test 2", 201, 5.0, "02/03/04", "Freshman");
		imTest.addStudent(student1);
		System.out.println(imTest.tree.root);
		assertEquals(imTest.tree.root, student1);
		
	}
/*
	@Test
	public void IntegrationManager_TestFrontEnd(){
	}
*/


  public static void main(String[] args) {
	  
    String className = MethodHandles.lookup().lookupClass().getName();
    String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
    String[] arguments = new String[] {
      "-cp",
      classPath,
      "--include-classname=.*",
      "--select-class=" + className };
    ConsoleLauncher.main(arguments);
    

    /*
     *Integration manager:
     * 		- Run all tests from main method!
     **/
    wranglerTest1();
    wranglerTest2();
    IntegrationManager_TestDataWrangler();
    IntegrationManager_TestBackEnd();
  }

}
