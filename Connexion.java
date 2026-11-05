package ZenCare;

import java.sql.*;
public class Connexion {
    public static Connection connecter() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/zencare?useSSL=false&serverTimezone=UTC";
            
            Connection con = DriverManager.getConnection(url, "root", "");
            return con;
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } catch (Exception e) {
        }
        return null;
    }

    // CE TEST DOIT ÊTRE LANCÉ SÉPARÉMENT (CLIC DROIT > RUN FILE)
    public static void main(String[] args) {
        connecter();
    }
}