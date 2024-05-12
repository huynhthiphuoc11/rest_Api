package com.example.rest_api.Repository;

import com.example.rest_api.Entity.Points;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
