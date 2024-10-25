package com.intern.intern_assignment.controller;

// import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;

// // // import org.springframework.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.intern.intern_assignment.course_entity.Course;
import com.intern.intern_assignment.coursereposiotry.coursereposiotry;
// // import com.intern.intern_assignment.STD_data.studentdata;
// // import com.intern.intern_assignment.STD_data.studentsavedata;
// // import com.intern.intern_assignment.course_entity.Course;
// // // import com.intern.intern_assignment.Course;
// // import com.intern.intern_assignment.coursereposiotry.coursereposiotry;
import com.intern.intern_assignment.reposiotry.reposiotry;
// // import com.intern.intern_assignment.service.student_service;
import com.intern.intern_assignment.student_entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;



// //     @PostMapping(path = "/save")
// //     public String postMethodName(@RequestBody String entity) {

        
// //         return entity;
// //     }
    

// //     @Autowired
// //     private student_service student_service;

// //     public String savestudent(@RequestBody studentsavedata studentsavedata)
// //     {
// //         String stname= student_service.addstudent(studentsavedata);
// //         return stname;
// //     } 

// //     public List<Student>getallstudents(){
// //         List<Student>students= repo.findAll();
// //             return students;


// //     }


// package com.intern.intern_assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Controller {
    @Autowired
    reposiotry repo;

    @Autowired
    coursereposiotry courseRepo;


    @GetMapping("/students")
    // public String getMethodName(@RequestParam String param) {
        // return new String();
    // }
    
    public List<Student>getallstudents(){
                List<Student>students= repo.findAll();
                    return students;
    }

    @GetMapping("/students/{id}")
        public Student getstudents(@PathVariable int id){
            Student Student = repo.findById(id).get();
            return Student;
        }

    @PostMapping("/students/add")
    public void createstudent(@RequestBody Student Student)
    {
        repo.save(Student);
    }

    @PutMapping("students/update/{id}")
        public Student updaStudent(@PathVariable int id) {
            Student student=repo.findById(id).get();
            student.setFirstname("deepak");
            student.setLastname("g");
            repo.save(student);
            return student;}


    @DeleteMapping("students/delete/{id}")
        public void removestudent(@PathVariable int id)
            {
                    Student student =repo.findById(id).get();
                    repo.delete(student);
        // //         }
            }
    @GetMapping("/courses")

    public List<Course> getAllCourses() {
    return courseRepo.findAll();
    }
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseRepo.findById(id).orElse(null);}

    @PostMapping("/courses/add")
        public void createCourse(@RequestBody Course course) {
            courseRepo.save(course);
        }


        
    // @PutMapping("/courses/update/{id}")
    //     public Course updateCourse(@PathVariable int id) {
    //     Course course = courseRepo.findById(id).get();
    //         // if (course != null) {
    //             course.setCourseName("hindi");
    //             // course.setCourseId(updatedCourse.getCourseId());
    //                 return courseRepo.save(course);
                
    //             // return null;
    //         }
    
    @PutMapping("/courses/update/{id}")
        public Course updateCourse(@PathVariable int id, @RequestBody Course updatedCourse) {
            Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
                
                // Update course details with data from the request body
                if (updatedCourse.getCourseName() != null) {
                    course.setCourseName(updatedCourse.getCourseName());
                }
                // Add additional fields here if needed
                
                return courseRepo.save(course);
            }
            

    
        
            @DeleteMapping("/courses/delete/{id}")
            public void deleteCourse(@PathVariable int id) {
                courseRepo.deleteById(id);
            }

            // @GetMapping("/courses/{courseId}/students")
            // public Set<Student> getStudentsByCourseId(@PathVariable int courseId) {
            // Course course = courseRepo.findById(courseId)
            // .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
            // return course.getStudents(); // Return as Set

            @GetMapping("/courses/{courseId}/students")
            public List<Student> getStudentsByCourseId(@PathVariable int courseId) {
                Course course = courseRepo.findById(courseId)
                    .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
    
                return new ArrayList<>(course.getStudents()); // Convert Set to List
}


            @PostMapping("/students/{studentId}/enroll/{courseId}")
            public Student enrollStudentInCourse(@PathVariable int studentId, @PathVariable int courseId) {
            Student student = repo.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
            Course course = courseRepo.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));

            student.getCourses().add(course);
            course.getStudents().add(student);

            repo.save(student); // Save to update the association in the database
            return student;
}

}

    // @GetMapping("/")
    // public String home() {
        // return "Welcome to the Student Management System!";

