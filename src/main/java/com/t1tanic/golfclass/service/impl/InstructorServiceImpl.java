package com.t1tanic.golfclass.service.impl;

import com.t1tanic.golfclass.domain.Instructor;
import com.t1tanic.golfclass.repository.InstructorRepository;
import com.t1tanic.golfclass.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Override
    public Instructor create(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Optional<Instructor> findById(Long id) {
        return instructorRepository.findById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }
}

