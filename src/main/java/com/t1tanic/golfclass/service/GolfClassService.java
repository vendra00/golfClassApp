package com.t1tanic.golfclass.service;

import com.t1tanic.golfclass.domain.GolfClass;

import java.util.List;
import java.util.Optional;

public interface GolfClassService {
    GolfClass create(GolfClass golfClass);
    List<GolfClass> findAll();
    Optional<GolfClass> findById(Long id);
    GolfClass update(GolfClass golfClass);
    void deleteById(Long id);
}

