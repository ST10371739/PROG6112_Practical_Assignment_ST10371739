package studentmanagment;

import java.util.ArrayList;

public class StudentManager {
    // List to hold all students
    private ArrayList<Student> studentList;

    // Constructor
    public StudentManager() {
        this.studentList = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Search for a student by ID
    public Student searchStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null; // Return null if student not found
    }

    // Delete a student by ID
    public boolean deleteStudent(String id) {
        Student student = searchStudent(id); // Find student first
        if (student != null) {
            studentList.remove(student); // Remove if found
            return true;
        }
        return false; // Return false if student not found
    }

    // Print a report of all students
    public void printStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
                System.out.println("----------------------------");
            }
        }
    }
}
