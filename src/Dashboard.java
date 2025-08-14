
import java.util.Scanner;

public class Dashboard {
    Scanner sc = new Scanner(System.in);

    public void adminDashboard() {
        System.out.println("-----------------------------------");
        System.out.println("| Welcome to the Admin Dashboard! |");
        System.out.println("-----------------------------------");
        System.out.println("1. Manage Faculty");
        System.out.println("2. Manage Students");
        System.out.println("3. Manage Courses");
        System.out.println("4. Logout");
        int choice = App.choiceSelector(sc, 1, 4);
        switch (choice) {
            case 1 -> {
                App.clearConsole();
                System.out.println("------------------------------");
                System.out.println("|   Manage Faculty Section    |");
                System.out.println("------------------------------\n");
                System.out.println("1. Add Faculty");
                System.out.println("2. Remove Faculty");
                System.out.println("3. Update Faculty Details");
                System.out.println("4. Faculty Credentials");
                System.out.println("5. View All Faculty");
                System.out.println("6. Back to Admin Dashboard");
                int facultyChoice = App.choiceSelector(sc, 1, 6);
                switch (facultyChoice) {
                    case 1 -> {
                        Crud crud = new Crud();
                        crud.addFaculty();
                        adminDashboard();

                    }
                    case 2 -> {
                        Crud crud = new Crud();
                        crud.removeFaculty();
                        adminDashboard();

                    }
                    case 3 -> {
                        Crud crud = new Crud();
                        crud.updateFaculty();
                        adminDashboard();
                    }
                    case 4 -> {
                        Crud crud = new Crud();
                        crud.facultyPWD();
                        adminDashboard();
                    }
                    case 5 -> {
                        Crud crud = new Crud();
                        String[][] fRecords=crud.viewAllFaculty();
                        App.clearConsole();
                        System.out.println("Faculty Records:");
                        System.out.println("-----------------");
                        System.out.println("ID\tName");
                        System.out.println("-----------------");
                        for (String[] record : fRecords) {
                            System.out.println(record[0] + "\t" + record[1]);
                        }
                        System.out.println("-----------------");
                        System.out.print("\nPress Enter to continue...");
                        sc.nextLine();
                        App.clearConsole();
                        adminDashboard();

                    }
                    case 6 -> {
                        App.clearConsole();
                        adminDashboard(); 
                    }

                }
            }
            case 2 -> {
                App.clearConsole();
                System.out.println("------------------------------");
                System.out.println("|   Manage Students Section    |");
                System.out.println("------------------------------\n");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Update Student Details");
                System.out.println("4. Student Credentials");
                System.out.println("5. View All Students");
                System.out.println("6. Back to Admin Dashboard");
                int studentChoice = App.choiceSelector(sc, 1, 6);
                switch (studentChoice) {
                    case 1 -> {
                        Crud crud = new Crud();
                        crud.addStudent();
                        System.out.println("Student added successfully.");
                        adminDashboard();

                    }
                    case 2 -> {
                        Crud crud = new Crud();
                        crud.removeStudent();
                        System.out.println("Student removed successfully.");
                        adminDashboard();
                    }
                    case 3 -> {
                        Crud crud = new Crud();
                        crud.updateStudent();
                        System.out.println("Student details updated successfully.");
                        adminDashboard();
                    }
                    case 4 -> {
                        Crud crud = new Crud();
                        crud.studentPWD();
                        adminDashboard();
                    }
                    case 5 -> {
                        Crud crud = new Crud();
                        String[][] sRecords=crud.viewAllStudents();
                        App.clearConsole();
                        System.out.println("Student Records:");
                        System.out.println("------------------------------");
                        System.out.println("ID\tName\tDepartment");
                        System.out.println("------------------------------");
                        for (String[] record : sRecords) {
                            System.out.println(record[0] + "\t" + record[1] + "\t" + record[2]);
                        }
                        System.out.println("------------------------------");
                        System.out.print("\nPress Enter to continue...");
                        sc.nextLine();
                        App.clearConsole();
                        adminDashboard();

                    }

                    case 6 -> {
                        App.clearConsole();
                        adminDashboard(); // Go back to Admin Dashboard
                    }
                }
            }

            case 3 -> {
                App.clearConsole();
                System.out.println("------------------------------");
                System.out.println("|   Manage Courses Section     |");
                System.out.println("------------------------------\n");
                System.out.println("1. Add Course");
                System.out.println("2. Remove Course");
                System.out.println("3. Update Course Details");
                System.out.println("4. View All Courses");
                // Added option to view all courses
                System.out.println("5. Back to Admin Dashboard");
                int courseChoice = App.choiceSelector(sc, 1, 5);
                switch (courseChoice) {
                    case 1 -> {
                        Crud crud = new Crud();
                        crud.addCourse();
                        System.out.println("Course added successfully.");
                        adminDashboard();
                    }
                    case 2 -> {
                        Crud crud = new Crud();
                        crud.removeCourse();
                        System.out.println("Course removed successfully.");
                        adminDashboard();
                    }
                    case 3 -> {
                        Crud crud = new Crud();
                        crud.updateCourse();
                        System.out.println("Course details updated successfully.");
                        adminDashboard();
                    }
                    case 4 -> {
                        Crud crud = new Crud();
                        String[][] cRecords=crud.viewAllCourses();
                        App.clearConsole();
                        System.out.println("Course Records:");
                        System.out.println("--------------------");
                        System.out.println("ID\tName");
                        System.out.println("--------------------");
                        for (String[] record : cRecords) {
                            System.out.println(record[0] + "\t" + record[1]);
                        }
                        System.out.println("---------------------");
                        System.out.print("\nPress Enter to continue...");
                        sc.nextLine();
                        App.clearConsole();
                        adminDashboard();

                    }
                    case 5 -> {
                        App.clearConsole();
                        App.loginType(); 
                        App.roleSelection(); 
                    }
                }
            }
            case 4 -> {
                System.out.println("Logging out...");
                System.out.print("Press Enter to continue...");
                sc.nextLine();
                App.clearConsole();
                App.loginType(); 
                App.roleSelection(); 

            }

        }
    }

