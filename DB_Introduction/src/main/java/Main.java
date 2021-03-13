import com.mysql.cj.jdbc.MysqlDataSource;
import model.User;

import java.sql.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("codersbay");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            Random random = new Random();
            insert(conn, new User(random.nextInt(), "Hansi"));

            ResultSet rs = stmt.executeQuery("SELECT id, name FROM user");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id);
                System.out.println(name);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insert(Connection connection, User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO user (id, name) VALUES (?,?) ");
        ps.setInt(1, user.getId());
        ps.setString(2, user.getName());
        ps.executeUpdate();
    }
}
