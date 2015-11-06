package controllers;

import models.Artist;

/**
 * Created by Jonatan on 06/11/2015.
 *
 * This class contain the configurations of security module.
 */
public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        return Artist.connect(username, password) != null;
    }

    static void onDisconnected() {
        Application.index();
    }

    static void onAuthenticated() {
        Admin.index();
    }

    static boolean check(String profile) {
        if("admin".equals(profile)) {
            return Artist.find("byEmail", connected()).<Artist>first().isAdmin;
        }
        return false;
    }

}
