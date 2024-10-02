// --== CS400 Project Three File Header ==--
// Name: Noa Figenblat
// Email: figenblat@wisc.edu
// Team: red
// Group: CP
// TA: Evan Wireman
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.List;
import java.util.Scanner;


//interface (implemented with proposal)
interface BuildingFrontEndInterface{

	//runs the program, including the main menu
	public void run(BuildingBackEnd engine);

	//UW-Madison Campus Map Command Menu 
	//1.View the UW Campus Map
	//2.Access information on a building
	//3.Enter a starting location/destination, and get the shortest path
	//4.Enter a starting location/destination, and get the distance through the shortest path
	//5.Enter a starting location/destination, and get the estimated travel time
	//6.Quit

	// method called upon in other methods for the user to input the starting location and the destination
	public void startAndDestination();

	//1.View the UW Campus Map
	public void viewMap();

	//2.Access specific building information
	public void buildingInfo();

	//3.Get the shortest path from a starting location to a destination
	public void shortPath(BuildingBackEnd engine);

	//4.Get the estimated travel time from a starting location to a destination
	public void travelTime(BuildingBackEnd engine);

	//5.Get the distance from a starting location to a destination through the shortest path
	public void cost(BuildingBackEnd engine);

	//6.Quit
	public void quit();


}

//public class (implemented primarily in final app week)

/*
 * @author Noa Figenblat
 */
public class BuildingFrontEnd implements BuildingFrontEndInterface{

	Scanner sc = new Scanner(System.in);

	String start;
	String dest;
	int distance;
	int time;
	List<String> path;

	/*
	 * This method runs the entire front end 
	 * It displays the main menu, and redirects the user to the section of the application they choose 
	 * Loop redisplays the menu options until the user selects 6 to quit the application 
	 */
	@Override
	public void run(BuildingBackEnd engine) {

		//To signify whether user has chosen to quit 
		boolean status = true;

		//main menu
		String prompt = "Please select an action from the following list (by typing 1, 2, etc):";
		String option1 = "1. View the Campus Map";
		String option2 = "2. Access information on a building";
		String option3 = "3. Get the shortest path from a starting location to a destination";
		String option4 = "4. Get the distance from a starting location to a destination";
		String option5 = "5. Get the estimated travel time from a starting location to a destination";
		String quit = "6. Quit";

		while(status == true) {
			//Printing the command menu 
			System.out.println(prompt);
			System.out.println(option1);
			System.out.println(option2);
			System.out.println(option3);
			System.out.println(option4);
			System.out.println(option5);
			System.out.println(quit);

			int userChoice = sc.nextInt();

			if (userChoice == 1) {
				viewMap();
			}
			else if(userChoice == 2) {
				buildingInfo();
			}
			else if (userChoice == 3) {
				shortPath(engine);
			}
			else if (userChoice == 4) {
				cost(engine);
			}
			else if (userChoice == 5) {
				travelTime(engine);
			}
			else if (userChoice == 6) {
				quit();
				status = false;
			}
			else {
				System.out.println("Error: Please select a valid option from the command menu.");
			}

		}

	}

	/*
	 * Method which allows the user to see an approximate visual map of the UW buildings included in this application
	 */
	public void viewMap() {
		System.out.println("-------------------------------------------UW Campus Map-------------------------------------------");
		System.out.println("* Bradley Residence Hall");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("				* Bascom Hall");
		System.out.println("			* Van Vleck Hall");
		System.out.println();
		System.out.println("		* Chamberlin Hall	*Chadbourne Hall  *Mosse Humanities");
		System.out.println("	 *De Luca Biochem");
		System.out.println();
		System.out.println();
		System.out.println("									* Gordon Dining");
		System.out.println();
		System.out.println();
		System.out.println("							*Ogg Hall	* Nicholas Center");
		System.out.println("		  * Engineering Hall");
		System.out.println();
		System.out.println("	* Camp Randall");
		System.out.println("		*Shell Rec");
		System.out.println("---------------------------------------------------------------------------------------------------");
	}

