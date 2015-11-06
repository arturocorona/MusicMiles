package controllers;

import models.Artist;

/**
 * Created by Jonatan on 06/11/2015.
 *
 * This class contain the configurations of security module.
 */
public class Security extends Secure.Security {
    
    /**
     * authenticate an Artist.
     * @param username
     * @param password
     * @return 
     */
    static boolean authenticate(String username, String password) {
        return Artist.connect(username, password) != null;
    }

    /**
     * Returns to the app index.
     */
    static void onDisconnected() {
        Application.index();
    }

    /**
     * redirect to the admin index.
     */
    static void onAuthenticated() {
        Admin.index();
    }

    /**
     * Check that the Artist is an admin.
     * @param profile
     * @return 
     */
    static boolean check(String profile) {
        if("admin".equals(profile)) {
            return Artist.find("byEmail", connected()).<Artist>first().isAdmin;
        }
        return false;
    }

}
