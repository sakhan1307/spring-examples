package com.springexample.jdbc.dao.hibenate;

import java.util.List;


public interface CourseDao {
    public void store(Course course);

    public void delete(Long courseId);

    public Course findById(Long courseId);

    public List<Course> findAll();
}
