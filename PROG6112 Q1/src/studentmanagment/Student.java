/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagment;

public class Student {
    private String id;
    private String name;
    private int age;
    private String course;
    private String email;

    
    //code attribution
    //Inheritance and Constructors in Java
    //https://www.geeksforgeeks.org/inheritance-and-constructors-in-java/
    
    // Constructor
    public Student(String id, String name, int age, String course, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

  
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
    
      public String getEmail() {
        return email;
    }

    
   public String toString() {
    return "Student ID: " + id + "\n" +
           "Student Name: " + name + "\n" +
           "Student Age: " + age + "\n" +
           "Student Email :" + email + "\n" +
           "Course: " + course;
}

}
