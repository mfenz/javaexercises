package at.cb.kfzteile.dao;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Dokument;
import at.cb.kfzteile.model.Warengruppe;
import at.cb.kfzteile.service.BenutzerService;
import at.cb.kfzteile.service.DokumenteService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WarengruppenDao {
    public static int createWarengruppe(Warengruppe warengruppe){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "INSERT INTO warengruppe " +
                    "(leiter_benutzer_id, bezeichnung) " +
                    "VALUES " +
                    "(?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, warengruppe.getLeiter().getId());
            ps.setString(2, warengruppe.getBezeichnung());
            int rowCount = ps.executeUpdate();
            if(rowCount > 0){
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if(generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
            throw new DaoException("Warengruppe konnte nicht erstellt werden");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static List<Warengruppe> getWarengruppen(){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM warengruppe ");
            ResultSet rs = ps.executeQuery();
            List<Warengruppe> warengruppen = new ArrayList<>();
            while (rs.next()){

                Benutzer benutzer = BenutzerService
                        .getBenutzerById(rs.getInt("leiter_benutzer_id")).get();

                // Dokumente laden
                List<Dokument> dokumente = DokumenteService.getDokumenteByWarengruppeId(rs.getInt("id"));


                warengruppen.add(new Warengruppe(
                        rs.getInt("id"),
                        benutzer,
                        rs.getString("bezeichnung"),
                        dokumente
                ));
            }
            return warengruppen;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static Optional<Warengruppe> getWarengruppeById(int id){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM warengruppe " +
                    "WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){

                // Benutzer laden
                Benutzer benutzer = BenutzerService
                        .getBenutzerById(rs.getInt("leiter_benutzer_id")).get();

                // Dokumente laden
                List<Dokument> dokumente = DokumenteService.getDokumenteByWarengruppeId(rs.getInt("id"));

                Warengruppe warengruppe = new Warengruppe(
                        rs.getInt("id"),
                        benutzer,
                        rs.getString("bezeichnung"),
                        dokumente
                );
                return Optional.of(warengruppe);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
