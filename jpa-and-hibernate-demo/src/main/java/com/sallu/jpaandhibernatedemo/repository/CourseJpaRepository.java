package com.sallu.jpaandhibernatedemo.repository;

import com.sallu.jpaandhibernatedemo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseJpaRepository {
    EntityManager entityManager;

    public CourseJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

}
