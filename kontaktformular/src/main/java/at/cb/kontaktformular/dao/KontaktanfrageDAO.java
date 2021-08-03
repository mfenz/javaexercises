/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.cb.kontaktformular.dao;

import at.cb.kontaktformular.model.Kontaktanfrage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mfenz
 */
public class KontaktanfrageDAO {
    // insert
    public static int createKontaktanfrage(String name, String nachricht) {
        try (Connection connection = DbConnection.getConnection()){
            // Werte die aus User-Eingaben stammen nur mit PreparedStatement 
            // an die Datenbank senden!!!
            PreparedStatement ps = connection.prepareStatement(""
                    + "INSERT INTO kontaktanfrage "
                    + "(name, nachricht) "
                    + "VALUES "
                    + "(?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, nachricht);
            int rowCount = ps.executeUpdate();
            if(rowCount == 0){
                // es wurde keine Zeile eingefügt --> Exception werfen
                throw new DAOException("Es wurden keine Zeilen verändert");
            }
            
            // generierten Key herausfinden
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                // rs.getInt(1) <-- Key des generierten Datensatzes
                return rs.getInt(1);
            }
            throw new DAOException("Es wurde kein Kontaktanfrage-Key generiert");
        } catch(SQLException e){
            throw new DAOException(e);
        }
    }
    
    // getAll
    // SELECT * FROM kontaktanfrage
    public static List<Kontaktanfrage> getKontaktanfragen(){
        try(Connection connection = DbConnection.getConnection()){
            Statement statement = connection.createStatement();
            // DB-Anfrage durchführen
            ResultSet rs = statement.executeQuery("SELECT * FROM kontaktanfrage");
            
            List<Kontaktanfrage> result = new ArrayList<>();
            
            // Über ResultSet iterieren
            while(rs.next()){
                // für jeden Datensatz ... 
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nachricht = rs.getString("nachricht");
                
                // Objekt aus Datensatz erzeugen
                Kontaktanfrage kontaktanfrage = new Kontaktanfrage(id, name, nachricht);
                
                // Objekt in Liste mit den Ergebnissen einfügen
                result.add(kontaktanfrage);
            }
            return result;
        } catch(SQLException e){
            throw new DAOException(e);
        }
    }
}
