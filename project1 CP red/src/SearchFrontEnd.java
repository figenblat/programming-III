import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

// interface (implemented with proposal)

interface SearchFrontEndInterface {
  /**
   * @param searchEngine allows user to call methods from the backend to be used in the frontend
   */
  public void run(SearchBackEndInterface searchEngine);

  void run(SearchBackEndPlaceholder searchEngine);

  // Here is a sample of the minimal set of options that
  // this front end will support:
  // SongSearch Command Menu:
  // 1. Insert New Song into Database
  // 2. Search For Song Titles by Words in those Title
  // 3. Search For Artists by Words in their Song Titles
  // 4. Display Years of Songs with Word in Title as Histogram
  // 5. Quit
  public void insertSong(SearchBackEndPlaceholder searchEngine); // references backend methods

  public void search_Title(SearchBackEndPlaceholder searchEngine);

  public void search_Artist(SearchBackEndPlaceholder searchEngine);

  public void years_Histogram(SearchBackEndPlaceholder searchEngine);


}

// public class (implemented primarilly in final app week)


/**
 * @author matth
 * 
 */
public class SearchFrontEnd implements SearchFrontEndInterface {
  Scanner word = new Scanner(System.in);

  /**
   * this is what is being displayed to the user runs a loop that will redisplay the options after
   * any method is ran and ends when the quit method is called
   */
  @Override
  public void run(SearchBackEndPlaceholder searchEngine) {
    // runs the options available to the user in order to get different data from the set
    boolean status = true;
    String option = // display being shown to user
        "select a number from the following: \n1.insert a Song \n2.Search For Song Titles by Words in those Title \n3.search for Artist by words in song \n4.Display Years of Songs with Word in Title as Histogram \n5. quit \n";
    while (status = true) { // runs a infinite loop until the quit option is called
      System.out.println(option);
      String choice = word.nextLine();
      if (choice.equals("1")) { // runs the insert method when called
        insertSong(searchEngine);
      } else if (choice.equals("2")) { // runs the search_Title method
        search_Title(searchEngine);
      } else if (choice.equals("3")) { // runs the search_Artist method
        search_Artist(searchEngine);
      } else if (choice.equals("4")) { // runs the histogram
        years_Histogram(searchEngine);
      } else if (choice.equals("5")) { // runs the quit method
        quit();
        break; // breaks the loop once the quit method is called
      } else {
        System.out.println("you didn't select a valid option try again"); // displays message if a
                                                                          // invalid option is
                                                                          // called
      }
    }
  }

  /**
   * this method allows the user to enter the title,Artist and year in order to add a valid SongData
   * type into the data set
   */
  @Override
  public void insertSong(SearchBackEndPlaceholder searchEngine) {
    System.out.println("Enter the title"); // gets the name of the song
    String title = word.nextLine();
    System.out.println("Enter name of Artist"); // gets the Artist
    String artist = word.nextLine();
    System.out.println("Enter year it was made"); // gets the year
    int year = word.nextInt();
    SongData song = new SongData(title, artist, year); // puts the inputs for these values into a
                                                       // new songData type
    searchEngine.addSong(song); // adds the songData type to the hashtable
  }



  /**
   * search_Title method uses backend software to find a list of titles of songs that contain the
   * word given by the user
   */
  @Override
  public void search_Title(SearchBackEndPlaceholder searchEngine) {
    System.out.println("Enter a word in the title of the song");
    String charc = word.nextLine(); // gets the word from user
    List<String> titles = searchEngine.findTitles(charc); // using backend software creates a list
                                                          // of titles with word given
    if (titles.size() == 0) { // displays this message if no songs were found
      System.out.println("no songs");
      return;
    }
    for (int i = 0; i < titles.size(); i++) { // prints out the list of songs one by one
      System.out.println(titles.get(i));
    }
  }


  /**
   * Allows the user to find the name of the artist based on words in the title of the song
   */
  @Override
  public void search_Artist(SearchBackEndPlaceholder searchEngine) {
    System.out.println("Enter words in the song title for Arist name");
    String charc = word.nextLine(); // gets the word in title of song
    List<String> artists = searchEngine.findArtists(charc); // creates a list of all the artist with
                                                            // that word in their title
    if (artists.size() == 0) { // displays this if no artist are found
      System.out.println("No artists");
      return;
    }
    for (int i = 0; i < artists.size(); i++) { // displays artist names one by one
      System.out.println(artists.get(i));
    }
  }



  /**
   * this creates a graph with each year and displays how many times a song with the given word is
   * found if the word is found in at least one song for that year
   */
  @Override
  public void years_Histogram(SearchBackEndPlaceholder searchEngine) {
    System.out.println("enter a word in the title");
    String charc = word.nextLine(); // gets the word in the title
    for (int i = 1900; i <= 2021; i++) { // loops from the year 1900 to present
      if (searchEngine.findNumberOfSongsInYear(charc, i) > 0) { // if the count for songs is 1 or
                                                                // more graphs it in the histogram
        System.out.println(
            "year: " + i + ": " + "I".repeat(searchEngine.findNumberOfSongsInYear(charc, i))); // displays
                                                                                               // the
                                                                                               // year
                                                                                               // and
                                                                                               // a
                                                                                               // graph
                                                                                               // of
                                                                                               // where
                                                                                               // each
                                                                                               // "I"
                                                                                               // represents
                                                                                               // one
                                                                                               // instance
      }
    }
  }

  /**
   * created to end the display message and finish the options called
   */
  public void quit() {
    System.out.println("you have finished calling your methods"); // displays this to show you are
                                                                  // done
  }

  @Override
  public void run(SearchBackEndInterface searchEngine) {
    // TODO Auto-generated method stub

  }



}

