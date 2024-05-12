package com.example.rest_api.Repository;

import com.example.rest_api.Entity.Classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