	/*
	 * Method which is used to set a start location and a destination by the user
	 * called upon in shortPath(), travelTime(), and cost()
	 */
	@Override
	public void startAndDestination() {

		boolean startValid = false;
		boolean destValid = false;

		// prompting user to set a starting location 
		while(startValid == false) {
			System.out.println("Please select a start location from the following list. Enter your selection like \"1\" or \"2\": ");

			System.out.println("1) Engineering Hall");
			System.out.println("2) Van Vleck Hall");
			System.out.println("3) Nicholas Center");
			System.out.println("4) Bascom Hall");
			System.out.println("5) Bradley Residence Hall");
			System.out.println("6) Camp Randall");
			System.out.println("7) Chamberlin Hall");
			System.out.println("8) Gordon Dining");
			System.out.println("9) Ogg Hall");
			System.out.println("10) Witte Hall");
			System.out.println("11) ChadBourne Hall");
			System.out.println("12) Moss Humanities");
			System.out.println("13) Shell Rec");
			System.out.println("14) De Luca Biochem");


			int selection1 = sc.nextInt();

			if(selection1 == 1 || selection1 == 2 || selection1 == 3 || selection1 == 4 || selection1 == 5 || selection1 == 6 || selection1 == 7 || selection1 == 8 
					|| selection1 == 9 || selection1 == 10 || selection1 == 11 || selection1 == 12 || selection1 == 13 || selection1 == 14) {
				startValid = true;
				if( selection1 == 1) {
					start = "Engineering Hall";
				}
				else if(selection1 == 2) {
					start = "Van Vleck Hall";
				}
				else if(selection1 == 3) {
					start = "Nicholas Center";
				}
				else if(selection1 == 4) {
					start = "Bascom Hall";
				}
				else if(selection1 == 5) {
					start = "Bradley Residence Hall";
				}
				else if(selection1 == 6) {
					start = "Camp Randall";
				}
				else if(selection1 == 7) {
					start = "Chamberlin Hall";
				}
				else if(selection1 == 8) {
					start = "Gordon Dining";
				}
				else if(selection1 == 9) {
					start = "Ogg Hall";
				}
				else if(selection1 == 10) {
					start = "Witte Hall";
				}
				else if(selection1 == 11) {
					start = "ChadBourne Hall";
				}
				else if(selection1 == 12) {
					start = "Moss Humanities";
				}
				else if(selection1 == 13) {
					start = "Shell Rec";
				}
				else {
					start = "De Luca Biochem";
				}
				System.out.println(start + " has been set as your starting location/building.");

			}
			else {
				startValid = false;
				System.out.println("Invalid selection!");
			}
		}

		//Prompting user to set a destination

		while(destValid == false) {

			System.out.println("Please select a destination from the following list. Enter your selection like \"1\" or \"2\": ");

			System.out.println("1) Engineering Hall");
			System.out.println("2) Van Vleck Hall");
			System.out.println("3) Nicholas Center");
			System.out.println("4) Bascom Hall");
			System.out.println("5) Bradley Residence Hall");
			System.out.println("6) Camp Randall");
			System.out.println("7) Chamberlin Hall");
			System.out.println("8) Gordon Dining");
			System.out.println("9) Ogg Hall");
			System.out.println("10) Witte Hall");
			System.out.println("11) ChadBourne Hall");
			System.out.println("12) Moss Humanities");
			System.out.println("13) Shell Rec");
			System.out.println("14) De Luca Biochem");

			int selection2 = sc.nextInt();

			if(selection2 == 1 || selection2 == 2 || selection2 == 3 || selection2 == 4 || selection2 == 5 || selection2 == 6 || selection2 == 7 || selection2 == 8 
					|| selection2 == 9 || selection2 == 10 || selection2 == 11 || selection2 == 12 || selection2 == 13 || selection2 == 14) {
				destValid = true;
				if( selection2 == 1) {
					dest = "Engineering Hall";
				}
				else if(selection2 == 2) {
					dest = "Van Vleck Hall";
				}
				else if(selection2 == 3) {
					dest = "Nicholas Center";
				}
				else if(selection2 == 4) {
					dest = "Bascom Hall";
				}
				else if(selection2 == 5) {
					dest = "Bradley Residence Hall";
				}
				else if(selection2 == 6) {
					dest = "Camp Randall";
				}
				else if(selection2 == 7) {
					dest = "Chamberlin Hall";
				}
				else if(selection2 == 8) {
					dest = "Gordon Dining";
				}
				else if(selection2 == 9) {
					dest = "Ogg Hall";
				}
				else if(selection2 == 10) {
					dest = "Witte Hall";
				}
				else if(selection2 == 11) {
					dest = "ChadBourne Hall";
				}
				else if(selection2 == 12) {
					dest = "Moss Humanities";
				}
				else if(selection2 == 13) {
					dest = "Shell Rec";
				}
				else {
					dest = "De Luca Biochem";
				}
				System.out.println(dest + " has been set as your destination.");

			}
			else {
				destValid = false;
				System.out.println("Invalid selection!");
			}
		}

	}

