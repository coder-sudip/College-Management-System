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
    }

    

    public void faculty() {
    Scanner scanner = new Scanner(System.in);
    App.clearConsole();

    System.out.println("---------------------------");
    System.out.println("|  Faculty role selected   |");
    System.out.println("---------------------------");

    System.out.println("Enter your Faculty credentials to login:");
    System.out.print("Faculty ID: ");
    int fid = App.idValidator();
    // System.out.println("ID IS " + fid);
    // int fid=2; // For testing purposes, you can replace this with App.idValidator() if needed
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();

    System.out.println("Authenticating...");
    App.holdScreen(1000); 

    boolean isAuthenticated = authenticate.authenticateFaculty(fid, username, password);
    System.out.println("Authentication result: " + isAuthenticated);
    App.holdScreen(1000); 

    if (isAuthenticated) {
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
        System.out.println("You ID IS " + sid);
        System.out.println("Enter your Student credentials to login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        boolean isAuthenticated = authenticate.authenticateStudent(sid, username, password);
        System.out.println("Authentication result: " + isAuthenticated);
        App.holdScreen(1000); 
        if (isAuthenticated) {
            App.clearConsole();
            Dashboard dashboard = new Dashboard();
            dashboard.studentDashboard(sid);
        }
        
    }

    public static void main(String[] args) {
        Roles roles = new Roles();
        // roles.admin();
        roles.faculty();
    }

}
