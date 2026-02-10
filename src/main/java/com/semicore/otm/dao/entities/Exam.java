package com.semicore.otm.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "exam_id")
        private Long examId;

        @Column(name = "exam_name")
        private String examName;

        @Column(name = "exam_date")
        private String examDate;

        @Column(name = "stud_id")
        private Long studentId;

        public Long getExamId() {
            return examId;
        }

        public void setExamId(Long examId) {
            this.examId = examId;
        }

        public String getExamName() {
            return examName;
        }

        public void setExamName(String examName) {
            this.examName = examName;
        }

        public String getExamDate() {
            return examDate;
        }

        public void setExamDate(String examDate) {
            this.examDate = examDate;
        }

        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }
}
