package com.sallu.jpaandhibernatedemo.repository;

import com.sallu.jpaandhibernatedemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void driverCode() {
        String createQuery = "create table course (\n" +
                "id bigint auto_increment primary key,\n" +
                "name varchar(40),\n" +
                "author varchar (40)\n" +
                ");";
        jdbcTemplate.update(createQuery);
    }

    public void insert(Course course) {
        String insertQuery = "INSERT INTO course(name, author) values(?, ?)";
        jdbcTemplate.update(insertQuery, course.getName(), course.getAuthor());
    }

    public Course findById(long id) {
        String selectQuery = "SELECT * FROM course WHERE id = ?";
        return jdbcTemplate.queryForObject(selectQuery, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public List<Course> findAll() {
        String selectQuery = "SELECT * FROM course";
        ResultSetExtractor<List<Course>> extractor = rs -> {
            List<Course> list = new ArrayList<>();
            while(rs.next()) {
                Course course = new Course(rs.getLong("id"), rs.getString("name"), rs.getString("author"));
                list.add(course);
            }
            return list;
        };
        return jdbcTemplate.query(selectQuery, extractor);
    }

}
