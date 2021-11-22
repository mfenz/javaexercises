package at.cb.immo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/immobilien");
        config.setUsername("root");
        config.setPassword("");
        // Angabe des Database Treibers
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // Wie viele Datenbankverbindungen sollen erstellt werden?
        config.setMaximumPoolSize(5);
        // Konfiguration übernehmen
        ds = new HikariDataSource(config);
    }

    private DbConnection(){
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
