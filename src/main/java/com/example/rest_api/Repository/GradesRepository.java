package com.example.rest_api.Repository;

import com.example.rest_api.Entity.Grades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
