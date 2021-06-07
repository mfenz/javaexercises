package service;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBlacklistService implements BlacklistService{

    // Verbindung zur Datenbank ist eine Instanzvariable
    private Connection connection;

    public DatabaseBlacklistService(){
        // Beim Erzeugen des Objekts wird eine DB-Verbindung aufgebaut
        initConnection();
    }

    /**
     * Baut eine Verbindung zur Datenbank auf
     */
    private void initConnection(){
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
            System.out.println("Fehler bei der DB-Verbindung: " + ex.getMessage());
            ex.printStackTrace();
            // Programm beenden
            System.exit(0);
        }
    }


    @Override
    public void addNames(List<String> names) {
        try {
            // für jeden Namen ein INSERT INTO Statement aufrufen
            for (String name : names){
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO blacklist (name) VALUES (?) ");
                // Platzhalter ? ersetzen
                ps.setString(1, name);
                // SQL Statement an die Datenbank senden und ausführen
                ps.executeUpdate();
                // Prepared Statement schließen
                ps.close();
            }
        } catch (SQLException ex){
            System.out.println("Fehler beim Einfügen der Namen: " + ex.getMessage());
        }
    }

    @Override
    public List<String> getNames() {
        List<String> result = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT name FROM blacklist ");
            // SQL SELECT-Befehl an Datenbank senden und ausführen
            ResultSet resultSet = ps.executeQuery();

            // Solange es ein nächstes Result (Ergebnis bzw. Datensatz) gibt
            while (resultSet.next()){
                String name = resultSet.getString("name");
                result.add(name);
            }
            ps.close();
        } catch (SQLException ex){
            System.out.println("Fehler beim Lesen der Blacklist: " + ex.getMessage());
        }
        return result;
    }

    @Override
    public void removeNames(List<String> names) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM blacklist WHERE name = ? ");
            for(String name : names){
                ps.setString(1, name);
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException ex){
            System.out.println("Fehler beim Löschen der Namen: " + ex.getMessage());
        }
    }
}
