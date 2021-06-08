package at.cb.userverwaltung.bl;

import at.cb.userverwaltung.model.User;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserVerwaltungBl {

    private Connection connection;
    private Scanner scanner;

    public UserVerwaltungBl(Scanner scanner){
        this.scanner = scanner;
        connectToDatabase();
    }

    public void connectToDatabase(){
        MysqlDataSource dataSource = new MysqlDataSource();
        // Definieren wo die Datenquelle (Datenbank) ist
        dataSource.setDatabaseName("cb");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
        try {
            // Datenbankverbindung herstellen
            Connection connection = dataSource.getConnection();
            this.connection = connection;
            System.out.println("Datenbankverbindung hergestellt!");
        } catch (SQLException ex){
            System.out.println("Fehler beim Verbinden zur DB: " + ex.getMessage());
            System.exit(0);
        }
    }

    public void addUser(){
        System.out.println("--- USER ANLEGEN ---");
        System.out.println("Name eingeben:");
        String name = scanner.nextLine();

        try {
            insertUser(name);
        } catch (SQLException e){
            System.out.println("Konnte den User nicht einfügen: " + e.getMessage());
        }

    }

    /**
     * Speichert einen neuen User in der Datenbank
     * @param name Name des Users
     */
    private void insertUser(String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO user " +
                        "(name) " +
                        "VALUES " +
                        "(?)");

        /**
         * INSERT INTO user
         * (name)
         * VALUES
         * (Marc)
         *
         *
         * INSERT INTO user
         * (name)
         * VALUES
         * ('Marc\'); DELETE FROM user; (')
         */

        // ? durch Wert ersetzen
        ps.setString(1, name);

        // SQL Statement an DB senden und ausführen lassen
        ps.executeUpdate();

        ps.close();
    }

    public void listUsers(){
        try {
            List<User> users = findUsers();
            for (User u : users){
                System.out.printf("%d %s %n", u.getId(), u.getName());
            }
        } catch (SQLException e){
            System.out.println("Fehler beim Laden der User: " + e.getMessage());
        }
    }

    /**
     * Gibt alle User in der Datenbank zurück
     * @return
     */
    public List<User> findUsers() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT id, name " +
                        "FROM user ");
        ResultSet rs = ps.executeQuery();

        List<User> result = new ArrayList<>();

        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");

            // Objekt der Klasse User erstellen
            User u = new User(id, name);
            result.add(u);
        }

        ps.close();
        return result;
    }
}
