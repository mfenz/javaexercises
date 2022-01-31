package at.cb.kfzteile.service;

import at.cb.kfzteile.dao.BenutzerDao;
import at.cb.kfzteile.dao.RollenDao;
import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Rolle;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class BenutzerService {

    /**
     * Erstellt einen User und speichert die Rolle in die Datenbank
     * @param benutzer der zu erstellende Benutzer
     * @return benutzerId die ID des neuen Benutzers
     */
    public static int createBenutzer(Benutzer benutzer){
        int userId = BenutzerDao.createBenutzer(benutzer);
        // Rolle speichern
        for(Rolle rolle : benutzer.getRollen()){
            RollenDao.createBenutzerRolle(userId, rolle.getId());
        }
        return userId;
    }

    public static Optional<Benutzer> getBenutzerById(int benutzerId){
        return BenutzerDao.getBenutzerById(benutzerId);
    }

    /**
     * Anmeldung eines Benutzer. Speichert Login-Daten nach erfolgreicher Anmeldung in Session
     * @param email Benutzer-Email
     * @param passwort Benutzer-Passwort im Plaintext
     * @param httpSession die HttpSession zum Speichern des Logins
     * @return Optional mit Benutzer wenn Login erfolgreich war, ansonsten empty Optional
     */
    public static Optional<Benutzer> login(String email, String passwort, HttpSession httpSession){
        // User via Email herausholen
        Optional<Benutzer> optionalBenutzer = BenutzerDao.getBenutzerByEmail(email);
        // Und bei Vorhandensein des Benutzers das Passwort prüfen!
        if(optionalBenutzer.isPresent() && BCrypt.checkpw(passwort, optionalBenutzer.get().getPasswort())){
            // Login durchführen!

            httpSession.setAttribute("logged_in", true);
            httpSession.setAttribute("user_id", optionalBenutzer.get().getId());
            httpSession.setAttribute("is_admin", optionalBenutzer.get().isAdmin());
            return optionalBenutzer;
        }
        return Optional.empty();
    }

    /**
     * Logout des aktuellen Benutzers
     * Löscht die Session
     * @param httpSession die zu löschende Session
     */
    public static void logout(HttpSession httpSession){
        httpSession.invalidate();
    }

    public static boolean isAdmin(HttpSession session){
        if(isLoggedIn(session)
                && session.getAttribute("is_admin") != null
        && (boolean) session.getAttribute("is_admin") == true){
            return true;
        }
        return false;
    }

    public static boolean isLoggedIn(HttpSession session){
        if(session.getAttribute("logged_in") != null
        && (boolean)session.getAttribute("logged_in") == true){
            return true;
        }
        return false;
    }

    public static int getCurrentUserId(HttpSession session){
        return (int) session.getAttribute("user_id");
    }
}
