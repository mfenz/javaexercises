import com.mysql.cj.jdbc.MysqlDataSource;
import model.User;

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

        userVerwaltung.createDatabase();

        // User einfügen und auslesen
        userVerwaltung.test();

        // DB-Connection schließen
        userVerwaltung.closeConnection();
    }
    // Hier wird später die Referenz auf die Datenbank-Connection hinterlegt
    private Connection connection;

    private void initConnection() {
        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setDatabaseName("db2");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
        try {
            Connection connection = dataSource.getConnection();
            // Instanzvariable initialisieren
            this.connection = connection;
        } catch (SQLException ex){
            // Im Fehlerfall: Fehlermeldung ausgeben
            System.out.println("Fehler bei DB-Connection: " + ex.getMessage());
            ex.printStackTrace();
            // Programm beenden
            System.exit(0);
        }
    }
    private void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Fehler bei DB-Connection close: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void createDatabase(){
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "CREATE DATABASE IF NOT EXISTS db3"
            );
            ps.execute();
            ps.close();
            connection.setCatalog("db3");
        } catch (SQLException ex){
            System.out.println("Create database error: " + ex.getMessage());
        }
    }

    public void test(){
        Random random = new Random();
        // User mit Zufallswerten erstellen
        User user = new User(random.nextInt(), "Susi " + random.nextInt(100));
        // user in DB einfügen
        insertUser(user);
        // Alle User aus Datenbank holen
        try {
            List<User> userList = findUser();
            for(User u : userList){
                // User ausgeben lassen
                print(u);
            }
        } catch (SQLException ex) {
            System.out.println("Fehler beim Laden der User aus DB: " + ex.getMessage());
            ex.printStackTrace();
        }

        // User anhand der ID in der Datenbank finden
        try {
            int searchUserId = user.getId();
            Optional<User> optionalUser = findUser(searchUserId);
            if(optionalUser.isPresent()){
                System.out.println("User gefunden:");
                print(optionalUser.get());
            } else {
                System.out.println("User nicht gefunden");
            }
        } catch (SQLException ex) {
            System.out.println("Fehler beim Laden von einzelnen User: " + ex.getMessage());
        }
    }

    private void insertUser(User user){
        try {
            // Statement vorbereiten
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user (id, name) VALUES (?, ?)");
            // Werte setzen
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            // Query ausführen
            ps.executeUpdate();
            // Releases this Statement object's database and JDBC resources
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Fehler beim Einfügen des User: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private List<User> findUser() throws SQLException {
        PreparedStatement ps = connection
                .prepareStatement("SELECT id, name FROM user");
        // Query ausführen und Resultat erhalten
        ResultSet resultSet = ps.executeQuery();
        // Liste anlegen (Resultate später als Objekt hier einfügen)
        List<User> result = new ArrayList<>();
        // Zeile für Zeile: solange es ein "next" gibt ...
        while (resultSet.next()){
            // Einzelne Werte vom Datensatz herausholen
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            // Daraus ein User-Objekt erstellen
            User user = new User(id, name);
            // user in result-Liste einfügen
            result.add(user);
        }
        // Releases this Statement object's database and JDBC resources
        ps.close();
        // Liste mit Resultaten zurückgeben
        return result;
    }

    private Optional<User> findUser(int userId) throws SQLException {
        PreparedStatement ps = connection
                .prepareStatement("SELECT id, name FROM user WHERE id = ?");
        ps.setInt(1, userId);
        // Query ausführen und Resultat erhalten
        ResultSet resultSet = ps.executeQuery();
        // Zeile für Zeile: solange es ein "next" gibt ...
        while (resultSet.next()){
            // Einzelne Werte vom Datensatz herausholen
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            // Daraus ein User-Objekt erstellen
            User user = new User(id, name);
            ps.close();
            return Optional.of(user);
        }
        ps.close();
        // falls nichts mit dieser ID gefunden wurde
        return Optional.empty();
    }

    private void print(User user){
        System.out.printf("User: id=%d name=%s \n", user.getId(), user.getName());
    }
}
