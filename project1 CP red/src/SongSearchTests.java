import java.io.FileNotFoundException;

public class SongSearchTests {

	public static void main(String[] args) throws Exception {
		// Run All Tests
		dataWrangler_test1();
		dataWrangler_test2();
		dataWrangler_test3();
	}

	// Data Wrangler Code Tests

	// test 1 - testing loadFiles
	public static boolean dataWrangler_test1() {
		SongLoader test1 = new SongLoader();
		SongLoader test2 = new SongLoader();
		String csvFilePath = "./Top500Songs.csv";

		boolean top10s = false;

		try {

			if (test1.loadFile(csvFilePath).size() == 500) {
				top10s = true;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (top10s == true) {
			System.out.println("loadFiles() is working");

		} else {
			System.out.println("loadFiles() fails");
		}

		return top10s;

	}

	// test 2 - testing loadAllFilesInDirectory
	public static boolean dataWrangler_test2() {
		SongLoader test3 = new SongLoader();
		String pathToDir = "./";

		boolean loads = false;
		try {
			if (test3.loadAllFilesInDirectory(pathToDir).size() == 1103) {
				loads = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (loads = true) {
			System.out.println("loadAllFilesInDirectory() is working");
		} else {
			System.out.println("loadAllFilesInDirectory() fails");
		}

		return loads;
	}

	// test 3 - testing SongData class
	public static boolean dataWrangler_test3() {

		String title = "Hello";
		String artist = "Adele";
		int yearPublished = 2015;
		SongData test3 = new SongData(title, artist, yearPublished);

		if (test3.getTitle() == "Hello" && test3.getArtist() == "Adele" && test3.getYearPublished() == 2015) {
			System.out.println("SongData is working.");
			return true;
		} else {
			System.out.println("SongData failed.");
			return false;
		}
	}

	// Back End Developer Tests

	// Front End Developer Tests
	
	public static boolean FrontEndDeveloper_TestInsertSong_And_search_Title(){
	    TextUITester test1 = new TextUITester("1\nSong C Consonant\nArtist X\n2021\2\nC\n5\n");
	    String output = test1.checkOutput();
	    if (output.contains("Song C Consonant"){
		    return true;
	    }
	    return false;
    }
    public static boolean FrontEndDeveloper_Testsearch_Artist(){
   	    TextUITester test2 = new TextUITester("1\nSong C Consonant\nArtist X\n2021\3\nC\n5\n");
            String output = test1.checkOutput();
            if (output.contains("Artist X"){
                    return true;
            }
            return false;
    }
    public static boolean FrontEndDeveloper_Histogram(){
            TextUITester test2 = new TextUITester("1\nSong C Consonant\nArtist X\n2021\4\nC\n5\n");
            String output = test1.checkOutput();
            if (output.contains("year: 2021: I"){
                    return true;
            }
            return false;
    }



	// Integration Manager Tests

}