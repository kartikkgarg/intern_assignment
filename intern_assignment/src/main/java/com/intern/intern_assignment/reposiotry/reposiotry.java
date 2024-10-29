package com.intern.intern_assignment.reposiotry;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.stereotype.Repository;

import com.intern.intern_assignment.student_entity.Student;

// // @Repository

public interface reposiotry extends JpaRepository <Student,Integer>{
    // Optional<Student> findBystudent_ID(String student_Id);
}