	/*
	 * Method which allows the user to access information about each building
	 */
	@Override
	public void buildingInfo() {

		// Begin Strings of building descriptions
		String engineering = "The UW Madison Engineering Hall is located at 1415 Engineering Dr, Madison, WI 53706";
		String vleck = "The UW Madison Van Vleck Hall is located at 480 Lincoln Dr, Madison, WI 53706";
		String nick = "The UW Madison Nicholas Recreation center is located at 797 W Dayton Street, Madison, WI 53715";
		String bascom = "The UW Madison Bascom Hall is located at 500 Lincoln Dr, Madison, WI 53706";
		String bradley = "The UW Madison Bradley Residence Hall is located at 650 Elm Dr, Madison, WI 53706";
		String randall = "The UW Madison Camp Randall Stadium is located at 1440 Monroe St, Madison, WI 53711";
		String chamberlin = "The UW Madison Chamberlin Hall is located at 1150 University Ave, Madison, WI 53706";
		String gordon = "The UW Madison Gordon Dining Hall is located at 770 W Dayton St, Madison, WI 53706";
		String ogg = "The UW Madison Ogg Hall is located at 835 W Dayton St, Madison, WI 53706";
		String witte = "The UW Madison Witte Hall is located at 615 W. Johnson Street, Madison, WI 53706";
		String chad = "The UW Madison Chadbourne Hall is located at 420 N Park St, Madison, WI 53706";
		String moss = "The UW Madison Mosse Humanities is located at 455 N Park St, Madison, WI 53706";
		String shell = "The UW Madison Shell Rec is located at 1430 Monroe St, Madison, WI 53711";
		String deLuca = "The UW Madison De Luca Biochem is located at 420 Henry Mall, Madison, WI 53706";
		// End of building descriptions 


		//Beginning of prompts for user to select a building
		System.out.println("Please enter the building number of the building you would like information on from the following list: ");
		System.out.println("1) Engineering Hall");
		System.out.println("2) Van Vleck Hall");
		System.out.println("3) Nicholas Center");
		System.out.println("4) Bascom Hall");
		System.out.println("5) Bradley Residence Hall");
		System.out.println("6) Camp Randall");
		System.out.println("7) Chamberlin Hall");
		System.out.println("8) Gordon Dining");
		System.out.println("9) Ogg Hall");
		System.out.println("10) Witte Hall");
		System.out.println("11) ChadBourne Hall");
		System.out.println("12) Moss Humanities");
		System.out.println("13) Shell Rec");
		System.out.println("14) De Luca Biochem");
		//End building choice prompts

		boolean cont = true;

		// loop until user no longer wants any more building information
		while(cont == true) {
			int infoChoice = sc.nextInt();
			if(infoChoice == 1) {
				System.out.println("Building information on Engineering Hall:");
				System.out.println(engineering);

			}
			else if (infoChoice == 2) {
				System.out.println("Building information on Van Vleck Hall:");
				System.out.println(vleck);

			}
			else if (infoChoice == 3) {
				System.out.println("Building information on Nicholas Center:");
				System.out.println(nick);

			}
			else if (infoChoice == 4) {
				System.out.println("Building information on Bascom Hall:");
				System.out.println(bascom);

			}
			else if (infoChoice == 5) {
				System.out.println("Building information on Bradley Residence Hall:");
				System.out.println(bradley);

			}
			else if( infoChoice == 6) {
				System.out.println("Building information on Camp Randall:");
				System.out.println(randall);


			}
			else if(infoChoice == 7) {
				System.out.println("Building information on Chamberlin Hall:");
				System.out.println(chamberlin);
			}
			else if(infoChoice == 8) {
				System.out.println("Building information on Gordon Dining:");
				System.out.println(gordon);

			}
			else if(infoChoice == 9) {
				System.out.println("Building information on Ogg Hall:");
				System.out.println(ogg);

			}
			else if(infoChoice == 10) {
				System.out.println("Building information on Witte Hall:");
				System.out.println(witte);

			}
			else if(infoChoice == 11) {
				System.out.println("Building information on ChadBourne Hall:");
				System.out.println(chad);

			}
			else if(infoChoice == 12) {
				System.out.println("Building information on Mosse Humanities:");
				System.out.println(moss);

			}
			else if(infoChoice == 13) {
				System.out.println("Building information on Shell Rec:");
				System.out.println(shell);

			}
			else if(infoChoice == 14) {
				System.out.println("Building information on De Luca Biochem:");
				System.out.println(deLuca);

			}
			else {
				System.out.println("Invalid selection! Please try entering the building number of the building"
						+ " you would like to acess information on again: ");
			}

			// Allows the user to access the information of another building
			System.out.println("Would you like information on another building? Type \"Y\" if you would like to get information on another building or \"N\""
					+ " if you would like to return back to the main menu.");

			String again = sc.next();

			if (again.equalsIgnoreCase("y")) {
				cont = true;
			}
			else {
				cont = false;
			}

		}


	}

