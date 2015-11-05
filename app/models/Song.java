package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import play.db.jpa.Model;

import java.io.File;

/**
 * Created by Jonatan on 04/11/2015.
 *
 * This class represents a song of an Artist.
 */

@Entity
public class Song extends Model {

    public String songName;
    public File audio;

    @Reference
    public Artist author;

    public Song(String songName, File audio, Artist author) {
        this.songName = songName;
        this.audio = audio;
        this.author = author;
    }

}
