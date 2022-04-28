import java.sql.*;

public class DatabaseConn {
    public static Connection getCon() {
        try {
            String url = "jdbc:mysql://localhost:3306/HealthcareManagement";
            String uname = "vaibhav";
            String pass = "Darkprince2507";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);
            return con;
        } catch (Exception e) {
            return null;
        }
    }
}
