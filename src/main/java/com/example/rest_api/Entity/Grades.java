package com.example.rest_api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    // Other grade fields here...

    // Constructors
    public Grades() {
        // Default constructor
    }

    public Grades(Long studentId /* Other grade fields here... */) {
        this.studentId = studentId;
        // Initialize other grade fields here...
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    // Other getters and setters for grade fields here...

    // toString() method (optional but recommended for debugging)
    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", studentId=" + studentId +
                // Other grade fields here...
                '}';
    }
}
