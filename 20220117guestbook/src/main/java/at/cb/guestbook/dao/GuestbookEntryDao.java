package at.cb.guestbook.dao;

import at.cb.guestbook.model.GuestbookEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GuestbookEntryDao {

    public static int createGuestbookEntry(GuestbookEntry guestbookEntry) {
        try(Connection connection = DbConnection.getConnection()){
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
            int rowCount = ps.executeUpdate();
            System.out.printf("Row count: %d%n", rowCount);
            // von der Datenbank generierten Primary Key zurückgeben
            return ps.getGeneratedKeys().getInt(1);
        } catch (SQLException e){
            throw new DaoException(e);
        }
    }

}
