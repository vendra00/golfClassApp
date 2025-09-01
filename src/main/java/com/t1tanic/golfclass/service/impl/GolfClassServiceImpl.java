package com.t1tanic.golfclass.service.impl;

import com.t1tanic.golfclass.domain.GolfClass;
import com.t1tanic.golfclass.repository.GolfClassRepository;
import com.t1tanic.golfclass.service.GolfClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GolfClassServiceImpl implements GolfClassService {

    private final GolfClassRepository golfClassRepository;

    @Override
    public GolfClass create(GolfClass golfClass) {
        return golfClassRepository.save(golfClass);
    }

    @Override
    public List<GolfClass> findAll() {
        return golfClassRepository.findAll();
    }

    @Override
    public Optional<GolfClass> findById(Long id) {
        return golfClassRepository.findById(id);
    }

    @Override
    public GolfClass update(GolfClass golfClass) {
        return golfClassRepository.save(golfClass);
    }

    @Override
    public void deleteById(Long id) {
        golfClassRepository.deleteById(id);
    }
}

