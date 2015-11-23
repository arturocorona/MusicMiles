package controllers;

import models.Artist;
import models.Song;
import play.modules.morphia.Blob;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

/**
 * Created by Jonatan on 22/11/2015.
 *
 * This class represents the controller of profile edition.
 *
 */

@With(Secure.class)
public class Profile extends Controller {
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            Artist user = Artist.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.artistName);
        }
    }

    public static void getImage(String name) {
        //Artist user = Artist.findById(id);
        Artist user = Artist.find("byArtistName", name).first();
        response.setContentTypeIfNotSet(user.artistImage.type());
        renderBinary(user.artistImage.get());
    }

    public static void editProfile(){
        Artist artist = Artist.find("byEmail", Security.connected()).first();
        render(artist);
    }

    public static void uploadSong(String songName, Blob audio, String name) {
        Artist author = Artist.find("byArtistName", name).first();
        author.addSong(songName, audio);
        editProfile();
    }
}
