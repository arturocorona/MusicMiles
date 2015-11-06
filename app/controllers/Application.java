package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 * Controller for access the app and get the Artist image.
 * @author arturo
 */
public class Application extends Controller {

    public static void index() {
        Artist first = Artist.find("byArtistName", "Volta").first();

        render(first);
    }

    public static void getImage(String name) {
        //Artist user = Artist.findById(id);
        Artist user = Artist.find("byArtistName", name).first();
        response.setContentTypeIfNotSet(user.artistImage.type());
        renderBinary(user.artistImage.get());
    }

}