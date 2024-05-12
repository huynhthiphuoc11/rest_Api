package com.example.rest_api.controller;

import com.example.rest_api.Entity.Classes;
import com.example.rest_api.Repository.ClassesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    @Autowired
    private ClassesRepository classesRepository;

    @PostMapping
    public Classes createClasses(@RequestBody Classes classes) {
        return classesRepository.save(classes);
    }

    @GetMapping
    public List<Classes> getAllClasses() {
        return classesRepository.findAll();
    }

    // Thêm các phương thức cập nhật, xóa, và lấy theo ID tương tự như UserController
}
