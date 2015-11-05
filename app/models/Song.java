package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import play.db.jpa.Model;

import java.io.File;
import play.data.validation.Required;

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
