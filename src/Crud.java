
import java.sql.*;
import java.util.Scanner;

public class Crud {
    String url = "jdbc:mysql://localhost:3306/collegeDB";
    String username = "root";
    String password = "Sanju@123";
    Scanner scanner = new Scanner(System.in);

    public void addFaculty() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Faculty (fid, fname) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            System.out.print("Enter Faculty ID: ");
            int fid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter Faculty Name: ");
            String fname = scanner.nextLine();
            pstmt.setInt(1, fid);
            pstmt.setString(2, fname);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("Faculty added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding faculty: " + e.getMessage());
        }

    }

    public void removeFaculty() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM Faculty WHERE fid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Faculty ID to remove: ");
            int fid = scanner.nextInt();
            pstmt.setInt(1, fid);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Faculty removed successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing faculty: " + e.getMessage());
        }
        System.out.println("Removing Faculty...");
    }

    public void updateFaculty() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "UPDATE Faculty SET fname = ? WHERE fid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Faculty ID to update: ");
            int fid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new Faculty Name: ");
            String fname = scanner.nextLine();
            pstmt.setString(1, fname);
            pstmt.setInt(2, fid);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Faculty updated successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating faculty: " + e.getMessage());
        }
        System.out.println("Updating Faculty Details...");
    }

    public void addStudent() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Students (sid, sname, dept) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID: ");
            int sid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter Student Name: ");
            String sname = scanner.nextLine();
            System.out.print("Enter Student Department: ");
            String dept = scanner.nextLine();
            pstmt.setInt(1, sid);
            pstmt.setString(2, sname);
            pstmt.setString(3, dept);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Student added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }

        System.out.println("Adding Student...");
    }

    public void removeStudent() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM Students WHERE sid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID to remove: ");
            int sid = scanner.nextInt();
            pstmt.setInt(1, sid);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Student removed successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing student: " + e.getMessage());
        }
        System.out.println("Removing Student...");
    }

    public void updateStudent() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "UPDATE Students SET sname = ?, dept = ? WHERE sid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID to update: ");
            int sid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new Student Name: ");
            String sname = scanner.nextLine();
            System.out.print("Enter new Student Department: ");
            String dept = scanner.nextLine();
            pstmt.setString(1, sname);
            pstmt.setString(2, dept);
            pstmt.setInt(3, sid);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Student updated successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
        System.out.println("Updating Student Details...");
    }

    public void addCourse() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Course (cid, cname) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Course ID: ");
            int cid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter Course Name: ");
            String cname = scanner.nextLine();
            pstmt.setInt(1, cid);
            pstmt.setString(2, cname);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Course added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
        System.out.println("Adding Course...");
    }

    public void removeCourse() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM Course WHERE cid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Course ID to remove: ");
            int cid = scanner.nextInt();
            pstmt.setInt(1, cid);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Course removed successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing course: " + e.getMessage());
        }
        System.out.println("Removing Course...");
    }

    public void updateCourse() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "UPDATE Course SET cname = ? WHERE cid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Course ID to update: ");
            int cid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new Course Name: ");
            String cname = scanner.nextLine();
            pstmt.setString(1, cname);
            pstmt.setInt(2, cid);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Course updated successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating course: " + e.getMessage());
        }
        System.out.println("Updating Course Details...");
    }

    public void addMarks() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Marks (student_id, course_id, marks) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter Course ID: ");
            int courseId = scanner.nextInt();
            System.out.print("Enter Marks: ");
            int marks = scanner.nextInt();
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.setInt(3, marks);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Marks added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding marks: " + e.getMessage());
        }
        System.out.println("Adding Marks...");
    }

    public void updateMarks() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "UPDATE Marks SET marks = ? WHERE student_id = ? AND course_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter Course ID: ");
            int courseId = scanner.nextInt();
            System.out.print("Enter new Marks: ");
            int marks = scanner.nextInt();
            pstmt.setInt(1, marks);
            pstmt.setInt(2, studentId);
            pstmt.setInt(3, courseId);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Marks updated successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating marks: " + e.getMessage());
        }
        System.out.println("Updating Marks...");
    }

    public void viewStudentMarks() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Marks";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Marks List:");
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                int courseId = rs.getInt("course_id");
                int marks = rs.getInt("marks");
                System.out.println("Student ID: " + studentId + ", Course ID: " + courseId + ", Marks: " + marks);
            }
        } catch (SQLException e) {
            System.out.println("Error viewing marks: " + e.getMessage());
        }
        System.out.println("Viewing Marks...");
    }

    public void viewCourses() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Course";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Courses List:");
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String cname = rs.getString("cname");
                System.out.println("Course ID: " + cid + ", Course Name: " + cname);
            }
        } catch (SQLException e) {
            System.out.println("Error viewing courses: " + e.getMessage());
        }

        System.out.println("Viewing Courses...");
    }

    public void viewAssignedCourses() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT c.cid, c.cname FROM Course c " +
                    "JOIN faculty_course fc ON c.cid = fc.course_id " +
                    "WHERE fc.faculty_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Faculty ID: ");
            int fid = scanner.nextInt();
            pstmt.setInt(1, fid);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Assigned Courses for Faculty ID " + fid + ":");
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String cname = rs.getString("cname");
                System.out.println("Course ID: " + cid + ", Course Name: " + cname);
            }
        } catch (SQLException e) {
            System.out.println("Error viewing assigned courses: " + e.getMessage());
        }
        System.out.println("Viewing Assigned Courses...");
    }

    public void changeStudentPassword() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_credentials SET password = ? WHERE sid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID: ");
            int sid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new Password: ");
            String newPassword = scanner.nextLine();
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, sid);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Password updated successfully for Student ID: " + sid);
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
        System.out.println("Changing Student Password...");
    }

    public String[] fetchStudentDetails(int sid) {
        String[] details = new String[2];
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Students WHERE sid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, sid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String sname = rs.getString("sname");
                String dept = rs.getString("dept");
                details[0] = sname;
                details[1] = dept;
            }
        } catch (SQLException e) {
            System.out.println("Error fetching student details: " + e.getMessage());
        }   
        return details;
    }

    public String fetchFaculty(int fid) {
        String fname = null;    
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT fname FROM Faculty WHERE fid = ?";   
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, fid);
            ResultSet rs = pstmt.executeQuery();    
            if (rs.next()) {
                fname = rs.getString("fname");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching faculty name: " + e.getMessage());
        }
        return fname;
    }

    public void facultyPWD() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "Insert into faculty_credentials (fid,username, password) values (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Faculty ID: ");
            int fid = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Faculty Username: ");
            String fname = scanner.nextLine();
            System.out.print("Enter Faculty Password: ");
            String newPassword = scanner.nextLine();
            pstmt.setInt(1, fid);
            pstmt.setString(2, fname);
            pstmt.setString(3, newPassword);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Password updated successfully for Faculty ID: " + fid);
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
    }
    public void studentPWD(){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "Insert into student_credentials (sid, username,password) values (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID: ");
            int sid = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Student Username: ");
            String sname = scanner.nextLine();
            System.out.print("Enter Student Password: ");
            String newPassword = scanner.nextLine();
            pstmt.setInt(1, sid);
            pstmt.setString(2, sname);
            pstmt.setString(3, newPassword);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Password updated successfully for Student ID: " + sid);
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
        System.out.println("Changing Student Password...");
    }


    public void checkResults() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT c.cid, c.cname, m.marks FROM Course c " +
                    "JOIN Marks m ON c.cid = m.course_id " +
                    "WHERE m.student_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            System.out.print("Enter Student ID: ");
            int sid = scanner.nextInt();
            pstmt.setInt(1, sid);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Results for Student ID " + sid + ":");
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String cname = rs.getString("cname");
                int marks = rs.getInt("marks");
                System.out.println("Course ID: " + cid + ", Course Name: " + cname + ", Marks: " + marks);
            }
        } catch (SQLException e) {
            System.out.println("Error checking results: " + e.getMessage());
        }
        System.out.println("Checking Results...");
    }

}
