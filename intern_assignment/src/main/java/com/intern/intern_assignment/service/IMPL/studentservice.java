// package com.intern.intern_assignment.service.IMPL;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.intern.intern_assignment.STD_data.studentsavedata;
// import com.intern.intern_assignment.service.student_service;
// import com.intern.intern_assignment.student_entity.Student;

// @Service

// public class studentservice implements student_service {
//     @Autowired
//     private StudentRepository StudentRepository;


//     @Override
//     public String addstudent (studentsavedata studentsavedata)
//     {
//         Student student =new Student(

//             // studentsavedata.getId(),

//             studentsavedata.getFirstname(),
//             studentsavedata.getLastname(),
//             studentsavedata.getEmail()
        
//         );
        
//         StudentRepository.save(student);
//         return student.getFirstname();
//     }

    
// }
