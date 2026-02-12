package com.semicore.otm.services.impl;

import com.semicore.otm.dao.entities.Exam;
import com.semicore.otm.dao.entities.Student;
import com.semicore.otm.dao.repositories.StudentRepository;
import com.semicore.otm.requests.ExamRequest;
import com.semicore.otm.requests.StudentRequest;
import com.semicore.otm.responses.ExamResponse;
import com.semicore.otm.responses.StudentResponse;
import com.semicore.otm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = studentRepository.save(convertStudentRequestToStudentEntity(studentRequest));
        StudentResponse studentResponse = convertStudentEntityToStudentResponse(student);
        return studentResponse;
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
        return convertStudentEntitiesToStudentResponses(studentRepository.findAll());
    }

    private Student convertStudentRequestToStudentEntity(StudentRequest studentRequest) {
        Student student = null;
        if(Objects.nonNull(studentRequest)) {
            student = new Student();
            student.setStudentName(studentRequest.getName());
            student.setStudentEmail(studentRequest.getEmail());
            student.setExams(convertExamRequestsToExamEntities(studentRequest.getExams()));
        }
        return student;
    }

    private Set<Exam> convertExamRequestsToExamEntities(Set<ExamRequest> exams) {
        return exams.stream().map(examRequest -> {
            Exam exam = new Exam();
            exam.setExamName(examRequest.getName());
            exam.setExamDate(examRequest.getDate());
            exam.setStudentId(examRequest.getStudentId());
            return exam;
        }).collect(Collectors.toSet());
    }

    private StudentResponse convertStudentEntityToStudentResponse(Student student) {
        StudentResponse studentResponse = null;
        if(Objects.nonNull(student)) {
            studentResponse = new StudentResponse();
            studentResponse.setId(student.getStudentId());
            studentResponse.setName(student.getStudentName());
            studentResponse.setEmail(student.getStudentEmail());
            studentResponse.setExams(convertExamEntitisToExamResponses(student.getExams()));
        }
        return studentResponse;
    }

    private Set<ExamResponse> convertExamEntitisToExamResponses(Set<Exam> exams) {
        Set<ExamResponse> examResponses = null;
        if(!CollectionUtils.isEmpty(exams)) {
            examResponses = new HashSet<>();
            for(Exam exam : exams) {
                examResponses.add(convertExamEntityToExamResponse(exam));
            }
        }
        return examResponses;
    }

    private ExamResponse convertExamEntityToExamResponse(Exam exam) {
        ExamResponse examResponse = null;
        if(Objects.nonNull(exam)) {
            examResponse = new ExamResponse();
            examResponse.setId(exam.getExamId());
            examResponse.setName(exam.getExamName());
            examResponse.setDate(exam.getExamDate());
        }
        return  examResponse;
    }


    private List<StudentResponse> convertStudentEntitiesToStudentResponses(List<Student> students) {
        List<StudentResponse> studentResponses = null;
        if(!CollectionUtils.isEmpty(students)) {
            studentResponses = new ArrayList<>();
            for(Student student : students) {
                studentResponses.add(convertStudentEntityToStudentResponse(student));
            }
        }
        return studentResponses;
    }
}
