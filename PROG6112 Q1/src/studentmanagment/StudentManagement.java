package studentmanagment;

import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("Student Management Application");
            System.out.println("*******************************");
            System.out.println("Enter (1) to launch menu or any other key to exit ");
            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("Exiting the application");
                break;
            }
            while (true) {
                System.out.println("Please select one of the following menu items");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit Application");
                input = scanner.nextLine();

                switch (input) {
                    case "1":
                        // Captures a new student with input validation
                        System.out.println("Enter student ID:");
                        String id = scanner.nextLine();

                        System.out.println("Enter Name:");
                        String name = scanner.nextLine();
                        
                         System.out.println("Enter Email:");
                        String email = scanner.nextLine();

                        // Validate age input (must be a number and >= 16)
                        String ageInput;
                        int age = -1;
                        while (age < 16) {
                            System.out.println("Enter age (16 or older):");
                            ageInput = scanner.nextLine();
                            if (ageInput.matches("\\d+")) {  // Check if the input contains only digits
                                age = Integer.parseInt(ageInput);
                                if (age < 16) {
                                    System.out.println("Age must be 16 or older. Please try again.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a valid number.");
                            }
                        }

                        System.out.println("Enter Course:");
                        String course = scanner.nextLine();

                        // Add the student after successful input validation
                        studentManager.addStudent(new Student(id, name, age, course, email));
                        System.out.println("Student added successfully!");
                        break;

                    case "2":
                        System.out.println("Enter student ID to search:");
                        id = scanner.nextLine();
                        Student student = studentManager.searchStudent(id);
                        if (student != null) {
                            System.out.println("Student found:\n" + student);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case "3":
                        System.out.println("Enter student ID to delete:");
                        id = scanner.nextLine();
                        
                        // Ask for confirmation before deleting
                        System.out.println("Are you sure you want to delete the student with ID " + id + "? (yes/no)");
                        String confirmation = scanner.nextLine();
                        
                        if (confirmation.equalsIgnoreCase("yes")) {
                            boolean deleted = studentManager.deleteStudent(id);
                            if (deleted) {
                                System.out.println("Student deleted successfully.");
                            } else {
                                System.out.println("Student not found.");
                            }
                        } else {
                            System.out.println("Deletion cancelled.");
                        }
                        break;

                    case "4":
                        System.out.println("Printing student report...");
                        studentManager.printStudents();
                        break;

                    case "5":
                        System.out.println("Exiting the application.");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
}
