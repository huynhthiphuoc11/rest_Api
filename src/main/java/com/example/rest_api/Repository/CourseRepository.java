package com.example.rest_api.Repository;

import com.example.rest_api.Entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
