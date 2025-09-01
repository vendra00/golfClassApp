package com.t1tanic.golfclass.repository;

import com.t1tanic.golfclass.domain.GolfClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolfClassRepository extends JpaRepository<GolfClass, Long> {
}

