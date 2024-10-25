package com.intern.intern_assignment.course_entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.intern.intern_assignment.student_entity.Student;

// @Entity
// public class Course {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     private String courseNumber;
//     private String courseName;

//     @ManyToMany(mappedBy = "courses")
//     private Set<Student> students = new HashSet<>();

//     // Default constructor
//     public Course() {}

//     // Parameterized constructor, getters, and setters
//     public Course(String courseNumber, String courseName) {
//         this.courseNumber = courseNumber;
//         this.courseName = courseName;
//     }

//     // Getters and setters
//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getCourseNumber() {
//         return courseNumber;
//     }

//     public void setCourseNumber(String courseNumber) {
//         this.courseNumber = courseNumber;
//     }

//     public String getCourseName() {
//         return courseName;
//     }

//     public void setCourseName(String courseName) {
//         this.courseName = courseName;
//     }

//     public Set<Student> getStudents() {
//         return students;
//     }

//     public void setStudents(Set<Student> students) {
//         this.students = students;
//     }
// }

// import org.hibernate.mapping.List;

// @Entity
// public class Course {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long courseId;
    
//     private String courseName;
    
//     @ManyToMany(mappedBy = "courses")
//     private List<Student> students;

//     public Long getCourseId() {
//         return courseId;
//     }

//     public void setCourseId(Long courseId) {
//         this.courseId = courseId;
//     }

//     public String getCourseName() {
//         return courseName;
//     }

//     public void setCourseName(String courseName) {
//         this.courseName = courseName;
//     }

//     public List<Student> getStudents() {
//         return students;
//     }

//     public void setStudents(List<Student> students) {
//         this.students = students;
//     }
//     public Course() {}

//     public Course(String courseNumber, String courseName) {
//                 this.courseId = courseId;
//                 this.courseName = courseName;
//     }


//     // Other fields, constructors, getters, setters
// }
// package com.intern.intern_assignment.course_entity;

import java.util.List;
import com.intern.intern_assignment.student_entity.Student;

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

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
    public Set<Student> getStudents() {
        return students;
    }
    
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

    // public List<Student> getStudents() {
        // return (List<Student>) students;
    // }

    public void setStudents(List<Student> students) {
        this.students = (Set<Student>) students;
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

