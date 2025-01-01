package com.miamills.studentbehaviourreport.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.miamills.studentbehaviourreport.repositories.StudentRepository;
import com.miamills.studentbehaviourreport.model.Student;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Add annotation to test the StudentController class
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    // Test method to verify that all students are returned
    @Test
    public void getAllStudents_ShouldReturnStudentList() throws Exception {
        // Mock the repository response
        given(studentRepository.findAll()).willReturn(Arrays.asList(
                new Student("1", "John Doe", "Class A", "Good student"),
                new Student("2", "Jane Doe", "Class B", "Excellent student")
        ));

        // Perform the GET request and verify the response
        this.mockMvc.perform(get("/api/v1/students"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json("[{'studentId':'1','studentName':'John Doe','studentClass':'Class A','teacherComment':'Good student'},{'studentId':'2','studentName':'Jane Doe','studentClass':'Class B','teacherComment':'Excellent student'}]"));
    }

    // Test method to verify that student names are returned based on teacher comment
    @Test
    void getAllStudentString() throws Exception {
        // Mock the repository response
        given(studentRepository.findByTeacherCommentContaining("someComment")).willReturn(Arrays.asList(
                new Student("1", "John Doe", "Class A", "someComment"),
                new Student("2", "Jane Doe", "Class B", "someComment")
        ));

        // Perform the GET request and verify the response
        this.mockMvc.perform(get("/api/v1/students/getAllStudentString")
                .param("comment", "someComment"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
            .andExpect(content().json("[\"John Doe\",\"Jane Doe\"]")); // Adjust expected content as needed
    }
}