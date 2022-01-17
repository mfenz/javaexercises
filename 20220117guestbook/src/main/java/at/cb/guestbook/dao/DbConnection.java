package at.cb.guestbook.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    // statischer Initialisierungsblock
    static {
        config.setJdbcUrl("jdbc:mysql://10.211.55.3/guestbook0122");
        config.setUsername("guestbook0122");
        config.setPassword("HHtY70PiA.(TPMsC");
        // Angabe des Database-Treibers
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // Wie viele Datenbank-Verbindungen sollene erstellt werden?
        config.setMaximumPoolSize(5);
        // Konfiguration übernehmen
        ds = new HikariDataSource(config);
    }

    /**
     * Private Konstruktor:
     * Damit ist ein Objekt dieser Klasse NICHT initialisierbar!
     */
    private DbConnection(){

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
