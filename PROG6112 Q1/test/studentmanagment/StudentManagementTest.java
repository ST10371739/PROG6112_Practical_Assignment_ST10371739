/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package studentmanagment;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class StudentManagementTest {

    public StudentManagementTest() {
    }

    @Test
    public void testSaveStudent() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student("101", "John Doe", 20, "Computer Science", "jane@gmail.com");
        studentManager.addStudent(student);
        Student retrievedStudent = studentManager.searchStudent("101");
        assertNotNull(retrievedStudent);
        assertEquals("John Doe", retrievedStudent.getName());
    }

    @Test
    public void testSearchStudent() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student("102", "Jane Doe", 22, "Mathematics", "ann@gmail.com");
        studentManager.addStudent(student);
        Student retrievedStudent = studentManager.searchStudent("102");
        assertNotNull(retrievedStudent);
        assertEquals("Jane Doe", retrievedStudent.getName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        StudentManager studentManager = new StudentManager();

        Student retrievedStudent = studentManager.searchStudent("999");
        assertNull(retrievedStudent); 
    }

    @Test
    public void testDeleteStudent() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student("203", "Charlie", 22, "Math", "anne@gmail.com");
        studentManager.addStudent(student);

        boolean deleted = studentManager.deleteStudent("203");
        assertTrue(deleted); 

        Student retrievedStudent = studentManager.searchStudent("203");
        assertNull(retrievedStudent);
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        StudentManager studentManager = new StudentManager();

        boolean deleted = studentManager.deleteStudent("999");
        assertFalse(deleted); 
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student("204", "David", 18, "Science", "stacy@gmail.com");

      
        studentManager.addStudent(student);

        
        Student retrievedStudent = studentManager.searchStudent("204");
        assertNotNull(retrievedStudent); 
        assertEquals(18, retrievedStudent.getAge()); 
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student("205", "Eva", 15, "History","123@gmail.com");

       
        studentManager.addStudent(student);

        
        Student retrievedStudent = studentManager.searchStudent("205");
        assertNull(retrievedStudent); 
    }

}