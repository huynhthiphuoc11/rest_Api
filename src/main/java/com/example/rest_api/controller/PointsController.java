package com.example.rest_api.controller;



import com.example.rest_api.Entity.Points;
import com.example.rest_api.Repository.PointsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/points")
public class PointsController {

    @Autowired
    private PointsRepository pointsRepository;

    @PostMapping
    public Points createPoints(@RequestBody Points points) {
        return pointsRepository.save(points);
    }

    @GetMapping
    public List<Points> getAllPoints() {
        return pointsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Points> getPointsById(@PathVariable Long id) {
        Optional<Points> points = pointsRepository.findById(id);
        return points.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Points> updatePoints(@PathVariable Long id, @RequestBody Points newPoints) {
        Optional<Points> optionalPoints = pointsRepository.findById(id);
        if (optionalPoints.isPresent()) {
            Points existingPoints = optionalPoints.get();
            existingPoints.setRegularPoints(newPoints.getRegularPoints());
            existingPoints.setMidterm(newPoints.getMidterm());
            existingPoints.setFinalExam(newPoints.getFinalExam());
            existingPoints.setAverage(newPoints.getAverage());
            existingPoints.setUserId(newPoints.getUserId());
            pointsRepository.save(existingPoints);
            return new ResponseEntity<>(existingPoints, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePoints(@PathVariable Long id) {
        try {
            pointsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
