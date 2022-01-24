package at.cb.guestbook.dao;

import at.cb.guestbook.model.GuestbookEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestbookEntryDao {

    public static int createGuestbookEntry(GuestbookEntry guestbookEntry) {
        /**
         * Try with resources:
         * Wenn die Connection nicht mehr benötigt wird, wird sie automatisch zurückgelegt
         */
        try(Connection connection = DbConnection.getConnection()){

            /**
             * Prepared Statement mit Fragezeichen als Platzhalter:
             * PS sind wichtig um SQL-Injections zu vermeiden.
             */
            PreparedStatement ps = connection.prepareStatement("" +
                            "INSERT INTO guestbook " +
                            "(name, email, text) " +
                            "VALUES " +
                            "(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            // Fragezeichen mit dem eigentlichen Wert ersetzen
            ps.setString(1, guestbookEntry.getName());
            ps.setString(2, guestbookEntry.getEmail());
            ps.setString(3, guestbookEntry.getText());
            // SQL Statement an die Datenbank senden und ausführen
            // rowCount <-- Die Anzahl der modifizierten Zeilen
            int rowCount = ps.executeUpdate();
            if(rowCount == 0){
                throw new DaoException("Create guestbook entry: could not insert row");
            }

            // ID des erzeugten Gästebucheintrags herausholen und zurückgeben
            ResultSet rs = ps.getGeneratedKeys();
            // innerhalb des ResultSet ist der Key (ID des Datensatzes)
            if(rs.next()){
                // Key aus dem ResultSet holen und zurückgeben
                return rs.getInt(1);
            }
            throw new DaoException("Create guestbook entry: could not create a key");
        } catch (SQLException e){
            /**
             * SQLException in eine DaoException umwandeln
             * Checked SQLException in unchecked DaoException umwandeln
             * ... damit nicht überall das try-catch geschrieben werden muss
             *
             * Wann checked-exceptions verwenden, wann unchecked exceptions verwenden?
             * Checked exceptions: wenn ich das Problem lösen kann (oder versuche zu lösen)
             * Beispiel: User gibt Dateiname an, Datei gibt es jedoch nicht
             * --> User muss Dateiname erneut eingeben
             *
             * Unchecked exception: wenn keine Lösung während der Laufzeit möglich ist
             */
            throw new DaoException(e);
        }
    }

    public static List<GuestbookEntry> getGuestbookEntries(){
        try(Connection conn = DbConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement("" +
                    "SELECT * " +
                    "FROM guestbook ");
            // SELECT Statement an den Server schicken
            ResultSet rs = ps.executeQuery();
            List<GuestbookEntry> entries = new ArrayList<>();

            // für jeden Datensatz der beim SELECT gefunden wurde ...
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String text = rs.getString("text");

                GuestbookEntry entry = new GuestbookEntry(id, name, email, text);

                entries.add(entry);
            }

            return entries;

        } catch (SQLException e){
            throw new DaoException(e);
        }
    }

}
