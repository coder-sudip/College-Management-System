import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticate {

    final String url = "jdbc:mysql://localhost:3306/collegeDB";
    final String username = "root";
    final String password = "Sanju@123";

    public boolean authenticateStudent(int sid, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
            return false;
        }
        try {
            Connection con = DriverManager.getConnection(url, this.username, this.password);
            String query = "SELECT * FROM student_credentials WHERE sid = ? AND username = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, sid);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");
                if (dbUsername.equals(username) && dbPassword.equals(password)) {
                    System.out.println("Authentication successful for Student ID: " + sid);
                    return true;
                }
            }
        }

        catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return false;
        }
        System.out.println("Authentication failed for Student ID: " + sid);
        return false;
    }

    public boolean authenticateFaculty(int fid, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
            return false;
        }
        try {
            Connection con = DriverManager.getConnection(url, this.username, this.password);
            String query = "SELECT * FROM faculty_credentials WHERE fid = ? AND username = ? AND password = ?"; 
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, fid);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String dbUsername = rs.getString("username");
                try {
                    
                    Thread.sleep(1000); 
                } catch (Exception e) { 

                }
                String dbPassword = rs.getString("password");   
                if (dbUsername.equals(username) && dbPassword.equals(password)) {
                    System.out.println("Authentication successful for Faculty ID: " + fid);
                    
                    return true;
                }
                
            }
        }
        catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return false;
        }
        System.out.println("Authentication failed for Faculty ID: " + fid);
        return false;
    }
}
