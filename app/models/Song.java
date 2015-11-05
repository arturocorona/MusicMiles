package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;
import java.io.File;
import play.data.validation.Required;
import play.modules.morphia.Model;

/**
 * Created by Jonatan on 04/11/2015.
 *
 * This class represents a song of an Artist.
 */
@Entity
public class Song extends Model {

    @Required
    public String songName;
    
    @Required
    public File audio;

    @Required
    
    @Reference
    public Artist author;

    public Song(String songName, File audio, Artist author) {
        this.songName = songName;
        this.audio = audio;
        this.author = author;
    }

}
