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
}
