// --== CS400 Project One File Header ==--
// Name: Noa Figenblat
// Email: figenblat@wisc.edu
// Team: red
// Group: CP
// TA: Evan Wireman
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;

// interface (implemented with proposal)

interface SongLoaderInterface {
	public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;

	public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException;
}

// public class (implemented primarily in final app week)

public class SongLoader implements SongLoaderInterface {

	private static List<SongDataInterface> list = new ArrayList();
	private static int indexTitle;
	private static int indexArtist;
	private static int indexYear;

	@Override
	public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
		System.out.println("=================================================");
		System.out.println("in loadFile(String csvFilePath) method");

		Path pathToFile = Paths.get(csvFilePath);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.ISO_8859_1)) {

			// read the first line from the csv file
			String headerLine = br.readLine();
			headerArray(headerLine);

			String line = br.readLine();

			// loop until all lines are read
			while (line != null) {

				// splitting the csv file on each line using a comma as delimiter

				String[] songDetails = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				String regex = "\\d+";

				// looping through each element in the line being read
				// if it does not end w a quote, concatenates it with the next index and moves
				// elements above down an index/changes array size by -1

				for (int i = 0; i < songDetails.length; i++) {

					if (i == indexYear && songDetails[i].matches(regex) == false) {
						String[] splittingYear = new String[2];
						String yearSplit = songDetails[i].toString();
						splittingYear = yearSplit.split(",");

						String[] front = new String[indexYear];
						String[] end = new String[songDetails.length - indexYear];

						for (int x = 0; x < front.length; x++) {
							front[x] = songDetails[x];

						}
						for (int y = end.length - 1; y > 0; y--) {
							end[y] = songDetails[front.length + y];

						}

						String[] temp = new String[songDetails.length + 1];
						int index = 1;

						for (int z = 0; z < temp.length; z++) {
							if (z < indexYear) {
								temp[z] = front[z];

							} else if (z == indexYear) {
								temp[z] = splittingYear[0];

							} else if (z == indexYear + 1) {
								temp[z] = splittingYear[1];
							} else {
								temp[z] = end[index];
								index++;
							}
						}

					}

				}

				for (int i = 0; i < songDetails.length; i++) {
					songDetails[i] = songDetails[i].replaceAll("\"", "");

				}

				SongData songInfo = createSongs(songDetails);

				// adding songs into the ArrayList
				list.add(songInfo);

				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();

			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("loadFiles() has finished running");
		System.out.println("=================================================");
		return list;
	}

	@Override
	public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
		System.out.println("=================================================");
		System.out.println("in loadAllFilesInDirectory() method");
		int files = 0;

		Path pathToDir = Paths.get(directoryPath);
		if (!Files.isDirectory(pathToDir)) {
			throw new IllegalArgumentException("the path does not lead to a directory!");
		}

		List<String> filesWithCSV = new ArrayList<>();

		try (Stream<Path> walk = Files.walk(pathToDir)) {
			filesWithCSV = walk.filter(path -> path.toString().endsWith(".csv")).map(x -> x.toString())
					.collect(Collectors.toList());
			for (int i = 0; i < filesWithCSV.size(); i++) {
				++files;
				System.out.println(
						"Taking files in the directory that end in .csv and sending them to loadFile(): now loading file number "
								+ files);
				list = this.loadFile(filesWithCSV.get(i));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("loadAllFilesInDirectory() has finished running.");
		System.out.println("=================================================");
		return list;

	}

	/*
	 * method to take the elements from the csv and create SongData objects from
	 * them
	 */
	private static SongData createSongs(String[] songDetails) {
		String regex = "\\d+";

		String title = songDetails[indexTitle];
		String artist = songDetails[indexArtist];
		songDetails[indexYear].trim();

		if (songDetails[indexYear].matches(regex)) {
			int yearPublished = Integer.parseInt(songDetails[indexYear]);
			return new SongData(title, artist, yearPublished);
		}

		return null;

	}

	/*
	 * creates an array of just the header values
	 * 
	 * @param String headerLine- the first row of the csv being fed by the buffered
	 * reader
	 */
	private static void headerArray(String headerLine) {

		// splitting the csv file on each line using a comma as delimiter
		String[] getIndex = headerLine.split(",");

		// looping through each element in the line being read
		// if it does not end w a quote, concatenates it with the next index and moves
		// elements above down an index/changes array size by -1
		for (int i = 0; i < getIndex.length; i++) {

			if (getIndex[i] != null && i < getIndex.length - 1) {
				if (getIndex[i].startsWith("\"") && !getIndex[i].endsWith("\"") && !getIndex[i].endsWith("0")
						&& !getIndex[i].endsWith("1") && !getIndex[i].endsWith("2") && !getIndex[i].endsWith("3")
						&& !getIndex[i].endsWith("4") && !getIndex[i].endsWith("5") && !getIndex[i].endsWith("6")
						&& !getIndex[i].endsWith("7") && !getIndex[i].endsWith("8") && !getIndex[i].endsWith("9")) {
					getIndex[i] = getIndex[i] + "," + getIndex[i + 1];
					int indexRemoving = i + 1;

					String[] temp = new String[getIndex.length - 1];

					// copying array into smaller array without the element that is being removed
					for (int j = 0, k = 0; j < getIndex.length; j++) {
						if (j != indexRemoving) {
							temp[k++] = getIndex[j];

						}
					}

					// put the temp array back into the songDetails array
					getIndex = new String[temp.length];

					for (int f = 0; f < getIndex.length; f++) {
						getIndex[f] = temp[f];

					}

				}
			}
		}
		for (int i = 0; i < getIndex.length; i++) {
			getIndex[i] = getIndex[i].replaceAll("\"", "");
			location(getIndex);

		}

	}

	/*
	 * method to determine at which index of the array the items we are looking for
	 * are
	 * 
	 * @param String [] getIndex - the array created in the method headerArray()
	 */
	public static void location(String[] getIndex) {
		for (int i = 0; i < getIndex.length; i++) {
			if (getIndex[i].equalsIgnoreCase("title")) {
				indexTitle = i;
			}
			if (getIndex[i].equalsIgnoreCase("artist")) {
				indexArtist = i;
			}
			if (getIndex[i].equalsIgnoreCase("year") || getIndex[i].equalsIgnoreCase("released")) {
				indexYear = i;

			}

		}

	}

	// placeholder(s) (implemented with proposal, and possibly added to later)
	class SongLoaderPlaceholder implements SongLoaderInterface {
		public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
			List<SongDataInterface> list = new LinkedList<>();
			list.add(new SongDataPlaceholderA());
			list.add(new SongDataPlaceholderB());
			return list;
		}

		public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
			List<SongDataInterface> list = new LinkedList<>();
			list.add(new SongDataPlaceholderA());
			list.add(new SongDataPlaceholderB());
			list.add(new SongDataPlaceholderC());
			return list;
		}
	}
}
