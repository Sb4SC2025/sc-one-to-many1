package com.semicore.otm.requests;

import com.semicore.otm.dao.entities.Exam;

import java.util.Set;

public class StudentRequest {
        private String name;
        private String email;
        private Set<ExamRequest> exams;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Set<ExamRequest> getExams() {
            return exams;
        }

        public void setExams(Set<ExamRequest> exams) {
            this.exams = exams;
        }
}
