package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;
import java.util.ArrayList;
import java.util.List;
import play.data.validation.Required;
import play.modules.morphia.Blob;
import play.modules.morphia.Model;

/**
 *
 * @author arturo
 *
 * This class represents an artist who uploads his songs.
 *
 */

@Entity
public class Artist extends Model {

    @Required
    public Blob artistImage;
    
    @Required
    public String artistName;
    
    @Required
    public String artistDescription;

    @Reference
    public List<Song> artistSongs;

    public Artist(Blob artistImage, String artistName, String artistDescription) {
        this.artistImage = artistImage;
        this.artistName = artistName;
        this.artistDescription = artistDescription;
        this.artistSongs = new ArrayList<Song>();
    }
}
