package com.semicore.otm.services;

import com.semicore.otm.requests.StudentRequest;
import com.semicore.otm.responses.StudentResponse;

import java.util.List;

public interface StudentService {
        StudentResponse createStudent(StudentRequest studentRequest);
        StudentResponse updateStudent(Long studentId, StudentRequest studentRequest);
        void deleteStudent(Long studentId);
        StudentResponse getStudentById(Long studentId);
        List<StudentResponse> getAllStudents();
}
