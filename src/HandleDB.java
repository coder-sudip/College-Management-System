import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HandleDB {
    public void setupDatabase() {
        System.out.println("Setting up database connection...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
            return;
        }

        String initialUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Sanju@123";

        try (Connection con = DriverManager.getConnection(initialUrl, username, password);
                Statement stmnt = con.createStatement()) {

            // Create DB if not exists
            stmnt.executeUpdate("CREATE DATABASE IF NOT EXISTS CollegeDB");
            System.out.println("Database created or already exists.");

        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
            return;
        }

        // Now connect directly to CollegeDB
        String dbUrl = "jdbc:mysql://localhost:3306/CollegeDB";
        try (Connection con = DriverManager.getConnection(dbUrl, username, password);
                Statement stmnt = con.createStatement()) {

            // Students Table
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Students (" +
                            "sid INT PRIMARY KEY, " +
                            "sname VARCHAR(50) NOT NULL, " +
                            "dept VARCHAR(50)" +
                            ")");

            // Faculty Table
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Faculty (" +
                            "fid INT PRIMARY KEY, " +
                            "fname VARCHAR(50) NOT NULL" +
                            ")");

            // Courses Table
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Course (" +
                            "cid INT PRIMARY KEY, " +
                            "cname VARCHAR(50) NOT NULL" +
                            ")");

            // Marks Table
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Marks (" +
                            "student_id INT, " +
                            "course_id INT, " +
                            "marks INT, " +
                            "PRIMARY KEY(student_id, course_id), " +
                            "FOREIGN KEY (student_id) REFERENCES Students(sid), " +
                            "FOREIGN KEY (course_id) REFERENCES Course(cid)" +
                            ")");

            // Student-Course Mapping
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS student_course (" +
                            "student_id INT, " +
                            "course_id INT, " +
                            "PRIMARY KEY(student_id, course_id), " +
                            "FOREIGN KEY (student_id) REFERENCES Students(sid), " +
                            "FOREIGN KEY (course_id) REFERENCES Course(cid)" +
                            ")");

            // Faculty-Course Mapping
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS faculty_course (" +
                            "faculty_id INT, " +
                            "course_id INT, " +
                            "PRIMARY KEY(faculty_id, course_id), " +
                            "FOREIGN KEY (faculty_id) REFERENCES Faculty(fid), " +
                            "FOREIGN KEY (course_id) REFERENCES Course(cid)" +
                            ")");

            // Faculty Credentials
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS faculty_credentials (" +
                            "fid INT PRIMARY KEY, " +
                            "username VARCHAR(50) NOT NULL, " +
                            "password VARCHAR(50) NOT NULL, " +
                            "FOREIGN KEY (fid) REFERENCES Faculty(fid)" +
                            ")");

            // Student Credentials
            stmnt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS student_credentials (" +
                            "sid INT PRIMARY KEY, " +
                            "username VARCHAR(50) NOT NULL, " +
                            "password VARCHAR(50) NOT NULL, " +
                            "FOREIGN KEY (sid) REFERENCES Students(sid)" +
                            ")");

            System.out.println("Database setup completed successfully.");
            try {
                Thread.sleep(1000); // 1 seconds pause
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error setting up database tables: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HandleDB dbHandler = new HandleDB();
        dbHandler.setupDatabase();
    }
}
