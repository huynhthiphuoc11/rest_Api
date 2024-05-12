package com.example.rest_api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "points")
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "regular_points")
    private double regularPoints;

    private double midterm;

    private double finalExam;

    private double average;

    @Column(name = "user_id")
    private Long userId;

    // Constructors
    public Points() {
        // Default constructor
    }

    public Points(double regularPoints, double midterm, double finalExam, double average, Long userId) {
        this.regularPoints = regularPoints;
        this.midterm = midterm;
        this.finalExam = finalExam;
        this.average = average;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRegularPoints() {
        return regularPoints;
    }

    public void setRegularPoints(double regularPoints) {
        this.regularPoints = regularPoints;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // toString() method (optional but recommended for debugging)
    @Override
    public String toString() {
        return "Points{" +
                "id=" + id +
                ", regularPoints=" + regularPoints +
                ", midterm=" + midterm +
                ", finalExam=" + finalExam +
                ", average=" + average +
                ", userId=" + userId +
                '}';
    }
}
