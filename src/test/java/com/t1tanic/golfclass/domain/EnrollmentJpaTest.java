package com.t1tanic.golfclass.domain;

import com.t1tanic.golfclass.TestcontainersConfiguration;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class EnrollmentJpaTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void persistsEnrollmentGraph() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        entityManager.persist(instructor);

        GolfClass golfClass = new GolfClass();
        golfClass.setTitle("Short Game Basics");
        golfClass.setInstructor(instructor);
        entityManager.persist(golfClass);

        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setEmail("jane@example.com");
        entityManager.persist(student);

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setGolfClass(golfClass);
        enrollment.setEnrolledAt(LocalDateTime.now());
        entityManager.persist(enrollment);
        entityManager.flush();
        entityManager.clear();

        Enrollment found = entityManager.find(Enrollment.class, enrollment.getId());
        assertThat(found.getStudent().getEmail()).isEqualTo("jane@example.com");
        assertThat(found.getGolfClass().getInstructor().getFirstName()).isEqualTo("John");
    }
}

