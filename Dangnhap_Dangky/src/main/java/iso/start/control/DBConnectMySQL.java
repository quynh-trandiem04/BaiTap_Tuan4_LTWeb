package iso.start.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectMySQL {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/dangnhap_dangky";
    private static Connection con = null;

    public static Connection getDatabaseConnection() throws IOException {
        try {
            if (con == null || con.isClosed()) {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            Connection c = getDatabaseConnection();
            if (c == null) {
                System.out.println("Something is wrong");
            } else {
                System.out.println("Connection successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
