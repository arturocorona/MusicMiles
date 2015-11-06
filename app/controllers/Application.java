package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        Artist first = Artist.find("byArtistName", "Volta").first();
        System.out.println("-->" + first.artistImage);

        render(first);
        //renderBinary(first.artistImage.get());
    }

}