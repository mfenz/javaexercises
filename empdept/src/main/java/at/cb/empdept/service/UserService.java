package at.cb.empdept.service;

import at.cb.empdept.dao.UserDAO;
import at.cb.empdept.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

public class UserService {

    //

    public static int createUser(String email, String password) throws ServiceInputException{
        // password plaintext --> hash + salt
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());

        email = email.toLowerCase();

        // Gibt es schon einen User mit dieser E-Mail Adresse?
        if(getUserByEmail(email).isPresent()){
            throw new ServiceInputException("User mit dieser Email-Adresse existiert bereits");
        }

        // User in DB einfügen
        return UserDAO.createUser(email, passwordHash);
    }

    public static Optional<User> getUserByEmail(String email){
        email = email.toLowerCase();

        return UserDAO.getUserByEmail(email);
    }

    public static Optional<User> getUserById(int id){
        return UserDAO.getUserById(id);
    }

    public static Optional<User> login(String email, String password){
        Optional<User> optionalUser = getUserByEmail(email);
        if(optionalUser.isEmpty()){
            return Optional.empty();
        }

        // Passwort überprüfen!
        boolean passwordOk = BCrypt.checkpw(password, optionalUser.get().getPassword());

        if(passwordOk){
            return optionalUser;
        }
        return Optional.empty();
    }
}
