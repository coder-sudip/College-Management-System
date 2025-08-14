import java.util.Scanner;

public class App {
    static void clearConsole() {
        // This is a platform-independent way to clear the console
        // It may not work in all IDEs or environments, but works in most terminal
        // emulators
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }

    static int idValidator() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            if (id > 0) {
                sc.close();
                return id;
            }
        } else {
            System.out.print("Invalid input. Please enter a positive integer.");
            sc.nextLine(); // Consume invalid input
        }
        sc.close();
        return idValidator(); 
    }

    public static void holdScreen(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Error in holdScreen: " + e.getMessage());
        }
    }

    static void homeScreen() {
        System.out.println("------------------------------------");
        System.out.println("|    College Management System!    |");
        System.out.println("------------------------------------\n");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println("3. About System");
    }

    static int choiceSelector(Scanner sc, int lowerBound, int upperBound) {
        int choice = -1;
        while (true) {
            System.out.print("Please select an option: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= lowerBound && choice <= upperBound) {
                    return choice;
                } else {
                    System.out.println(String.format("Invalid input. Please enter a number between %d and %d",
                            lowerBound, upperBound));
                    // System.out.println("Press Enter to continue...");
                    sc.nextLine();

                }
            } else {
                System.out.println(String.format("Invalid input. Please enter a number between %d and %d", lowerBound,
                        upperBound));
                sc.nextLine(); // consume invalid input
                // System.out.println("Press Enter to continue...");
                // sc.nextLine();
            }
        }
    }

    static void loginType() {
        System.out.println("-----------------------------------");
        System.out.println("|   Select Login Type Below:      |");
        System.out.println("-----------------------------------\n");
        System.out.println("1. Admin Login");
        System.out.println("2. Faculty Login");
        System.out.println("3. Student Login");
        System.out.println("4. Back to Home Screen");
    }

    static void roleSelection() {
        Scanner sc = new Scanner(System.in);
        int loginChoice = choiceSelector(sc, 1, 4);
        Roles roles = new Roles();
        switch (loginChoice) {
            case 1 -> {
                roles.admin();
            }
            case 2 -> {
                roles.faculty();
            }
            case 3 -> {
                roles.student();
            }
            case 4 -> {
                clearConsole();
                sc.nextLine();
                return;
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                sc.nextLine();

                // clearConsole();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HandleDB dbHandler = new HandleDB();
        dbHandler.setupDatabase(); // Ensure the database is set up before proceeding
        while (true) {
            clearConsole();
            homeScreen();
            int choice = choiceSelector(sc, 1, 3);
            switch (choice) {
                case 1 -> {
                    clearConsole();
                    sc.nextLine();
                    loginType();
                    roleSelection();

                }
                case 2 -> {
                    clearConsole();
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    return; // Exit the application
                }
                case 3 -> {
                    clearConsole();
                    System.out.println(
                            "This is a College Management System developed to manage student records, courses, and faculty information.");
                    System.out.print("Press Enter to return to the home screen...");
                    sc.nextLine();
                    sc.nextLine();
                    clearConsole();
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}