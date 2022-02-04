package at.cb.kfzteile.dao;

import at.cb.kfzteile.model.Interessent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class InteressentenDao {
    public static Optional<Interessent> getInteressentByBenutzerId(int benutzerId){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM interessent " +
                    "WHERE benutzer_id = ?");
            ps.setInt(1, benutzerId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return Optional.of(new Interessent(
                        rs.getString("strasse"),
                        rs.getString("plz"),
                        rs.getString("ort"),
                        rs.getString("firmenname")
                ));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static void createInteressent(int benutzerId, Interessent interessent){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "INSERT INTO interessent " +
                    "(benutzer_id, strasse, plz, ort, firmenname) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?)");
            ps.setInt(1, benutzerId);
            ps.setString(2, interessent.getStrasse());
            ps.setString(3, interessent.getPlz());
            ps.setString(4, interessent.getOrt());
            ps.setString(5, interessent.getFirmenname());
            int rowCount = ps.executeUpdate();
            if(rowCount == 0){
                throw new DaoException("Interessent konnte nicht erstellt werden");
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static void deleteInteressentByBenutzerId(int benutzerId){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "DELETE " +
                    "FROM interessent " +
                    "WHERE benutzer_id = ?" +
                    "");
            ps.setInt(1, benutzerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
