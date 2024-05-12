package com.example.rest_api.Repository;

import com.example.rest_api.Entity.Attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
