package com.miamills.studentbehaviourreport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

// Add entity annotation to mark the Student class as a JPA entity
@Entity
public class Student {

    // Mark studentId as primary key
    @Id
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_class", nullable = true)
    private String studentClass;

    @Column(name = "teacher_comment", nullable = true)
    private String teacherComment;

    // No-argument constructor required by Hibernate
    public Student() {
    }

    // Add constructors to initialize fields for the Student class
    public Student(String studentId, String studentName, String studentClass, String teacherComment) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.teacherComment = teacherComment;
    }

    // Getter methods for all fields
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getTeacherComment() {
        return teacherComment;
    }

    // Setter method for teacherComment-needed for updates in PUT endpoint
    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment;
    }
}