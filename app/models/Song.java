package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import play.data.validation.Required;
import play.modules.morphia.Blob;
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
    public Blob audio;

    @Reference
    public Artist author;

    public Song(String songName, Blob audio, Artist author) {
        this.songName = songName;
        this.audio = audio;
        this.author = author;
    }

    @Override
    public String toString() {
        return songName;
    }
}
