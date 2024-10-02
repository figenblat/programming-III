import static org.junit.jupiter.api.Assertions.*;
import java.lang.invoke.MethodHandles;
import org.junit.platform.console.ConsoleLauncher;
import org.junit.jupiter.api.Test;

public class UWCampusMapTests {

	//frontend put your tests here
	
	/*
	 * Front End Test #1
	 * Testing: 2.Access information on a building
	 * @author Noa Figenblat
	 */
	@Test
	public void frontEndTest1() {
		BuildingFrontEnd ui = new BuildingFrontEnd();
		BuildingBackEnd engine = new BuildingBackEnd();
		TextUITester test1 = new TextUITester("2\n4\nN\n6\n");
		
		boolean correct1 = false;
		
		ui.run(engine);
		
		String actual1 = test1.checkOutput();
		
		if(actual1.startsWith("Please select an action from the following list (by typing 1, 2, etc):") &&
				actual1.contains("Building information on Bascom Hall:")) {
			correct1 = true;
		}
		
		assertEquals(correct1, true);
		
		
	}
	
	/*
	 * Front End Test #2
	 * Testing: 3.Enter a starting location/destination, and get the shortest path
	 * @author Noa Figenblat
	 */
	
	@Test
	public void frontEndTest2() {
		BuildingFrontEnd ui = new BuildingFrontEnd();
		BuildingBackEnd engine = new BuildingBackEnd();
		TextUITester test2 = new TextUITester("3\n1\n2\n6\n");
		
		boolean correct2 = false;
		
		ui.run(engine);
		
		String actual2 = test2.checkOutput();
		
		if(actual2.startsWith("Please select an action from the following list (by typing 1, 2, etc):") && actual2.contains("The shortest path is:")) {
			correct2 = true;
		}
		
		assertEquals(correct2, true);
		
	}
	
	/*
	 * Front End Test #3
	 * Testing: 4.Enter a starting location/destination, and get the distance through the shortest path
	 * @author Noa Figenblat
	 */
	@Test
	public void frontEndTest3() {
		BuildingFrontEnd ui = new BuildingFrontEnd();
		BuildingBackEnd engine = new BuildingBackEnd();
		TextUITester test3 = new TextUITester("4\n1\n12\n6\n");
		
		boolean correct3 = false;
		
		ui.run(engine);
		
		String actual3 = test3.checkOutput();
		
		if(actual3.startsWith("Please select an action from the following list (by typing 1, 2, etc):") &&
				actual3.contains("The distance from Engineering Hall to Moss Humanities through the shortest path is: ")) {
			correct3 = true;
		}
		
		assertEquals(correct3, true);
		
	}
	
	/*
	 * Front End Test #4
	 * Testing: 5. Get the estimated travel time from a starting location to a destination
	 * @author Noa Figenblat
	 */
	@Test
	public void frontEndTest4() {
		BuildingFrontEnd ui = new BuildingFrontEnd();
		BuildingBackEnd engine = new BuildingBackEnd();
		TextUITester test4 = new TextUITester("5\n1\n2\n6\n");
		
		boolean correct4 = false;
		
		ui.run(engine);
		
		String actual4 = test4.checkOutput();
		
		if(actual4.startsWith("Please select an action from the following list (by typing 1, 2, etc):") &&
				actual4.contains("The expected travel time is approximately: ")) {
			correct4 = true;
		}
		
		assertEquals(correct4, true);
		
	}
	
	/*
	 * Front End Test #5
	 * Testing: 6.Quit
	 * @author Noa Figenblat
	 */
	@Test
	public void frontEndTest5() {
		BuildingFrontEnd ui = new BuildingFrontEnd();
		BuildingBackEnd engine = new BuildingBackEnd();
		TextUITester test5 = new TextUITester("6\n");
		
		boolean correct5 = false;
		
		ui.run(engine);
		
		String actual5 = test5.checkOutput();
		
		if(actual5.startsWith("Please select an action from the following list (by typing 1, 2, etc):") &&
				actual5.contains("Thanks for using UW Campus Map!")) {
			correct5 = true;
		}
		
		assertEquals(correct5, true);
		
	}





	//backend put your tests here
	






	//wrangler put your tests here
	





	//integration manager put your tests here
	
	
	public static void main(String[] args) {
	    String className = MethodHandles.lookup().lookupClass().getName();
	    String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
	    String[] arguments = new String[] {
	      "-cp",
	      classPath,
	      "--include-classname=.*",
	      "--select-class=" + className };
	    ConsoleLauncher.main(arguments);
	    
	  }
	  

}




