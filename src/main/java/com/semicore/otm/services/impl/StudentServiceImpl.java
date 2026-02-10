package com.semicore.otm.services.impl;

import com.semicore.otm.dao.repositories.StudentRepository;
import com.semicore.otm.requests.StudentRequest;
import com.semicore.otm.responses.StudentResponse;
import com.semicore.otm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        return null;
    }

    @Override
    public void deleteStudent(Long studentId) {

    }

    @Override
    public StudentResponse getStudentById(Long studentId) {
        return null;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return List.of();
    }
}