	/*
	 * Method which allows the user to get the shortest path by entering a start location and a destination
	 * Calls upon the startAndDestination() method to set the start and destination values
	 * Prints the shortest path as a string ie: The shortest path is: [A, B, C]
	 */
	@Override
	public void shortPath(BuildingBackEnd engine) {
		startAndDestination();
		path = engine.shortestPath(start,dest);
		System.out.println("The shortest path is: " + path.toString());
	}

	/*
	 * Method to get the distance from an entered start location to a destination through the shortest path 
	 * Calls upon the startAndDestination() method to set the start and destination values
	 * Prints the distance as a string ie: The distance from A to B through the shortest path is: 0
	 */
	@Override
	public void cost(BuildingBackEnd engine) {

		startAndDestination();
		distance = engine.getPathCost(start, dest);

		System.out.println("The distance from " + start + " to " + dest + " through the shortest path is: " + distance);
	}

	/*
	 * Method to get the estimated travel time from an entered start location to a destination
	 * Calls upon the startAndDestination() method to set the start and destination values
	 * Prints the expected travel time as a string ie: The expected travel time is approximately: 0
	 */
	@Override
	public void travelTime(BuildingBackEnd engine) {
		startAndDestination();
		distance = engine.getPathCost(start, dest);

		System.out.println("Enter your walking speed in mph. For example, enter 1: ");

		int mph = sc.nextInt();

		time = engine.getTravelTime(distance, mph);

		System.out.println("The expected travel time is approximately: " + time);

	}

	/*
	 * Method to quit the application 
	 * Displays a goodbye message and bring the method run() to an end
	 */
	@Override
	public void quit() {
		System.out.println("Thanks for using UW Campus Map!");
		sc.close();


	}

}






