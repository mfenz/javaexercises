package at.cb.kfzteile.dao;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Interessent;
import at.cb.kfzteile.model.Rolle;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BenutzerDao {
    public static int createBenutzer(Benutzer benutzer){
        try(Connection con = DbConnection.getConnection()){

            String passwordHash = BCrypt.hashpw(benutzer.getPasswort(), BCrypt.gensalt());

            PreparedStatement ps = con.prepareStatement("" +
                    "INSERT INTO benutzer " +
                    "(vorname, nachname, email, passwort, warengruppe_id) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, benutzer.getVorname());
            ps.setString(2, benutzer.getNachname());
            ps.setString(3, benutzer.getEmail());
            ps.setString(4, passwordHash);
            if(benutzer.getWarengruppeId().isPresent()){
                ps.setInt(5, benutzer.getWarengruppeId().get());
            } else {
                ps.setNull(5, Types.NULL);
            }

            int rowCount = ps.executeUpdate();
            if(rowCount > 0){
                // Welche ID hat der neue Datensatz?
                ResultSet generatedKey = ps.getGeneratedKeys();
                if(generatedKey.next()){
                    return generatedKey.getInt(1);
                }
            }
            throw new DaoException("Benutzer konnte nicht gespeichert werden");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static Optional<Benutzer> getBenutzerByEmail(String email){
        try(Connection con = DbConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT *, b.id AS benutzerId, r.id AS rolleId, i.benutzer_id AS interessentId " +
                    "FROM benutzer b " +
                    "LEFT JOIN benutzer_hat_rolle bhr ON (b.id = bhr.benutzer_id) " +
                    "LEFT JOIN rolle r ON(bhr.rolle_id = r.id) " +
                    "LEFT JOIN interessent i ON(b.id = i.benutzer_id) " +
                    "WHERE email = ?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            Benutzer benutzer = null;
            List<Rolle> rollen = new ArrayList<>();
            Optional<Interessent> interessent = Optional.empty();
            while (rs.next()){
                Optional<Integer> warengruppeId;
                if(rs.getInt("warengruppe_id") == 0){
                    warengruppeId = Optional.empty();
                } else {
                    warengruppeId = Optional.of(rs.getInt("warengruppe_id"));
                }

                // interessent
                if(rs.getInt("interessentId") != 0){
                    interessent = Optional.of(new Interessent(
                            rs.getString("strasse"),
                            rs.getString("plz"),
                            rs.getString("ort"),
                            rs.getString("firmenname")
                    ));
                }

                // rolle
                if(rs.getInt("rolleId") != 0){
                    rollen.add(new Rolle(
                            rs.getInt("rolleId"),
                            rs.getString("name")
                    ));
                }

                // benutzer
                benutzer = new Benutzer(
                        rs.getInt("benutzerId"),
                        rs.getString("vorname"),
                        rs.getString("nachname"),
                        rs.getString("email"),
                        rs.getString("passwort"),
                        warengruppeId,
                        rollen, interessent
                );
            }
            return Optional.ofNullable(benutzer);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static Optional<Benutzer> getBenutzerById(int id){
        try(Connection con = DbConnection.getConnection()){
            // für den Benutzer brauche ich ...
            // Rollen
            // Interessent

            PreparedStatement ps = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM benutzer " +
                    "WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){

                Optional<Integer> warengruppeId;
                if(rs.getInt("warengruppe_id") == 0){
                    warengruppeId = Optional.empty();
                } else {
                    warengruppeId = Optional.of(rs.getInt("warengruppe_id"));
                }

                // Rollen laden
                List<Rolle> rollen = RollenDao.getBenutzerRollen(id);

                // Interessent laden
                Optional<Interessent> interessent = InteressentenDao.getInteressentByBenutzerId(id);

                Benutzer benutzer = new Benutzer(
                        rs.getInt("id"),
                        rs.getString("vorname"),
                        rs.getString("nachname"),
                        rs.getString("email"),
                        rs.getString("passwort"),
                        warengruppeId,
                        rollen,
                        interessent
                );
                return Optional.of(benutzer);
            }
            throw new DaoException("Benutzer nicht gefunden");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
