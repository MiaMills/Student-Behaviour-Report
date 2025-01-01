package com.miamills.studentbehaviourreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Add annotation which tells Spring Boot to start auto-config and scanning process
// Annotation simplifies setup by reducing need for multiple individual annotations
// Functions: set up configs and needed components, scans components, resolves dependencies
@SpringBootApplication

// Add main method which uses Spring Boot application.run to launch app'n.
public class StudentBehaviorReportApplication {

    public static void main(String[] args) {
        // Add method which starts up app'n
        SpringApplication.run(StudentBehaviorReportApplication.class, args);
    }
}