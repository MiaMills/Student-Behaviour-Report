package com.miamills.studentbehaviourreport.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.miamills.studentbehaviourreport.model.Student;
import com.miamills.studentbehaviourreport.repositories.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

// Add annotations for RestController
@RestController
@RequestMapping("/students")   // Base URL for all endpoints in this controller
public class StudentController {

    // Add private field- only accessible within this class
    private final StudentRepository studentRepository;

    // Constructor injection for StudentRepository
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET a specific student's teacher comment by ID
    @GetMapping("/{id}/getTeacherComment")
    public ResponseEntity<String> getTeacherComment(@PathVariable String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return ResponseEntity.ok(student.getTeacherComment());
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    // GET filtered students by teacher comment
    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterStudentsByComment(@RequestParam String comment) {
        List<Student> students = studentRepository.findByTeacherCommentContaining(comment);
        return ResponseEntity.ok(students);
    }

    // PUT (Update) student details (e.g., updating a teacher's comment)
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Update fields as necessary
        existingStudent.setTeacherComment(updatedStudent.getTeacherComment());
        return ResponseEntity.ok(studentRepository.save(existingStudent));
    }

    // DELETE a student by their ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Optional: GET all student names as strings
    @GetMapping("/getAllStudentString")
    public ResponseEntity<List<String>> getAllStudentString(@RequestParam String comment) {
        List<String> studentNames = studentRepository.findByTeacherCommentContaining(comment)
                .stream()
                .map(Student::getStudentName) // Assuming Student has a getStudentName() method
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentNames);
    }
}
