package com.MiaMils.StudentBehaviorReport.StudentBehaviorReport;

import com.miamills.studentbehaviourreport.StudentBehaviorReportApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Add annotation to indicate that this is a Spring Boot test class
@SpringBootTest(classes = StudentBehaviorReportApplication.class) // Ensure the main application class is specified
class StudentBehaviorReportApplicationTests {

    // Add test method to verify that the application context loads successfully
    @Test
    void contextLoads() {
        // This test will pass if the application context loads successfully
    }
}