import java.util.Scanner;

public class Roles {
    final private String  password = "12345";
    final private String username = "admin";
    Scanner scanner = new Scanner(System.in);
    Authenticate authenticate = new Authenticate();

    public void admin() {

        App.clearConsole();
        System.out.println("---------------------------");
        System.out.println("|   Admin role selected   |");
        System.out.println("---------------------------");

        System.out.println("Enter your admin credentials to login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals(this.username) && password.equals(this.password)) {
            App.clearConsole();
            Dashboard dashboard = new Dashboard();
            dashboard.adminDashboard();
        } else {
            System.out.println("Invalid credentials. Please try again.");
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
            admin();
        }
        scanner.close();

    }

    public void faculty() {
        App.clearConsole();

        System.out.println("---------------------------");
        System.out.println("|  Faculty role selected   |");
        System.out.println("---------------------------");

        System.out.println("Enter your Faculty credentials to login:");
        System.out.print("Faculty ID: ");
        int fid = App.idValidator();
        System.out.println("ID IS " + fid);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println("Authenticating...");
        App.holdScreen(1000); // Pause for a moment to show the result
        System.out.println("Authentication result: " + authenticate.authenticateFaculty(fid, username, password));
        App.holdScreen(1000); // Pause for a moment to show the result
        if (authenticate.authenticateFaculty(fid, username, password)) {
            App.clearConsole();
            Dashboard dashboard = new Dashboard();
            dashboard.facultyDashboard(fid);
        }
    }

    public void student() {
        App.clearConsole();

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("|  Student role selected   |");
        System.out.println("---------------------------");

        System.out.println("Enter your Student ID:");
        int sid = App.idValidator();
        System.out.println("Enter your Student credentials to login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        boolean isAuthenticated = authenticate.authenticateStudent(sid, username, password);
        System.out.println("Authentication result: " + isAuthenticated);
        App.holdScreen(1000); // Pause for a moment to show the result
        if (isAuthenticated) {
            scanner.close();
            App.clearConsole();
            Dashboard dashboard = new Dashboard();
            dashboard.studentDashboard(sid);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // Roles roles = new Roles();
        // roles.admin();
    }

}
