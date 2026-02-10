package com.semicore.otm.dao.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "student_id")
        private Long studentId;
        @Column(name = "student_name")
        private String studentName;
        @Column(name = "student_email")
        private String studentEmail;
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "stud_id", referencedColumnName = "student_id")
        private Set<Exam> exams;

        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getStudentEmail() {
            return studentEmail;
        }

        public void setStudentEmail(String studentEmail) {
            this.studentEmail = studentEmail;
        }

        public Set<Exam> getExams() {
            return exams;
        }

        public void setExams(Set<Exam> exams) {
            this.exams = exams;
        }
}
