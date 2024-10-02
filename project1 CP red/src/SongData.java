// --== CS400 Project One File Header ==--
// Name: Noa Figenblat
// Email: figenblat@wisc.edu
// Team: red
// Group: CP
// TA: Evan Wireman
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

// interface (implemented with proposal)

interface SongDataInterface {
	public String getTitle();

	public String getArtist();

	public int getYearPublished();
}

// public class (implemented primarily in final app week)

public class SongData implements SongDataInterface {
	private String title;
	private String artist;
	private int yearPublished;

	public SongData(String title, String artist, int yearPublished) {
		this.title = title;
		this.artist = artist;
		this.yearPublished = yearPublished;
	}

	@Override
	public String getTitle() {
		return title;

	}

	@Override
	public String getArtist() {
		return artist;
	}

	@Override
	public int getYearPublished() {
		return yearPublished;
	}

}

class SongDataPlaceholderA implements SongDataInterface {
	public String getTitle() {
		return "Song A Vowel";
	}

	public String getArtist() {
		return "Artist X";
	}

	public int getYearPublished() {
		return 1900;
	}
}

class SongDataPlaceholderB implements SongDataInterface {
	public String getTitle() {
		return "Song B Consonant";
	}

	public String getArtist() {
		return "Artist Y";
	}

	public int getYearPublished() {
		return 2000;
	}
}

class SongDataPlaceholderC implements SongDataInterface {
	public String getTitle() {
		return "Song C Consonant";
	}

	public String getArtist() {
		return "Artist X";
	}

	public int getYearPublished() {
		return 2021;
	}
}
