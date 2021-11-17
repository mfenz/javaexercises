package at.cb.immo.dao;

import at.cb.immo.model.Immobilie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImmobilieDAO {
    public static int createImmobilie(String type, String adresse,
                                      float kaufpreis, String fotoUrl){
        try(Connection conn = DbConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement("" +
                    "INSERT INTO immobilie " +
                    "(typ, adresse, kaufpreis, foto_url) " +
                    "VALUES " +
                    "(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type);
            ps.setString(2, adresse);
            ps.setFloat(3, kaufpreis);
            ps.setString(4, fotoUrl);
            int rowCount = ps.executeUpdate();
            if(rowCount > 0 && ps.getGeneratedKeys().next()){
                return ps.getGeneratedKeys().getInt(1);
            }
            throw new DAOException("Immobilie nicht angelegt");
        } catch (SQLException e){
            throw new DAOException(e);
        }
    }

    public static List<Immobilie> getImmobilien(){
        try(Connection conn = DbConnection.getConnection()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM immobilie");
            List<Immobilie> result = new ArrayList<>();
            while (rs.next()){
                Immobilie immo = new Immobilie(
                        rs.getInt("id"),
                        rs.getString("typ"),
                        rs.getString("adresse"),
                        rs.getFloat("kaufpreis"),
                        rs.getString("foto_url")
                );
                result.add(immo);
            }
            return result;
        } catch (SQLException e){
            throw new DAOException(e);
        }
    }

    public static Optional<Immobilie> getImmobilieById(int id){
        try(Connection conn = DbConnection.getConnection()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("" +
                    "SELECT * " +
                    "FROM immobilie " +
                    "WHERE id = " + id);
            while (rs.next()){
                Immobilie immo = new Immobilie(
                        rs.getInt("id"),
                        rs.getString("typ"),
                        rs.getString("adresse"),
                        rs.getFloat("kaufpreis"),
                        rs.getString("foto_url")
                );
                return Optional.of(immo);
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new DAOException(e);
        }
    }

    public static void update(Immobilie immo){
        try(Connection conn = DbConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement("" +
                    "UPDATE immobilie " +
                    "SET typ = ?, adresse = ?, kaufpreis = ?, foto_url = ? " +
                    "WHERE id = ?");
            ps.setString(1, immo.getType());
            ps.setString(2, immo.getAdresse());
            ps.setFloat(3, immo.getKaufpreis());
            ps.setString(4, immo.getFotoUrl());
            ps.setInt(5, immo.getId());
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DAOException(e);
        }
    }
}
