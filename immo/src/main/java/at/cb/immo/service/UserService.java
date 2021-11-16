package at.cb.immo.service;

import at.cb.immo.dao.UserDAO;
import at.cb.immo.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class UserService {

    // Namen der Session-Variablen
    public static final String SESSION_LOGGED_IN = "logged_in";
    public static final String SESSION_USER_ID = "user_id";
    public static final String SESSION_ADMIN = "is_admin";

    public static int createUser(String name, String email, String password) throws ServiceException{
        // Wurden Name, Email, und Passwort eingegeben?
        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
            throw new ServiceException("Name, Email und Passwort eingeben");
        }

        // Gibt es schon einen User mit dieser E-Mail Adresse?
        if(UserDAO.getUserByEmail(email).isPresent()){
            throw new ServiceException("User existiert bereits");
        }
        return UserDAO.createUser(name, email, password);
    }

    /**
     * Meldet den User nach erfolgter Daten-Überprüfung am System an
     * @param email
     * @param password
     * @return true wenn login erfolgreich, ansonsten false
     */
    public static boolean login(String email, String password, HttpSession httpSession){
        // User via Email herausholen
        Optional<User> optionalUser = UserDAO.getUserByEmail(email);
        if(optionalUser.isPresent() && BCrypt.checkpw(password, optionalUser.get().getPassword())){
            // Login durchführen
            httpSession.setAttribute(SESSION_LOGGED_IN, true);
            httpSession.setAttribute(SESSION_USER_ID, optionalUser.get().getId());
            httpSession.setAttribute(SESSION_ADMIN, optionalUser.get().isAdmin());

            return true;
        }
        return false;
    }

    public static void logout(HttpSession session){
        session.setAttribute(SESSION_LOGGED_IN, false);
        session.setAttribute(SESSION_USER_ID, null);
        session.setAttribute(SESSION_ADMIN, null);
        session.invalidate();
    }

    public static boolean isLoggedIn(HttpSession session){
        if(session.getAttribute(SESSION_LOGGED_IN) != null
                && (boolean)session.getAttribute(SESSION_LOGGED_IN) == true){
            return true;
        }
        return false;
    }

    public static boolean isAdmin(HttpSession session){
        if(session.getAttribute(SESSION_ADMIN) != null
                && (boolean) session.getAttribute(SESSION_ADMIN)){
            return true;
        }
        return false;
    }
}
