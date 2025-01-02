package com.miamills.studentbehaviourreport.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miamills.studentbehaviourreport.model.Student;
import com.miamills.studentbehaviourreport.repositories.StudentRepository;

// Add service annotation to mark the class as a Spring service
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor to inject the student repository
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // Method to update a student's teacher comment
    public Student updateStudentComment(String studentId, String newCommentString) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setTeacherComment(newCommentString);
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }
    }

    // Method to find a student by their ID- RETRIEVE
    public Student findStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Method to add a new student- CREATE
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Method to delete a student by their ID- DELETE
    public void deleteStudentById(String studentId) {
        studentRepository.deleteByStudentId(studentId);
    }

    // Method to update a student's details- UPDATE
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}