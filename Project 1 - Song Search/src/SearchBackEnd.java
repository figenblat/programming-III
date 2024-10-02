import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
// interface (implemented with proposal)

interface SearchBackEndInterface {    
    public void addSong(SongDataInterface song);
    public boolean containsSong(SongDataInterface song);

    // returns list of the titles of all songs that contain the word titleWord in their song title
    public List<String> findTitles(String titleWord);

    // returns list of the artists of all songs that contain the word titleWord in their song title
    public List<String> findArtists(String titleWord);

    // returns the number of songs that contain the word titleWord in their song title, and were published in year
    public int findNumberOfSongsInYear(String titleWord, int year);
}

// public class (implemented primarilly in final app week)
public class SearchBackEnd implements SearchBackEndInterface {
    HashtableMap m = new HashtableMap();
    @Override
    @SuppressWarnings("unchecked")
    public void addSong(SongDataInterface song) {
        // TODO Auto-generated method stub
        m.put(song, song);
    }
    @Override
   @SuppressWarnings("unchecked")
    public boolean containsSong(SongDataInterface song) {
        // TODO Auto-generated method stub
        return  m.containsKey(song);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<String> findTitles(String titleWord) {
        // TODO Auto-generated method stub
        ArrayList songs = new ArrayList<String>();
        String song = "";
        for(int i = 0; i < m.getSongs().length; i++) {
            for(int j = 0; j < m.getSongs()[i].size(); j++) {
                SongData d = (SongData)m.getSongs()[i].get(j);
                song = d.getTitle();
                if(song.toLowerCase().contains(titleWord.toLowerCase())) {
                    songs.add(d.getTitle());
                }
            }
        }
        return songs;
    }
    @SuppressWarnings("unchecked")
    public List<String> findArtists(String titleWord) {
        // TODO Auto-generated method stub
        ArrayList artists = new ArrayList<String>();
        String song = "";
        for(int i = 0; i < m.getSongs().length; i++) {
            for(int j = 0; j < m.getSongs()[i].size(); j++) {
                SongData d = (SongData)m.getSongs()[i].get(j);
                song = d.getTitle();
                if(song.toLowerCase().contains(titleWord.toLowerCase())) {
                    artists.add(d.getArtist());
                }
            }
        }
        return artists;
    } 
	@SuppressWarnings("unchecked")
    public int findNumberOfSongsInYear(String titleWord, int year) {
        // TODO Auto-generated method stub
        ArrayList songs = new ArrayList<String>();
        String song = "";
        int count = 0;
        for (int i = 0; i < m.getSongs().length; i++) {
            for (int j = 0; j < m.getSongs()[i].size(); j++) {
                SongData d = (SongData) m.getSongs()[i].get(j);
                if(d.getTitle().toLowerCase().contains(titleWord.toLowerCase()) && d.getYearPublished() == year) {
                    count++;
                }
            }
        }
        return count;
    }
}
class SearchBackEndPlaceholder implements SearchBackEndInterface {
    private SongDataInterface onlySong;

    public void addSong(SongDataInterface song) {
        this.onlySong = song;
    }
    public boolean containsSong(SongDataInterface song) {
        return onlySong.equals(song);
    }
    public List<String> findTitles(String titleWord) {
        List<String> titles = new LinkedList<>();
        if(onlySong.getTitle().contains(titleWord))
            titles.add(onlySong.getTitle());
        return titles;
    }
    public List<String> findArtists(String titleWord) {
        List<String> artists = new LinkedList<>();
        if(onlySong.getArtist().contains(titleWord))
            artists.add(onlySong.getArtist());
        return artists;
    }
    public int findNumberOfSongsInYear(String titleWord, int year) {
        if(onlySong.getYearPublished() == year) return 1;
        return 0;
    }
}
// placeholder(s) (imp`lemented with proposal, and possibly added to later)