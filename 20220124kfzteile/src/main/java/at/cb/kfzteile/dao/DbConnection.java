package at.cb.kfzteile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DB_HOST = "10.211.55.3";
    private static final String DB_USER = "kfzteile0122";
    private static final String DB_PASSWORD = "1-WVLJ/[@oDE0gXH";
    private static final String DB_NAME = "kfzteile0122";

    /**
     * Erzeugt eine neue Datenbankverbindung
     * protected: damit nur im DAO auf die Connection zugegriffen werden kann
     * Jede Connection muss von der aufrufenden Methode selbständig geschlossen werden!
     * @return Connection die neue Verbindung zur Datenbank
     * @throws SQLException bei SQLException oder ClassNotFoundException
     */
    protected static Connection getConnection() throws SQLException {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s:3306/%s", DB_HOST, DB_NAME);
            Connection con = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }
}
