package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;
import java.util.ArrayList;
import java.util.List;

import play.data.validation.Email;
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

    @Email
    @Required
    public String email;

    @Required
    public String password;
    
    @Required
    public String artistDescription;

    public boolean isAdmin;

    @Reference
    public List<Song> artistSongs;

    public Artist(Blob artistImage, String artistName, String email, String password, String artistDescription) {
        this.artistImage = artistImage;
        this.artistName = artistName;
        this.email = email;
        this.password = password;
        this.artistDescription = artistDescription;
        this.artistSongs = new ArrayList<Song>();
    }

    public static Artist connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }

    public void addSong(String songName, Blob audio){
        Song song = new Song(songName, audio, this).save();
        this.artistSongs.add(song);
        this.save();
    }

    @Override
    public String toString() {
        return artistName;
    }
}
