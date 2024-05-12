package com.example.rest_api.controller;

import com.example.rest_api.Entity.Grades;
import com.example.rest_api.Repository.GradesRepository;
import com.example.rest_api.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping
    public Grades createGrades(@RequestBody Grades grades) {
        return gradesRepository.save(grades);
    }

    @GetMapping
    public List<Grades> getAllGrades() {
        return gradesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Grades getGradesById(@PathVariable Long id) {
        return gradesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grades not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Grades updateGrades(@PathVariable Long id, @RequestBody Grades gradesUpdate) {
        return gradesRepository.findById(id)
                .map(grades -> {
                    grades.setStudentId(gradesUpdate.getStudentId());
                    // Cập nhật các trường điểm số khác tại đây
                    return gradesRepository.save(grades);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Grades not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteGrades(@PathVariable Long id) {
        gradesRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
