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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfenz
 */
public class KontaktanfrageDAO {
    /**
     * Fügt eine neue Kontaktanfrage in DB ein
     * @param name
     * @param nachricht
     * @return int ID der neuen Kontaktanfrage
     */
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
    
    /**
     * Liest alle Kontaktanfragen aus der DB aus
     * @return Liste von Kontaktanfragen
     */
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
    
    /**
     * Lädt eine Kontaktanfrage anhand der ID aus der Datenbank
     * @param id
     * @return 
     */
    public static Optional<Kontaktanfrage> getKontaktanfrageById(int id){
        try(Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement(""
                    + "SELECT * "
                    + "FROM kontaktanfrage "
                    + "WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return Optional.of(
                        new Kontaktanfrage(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("nachricht"))
                );
            }
            return Optional.empty();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }
    
    /**
     * Löscht eine Kontaktanfrage anhand der ID aus der Datenbank
     * @param id
     * @return 
     */
    public static boolean deleteKontaktanfrageById(int id){
        try(Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement(""
                    + "DELETE from kontaktanfrage "
                    + "WHERE id = ?");
            // erstes Fragezeichen mit ID ersetzen
            ps.setInt(1, id);
            
            // Statement an die DB senden
            int rowCount = ps.executeUpdate();
            // rowCount <-- wie viele Datensätze wurden verändert (gelöscht)?
            return rowCount > 0;
        } catch(SQLException e){
            throw new DAOException(e);
        }
    }
    
    /**
     * Bearbeitet eine Kontaktanfrage in der Datenbank
     * @param kontaktanfrage 
     */
    public static void updateKontaktanfrage(Kontaktanfrage kontaktanfrage){
        try(Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement(""
                    + "UPDATE kontaktanfrage "
                    + "SET name = ?, nachricht = ? "
                    + "WHERE id = ?");
            ps.setString(1, kontaktanfrage.getName());
            ps.setString(2, kontaktanfrage.getNachricht());
            ps.setInt(3, kontaktanfrage.getId());
            int rowCount = ps.executeUpdate();
        } catch(SQLException e){
            throw new DAOException(e);
        }
    }
}