    public void facultyDashboard(int fid) {
        Crud crud = new Crud();
        String fname= crud.fetchFaculty(fid);
        System.out.println("-------------------------------------");
        System.out.println("| Welcome to the Faculty Dashboard! |");
        System.out.println("-------------------------------------");
        System.out.println("Faculty ID: " + fid);
        System.out.println("Name: " + fname + "\n");
        System.out.println("1. View Assigned Courses");
        System.out.println("2. Put Marks");
        System.out.println("3. View Student Marks");
        System.out.println("4. Logout");
        int choice = App.choiceSelector(sc, 1, 4);
        switch (choice) {
            case 1 -> {
                crud.viewAssignedCourses();
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                facultyDashboard(fid); 
            }
            case 2 -> {
                crud.addMarks();
                System.out.println("Marks put successfully.");
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                facultyDashboard(fid); 
            }
            case 3 -> {
                crud.viewStudentMarks();
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                facultyDashboard(fid); 
            }
            case 4 -> {
                System.out.println("Logging out...");
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                App.clearConsole();
                App.loginType(); 
                App.roleSelection(); 
            }
        }

    }

    public void studentDashboard(int sid) {
        Crud crud = new Crud();
        String arr[]=crud.fetchStudentDetails(sid);
        System.out.println("------------------------------------");
        System.out.println("| Welcome to the Student Dashboard! |");
        System.out.println("------------------------------------");
        System.out.println("Student ID: " + sid);
        System.out.println("Name: " + arr[0]);
        System.out.println("Department: " + arr[1]+"\n");
        System.out.println("1. View Courses");
        System.out.println("2. Check Results");
        System.out.println("3. Change Password");
        System.out.println("4. Logout");
        int choice = App.choiceSelector(sc, 1, 4);
        switch (choice) {
            case 1 -> {
                crud.viewCourses();
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                App.clearConsole();
                studentDashboard(sid); 
            }
            case 2 -> {
                crud.checkResults();
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                App.clearConsole();
                studentDashboard(sid); 
            }
            case 3 -> {
                crud.changeStudentPassword(sid);
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                App.clearConsole();

                studentDashboard(sid); 
            }
            case 4 -> {
                System.out.println("Logged out successfully.");
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
                App.clearConsole();
                App.loginType(); 
                App.roleSelection(); 
            }
        }
    }
}
