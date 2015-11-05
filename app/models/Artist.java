package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import play.db.jpa.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arturo
 *
 * This class represents an artist who uploads his songs.
 *
 */

@Entity
public class Artist extends Model {

    public File artistImage;
    public String artistName;
    public String artistDescription;

    @Reference
    public List<Song> artistSongs;

    public Artist(File artistImage, String artistName, String artistDescription) {
        this.artistImage = artistImage;
        this.artistName = artistName;
        this.artistDescription = artistDescription;
        this.artistSongs = new ArrayList<Song>();
    }
}
