/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.cb.kontaktformular.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author BBRZ
 */
public class DbConnection {
    private static HikariConfig config = new HikariConfig();
   private static HikariDataSource ds;

   static {
       config.setJdbcUrl( "jdbc:mysql://localhost:3306/kontaktformular" );
       config.setUsername( "root" );
       config.setPassword( "" );
       config.addDataSourceProperty( "cachePrepStmts" , "true" );
       config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
       config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
       config.setDriverClassName("com.mysql.cj.jdbc.Driver");
       config.setMaximumPoolSize(5);
       ds = new HikariDataSource( config );
   }
   
   private DbConnection() {}

   public static Connection getConnection() throws SQLException {
       return ds.getConnection();
   }


}
