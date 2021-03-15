import com.mysql.cj.jdbc.MysqlDataSource;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserVerwaltung {
    public static void main(String[] args) {
        UserVerwaltung userVerwaltung = new UserVerwaltung();
        // DB-Connection erstellen
        userVerwaltung.initConnection();

        // Daten in DB einfügen
        userVerwaltung.verwalten();

        // Db-Connection schließen
        userVerwaltung.closeConnection();
    }

    // Connection zur Datenbank (muss noch initialisiert werden!)
    private Connection connection;

    private void initConnection(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("cb");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("127.0.0.1");
        dataSource.setPort(3306);

        try {
            // Verbindung aufbauen ...
            Connection connection = dataSource.getConnection();
            this.connection = connection;
            System.out.println("Verbindung zur Datenbank hergestellt!");
        } catch (SQLException ex){
            System.out.println("Fehler bei DB-Connection: " + ex.getMessage());
            ex.printStackTrace();
            System.exit(0);
        }
    }

    private void verwalten(){
        Random random = new Random();
        User user1 = new User(random.nextInt(1000), "Ivica");
        insertUser(user1);

        try {
            List<User> user = getUser();
            for(User u : user){
                print(u);
            }
        } catch (Exception ex){
            System.out.println("Fehler beim Auslesen aller User: " + ex.getMessage());
        }

        int suchUserId = 1234;
        System.out.printf("User mit ID %d suchen:\n", suchUserId);
        try {
            Optional<User> optionalUser = getUser(suchUserId);
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                print(user);
            } else {
                System.out.println("User leider nicht gefunden :(");
            }
        } catch (SQLException ex){
            System.out.println("Fehler beim Finden von User. " + ex.getMessage());
        }
    }

    private void print(User user){
        System.out.printf("%d %s \n", user.getId(), user.getName());
    }

    private void insertUser(User user){
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user (id, name) VALUES (?, ?)");
            // werte setzen. 1 und 2 referenzieren das jeweilige Fragezeichen
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            // Query ausführen
            ps.executeUpdate();
            // Ressourcen vom prepared statement freigeben (löschen)
            // Damit "java" es "vergisst"
            // // Releases this Statement object's database and JDBC resources
            ps.close();
            System.out.println("User hinzugefügt!");
        } catch (SQLException ex){
            System.out.println("Fehler beim Einfügen des User: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private List<User> getUser() throws SQLException {
        PreparedStatement ps =  connection.prepareStatement(
                "SELECT id, name FROM user");
        // Query ausführen
        ResultSet resultSet = ps.executeQuery();
        // Liste anlegen für Rückgabe
        List<User> result = new ArrayList<>();
        // Zeile für Zeile: solange es ein "next" gibt ...
        while (resultSet.next()){
            // Einzelne Werte vom Datensatz herausholen
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            // Daraus ein User-Objekt erstellen
            User user = new User(id, name);
            // user in Result-Liste einfügen
            result.add(user);
        }
        ps.close();
        // Liste mit den Resultaten zurückgeben
        return result;
    }

    private Optional<User> getUser(int userId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT id, name FROM user WHERE id = ?");
        ps.setInt(1, userId);
        // Query ausführen
        ResultSet resultSet = ps.executeQuery();
        try {
            if(resultSet.next()){
                // Einzelne Werte vom Datensatz herausholen
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Daraus ein User-Objekt erstellen
                User user = new User(id, name);
                // User in Optional-Objekt "verpacken" und zurückgeben
                return Optional.of(user);
            }
        } finally {
            System.out.println("Finally!");
            // finally wird IMMER!! ausgeführt (egal ob im try ein Fehler war)
            ps.close();
        }
        return Optional.empty();
    }

    private void closeConnection(){
        try {
            connection.close();
            System.out.println("Datenbankverbindung geschlossen!");
        } catch (SQLException ex){
            System.out.println("Fehler bei DB-Connection close: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
