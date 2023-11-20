package com.sallu.jpaandhibernatedemo;

import com.sallu.jpaandhibernatedemo.entity.Course;
import com.sallu.jpaandhibernatedemo.repository.CourseJdbcRepository;
import com.sallu.jpaandhibernatedemo.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    CourseJdbcRepository jdbcRepository;
    CourseJpaRepository jpaRepository;

    @Autowired
    public CourseCommandLineRunner(CourseJdbcRepository jdbcRepository, CourseJpaRepository jpaRepository) {
        this.jdbcRepository = jdbcRepository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.driverCode();

        jpaRepository.insert(new Course("Java Course", "IIT-Bombay"));
        jpaRepository.insert(new Course("Springboot Course", "IIT-Bombay"));
        jpaRepository.insert(new Course("C++ Course", "IIT-Madras"));
        jpaRepository.insert(new Course("SQL Course", "IIT-Kanpur"));
        jpaRepository.insert(new Course("JS Course", "IIT-Delhi"));

        System.out.println("The first course is " + jpaRepository.findById(1));
    }
}
