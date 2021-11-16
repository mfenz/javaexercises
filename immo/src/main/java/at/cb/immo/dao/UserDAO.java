package at.cb.immo.dao;

import at.cb.immo.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Optional;

public class UserDAO {
    public static int createUser(String name, String email, String password){
        // try with resources
        try(Connection conn = DbConnection.getConnection()) {
            // Passwort hashen
            String pwHash = BCrypt.hashpw(password, BCrypt.gensalt());

            // für jede einzufügende Spalte wird ein Questionmark-Parameter angegeben
            PreparedStatement ps = conn.prepareStatement("" +
                    "INSERT INTO users " +
                    "(name, email, passwort, admin) " +
                    "VALUES " +
                    "(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pwHash);
            ps.setBoolean(4, false);

            // rowCount: Anzahl der eingefügten/veränderten Datensätze durch das Statement
            int rowCount = ps.executeUpdate();
            if(rowCount < 1){
                throw new DAOException("User nicht angelegt");
            }

            // Welche ID hat der neue User?
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()){
                // Die erzeugte ID zurückgeben
                return generatedKeys.getInt(1);
            }
            throw new DAOException("User anlegen: keine Keys erzeugt");
        } catch (SQLException e){
            // Checked SQL Exception in unchecked DAOException umwandeln
            throw new DAOException(e);
        }
    }

    public static Optional<User> getUserByEmail(String email){
        try(Connection conn = DbConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement("" +
                    "SELECT * " +
                    "FROM users " +
                    "WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int id = rs.getInt("ID");
                String emailDb = rs.getString("email");
                String password = rs.getString("passwort");
                String name = rs.getString("name");
                boolean admin = rs.getBoolean("admin");

                return Optional.of(new User(id,name, emailDb, password, admin));
            }
            return Optional.empty();

        } catch (SQLException e){
            throw new DAOException(e);
        }
    }
}
