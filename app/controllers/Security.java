package controllers;

import models.Artist;

/**
 * Created by Jonatan on 06/11/2015.
 */
public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        return Artist.connect(username, password) != null;
    }

}
