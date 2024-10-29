package com.intern.intern_assignment.course_entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.intern.intern_assignment.student_entity.Student;

// for nesting

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;




import java.util.List;
import com.intern.intern_assignment.student_entity.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course id")
    private int course_Id;
    @Column(name = "course name") 
    private String courseName;

    
// public class Course {
    // other fields and annotations...

    @JsonIgnore
    // @ManyToMany(mappedBy = "courses")
    // private Set<Student> students;

    // other getters, setters, and methods...
// }
    

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();
    
    
    // Default constructor
    public Course() {}

    // Constructor to initialize courseName only
    public Course(String courseName) {
        super();
        this.courseName = courseName;
    }

    // Getters and setters
    public int getCourseId() {
        return course_Id;
    }

    public void setCourseId(int courseId) {
        this.course_Id = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String course_Name) {
        this.courseName = course_Name;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void setStudents(List<Student> students) {
        this.students = new HashSet<>(students);

    }

    @Override
    public String toString() {
        return "Course [courseId=" + course_Id + ", courseName=" + courseName + "]";
    }
    

}

    // public List<Student> getStudents() {
        // return students;
    // }

    // public void setStudents(List<Student> students) {
        // this.students = students;
    // }

