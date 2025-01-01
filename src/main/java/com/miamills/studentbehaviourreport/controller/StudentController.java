package com.miamills.studentbehaviourreport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.miamills.studentbehaviourreport.model.Student;
import com.miamills.studentbehaviourreport.repositories.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students") // Base URL for all endpoints in this controller
public class StudentController {

    private final StudentRepository studentRepository;

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

    // PUT to update a student's comment
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setTeacherComment(updatedStudent.getTeacherComment());
        return ResponseEntity.ok(studentRepository.save(existingStudent));
    }

    // DELETE a student by ID
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String id) {
        studentRepository.deleteByStudentId(id);
        return ResponseEntity.noContent().build();
    }

    // GET all student names filtered by teacher comment
    @GetMapping("/getAllStudentString")
    public ResponseEntity<List<String>> getAllStudentString(@RequestParam String comment) {
        List<String> studentNames = studentRepository.findByTeacherCommentContaining(comment)
                .stream()
                .map(Student::getStudentName)
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentNames);
    }
}