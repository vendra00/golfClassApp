package com.t1tanic.golfclass.controller;

import com.t1tanic.golfclass.domain.GolfClass;
import com.t1tanic.golfclass.service.GolfClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class GolfClassController {

    private final GolfClassService golfClassService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GolfClass create(@RequestBody GolfClass golfClass) {
        return golfClassService.create(golfClass);
    }

    @GetMapping
    public List<GolfClass> findAll() {
        return golfClassService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GolfClass> findById(@PathVariable Long id) {
        return golfClassService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GolfClass> update(@PathVariable Long id, @RequestBody GolfClass golfClass) {
        if (golfClassService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        golfClass.setId(id);
        return ResponseEntity.ok(golfClassService.update(golfClass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        golfClassService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

