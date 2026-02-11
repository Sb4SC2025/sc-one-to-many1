package com.semicore.otm.controllers;

import com.semicore.otm.requests.StudentRequest;
import com.semicore.otm.responses.StudentResponse;
import com.semicore.otm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

     @GetMapping
     public List<StudentResponse> findAllStudents() {
         System.out.print("findAllStudents");
         return studentService.getAllStudents();
     }

     @PostMapping
     public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
         System.out.println("createStudent");
            return studentService.createStudent(studentRequest);
     }

        @PutMapping("/{id}")
        public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
            return studentService.updateStudent(id, studentRequest);
        }

        @DeleteMapping("/{id}")
        public void deleteStudent(@PathVariable Long id) {
            studentService.deleteStudent(id);
        }


}
