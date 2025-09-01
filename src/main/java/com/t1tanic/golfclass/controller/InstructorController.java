package com.t1tanic.golfclass.controller;

import com.t1tanic.golfclass.domain.Instructor;
import com.t1tanic.golfclass.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Instructor create(@RequestBody Instructor instructor) {
        return instructorService.create(instructor);
    }

    @GetMapping
    public List<Instructor> findAll() {
        return instructorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable Long id) {
        return instructorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable Long id, @RequestBody Instructor instructor) {
        if (instructorService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        instructor.setId(id);
        return ResponseEntity.ok(instructorService.update(instructor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instructorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

