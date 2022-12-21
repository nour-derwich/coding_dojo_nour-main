import java.util.Set;
import java.util.HashMap;

public class HashMapUser {
  public static void main(String[] args) {
    // create a trackList HashMap
    HashMap<String, String> trackList = new HashMap<>();

    // add in at least four songs to the trackList
    trackList.put("title1", "lyrics1");
    trackList.put("title2", "lyrics2");
    trackList.put("title3", "lyrics3");
    trackList.put("title4", "lyrics4");
   // retrieve a song from the trackList by its title
    String lyrics = trackList.get("title3");
    System.out.println(lyrics); // prints "lyrics3"

  for (String title : trackList.keySet()) {
      System.out.println("Track: " + title + " Lyrics: " + trackList.get(title));}
  }
}
