package at.cb.userverwaltung.bl;

import at.cb.userverwaltung.model.User;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        // ? durch Wert ersetzen
        ps.setString(1, name);

        // SQL Statement an DB senden und ausführen lassen
        ps.executeUpdate();

        ps.close();
    }

    public void listUsers(){

    }
}
