/**
 * This package contains the repository interfaces for the Student Behaviour Report application.
 * Repositories are responsible for data access and manipulation, providing an abstraction layer
 * over the underlying data storage mechanisms.
 */
package com.miamills.studentbehaviourreport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miamills.studentbehaviourreport.model.Student; // Manages ordered collections of data of students.


// Add repository annotation to mark the interface as a Spring Data repository
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    // Method to find students by their name
    List<Student> findByStudentName(String studentName);

    // Method to find students whose teacher comments contain a specific string
    List<Student> findByTeacherCommentContaining(String comment);

    // Method to delete a student by their ID
    void deleteByStudentId(String studentId);

    // Method to find a student by their ID
    Optional<Student> findById(String studentId);
}