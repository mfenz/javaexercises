package at.cb.kfzteile.dao;

import at.cb.kfzteile.model.Rolle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RollenDao {
    public static void createBenutzerRolle(int benutzerId, int rolleId)
    {
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "INSERT INTO benutzer_hat_rolle " +
                    "(rolle_id, benutzer_id) " +
                    "VALUES " +
                    "(?, ?)");
            ps.setInt(1, rolleId);
            ps.setInt(2, benutzerId);

            int rowCount = ps.executeUpdate();
            if(rowCount < 1){
                throw new DaoException("Benutzer-Rolle konnte nicht gespeichert werden");
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static List<Rolle> getBenutzerRollen(int benutzerId){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM benutzer_hat_rolle bhr " +
                    "INNER JOIN rolle r ON(bhr.rolle_id = r.id) " +
                    "WHERE bhr.benutzer_id = ?");
            ps.setInt(1, benutzerId);
            ResultSet rs = ps.executeQuery();
            List<Rolle> rollen = new ArrayList<>();
            while (rs.next()){
                rollen.add(new Rolle(rs.getInt("id"), rs.getString("name")));
            }
            return rollen;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
