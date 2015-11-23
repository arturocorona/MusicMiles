package controllers;

import play.*;
import play.modules.morphia.Blob;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        //Artist first = Artist.find("byArtistName", "Volta").first();
        render();
    }

    public static void miles() {
        List<Song> songs = Song.q().asList();
        render(songs);
    }

    public static void getImage(String name) {
        //Artist user = Artist.findById(id);
        Artist user = Artist.find("byArtistName", name).first();
        response.setContentTypeIfNotSet(user.artistImage.type());
        renderBinary(user.artistImage.get());
    }

    public static void getAudio(String name) {
        Song song = Song.find("bySongName", name).first();
        response.setContentTypeIfNotSet(song.audio.type());
        renderBinary(song.audio.get());
    }

    public static void showProfile(String name){
        Artist artist = Artist.find("byArtistName", name).first();
        render(artist);
    }

    public static void registerArtist(Blob artistImage, String artistName, String email,
        String password, String artistDescription) {
        Artist artist = new Artist(artistImage, artistName, email, password, artistDescription).save();
        Profile.editProfile();
    }

}