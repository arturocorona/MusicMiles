package controllers;

import models.Artist;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

/**
 * Created by Jonatan on 06/11/2015.
 *
 * This class represents the personalization of users.
 */

@With(Secure.class)
public class Admin extends Controller {
    
    /**
     * Interceptor method that set the connected Artist on the Args
     */
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            Artist user = Artist.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.artistName);
        }
    }

    /**
     * Index method for Admin
     */
    public static void index() {
        render();
    }
}
