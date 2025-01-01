package com.miamills.studentbehaviourreport.model;

// Class representing a Teacher entity
public class Teacher {
    // Fields representing teacher's attributes
    private final String teacherId;
    private final String teacherName;
    private final String email;
    private final String password;
    private String teacherComment;

    // Constructor to initialize fields for the Teacher class
    public Teacher(String teacherId, String teacherName, String email, String password, String teacherComment) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.email = email;
        this.teacherComment = teacherComment;
        this.password = password;
    }

    // Getter method for teacherName
    public String getTeacherName() {
        return teacherName;
    }

    // Getter method for email
    public String getEmail() {
        return email;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Getter method for teacherComment
    public String getTeacherComment() {
        return teacherComment;
    }

    // Setter method for teacherComment
    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment;
    }

    // Getter method for teacherId
    public String getTeacherId() {
        return teacherId;
    }
}