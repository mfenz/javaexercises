package at.cb.empdept.dao;

import at.cb.empdept.model.User;

import java.sql.*;
import java.util.Optional;

public class UserDAO {
    public static int createUser(String email, String password){
        try (Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement("" +
                    "INSERT INTO user " +
                    "(email, password) " +
                    "VALUES " +
                    "(?, ?) ", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.setString(2, password);

            int rowCount = ps.executeUpdate();
            if(rowCount < 1){
                throw new DAOException("Create user: es wurden keine Zeilen bearbeitet.");
            }
            // ID des generierten Datensatzes auslesen
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()){
                // Primary Key auslesen und zurückgeben
                return generatedKeys.getInt(1);
            }
            throw new DAOException("Create user: Es wurde kein Key generiert");
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static Optional<User> getUserByEmail(String email){
        try(Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement("" +
                    "SELECT * " +
                    "FROM user " +
                    "WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return Optional.of(
                        new User(rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("password")));
            }
            // kein User gefunden --> leeres Optional-Objekt zurückgeben
            return Optional.empty();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static Optional<User> getUserById(int id){
        try(Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement("" +
                    "SELECT * " +
                    "FROM user " +
                    "WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return Optional.of(
                        new User(rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("password")));
            }
            // kein User gefunden --> leeres Optional-Objekt zurückgeben
            return Optional.empty();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
