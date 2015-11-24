import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void createAndRetrieveArtist() {
        new Artist(null, "Miles", "miles@gmail.com", "secret",
            "Cool Jazz for the people").save();

        Artist miles = Artist.find("byEmail", "miles@gmail.com").first();

        //Test
        assertNotNull(miles);
        assertEquals("Miles", miles.artistName);
    }

    @Test
    public void uploadSong() {
        new Artist(null, "Miles", "miles@gmail.com", "secret",
                "Cool Jazz for the people").save();

        Artist miles = Artist.find("byEmail", "miles@gmail.com").first();

        Song newSong =  new Song("Bitches Brew", null, miles);

        assertNotNull(newSong);
        assertEquals("Bitches Brew", newSong.songName);

    }

    @Test
    public void getSongsAndExist() {
        List<Song> songs = Song.q().asList();

        assertNotNull(songs);
    }

    @Test
    public void tryConnectAsArtist() {
        // Create a new Artist and save it
        new Artist(null, "Miles", "miles@gmail.com", "secret",
                "Cool Jazz for the people").save();

        // Test
        assertNotNull(Artist.connect("miles@gmail.com", "secret"));
        assertNull(Artist.connect("miles@gmail.com", "badpassword"));
        assertNull(Artist.connect("miles@gmail.com", "secret"));
    }

}
