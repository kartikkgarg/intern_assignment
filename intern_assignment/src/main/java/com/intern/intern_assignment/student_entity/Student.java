
package com.intern.intern_assignment.student_entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intern.intern_assignment.course_entity.Course; // Import Course class

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "student_ID", length = 11)
    private int student_ID;

    @Column(name = "student first name", length = 45)
    private String firstname;

    @Column(name = "student last name", length = 45)
    private String lastname;

    @Column(name = "student email", length = 405)
    private String email;

    @ManyToMany
    @JoinTable(
        name = "course_students",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
        private Set<Course> courses = new HashSet<>();
    // Getters, setters, constructor, etc.

    
    public Student() {
    }
    // @JsonIgnore
    // private Set<Course> course; // For Student class

    

    public Student(String firstname, String lastname, String email) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public int getId() {
        return student_ID;
    }

    public void setId(int id) {
        this.student_ID = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // public List<Course> getCourses() {
        // return new ArrayList<>(courses);
    // }

// Set course list by converting to a Set internally
    public void setCourses(List<Course> courses) {
        this.courses = new HashSet<>(courses);
    }

    // Convert the courses Set to a List for retrieval in Controller
    public List<Course> getCourses() {
    return new ArrayList<>(courses);
}

// Enroll method
    public void enrollInCourse(Course course) {
        this.courses.add(course);
    course.getStudents().add(this);

    // public List<Course> getCourses() {
        // return (List<Course>) courses;
    }

    // public void setCourses(List<Course> courses) {
        // this.courses = (Set<Course>) courses;
    

    // Method to enroll in a course
    // public void enrollInCourse(Course course) {
        // this.courses.add(course);
        // course.getStudents().add(this);
    
    

    @Override
    public String toString() {
        return "Student [id=" + student_ID + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
    }

}

    // @ManyToMany(mappedBy = "students") // Make sure this matches the field name in Course class
    // private Set<Course> courses = new HashSet<>();

    // Getters, setters, constructor, etc.
    

