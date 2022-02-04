package at.cb.kfzteile.dao;

import at.cb.kfzteile.model.Dokument;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DokumenteDao {
    public static int createDokumente(Dokument dokument){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "INSERT INTO dokument " +
                    "(warengruppe_id, pfad, dateiname) " +
                    "VALUES " +
                    "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dokument.getWarengruppeId());
            ps.setString(2, dokument.getPfad());
            ps.setString(3, dokument.getDateiname());
            int rowCount = ps.executeUpdate();
            if(rowCount > 0){
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if(generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
            throw new DaoException("Dokumente konnte nicht erzeugt werden");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static List<Dokument> getDokumenteByWarengruppeId(int warengruppeId){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM dokument " +
                    "WHERE warengruppe_id = ?");
            ps.setInt(1, warengruppeId);
            ResultSet rs = ps.executeQuery();
            List<Dokument> dokumente = new ArrayList<>();
            while (rs.next()){
                dokumente.add(new Dokument(
                        rs.getInt("id"),
                        rs.getInt("warengruppe_id"),
                        rs.getString("pfad"),
                        rs.getString("dateiname")
                ));
            }
            return dokumente;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static Optional<Dokument> getDokumentById(int id){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM dokument " +
                    "WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return Optional.of(new Dokument(
                        rs.getInt("id"),
                        rs.getInt("warengruppe_id"),
                        rs.getString("pfad"),
                        rs.getString("dateiname")
                ));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
